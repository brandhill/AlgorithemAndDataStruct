package ArraysProblems;

// http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/

public class KadaneWrapArray {
	
	public void kadaneWrap(int[] arr) {
		int start = -1;
		int end = -1;
		int fstart = -1;
		int fend = -1;
		int i = 0;
		int sum = 0;
		int actsum = 0;
		while(i < arr.length) {
			if(arr[i] < 0) {
				sum += arr[i];
				
				if(start==-1) {
					start = i;
					end = i;
				}
				else {
					end++;
				}
				
			}
			else {
				if(actsum>sum) {
					actsum = sum;
					sum = 0;
					fstart = start;
					fend = end;
				}
				start = -1;
				end = -1;
			}
			i++;
		}
		
		if(start!=-1) {
			int j = 0;
			while(j<start) {
				if(arr[j] < 0) {
					sum+=arr[j];
					end = j;
				}
				else {
					if(actsum>sum) {
						actsum = sum;
						sum = 0;
						fstart = start;
						fend = end;
					}
					break;
				}
				j++;
			}
		}
		
		int sum1 = 0;
		System.out.println(fstart+" "+fend);
		for(int k = 0; k < arr.length; k++) {
			if(fend<fstart) {
				if(k>fend && k < fstart) {
					sum1 += arr[k];
				}
			}
			else {
				if(k>fend || k < fstart) {
					sum1 += arr[k];
				}
			}
		}
		
		System.out.println(sum1);
		
	}
	  public static void main(String args[]){
		KadaneWrapArray kwa = new KadaneWrapArray();
	    int input[] = {12, -2, -6, 5, 9, -7, 3};
	    int input1[] = {8, -8, 9, -9, 10, -11, 12};
	    int input2[] = {-10, 2, -1, 5};
	    int input3[] = {-2, 4, -1, 4, -1};
	    kwa.kadaneWrap(input);
	    kwa.kadaneWrap(input1);
	    kwa.kadaneWrap(input2);
	    kwa.kadaneWrap(input3);
	  }
}
