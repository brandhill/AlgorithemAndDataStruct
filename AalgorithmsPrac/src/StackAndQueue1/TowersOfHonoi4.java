package StackAndQueue1;

import java.util.Stack;

public class TowersOfHonoi4 {
 
	static Stack<Integer> t1 = new Stack<Integer>();
	static Stack<Integer> t2 = new Stack<Integer>();
	static Stack<Integer> t3 = new Stack<Integer>();
	
	
	static void moveTop(Stack<Integer> Src,Stack<Integer> Dest) {
		int item = Src.peek();
		System.out.println("Move item "+ item +" from "+Src+ " to " + Dest);
		Src.pop();
		Dest.push(item);
		//System.out.println("Move item "+ item +" from "+Src+ " to " + Dest);
	}
	
	static void movestacks(int size,Stack<Integer> Src, Stack<Integer> Dest,Stack<Integer> Buff) {
		if(size > 0) {
			movestacks (size-1,Src,Buff,Dest);
			moveTop(Src,Dest);
			movestacks(size-1,Buff,Dest,Src);
		}
		
	}
	
	public static void main(String[] args) {
		TowersOfHonoi4.t1.push(5);
		TowersOfHonoi4.t1.push(4);
		TowersOfHonoi4.t1.push(3);
		TowersOfHonoi4.t1.push(2);
		TowersOfHonoi4.t1.push(1);
		System.out.println("t1 "+TowersOfHonoi4.t1.hashCode());
		System.out.println("t2 "+TowersOfHonoi4.t2.hashCode());
		System.out.println("t3 "+TowersOfHonoi4.t3.hashCode());
		TowersOfHonoi4.movestacks(TowersOfHonoi4.t1.size(), TowersOfHonoi4.t1, TowersOfHonoi4.t3, TowersOfHonoi4.t2);
		
		
		
		
	}
}
