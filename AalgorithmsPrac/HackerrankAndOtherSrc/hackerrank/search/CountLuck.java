package hackerrank.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountLuck {
	
	static String countLuck(char[][] forest, int k, int r2, int c2) {
		
		Result result = new Result();
		countLuckHelper(forest,r2,c2,0,result);
		//System.out.println(count);
		if(result.count == k) {
			return "Impressed";
		}
		else
			return "Oops!";
	}
	
	 private static void  countLuckHelper(char[][] forest, int r2, int c2,int count,Result result) {
		 
		 if(forest[r2][c2]=='X')
			 return;
		 else if(forest[r2][c2]=='*') {
			 result.count = count;
			 return;
		 }
		 int count1 = 0;
		 forest[r2][c2] = 'X';
		 char a = forest[Math.max(r2-1, 0)][c2];
		 if(a!='X') {
			 count1++;
		 }
		 char b = forest[Math.min(r2+1, forest.length-1)][c2];
		 if(b!='X') {
			 count1++;
		 }
		 char c = forest[r2][Math.max(c2-1, 0)];
		 if(c!='X') {
			 count1++;
		 }
		 char d = forest[r2][Math.min(c2+1, forest[0].length-1)];
		 if(d!='X') {
			 count1++;
		 }
		 //System.out.println(a+" "+b+" "+c+" "+d);
		 //System.out.println(count1);
		 if(count1==0) {
			 return;
		 }
		 else if(count1>1) {
			 count++;
		 }
		 
		 //System.out.println(r2+" "+c2+" "+count);
		countLuckHelper(forest,Math.max(r2-1, 0),c2,count,result); 
		countLuckHelper(forest,Math.min(r2+1, forest.length-1),c2,count,result); 
		countLuckHelper(forest,r2,Math.max(c2-1, 0),count,result); 
		countLuckHelper(forest,r2,Math.min(c2+1, forest[0].length-1),count,result);
	 }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();;
		
		List<String> output = new ArrayList<String>();
		
		for ( int m = 0; m < loop; m++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int r2 = -1;
			int c2 = -1;
			char[][] forest = new char[row][col];
			sc.nextLine();
		for ( int i = 0; i < row; i++) {
				String input = sc.nextLine();
				forest[i] = input.toCharArray();
				//if(r2!=-1) {
					for ( int j = 0; j < input.length(); j++) {
						if(forest[i][j]=='M') {
							r2 = i;
							c2 = j;
							break;
						}
							
					//}
				}
		}
		int k = sc.nextInt();
		output.add(CountLuck.countLuck(forest, k, r2, c2));
		}
		
		for ( String s : output) {
			System.out.println(s);
		}
	}
}

class Result {
	int count;
}
