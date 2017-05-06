package CareerCup;

// https://www.careercup.com/question?id=5067380066615296

public class FindPositionWhichDividesBracktesBalancely {
	
	
	static int split(String s) {
		int i = 0;
		int count=0;
		while(i<s.length()) {
			if(s.charAt(i)==')') {
				count++;
			}
			i++;
		}
			return count;
	}


	public static void main(String[] args) {
		System.out.println(split("(())))("));
		System.out.println(split("(((((()((())"));
		System.out.println(split("))))))))("));
	

	}
}
