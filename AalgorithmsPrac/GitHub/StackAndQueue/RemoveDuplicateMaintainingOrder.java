package StackAndQueue;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;

// https://leetcode.com/problems/remove-duplicate-letters/

// Time - O(n^2)
// Space - O(n)
public class RemoveDuplicateMaintainingOrder {
	public String removeDuplicateLetters(String s) {
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
        System.out.println(rm.removeDuplicateLetters("cbacdcbc"));
        System.out.println(rm.removeDuplicateLetters("ccacbaba"));
        System.out.println(rm.removeDuplicateLetters("abacb"));
        
        
    }
}
