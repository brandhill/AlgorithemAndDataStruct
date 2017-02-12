package DynamicProgramming;

public class RecusrExample {
	
	static int recurseMethodSum(int n,int sum) {
		if(n<0)
			return 0;
		//System.out.println("n "+n);
		System.out.println("Step "+n);
		sum = n+recurseMethodSum(n-1,sum);
		System.out.println("Step "+n);
		//System.out.println("sum "+sum);
		return sum;
	}
	
	public static void main(String[] args) {
		int n = RecusrExample.recurseMethodSum(10, 0);
		System.out.println(n);
	}
}
