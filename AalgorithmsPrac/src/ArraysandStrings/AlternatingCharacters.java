package ArraysandStrings;

import java.util.Scanner;

public class AlternatingCharacters {

	static void Deletechars(String[] input){
		String[] output = new String[input.length];
		for(int i=0;i<input.length;i++){
			StringBuffer SB = new StringBuffer(input[i]);
			int count = 0;
			for(int j=0;j<=input[i].length()-2;j++){
				if(SB.charAt(j)==SB.charAt(j+1))
					count++;
			}
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String[] input = new String[len];
        for(int i=0;i<len;i++){
        	input[i] = in.next();
        }
        AlternatingCharacters.Deletechars(input);
	}
}
