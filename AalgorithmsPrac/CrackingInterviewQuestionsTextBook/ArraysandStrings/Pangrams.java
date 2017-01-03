package ArraysandStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.nextLine();
		Map<Character,Boolean> map = new HashMap<Character,Boolean>();
		for(int i=97;i<=122;i++){
			map.put((char) i, false);
		}
		char[] chars = S.toLowerCase().toCharArray();
		for(int i=0;i<S.length();i++){
			if(map.containsKey(chars[i])){
				map.put(chars[i],true);
			}
		}
		
		if(map.containsValue(false)){
			System.out.println("not pangram");
		}
		else{
			System.out.println("pangram");
		}
		
	}
}
