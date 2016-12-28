package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RichieRich {
	
	static String HighestPalindrome(String number, int k) {
		if(number==null || number.isEmpty())
			return "-1";
		char[] chars = number.toCharArray();
		if(number.length() <= k) {
			for ( int i = 0; i <chars.length; i++) {
				chars[i] = '9';
			}
			return String.valueOf(chars);
		}
		int lowIndex = 0;
		int highIndex = number.length() - 1;
		
		//System.out.println(lowIndex+" "+highIndex);
		Queue<Store> queue = new LinkedList<Store>();
		int high = 9;
		int count = 0;
		while(lowIndex < highIndex) {
			char l = number.charAt(lowIndex);
			char h = number.charAt(highIndex);
			//System.out.println(l+" "+h);
			int v = 0;
			if(l > h) {
				queue.add(new Store(highIndex,l));
				//System.out.println(v);
				count++;
			}
			else if (l < h) {
				queue.add(new Store(lowIndex,h));
				//System.out.println(v);
				count++;
			}
			lowIndex++;
			highIndex--;
		}
		int diff = k - count;
		if(diff<0)
			return "-1";
		else if (diff>0) {
			while (diff > 0 && !queue.isEmpty()) {
				Store st = queue.poll();
				int index = st.index;
				int value = Integer.valueOf(String.valueOf(st.val));
				if ( value < high) {
					value = high;
					diff--;
				}
					chars[index] = Integer.toString(value).charAt(0);
					chars[number.length()-1-index] = Integer.toString(value).charAt(0);
			}
			
			int index = 0;
			while(diff > 1 && index <= number.length()/2) {
				int value = Integer.valueOf(String.valueOf(chars[index]));
					if ( value < high) {
						value = high;
						diff = diff-2;
						chars[index] = Integer.toString(high).charAt(0);
						chars[number.length()-1-index] = Integer.toString(value).charAt(0);
					}
						index++;
			}
			
			if (diff%2==1) {
				chars[number.length()/2] = '9';
			}
			
		}
		
		while(!queue.isEmpty()) {
			Store st1 = queue.poll();
			int index = st1.index;
			int value = Integer.valueOf(String.valueOf(st1.val));
			//System.out.println(index+" "+value);
			chars[index] = Integer.toString(value).charAt(0);
			chars[number.length()-1-index] = Integer.toString(value).charAt(0);
		}
		
		
		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
		String a = RichieRich.HighestPalindrome(number, k);
		System.out.println(a);
	}
}

class Store {
	int index;
	char val;
	
	Store(int index,char val) {
		this.index = index;
		this.val = val;
	}
}