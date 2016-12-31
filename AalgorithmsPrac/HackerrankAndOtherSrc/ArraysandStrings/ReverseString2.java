package ArraysandStrings;

public class ReverseString2 {
	
	public static String reverse(char[] str){
		char[] str1 = new char[str.length];
		int j = 0;
		for(int i=str.length-1;i>=0;i--){
			
			str1[j] = str[i];
			System.out.println(str1[j]);
			j++;
		}
		
		return new String(str1);
	}
	
	public static void main(String[] args) {
		String s = "harshachaitanya";
		char[] str = s.toCharArray();
		System.out.println(reverse(str));
	}
}
