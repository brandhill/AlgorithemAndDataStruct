package ArraysAndStrings1;

// Compress a string 
// Ex: 'aabcccccaaa' to 'a2b1c5a3', 'aa' to 'aa', 'aaa' to 'a3', 'aaab' to 'aaab'

public class BasicStringComp5 {
		
	static String StrinCompress(String s ) {
		
		if ( s.length() <= 2 || s == null ) 
			return s;
		
		char[] chars = s.toCharArray();
		int count = 1;
		char last = chars[0];
		StringBuffer str = new StringBuffer();
		for ( int i = 1; i < chars.length; i++ ) {
				
			if ( chars[i]==last ) {
				count++;
			}
			else {
				str.append(last);
				str.append(count);
				last = chars[i];
				count = 1;
			}
		} 
		str.append(last);
		str.append(count);
		if(str.length()>=s.length())
			return s;
		else
			return str.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(BasicStringComp5.StrinCompress("aaabbbbc"));
	}
}
