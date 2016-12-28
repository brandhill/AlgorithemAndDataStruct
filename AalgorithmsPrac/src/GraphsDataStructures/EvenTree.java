package GraphsDataStructures;

import java.util.Scanner;

public class EvenTree {
	Vertex1[] nums;
	EvenTree(int count){
		nums = new Vertex1[count];
		for( int i = 0; i < count;i++) {
			nums[i] = new Vertex1(i+1);
		}
		
		
	}
	
	void linknums(int num1,int num2) {
		//nums[num1-1].addNeighbor(new Neighbors(num2));
		nums[num2-1].addNeighbor(new Neighbors(num1));
	}
	
	void deletelinks(int num1,int num2) {
		Neighbors neis = nums[num1-1].nei;
		Neighbors prev = null;
		if(neis.i == num2) {
			nums[num1-1].nei = neis.next;
			return;
		}
		while(neis!=null) {
			if(neis.i == num2) {
				prev.next = neis.next;
				return;
			}
			prev = neis;
			neis = neis.next;
		}
	}
	
	int getMaxEvenTrees(Vertex1 vertex,CountMaintain count) {
		
		if(vertex == null)
			return 0;
		Neighbors neis = vertex.nei;
		int count1 = 0;
		while(neis != null) {
			int result = getMaxEvenTrees(nums[neis.i-1],count);
			if(result >=2 && result%2 == 0) {
				//deletelinks(vertex.i,neis.i);
				count.count++;
				//System.out.println(count+" "+vertex.i+" "+neis.i);
				result = 0;
			}
			count1 = count1 + result; 
			neis = neis.next;
		}
		
		
		return count1+1;
		
		
	}
	
	void print() {
		for ( int i =0; i < nums.length; i++) {
			System.out.print(nums[i].i+" --> ");
			Neighbors n = nums[i].nei; 
			while(n!=null) {
				System.out.print(n.i+",");
				n = n.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		EvenTree tree = new EvenTree(count);
		int loop = sc.nextInt();
		for ( int i=1; i<= loop;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			tree.linknums(num1, num2);
		}
		
		//tree.print();
		//Integer count1 = new Integer(0);
		CountMaintain count1  = new CountMaintain();
		tree.getMaxEvenTrees(tree.nums[0], count1);
		System.out.println(count1.count);
		//System.out.println("Completed");
		
	}
}

class Vertex1 {
	int i;
	Neighbors nei;
	Vertex1(int i) {
		this.i = i;
	}
	
	void addNeighbor(Neighbors add) {
		if(nei == null )
			nei = add;
		else {
			add.next = nei;
			nei = add;
		}
	}
}
class Neighbors {
	int i;
	Neighbors next;
	Neighbors(int i) {
		this.i = i;
	}
}

class CountMaintain {
	
	int count;
	
}
