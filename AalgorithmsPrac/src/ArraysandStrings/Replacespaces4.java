package ArraysandStrings;

public class Replacespaces4 {
	
	public String replacespances(String s){
		char[] c1 = s.trim().toCharArray();
		
		String[] tokens = new String(c1).split(" ");
		StringBuffer finalstring = new StringBuffer("");
		for(int i =0;i<tokens.length;i++){
		if(i!=tokens.length-1)
		finalstring.append(tokens[i]+"%20");
		else
		finalstring.append(tokens[i]);
		}
		return finalstring.toString();
	}
	
	public static void main(String[] args) {
		
		Replacespaces4 r = new Replacespaces4();
		String s = r.replacespances("   my name is harsha    ");
		System.out.println(s);
	}
}
