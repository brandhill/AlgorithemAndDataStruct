package CareerCup;

public class AddNumbersWithoutPlusOperator {
	static int Add(int x, int y){
	    while(y!=0){
	        int carry = (x&y)<<1;
	        System.out.println("Carry "+carry);
	        x=x^y;
	        System.out.println("x "+x);
	        y=carry;
	    }
	    return x;
	}
	
	public static void main(String[] args) {
		System.out.println(Add(21,12));
	}
}
