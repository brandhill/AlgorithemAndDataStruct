package ArraysProblems;

public class CountInversionOfSize3 {
	
	// Time - O(n^3)
	// Space - O(1)
	static public int findInversions(int[] input) {
		
		int a,b;
		int count =0;
		for (int i = 0; i < input.length-2; i++) {
			a = input[i];
			for (int j = i+1; j <input.length-1; j++) {
				if(input[j]<a) {
					b = input[j];
					for (int k = j+1; k <input.length; k++) {
						if(input[k]<b) {
							System.out.println(a+" "+b+" "+input[k]);
							count++;
						}
					}
				}
			}
			
			
		}
		System.out.println(count);
		return count;
	}
	// Time - O(n^2)
	// Space - O(1)
	static public int findInversions1(int[] input) { 
		int count = 0;
		
		for ( int i = 1; i <input.length-1;i++) {
			int a = input[i];
			int larger = 0;
			for ( int k = i-1; k >=0; k--) {
				if(input[k] > a) {
					larger++;
				}
			}
			int smaller = 0;
			for ( int k = i+1; k <input.length; k++) {
				if(input[k] < a) {
					smaller++;
				}
			}
			count += larger*smaller;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] input = {5,4,2,3,1};
		int count = CountInversionOfSize3.findInversions1(input);
		System.out.println(count);
	}
}
