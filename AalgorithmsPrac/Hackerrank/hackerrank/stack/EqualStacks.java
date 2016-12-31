package hackerrank.stack;

import java.util.Scanner;

public class EqualStacks {
	
	static int findHeightOfStacks(int[] h1, int[] h2, int[] h3, int sum1,int sum2,int sum3){
		//Stack
		int i = 0;
		int j = 0;
		int k = 0;
		while(true){
			System.out.println(sum1+ " " + sum2 + " "+ sum3);
			if(sum1==0 || sum2==0 || sum3==0)
				return 0;
			else if(sum1==sum2?sum1==sum3:false){
				return sum1;
			}
			else{
				int sum = Math.max(sum1, Math.max(sum2, sum3));
				System.out.println(sum);
				if(sum==sum1){
					sum1 -= h1[i];
					i++;
				}
				else if(sum==sum2){
					sum2 -= h2[j];
					j++;
				}
				else if(sum==sum3){
					sum3 -= h3[k];
					k++;
				}
			}
			
		}
		
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int sum1 = 0;
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            sum1 = sum1 + h1[h1_i];
        }
        int h2[] = new int[n2];
        int sum2 = 0;
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            sum2 = sum2 + h2[h2_i];
        }
        int h3[] = new int[n3];
        int sum3 = 0;
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            sum3 = sum3 + h3[h3_i];
        }
        
        System.out.println(EqualStacks.findHeightOfStacks(h1, h2, h3, sum1, sum2, sum3));
    }
}
