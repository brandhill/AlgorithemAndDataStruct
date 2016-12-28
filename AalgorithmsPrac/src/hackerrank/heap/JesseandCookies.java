package hackerrank.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JesseandCookies {
	
	static int getTaste(int[] cookies, int taste) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for ( int i = 0; i < cookies.length; i++) {
			queue.add(cookies[i]);
		}
		int count = 0;
		while(queue.peek() < taste) {
			if(queue.size() < 2){
				return -1;
			}
			int i = queue.poll();
			int j = queue.poll();
			//System.out.println(i+" "+j);
			queue.add(i+(2*j));
			count++;
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int val = sc.nextInt();
		int[] arr = new int[count];
		for ( int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(JesseandCookies.getTaste(arr, val));
	}
}
