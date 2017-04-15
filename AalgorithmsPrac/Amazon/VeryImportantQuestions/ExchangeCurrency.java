package VeryImportantQuestions;

public class ExchangeCurrency {
	
	static int countCombination(int n) {
		return countCombinations(n,100);
	}
	
	private static int countCombinations(int n, int currency) {
		System.out.println(n);
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		int combinations = 0;
		if(currency==100)
			combinations += countCombinations(n-100,100);
		if(currency>=50)
			combinations += countCombinations(n-50,50);
		if(currency>=25)
			combinations += countCombinations(n-25,25);
		if(currency>=10)
			combinations += countCombinations(n-10,10);
		if(currency>=5)
			combinations += countCombinations(n-5,5);
		
			combinations += countCombinations(n-1,1);
		
			return combinations;
	}
	
	public static void main(String[] args) {
		int n = countCombination(10);
		System.out.println("count "+n);
	}
}
