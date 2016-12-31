package hackerrank.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestRectangle {
	
	
	static int findLargestRectangle(Integer[] list){
		int area = 1;
		for( int i = 0; i < list.length; i++) {
			//System.out.println(i);
			int height = list[i];
			int count = 1;
			for( int j = i+1; j < list.length; j++) {
				if(list[j]>=height) {
					count++;
				}
				else{
					break;
				}
			}
			
			for( int k = i-1; k >=0; k--){
				if(list[k]>=height) {
					count++;
				}
				else{
						break;
					}
					
			}
			height = height * count;
			if(height > area) {
				area = height;
			}
		}
		
		return area;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		String s = in.nextLine();
		String[] list1 = s.split(" "); 
		Integer[] list = new Integer[count];
		for( int i = 0; i < list1.length; i++) {
			list[i] = Integer.valueOf(list1[i]);
			//System.out.println(list[i]);
		}
		System.out.println(LargestRectangle.findLargestRectangle(list));
	}
}
