package ArraysAndStrings1;

public class Isrotation {

	static boolean isRotation(String s1,String s2) {
		
		if(s1.length() != s2.length())
			return false;
		if(s1.equalsIgnoreCase(s2))
			return true;
		
		for ( int i = 1 ; i < s1.length(); i++) {
			String fir = s1.substring(0, i);
			String sec = s1.substring(i);
			if( isSubstring(s2+s2,sec+fir)) {
				return true;
			}
			/*if(s2.equalsIgnoreCase(sec+fir))
				return true;
			*/
		}
		
		return false;
	}
	
	static boolean isSubstring(String s,String sub) {
		
		for ( int i = 0; i+sub.length()-1< s.length();i++) {
			if(s.substring(i, i+sub.length()).equalsIgnoreCase(sub)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(Isrotation.isRotation("waterbottle", "erbottlewat"));
		System.out.println(Isrotation.isRotation("HarshaChaitanya", "ChaitanyaHARSha"));
		
	}
}
