package Arrays;

public class CheckIfOneEditAway {
	
	static boolean checkIfOneEditAway(String s1, String s2) {
		if(s1==null && s2==null || (s1.isEmpty() && s2.isEmpty())) {
			return true;
		}
		
		if((s1==null || s2==null) || (s1.isEmpty() || s2.isEmpty())) {
			return false;
		}
		int diff = Math.abs(s1.length()-s2.length());
		if(diff>1) {
			return false;
		}
		boolean isInsertable = false;
		String longString = s1;
		String shortString = s2;
		if(diff==1) {
			isInsertable = true;
			if(s2.length()>s1.length()) {
				shortString = s1;
				longString = s2;
			}
		}
		int diffCount = 0;
		for(int i=0; i< shortString.length(); i++) {
			char c1 = longString.charAt(i);
			char c2 = shortString.charAt(i);
			if(c1!=c2) {
				diffCount +=1;
				if(isInsertable) {
					shortString = shortString.substring(0,i)+c1+shortString.substring(i,shortString.length());
					System.out.println(shortString);
					isInsertable  = false;
				}
			}
			if(diffCount>1)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkIfOneEditAway("abes","abeds"));
	}
}
