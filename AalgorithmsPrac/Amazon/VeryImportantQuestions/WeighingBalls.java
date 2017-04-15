package VeryImportantQuestions;


//Given an array of balls (objects) of uniform size and shape where one ball is slightly heavier than the
//others (and the rest weigh the same), and a balance scale (in the form of a function- scale(array,
//leftStart, leftEnd, rightStart, rightEnd), which weighs the two sides of the array and returns -1,0,1 if
//the left is heavier, even, or right is heavier) find the index of the heavier ball in an efficient manner.

public class WeighingBalls {
	
	static int FindOddBall(int[] balls) {
		if(balls==null)
			return -1;
		return ScaleBy3(balls, 0, balls.length-1);
	}
	
	private static int ScaleBy3(int[] balls,int start, int end) {
		if((end-start+1)/3==1) {
			return Scale(balls, start, end);
		}
		
		int n = (end-start+1)/3;

		int x = weighingscale(balls, start, start+n-1,start+n,start+2*n-1);
		if(x==-1) {
			return ScaleBy3(balls, start, start+n-1);
		} else if(x==1) {
			return ScaleBy3(balls, start+n, start+2*n-1);
		}
		start += 2*n; 
		
		return ScaleBy3(balls, start, end);
	}
	
	private static int Scale(int[] balls,int start,int end) {
		System.out.println("Start "+start+" end "+end);
		if(start==end) {
			return start;
		}
		int mid = (start+end)/2;
		int lstart = -1;
		int lend = -1;
		int rstart = -1;
		int rend = -1;
		if((start+end)%2==0) {
			lstart = start;
			lend = mid-1;
			rstart = mid+1;
			rend = end;
		}
		else {
			lstart = start;
			lend = mid;
			rstart = mid+1;
			rend = end;
		}
		int n = weighingscale(balls,lstart,lend,rstart,rend);
		if(n==-1){
			return Scale(balls,lstart,lend);
		}
		else if(n==1) {
			return Scale(balls,rstart,rend);
		}
		return mid;
	}
	
	private static int weighingscale(int[] balls, int lstart, int lend, int rstart, int rend) {
		System.out.println(lstart+","+lend+" - "+rstart+","+rend);
		int leftSum = findSum(balls,lstart,lend);
		int rightSum = findSum(balls,rstart,rend);
		System.out.println(leftSum+" "+rightSum);
		if(leftSum>rightSum) {
			return -1;
		} else if(leftSum<rightSum) {
			return 1;
		}
		return 0;
	}
	
	static private int findSum(int[] balls, int start, int end) {
		int sum = 0;
		for(int i = start; i<=end; i++) {
			sum += balls[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] balls = {1,1,1,1,1,1,1,1,1,1,2,1,1,1,1};
		System.out.println(FindOddBall(balls));
	}
}
