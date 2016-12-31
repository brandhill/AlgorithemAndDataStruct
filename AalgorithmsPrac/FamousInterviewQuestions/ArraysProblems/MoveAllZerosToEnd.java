	package ArraysProblems;

import java.util.Arrays;

// Time - O(n)
// Space - O(1)

public class MoveAllZerosToEnd {
	
	
	// Other solution(simple code)
	public void moveZeros1(int arr[]){ 
		int slow = 0;
		int fast = 0; 
		
		while(fast<arr.length) {
			if(arr[fast]==0) {
				fast++;
				continue;
			}
			arr[slow] = arr[fast];
			slow++;
			fast++;
		}
		
		while(slow<arr.length) {
			arr[slow++] = 0;
		}
	}
	
	// My Solution(more code)
	public void moveZeros(int arr[]){
        int slow = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]==0) {
				slow = i;
				break;
			}
		}
		int fast = slow+1;
		System.out.println("slow "+slow);
		while(fast<arr.length) {
			System.out.println("fast "+fast);
			if(arr[fast]!=0 && fast>slow) {
				arr[slow] = arr[fast];
				arr[fast] = 0;
				slow++;
				while(slow<arr.length) {
					System.out.println("slow "+slow);
					if(arr[slow]==0) {
						break;
					}
					slow++;
				}
			}
			fast++;
			
        }
		//System.out.println(Arrays.toString(arr));
    }
    
	
    public static void main(String args[]){
        MoveAllZerosToEnd maz  = new MoveAllZerosToEnd();
        //int arr[] = {0,0,1,2,0,5,6,7,0};
        int arr[] = {1,2,3,4,0,4,5,0,4};
        maz.moveZeros1(arr);
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
