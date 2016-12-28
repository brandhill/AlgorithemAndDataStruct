//asdasdad
package Test;

import java.util.HashMap;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public abstract class Solution {
	
	static int sum(int[] numbers) {
		int sum = 0;
		for(int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		return sum;
	}
	static void StairCase(int n ){
		for ( int i = n; i > 0; i--){
			for(int j =1; j <=n;j++) {
				if(j>=i){
					System.out.print("#");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		StairCase(6);
//		HashMap map = new HashMap();
		//Solution1 sol1 = new Solution1();
		String s = "mercury";
		for(int i = 0; i < s.length(); ++i) {
			System.out.println(i);
		}
	}
}
