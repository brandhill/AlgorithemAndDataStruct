package BitManuplations;

public class BitOperations {
	
	
	static boolean getBit(int num, int i) {
		int n = 1<<i;
		boolean ans = (num & n)!=0;
		return ans;
	}
	
	static int setBit(int num, int i) {
		int n = 1<<i ;
//		System.out.println(n);
		return (num | n);
	}
	
	static int clearBit(int num, int i) {
		int n = ~(1<<i);
		return (num & n);
	}
	
	static int clearBitFromRightTilli(int num, int i) {
		int n = ((1<<i)-1);
		System.out.println(n);
		return (num & n);
	}
	
	static int clearBitFromiTillLeft(int num, int i) {
		int n = ((1<<(i+1)));
		System.out.println(n);
		return (num & n);
	}
	
	public static void main(String[] args) {
		int num = (1<<3)-1;
//		System.out.println(num);
//		System.out.println(getBit(4,3));
//		System.out.println(setBit(7,3));
//		System.out.println(clearBit(15,2));
//		System.out.println(clearBitFromLeftTilli(15,2));
		System.out.println(clearBitFromiTillLeft(7,2));
		int n = (7<<2);
		System.out.println(n);
		
	}
}
