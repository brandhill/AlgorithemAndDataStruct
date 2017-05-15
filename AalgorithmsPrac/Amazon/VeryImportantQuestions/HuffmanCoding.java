package VeryImportantQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;



public class HuffmanCoding {

  static Map<String,String> huffmanCoding(String s) {
      char[] input = s.toCharArray();
      Arrays.sort(input);
      int count = 0;
      Queue<Node> heap = new PriorityQueue<Node>();
      Map<String,String> map = new HashMap<String,String>();
      for(int i=0; i<input.length-1; i++) {
          count++;
          if(input[i]!=input[i+1]) {
            Node n = new Node(input[i]+"",count);
            heap.offer(n);
            count = 0;
          }
      }
      
      if(count==0) {
    	  heap.offer(new Node(input[input.length-1]+"",0));
      } else {
    	  heap.offer(new Node(input[input.length-1]+"",count+1));
      }
      while(heap.size()!=1) {
    	  Node right = heap.poll();
    	  Node left = heap.poll();
          System.out.println("right "+right.count);
    	  System.out.println("left "+left.count);
          Node node = new Node(left.c+right.c,left.count+right.count);
          node.left = left; 
          node.right = right;
          heap.offer(node);
      }

      Node root = heap.poll();
      System.out.println(root.c);
      huffmanCodingHelper(root,map,"");

      return map;
  }

  static void huffmanCodingHelper(Node node,Map<String,String> map, String code) {
	  
      if(node.left == null && node.right == null) {
//    	  System.out.println(node.c+" "+code);
        map.put(node.c,code);
        return;
      }
      huffmanCodingHelper(node.left,map,code+"0");
      huffmanCodingHelper(node.right,map,code+"1");
  }

  public static void main(String args[]) {
      Map<String,String> map = huffmanCoding("aaaaaaaaaaaaaaaeeeeeeeeeeeebbbbbbbccccccddddd");
      for(String c: map.keySet()) {
        System.out.println(c+" "+map.get(c));
      }
  }
}


class Node implements Comparable<Node> {
  String c;
  int count;
  Node left;
  Node right;

  Node(String c,int count) {
    this.c = c;
    this.count = count;
  }
  @Override
  public int compareTo(Node n) {
    if(this.count>n.count) {
      return 1;
    } else if(this.count< n.count) {
      return -1;
    }
    return 0;
  }
}

