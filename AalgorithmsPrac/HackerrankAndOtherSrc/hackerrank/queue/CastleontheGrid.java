package hackerrank.queue;

import java.util.Arrays;
import java.util.Scanner;

public class CastleontheGrid {
	
	static int MoveCastle(char[][] chart,int eX,int eY,int X, int Y) throws InterruptedException{
		int[][] track = new int[chart.length][chart.length];
		for(int i = 0; i < track.length; i++) {
			Arrays.fill(track[i], -1);
		}
		track = MoveCastleHelper(chart,eX,eY,X,Y,track,0);
		for(int i = 0; i < track.length; i++) {
			for(int j = 0; j < track.length; j++) {
				System.out.print(track[i][j]+" ");
			}
			System.out.println();
		}
		return track[eX][eY];
	}
	
	private static int[][] MoveCastleHelper(char[][] chart,int eX,int eY,int X, int Y,int[][] track, int count) throws InterruptedException{
		int N = chart.length;
		//System.out.println(N-1);
		if( !(X>=0 && X < N  && Y>=0 && Y < N && chart[X][Y]!='X' && (track[X][Y] > count || track[X][Y]==-1)))
			return track;
		
		track[X][Y] = count;
		//}
		//System.out.println("("+X+","+Y+")"+" - "+track[X][Y]);
		// X-1,Y-1
		MoveCastleHelper(chart,eX,eY,X-1,Y-1,track,count+1);
		// X-1,Y
		MoveCastleHelper(chart,eX,eY,X-1,Y,track,count+1);
		// X-1,Y+1
		MoveCastleHelper(chart,eX,eY,X-1,Y+1,track,count+1);
		// X,Y-1
		MoveCastleHelper(chart,eX,eY,X,Y-1,track,count+1);
		// X,Y+1
		MoveCastleHelper(chart,eX,eY,X,Y+1,track,count+1);
		// X+1,Y-1
		MoveCastleHelper(chart,eX,eY,X+1,Y-1,track,count+1);
		// X+1,Y
		MoveCastleHelper(chart,eX,eY,X+1,Y,track,count+1);
		// X+1,Y+1
		MoveCastleHelper(chart,eX,eY,X+1,Y+1,track,count+1);
		
		return track;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		//int N = sc.nextInt();
		//char[][] chart = new char[N][N];
		char[][] chart = {{'.','.','X','.'},{'.','.','X','.'},{'.','.','X','.'},{'.','X','.','.'}};
		int count = CastleontheGrid.MoveCastle(chart, 2, 3, 2, 1);
		System.out.println(count);
	}
}
