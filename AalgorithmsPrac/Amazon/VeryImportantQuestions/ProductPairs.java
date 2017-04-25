package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//Amazon wants to send recommendations regarding products, but we want to do it in pairs. Products
//fall into different categories and we don't want to recommend a pair of products that come from the
//same category. There are N products and we don't know exactly how many categories there are and
//which product belongs to which category. We are, however, aware that certain pairs of products
//belong in the same category.

//So, we are given a list of such product (ID) pairs that identify products belonging to a same category,
//for example: (1, 5), (7, 2), (3, 4), (4, 8), (6, 3), (5, 2).

//When we analyze that list, we can see that we only have two categories with 4 products, each: (1, 2, 5,
//7), (3, 4, 6, 8)

//The questions are:
//How many categories we have and how many products in each category?
//In how many ways can we choose a pair of products so that the two products come from
//different categories?

public class ProductPairs {
    
    List<List<Integer>> getProducts(List<Similar> list) {
       
       Map<Integer, List<Integer>> similarProducts = new HashMap<Integer, List<Integer>>();
       populateMap(similarProducts, list);
       List<List<Integer>> categoryProducts = new ArrayList<List<Integer>>();
       Set<Integer> vistied = new HashSet<Integer>();
       for(Integer i: similarProducts.keySet()) {
           if(!vistied.contains(i)) {
               vistied.add(i);
               List<Integer> products = new ArrayList<Integer>();
               Queue<Integer> queue = new PriorityQueue<Integer>();
               products.add(i);
               queue.add(i);
               BFS(queue, vistied, similarProducts, products);
               categoryProducts.add(products);
           }
       }
       
       return categoryProducts;
    }
    
    void populateMap(Map<Integer, List<Integer>> similarProducts, List<Similar> list) {
    	for(int i=0; i< list.size(); i++) {
            Similar s = list.get(i);
            if(similarProducts.containsKey(s.id1)) {
                similarProducts.get(s.id1).add(s.id2);
            } else {
                List<Integer> array = new ArrayList<Integer>();
                array.add(s.id2);
                similarProducts.put(s.id1,array);
            }
            
            
            if(similarProducts.containsKey(s.id2)) {
                similarProducts.get(s.id2).add(s.id1);
            } else {
                List<Integer> array = new ArrayList<Integer>();
                array.add(s.id1);
                similarProducts.put(s.id2,array);
            }
        }
    }
    
    void BFS(Queue<Integer> queue, Set<Integer> visited, Map<Integer, List<Integer>> similarProducts, List<Integer> products) {

         
         while(!queue.isEmpty()) {
        	 int i = queue.poll();
        	 System.out.print(i+" ");
             List<Integer> list = similarProducts.get(i);
             for(Integer num: list) {
                 if(!visited.contains(num)) {
                     visited.add(num);
                     queue.add(num);
                     products.add(num);
                 }
             }
         
         }
         System.out.println();
    }
    
    public static void main(String[] args) {
    	Similar s1 = new Similar(1,5);
    	Similar s2 = new Similar(7,2);
    	Similar s3 = new Similar(3,4);
    	Similar s4 = new Similar(4,8);
    	Similar s5 = new Similar(6,3);
    	Similar s6 = new Similar(5,2);
    	Similar s7 = new Similar(5,9);
    	
    	List<Similar> products = new ArrayList<Similar>();
    	products.add(s1);
    	products.add(s2);
    	products.add(s3);
    	products.add(s4);
    	products.add(s5);
    	products.add(s6);
    	products.add(s7);
    	
    	ProductPairs p = new ProductPairs();
    	System.out.println(p.getProducts(products));
	}
    
}

class Similar {
    int id1;
    int id2;
    
    Similar(int id1, int id2) {
    	this.id1 = id1;
    	this.id2 = id2;
    }
}
