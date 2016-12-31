package GeekToGeek.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Smallestsubarray {
	
	static int[] SmallersSubarray1(int[] arr){
		
		int[] sumarr = new int[arr.length];
		int N = arr.length;
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			sumarr[i] = sum%N;
		}
		return sumarr;
		
		
		
	}
	static int[] SmallersSubarray(int[] arr){
		int N = arr.length;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			int sum = 0;
			for(int j = i; j < N;j++){
				temp.add(arr[j]);
				sum = sum+arr[j];
				if( sum!=1 && sum%N==0) {
					if(list.isEmpty() || list.size() > temp.size()) {
						list = temp;
					}
					break;
				}
			}
		}
		
		int[] sub = new int[list.size()];
		
		for ( int i = 0 ; i < list.size(); i++) {
			sub[i] = list.get(i);
			//System.out.print(sub[i]+" ");
		}
		 
		return sub;
	}
		
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 2, 2, 4, 2};
		int[] sub = Smallestsubarray.SmallersSubarray(arr);
		//System.out.println(sub.);
	}
}	
