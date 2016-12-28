package hackerrank.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuttheTree {
	
	static int getMinSum(data parent,data root,int totalsum, int diff){
		
		for (data child: root.list) {
			if(!child.equals(parent)) {
			int sum1 = cutTree(root,child);
			int sum2 = totalsum - sum1;
			diff = Math.abs(sum1-sum2)<diff?Math.abs(sum1-sum2):diff;
			diff = getMinSum(root,child,totalsum,diff);
			}
		}
		
		//System.out.println(cutTree(root,root.list.get(0)));
		return diff;
	}
	
	static int cutTree(data root,data current) {
		//currentsum += root.val;
		if(current.sum!=null) {
			return current.sum;
		} 
		int currentsum = 0;
		for(data d: current.list) {
			//running = running + d.val;
			if(!d.equals(root)) {
				currentsum += cutTree(current,d);
			}
		}
		currentsum += current.val;
		current.sum = currentsum;
		//System.out.println((root.index+1)+" "+currentsum);
		return currentsum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		List<data> list1 = new ArrayList<data>();
		int sum = 0;
		for ( int i = 0; i < count; i++) {
			int num = sc.nextInt();
			sum += num;
			list1.add(new data(i,num));
		}
		
		while(sc.hasNext()) {
			int a = sc.nextInt();
			if(a == -1) {
				break;
			}
			int b = sc.nextInt();
			list1.get(a-1).add(list1.get(b-1));
			list1.get(b-1).add(list1.get(a-1));
		}
		
		/*for ( data d : list1) {
			System.out.print("("+(d.index+1)+","+d.val+") -- ");
			for (data d1 : d.list) {
				System.out.print("("+(d1.index+1)+","+d1.val+") ");
			}
			System.out.println();
		}*/
		
		int diff = CuttheTree.getMinSum(list1.get(0),list1.get(0),sum,Integer.MAX_VALUE);
		System.out.println(diff);
	}
}

class data {
	int index;
	int val;
	Integer sum;
	List<data> list;
	data(int index,int val){
		list = new ArrayList<data>();
		this.index = index;
		this.val = val;
		sum = null;
	}
	
	void add(data d) {
		list.add(d);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + val;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		data other = (data) obj;
		if (index != other.index)
			return false;
		if (val != other.val)
			return false;
		return true;
	}
	
	
}

