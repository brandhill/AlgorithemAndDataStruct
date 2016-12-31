package hackerrank.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NikitaandtheGame {
	
	
	static int BalanceMaxSplit(int[] array) {
		int sum = 0;
		for ( int i = 0;i < array.length; i++) {
			sum = sum + array[i];
		}
		
		return BalanceMaxSplitHelper1(array, sum, 0, array.length-1, 0);
			//return BalanceMaxSplitHelper(array,0,array.length-1,0);
		}
	
	static int BalanceMaxSplitHelper(int[] array, int start, int end,int count) {
		
		
		for ( int j = 0; j < array.length; j++) {
			//if(array[])
		}
		
		if(start >=end )
			return count;
		int len = (end-start+1)==array.length?(end-start):(end-start+1) ;
		int left = 0;
		int right = 0;
		int newStart = start;
		int newEnd = end;
		//start++
		while(true) {
			//System.out.print("start & end "+start+" "+end);
			if(start >=end ) {
				if(left==right) {
					//System.out.println("check"+start+" "+((len/2)+newStart));
					if (start==end && start==((len/2)+newStart)) {
						if(array[start] == 0){
							//System.out.println(start+" "+array[start]);
							end--;
						}
						else	
							return count;
					}
						
					//System.out.println("Increment");
					count++;
					break;
					//return count;
				}
			else
				return count;	
			}
			
			if(left>right) {
				right = right + array[end];
			}
			else if(right>left) {
				left = left + array[start];
			}
			else {
				left = left + array[start];
				right = right + array[end];
			}
			
			if(left > right)
				end--;
			else if(right > left)
				start++;
			else {
				start++;
				end--;
			}
			//System.out.println(" left & righ "+left+" "+right);
		}
		//System.out.println();
		//System.out.println(count);
		//System.out.println("c "+c);
		return Math.max(BalanceMaxSplitHelper(array,newStart,start-1,count),BalanceMaxSplitHelper(array,end+1,newEnd,count));
		
	}
	
	public static int BalanceMaxSplitHelper1(int[] array,int sum,int start, int end,int count) {
		if(start>=end)
			return count;
		int leftsum = 0;
		for( int i = start; i < end; i++) {
			leftsum = leftsum + array[i];
			sum = sum - array[i];
			if(sum==leftsum){
				return Math.max(BalanceMaxSplitHelper1(array,leftsum,start,i,count+1), BalanceMaxSplitHelper1(array,sum,i+1,end,count+1));
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		//int[] array = {4,1, 0, 1, 1, 0, 1};
		//int[] array = {3,3,2,2,2,3,2,3};
		//int[] array = {3,3,3};
		//int[] array = {2};
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		List<int[]> list = new ArrayList<int[]>();
		for ( int i = 0; i <loop; i++) {
			int len = sc.nextInt();
			int[] array = new int[len];
			list.add(array);
			for( int j = 0; j< len; j++) {
				array[j] = sc.nextInt();
			}
		}
		for( int j = 0; j < list.size(); j++) {
			//int count1 = NikitaandtheGame.BalanceMaxSplit(list.get(j));
			int count1 = NikitaandtheGame.BalanceMaxSplit(list.get(j));
			System.out.println(count1);
		}
		//int[] array = {2,2,0,2,2};
		//System.out.println(NikitaandtheGame.BalanceMaxSplit(array));
		
	}
}


/* 
0
0
6
2
15
11
4
1
0
54*/

/*
 * 2 0 0 2 2 0 0 0 0 2 0 2 0 2 0 2 0 0 0 2 0 0 2 0
expected
0
0
6
2
15
11
4
1
0
54*/
