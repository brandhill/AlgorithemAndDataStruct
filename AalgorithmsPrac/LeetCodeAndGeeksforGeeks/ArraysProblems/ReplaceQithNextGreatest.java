package ArraysProblems;

// http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
public class ReplaceQithNextGreatest {
	
	static int[] NextGreatest(int[] input) {
		int prev = -1;
		for(int i = input.length-1; i >= 0; i--) {
				//System.out.println(prev);
				int temp = input[i];
				input[i] = prev;
				prev = Math.max(temp, prev);
		}
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i]+" ");
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = {16, 17, 4, 6, 5, 2};
		ReplaceQithNextGreatest.NextGreatest(input);
	}
}
