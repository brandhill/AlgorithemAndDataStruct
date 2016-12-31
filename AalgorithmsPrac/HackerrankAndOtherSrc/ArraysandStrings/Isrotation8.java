package ArraysandStrings;

import java.util.Arrays;

public class Isrotation8 {
	public String sort(String s){
		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		String sorted = new String(c1);
		return sorted;
	}
	
	public boolean isRotation(String s1,String s2){
	if(s1.length()!=s2.length() || !(sort(s1.toLowerCase()).equalsIgnoreCase(sort(s2.toLowerCase())))){
		return false;
	}

	int len = s1.length();
	for(int i=0;i<len;i++){
		String firstString = s1.substring(i,len);
		String secondString = s1.substring(0, i);
		String s = firstString+secondString;
		if(s.equalsIgnoreCase(s2)){
			return true;
		}
	}
	return false;	
	}
	
	public static void main(String[] args) {
		Isrotation8 q8 = new Isrotation8();
		System.out.println(q8.isRotation("HarshaChaitanya", "ChaitanyaHARSha"));
	}
}
