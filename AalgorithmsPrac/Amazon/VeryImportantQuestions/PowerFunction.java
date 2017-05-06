package VeryImportantQuestions;

public class PowerFunction {
	
	static int power(int a, int b) {
		if(b==0)
			return 1;
		if(b==1)
			return a;
		System.out.println(a+" "+b);
		int result = power(a, b/2);
		System.out.println(a+" "+b);
		System.out.println(result);
		if(b%2==0)
			return result*result;
		return result*result*a;
	}
	
	
	public static void main(String[] args) {
		System.out.println(power(2,10));
	}
}
