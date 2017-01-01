package StackAndQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/

public class RemoveDuplicateMaintainingOrder {
	// Time - O(n)
	// Space - O(n)
	public String removeDuplicateLetters(String s) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		StringBuffer output = new StringBuffer("");
		char[] chars = s.toCharArray();
		for(int i = 0; i <s.length(); i++) {
			char c= s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		Stack<Character> stack = new Stack<Character>();
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length();i++) {
			char c = chars[i];
			map.put(c, map.get(c)-1);
			if(stack.isEmpty()) {
				stack.push(c);
				set.add(c);
				continue;
			}
			while (!stack.isEmpty() && c<stack.peek() && map.get(stack.peek())>0 && !set.contains(c)) {
				set.remove(stack.pop());
			}
			 
			if(!set.contains(c)){
				stack.push(c);
				set.add(c);
			}
		}
		
		while(!stack.isEmpty()) {
			output.append(stack.pop());
		}
		
		return output.reverse().toString();
	}
	// Time - O(n^2)
	// Space - O(n)
	public String removeDuplicateLetters1(String s) {
		Set<Character> finalSet = new HashSet<Character>();
		StringBuffer output = new StringBuffer("");
		int size = 0;
		for(int i = 0; i <s.length(); i++) {
			char c= s.charAt(i);
			if(!finalSet.contains(c)) {
				size++;
				finalSet.add(c);
			}
		}
		Queue<Character> queue = new LinkedList<Character>();
		int index=-1;
		//Set<Character> finalSet = new HashSet<Character>();
		while(size!=0) {
		Set<Character> tempSet = new HashSet<Character>();
		char temp = 'z';
		int temp1=0;
		int size1 = 0;
		for(int i = s.length()-1; i >index; i--) {
			char c= s.charAt(i);
			//System.out.println(!finalSet.contains(c)+" "+c);
			if(!tempSet.contains(c) && finalSet.contains(c)) {
				size1++;
				//System.out.println("executed"+" "+size1+" "+size);
				tempSet.add(c);
			}
			if(size1==size && temp>=c && finalSet.contains(c)) {
				//System.out.println(size+" "+c+" "+i);
				temp = c;
				temp1 = i;
			}
		}
		finalSet.remove(temp);
		queue.add(temp);
		index = temp1;
		size--;
		//System.out.println("----");
		}
		
		while(!queue.isEmpty()) {
			output.append(queue.poll());
		}
		
		return output.toString();
	}
	
	public static void main(String args[]) {
        RemoveDuplicateMaintainingOrder rm = new RemoveDuplicateMaintainingOrder();
        //System.out.println(rm.removeDuplicateLetters("cbabdccbdc"));
        //System.out.println(rm.removeDuplicateLetters("ccbdbba"));
        System.out.println(rm.removeDuplicateLetters("bcabc"));
        
        
    }
}
//abcd
//cbda
//abc