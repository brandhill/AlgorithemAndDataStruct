package DynamicProgramming;

import GraphsDataStructures.mainclass;

public class MagicArray3 {
	
	static int MagicIndexForDistinctArray(int[] array,int start,int end) {
		
		if(start > end )
			return -1;
		
		int mid = (start + end)/2;
		
		if (array[mid]==mid)
			return mid;
		else if (array[mid] < mid) {
			return MagicIndexForDistinctArray(array,mid+1,end);
		} 
		else {
			return MagicIndexForDistinctArray(array,start,mid-1);
		}
		
	}
	
	static int MagicIndexForDuplicatArray(int[] array,int start,int end) {
		
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		System.out.println(mid+" "+array[mid]);
		if(array[mid]==mid) {
			return mid;
	/*		int val = mid;
			mid = mid - 1;
			while(mid>=start) {
				if(array[mid] != mid) {
					return mid+1;
				}
				mid = mid-1;
			}
			return val;*/
		}
		else {
			int j = MagicIndexForDuplicatArray(array,start,Math.min(mid-1, array[mid]));
			if(j!=-1)
				return j;
			int k = MagicIndexForDuplicatArray(array,Math.max(mid+1, array[mid]),end);
			if(k!=-1)
				return k;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {-1,0,1,3,5,6};
		int i = MagicArray3.MagicIndexForDistinctArray(array, 0, array.length-1);
		//System.out.println(i);
		int[] array1 = {-1,0,1,-2,2,10,7,8,8};
		int m = MagicArray3.MagicIndexForDuplicatArray(array1, 0, array1.length-1);
		System.out.println(m);
	}
	
}
