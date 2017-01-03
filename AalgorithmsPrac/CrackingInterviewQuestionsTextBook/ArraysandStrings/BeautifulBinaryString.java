package ArraysandStrings;

import java.util.Scanner;

public class BeautifulBinaryString {

	static void StringModif(String s){
		StringBuffer SB = new StringBuffer(s);
		int count = 0;
		for(int i=0;i<SB.length()-2;i++){
			if(SB.substring(i, i+3).equalsIgnoreCase("010")){
				SB.setCharAt(i+2,'1');
				i=i+2;
				count++;
			}
		}
		//System.out.println(SB.toString());
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        BeautifulBinaryString.StringModif(s);
        
	}
}
