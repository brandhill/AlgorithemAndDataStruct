package VeryImportantQuestions;

import GraphsDataStructures.mainclass;

public class AsciiToInteger {
	
	public static int asciiToInt(String str)
	{
	int result = 0;
	for(int i = 0; i < str.length();i++)
	{
		System.out.println("Before "+result);
		System.out.println((int)str.charAt(i)+" "+(int) '0');
	result*= 10;
	result+= str.charAt(i)-'0';
	System.out.println("After "+result);
	}
	return result;
	}
	
	public static String intToAscii(int i) {
	StringBuilder sb = new StringBuilder();
	while(i != 0)
	{
	char c =  (char) (48+(i%10));
	System.out.println((48+(i%10)));
	System.out.println(c);
	sb.insert(0,c);
	i/= 10;
	}
	return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(asciiToInt("abcd"));
		System.out.println(intToAscii(54562));
		char c = (char) 97;
		System.out.println(c);
	}
	
}
