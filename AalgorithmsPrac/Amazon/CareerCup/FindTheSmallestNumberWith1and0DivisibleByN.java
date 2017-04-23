package CareerCup;

import java.util.HashMap;
import java.util.Map;

// https://www.careercup.com/question?id=6017875829587968

public class FindTheSmallestNumberWith1and0DivisibleByN {
	
	static Double findSmallestNumber(int n) {
		
		double i = 1;
		double value = 0;
		// key -  reminder, value - i
		Map<Integer,Double> remainderLookUp = new HashMap<Integer,Double>();
		
		int temp = n;
		boolean check = true;
		while(temp!=1) {

			int k = temp%10;
			System.out.println(temp+" "+k);
			if(k!=1 && k!=0) {
				check = false;
				break;
			}
			temp /= 10;
		}
		if(check)
			return (double) n;
		System.out.println(check);
		while(i<Double.MAX_VALUE && i>0) {
			int remainder = (int) i%n;
			System.out.println(i+" "+remainder);
			if(remainder==0) {
				return i;
			}
			else if(remainderLookUp.containsKey(remainder)) {
				value = i - remainderLookUp.get(remainder);
				return value;
			} 
			remainderLookUp.put(remainder, i);
			i *= 10;
			i += 1;
		}
		
		return (double) -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findSmallestNumber(367));
	}
}
