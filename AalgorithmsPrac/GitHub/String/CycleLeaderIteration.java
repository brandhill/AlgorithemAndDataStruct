package String;

public class CycleLeaderIteration {
	
	// Time - O(n), Space - O(1)
	 public void iterate(char str[]){
	        int power = 1;
	        int len = str.length;
	        while(power<len) {
	        	int index = power;
	        	int newIndex = -1;
	        	char temp = str[index];
	        	char temp1;
	        	//System.out.println("power "+power);
	        	while(newIndex!=power) {
	        		//System.out.print(index+" ");
	        		if(index%2==0) {
	        			newIndex = index/2;
	        		}
	        		else {
	        			newIndex = len/2 + index/2;
	        		}
	        		temp1 = str[newIndex];
	        		str[newIndex] = temp;
	        		temp = temp1;
	        		index = newIndex;
	        	}
	        	//System.out.println();
	        	power *= 3;
	        }
	    }
	 
		// Time - O(n), Space - O(n)
	 public void iterate1(char str[]){
		 	int len = str.length;	
		 	boolean[] check = new boolean[len];
		 	for(int i = 0; i < str.length; i++) {
		 		int j = i;
		 		char temp = str[j];
		 		char temp1;
		 		while(!check[j]) {
		 			check[j] = true;
		 			if(j%2==0) {
		 				j = j/2;
		 			}
		 			else {
		 				j = len/2 + j/2;
		 			}
		 			temp1 = str[j];
		 			str[j] = temp;
		 			temp = temp1;
		 		}
		 	}
	    }
	    
	    public static void main(String args[]){
	        String str = "1a2b3c4d5e6f7g8h9iAjBkClDmEn";
	        System.out.println(str.length());
	        char[] str1 = str.toCharArray();
	        char[] str2 = str.toCharArray();
	        CycleLeaderIteration cli = new CycleLeaderIteration();
	        cli.iterate1(str1);
	        for(char ch: str1){
	            System.out.print(ch + " ");
	        }
	        System.out.println();
	        cli.iterate(str2);
	        for(char ch: str2){
	            System.out.print(ch + " ");
	        }
	    }
}
