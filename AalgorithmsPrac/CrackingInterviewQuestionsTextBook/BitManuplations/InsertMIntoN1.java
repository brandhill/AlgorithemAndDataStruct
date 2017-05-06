package BitManuplations;

public class InsertMIntoN1 {
	
	static int InsertMIntoN(int M, int N, int i, int j) {
		int allOnes = ~0;
		int moveByJ = allOnes << (j+1);
		System.out.println(moveByJ);
		int moveByI = (allOnes << i)-1;
		System.out.println(moveByI);
		int mask = moveByJ | moveByI;
		int clearNBetweenIandJ = N & mask;
		return clearNBetweenIandJ & clearNBetweenIandJ;
	}
	
	static void convertToBinary(int n) {
		StringBuilder s = new StringBuilder("");
		while(n>1) {
			s.append(n%2);
			n /= 2;
		}
		if(n==1)
			s.append(1);
		System.out.println(s.reverse().toString());
	}
	
	public static void main(String[] args) {
		convertToBinary(InsertMIntoN(1024,19,2,6));
	}
}
