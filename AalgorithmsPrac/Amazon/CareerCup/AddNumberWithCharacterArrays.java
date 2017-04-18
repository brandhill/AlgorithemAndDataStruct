package CareerCup;

// https://www.careercup.com/question?id=5169340234072064

// Incomplete
public class AddNumberWithCharacterArrays {
	
	char[] addNumbers(char[] input1, char[] input2) {
		int dot1 = -1;
		int dot2 = -1;
		for(int i=0;i<input1.length; i++) {
			if(input1[i]=='.') {
				dot1 = i;
				break;
			}
		}
		for(int i=0;i<input2.length; i++) {
			if(input1[i]=='.') {
				dot2 = i;
				break;
			}
		}
		
		return input1;
	}
}
