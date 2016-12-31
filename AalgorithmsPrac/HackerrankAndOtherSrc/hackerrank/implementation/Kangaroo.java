package hackerrank.implementation;

import java.util.Scanner;

public class Kangaroo {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p1 = sc.nextInt();
		int v1 = sc.nextInt();
		int p2 = sc.nextInt();
		int v2 = sc.nextInt();
		if (p1<=p2) {
			if(v1<=v2){
				System.out.println("NO");
			}
			else {
				int i = 1;
				while(p1<p2) {
					p1 = p1 + (v1*i);
					p2 = p2 + (v2*i);
					if(p1==p2) {
						System.out.println("YES");
						break;
					}
					else if(p1>p2){
						System.out.println("NO");
						break;
					}
				}
			}
		}
		else if (p1>=p2) {
			if(v1>=v2){
				System.out.println("NO");
			}
		}
		else {
			int i = 1;
			while(p2<p1) {
				p1 = p1 + (v1*i);
				p2 = p2 + (v2*i);
				if(p1==p2) {
					System.out.println("YES");
					break;
				}
				else if(p2>p1){
					System.out.println("NO");
					break;
				}
			}
		}
	}
}
