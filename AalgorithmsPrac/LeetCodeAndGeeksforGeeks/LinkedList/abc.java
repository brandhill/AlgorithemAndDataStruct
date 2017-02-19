package LinkedList;

public class abc {
	public static String reverseString(String input) {
		
		 String[] strings = input.split(" ");
		 Integer k = new Integer(strings[strings.length-1]);
		 StringBuffer output = new StringBuffer("");
		 for(int i = 0; i < strings.length-1;i++) {
			 if(i==k-1) {
				 char[] chars = strings[i].toCharArray();
				 for(int j = chars.length-1; j >=0; j--) {
					 output.append(chars[j]);
				 }
			 }
			 else {
				 output.append(strings[i]);
			 }
			 output.append(" ");
		 }
		 System.out.println(output.toString());
		 return output.toString();
	}
public static void main(String[] args) {

	
	
	int[] a = new int[10];
	for(int i = 0; i < 10; ++i) {
		a[i] = i;
		System.out.println(a[i]+" ");
		i++;
		
	}
}
}
