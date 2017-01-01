package String;

// Time - O(n)
// Space - O(n)

public class RunLengthEncoding {
	
    static String EncodeString(String s) {
    	if(s==null || s.trim().length()==0)
    		return "Cannot be Encoded";
    	StringBuffer output = new StringBuffer("");
    	char[] chars = s.toCharArray();
    	int i= 0;
    	while(i<s.length()) {
    		char c = chars[i];
    		output.append(c);
    		i++;
    		int count = 1;
    		while(i<s.length() && chars[i]==chars[i-1]) {
    			count++;
    			i++;
    		}
    		output.append(count);
    	}
    	
    	if(output.length()>s.length()) {
    		return s;
    	}
    	else
    		return output.toString();
    }
    
    public static void main(String args[]){
        
        String str = "AAAAAAAAAAAAABBCDDEEEEE";
    	//String str = "AAB";
    	//String str = "";
        String output = RunLengthEncoding.EncodeString(str);
        System.out.print(output);
    }
}
