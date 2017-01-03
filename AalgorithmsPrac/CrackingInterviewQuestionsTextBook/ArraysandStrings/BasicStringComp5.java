package ArraysandStrings;

public class BasicStringComp5 {
	char[] s1 = null;
	int j = 0;
	public void addchars(char c,Integer count){
		s1[j] = c;
		j++;
	
		char[] cnt = count.toString().toCharArray();
		for(char c1:cnt){
			if(j>=s1.length){
				return;
			}
			s1[j] = c1;
			j++;
		}
	}
	public String stringcompchar(String s){
		char[] c = s.toCharArray();
		s1 = new char[s.length()];
		Integer count = new Integer(1);
		for(int i=0;i<s.length()-1;i++){
			//System.out.println("J size"+j+" "+" and s1 length "+s1.length);
			if(j>=s1.length){
				return s;
			}
			if(c[i]==c[i+1]){
				count++;
				if(i==s.length()-2 ){
					addchars(c[i], count);
					//count=1;
				}
			}
			else{
				addchars(c[i], count);
				count=1;
			}
			if(c[i]!=c[i+1] && i==s.length()-2){
				addchars(c[i+1], count);
			}
			
		}
		if(s1.toString().length()<=s.length())
			return s;
		
		return new String(s1) ;
	}
	
	public String stringcomp(String s){
		
		char[] c = s.toCharArray();
		StringBuffer s1 = new StringBuffer("");
		int count = 1;
		for(int i=0;i<s.length()-1;i++){
			if(c[i]==c[i+1]){
				count++;
				if(i==s.length()-2 ){
					s1.append(c[i]+""+count);
				}
			}
			else{
				s1.append(c[i]+""+count);
				count=1;
			}
			
			if(c[i]!=c[i+1] && i==s.length()-2){
				s1.append(c[i+1]+""+count);
			}
			
		}
		if(s1.length()>=s.length())
			return s;
		
		return s1.toString();
	}
	
	public static void main(String[] args) {
		BasicStringComp5 q5 = new BasicStringComp5();
		String s = q5.stringcompchar("aaabbcccc");
		System.out.println(s);
	}
}
