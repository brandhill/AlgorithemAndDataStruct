package ArraysandStrings;

//Find if String as unique characters?
public class FindifUniqueChars1 {
	public static void main(String[] args) {
		
	//String s = "asdfgdjk";
	  String s = "asdlgdjk";
	for(int i=0;i<s.length();i++){
		if(i!=s.lastIndexOf(s.charAt(i))){
			System.out.println(i);
			System.out.println("Does not have unique characters");
			break;
		}
		if(i==s.length()-1){
			System.out.println("String has unique characters");
		}
	}
	}
}
