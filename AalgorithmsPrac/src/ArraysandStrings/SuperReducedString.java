package ArraysandStrings;

import java.util.Scanner;

public class SuperReducedString {

	 static String reduceString(String S){
		 if(S==null || S.trim().isEmpty() ){
			 return "Empty String";
		 }
		char[] chars = S.toCharArray();
		
		int i =0;
		boolean check = false;
		while(i<=S.length()-2){
			check = false;
			if(chars[i]==chars[i+1]){
				S = S.substring(0,i)+S.substring(i+2);
				chars = S.toCharArray();
				check = true;
			}
			if(check && i==0){
				i = 0;
			}
			else if(check) {
				i--;
			}
			else{
				i++;
			}
		}
		
		/*for(int i=0;i <= S.length()-2;i++){
			//System.out.println(chars[i]+" "+chars[i+1]);
			System.out.println("Start "+ i);
			if(chars[i]==chars[i+1]){
				System.out.println(chars[i]+" "+chars[i+1]);
				S = S.substring(0,i)+S.substring(i+2);
				i--;
				chars = S.toCharArray();
			}
			System.out.println(i);
		}*/
		if(S.isEmpty())
			return "Empty String";
		else
			return S;
	}
	
	 
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//String S = sc.nextLine();
		System.out.println(SuperReducedString.reduceString("aaabccddd"));
	}
}
