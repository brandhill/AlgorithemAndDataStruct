package ArraysAndStrings1;

public class ReplaceSpaces4 {
	
	static String replaceSpaces(String s){
		
		//String[] tokens = s.split(" ");
		//String s1 = s.replaceAll(" ", "%20");
		//System.out.println(s1);
		
		// If to be done using char array
		char[] chars = s.toCharArray();
		int len = s.length();
		int count = 0;
		for ( int i = 0; i < len; i++) {
			if(chars[i]==' ')
				count++;
		}
		int newLength = len + (count * 2);
		
		char[] chars1 = new char[newLength];
		//chars[newLength] = '\0';
		
		for( int i = len-1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars1[newLength-1] = '0';
				chars1[newLength-2] = '2';
				chars1[newLength-3] = '%';
				newLength = newLength - 3;
			}
			else {
				chars1[newLength-1] = chars[i];
				newLength = newLength - 1;
			}
		}
		
		
		return String.valueOf(chars1);
	}
	
	public static void main(String[] args) {
		System.out.println(ReplaceSpaces4.replaceSpaces("   my  name is harsha    "));
	}
}

//%20%20%20my%20%20name%20is%20harsha%20%20%20%20
//%20%20%20my%20%20name%20is%20harsha%20%20%20%20
