package hackerrank.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SnakesandLadders {
	
	static int QuickWay(Map<Integer,Integer> Ladder,Map<Integer,Integer> Snake) {
		QuickCount Q = new QuickCount();
		//System.out.println(Q.count);
		QuickWayHelper(100, Ladder, Snake, Q, 0);
		return Q.count;
	}
	
	static void QuickWayHelper(int start,Map<Integer,Integer> Ladder,Map<Integer,Integer> Snake,QuickCount Q,int count) {
		
		if(start == 1 && (Q.count==-1 || Q.count > count)) {
			Q.count = count;
			return;
		}
		
		int i = start;
		while( i > 1 ) {
			int temp = i;
			count++;
			if(Q.count!= -1 && count > Q.count)
				return;
			//System.out.print(i+" ");
			Map<Integer,Integer> LadderSnake = new HashMap<Integer,Integer>();
			for (int j = 0; j <=6; j++) {
				int num = i-j < 1?1:i-j;
				if(num == 1 && (Q.count==-1 || Q.count > count)) {
					Q.count = count;
					return;
				}
				if(Ladder.containsKey(num)) {
					LadderSnake.put(num,Ladder.get(num));
				}
				else if (Snake.containsKey(num)) {
					LadderSnake.put(num,Snake.get(num));
				}
			}
			if(!LadderSnake.isEmpty()) {
				for (Integer L: LadderSnake.keySet()) {
					if(Math.abs(LadderSnake.get(L) - L) > 6) {
					if(L==100)
						QuickWayHelper(LadderSnake.get(L),Ladder,Snake,Q,count-1);
					else
						QuickWayHelper(LadderSnake.get(L),Ladder,Snake,Q,count);
					}
				}
			}
			for (int j = 6; j >=1; j--) {
				int num1 = i-j < 1?1:i-j;
				if(!LadderSnake.containsKey(num1) && !Snake.containsValue(num1)) {
					i = num1;
					break;
				}
			}
			if(i == temp)
				return;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < loop; i++) {
			Map<Integer,Integer> Ladder = new HashMap<Integer,Integer>();
			Map<Integer,Integer> Snake = new HashMap<Integer,Integer>();
			int L = sc.nextInt();	
			for (int j = 0; j < L;j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				Ladder.put(end, start);
			}
			int S = sc.nextInt();	
			for (int j = 0; j < S;j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				Snake.put(end, start);
			}
			
			output.add(SnakesandLadders.QuickWay(Ladder, Snake));
		} 
		
		for(Integer i : output) {
			//System.out.println();
			System.out.println(i);
		}
	}
}

class QuickCount {
	int count;
	QuickCount(){
		count = -1;
	}
}

class LadderSnakeClass {
	int start;
	int end;
	LadderSnakeClass(int start, int end) {
		this.start = start;
		this.end = end;
	}
}