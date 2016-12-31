package hackerrank.greedy;

import java.util.Scanner;

public class GoodlandElectricity {
	
	static int getCount(int[] c,int k) {
		boolean[] ref = new boolean[c.length];
		int n = getCountHelper(c,ref,0,c.length-1,k-1,0);
		for(int i = 0; i < ref.length; i++) {
			if(!ref[i])
				System.out.print(i+" ");
		}
		return n;
	}
	
	static int getCountHelper(int[] c,boolean[] ref,int start,int end,int k,int count) {
		
		System.out.println(start+" "+end+" "+count);
		if(start>=end) {
			return count;
		}
		
		int n = start +k;
		while( n>= Math.max(start-k, 0)  && c[n]==0 ) {
			n--;
		}
		System.out.println(n+" "+start);
		if(n<Math.max(start-k, 0))
			return -1;
		boolean check = false;
		for(int i = Math.max(n-k, 0); i <= n+k; i++) {
			if(!ref[i]) {
				if(!check) {
					count++;
					check = true;
				}
				ref[i] = true;
			}
		}
		int m = end-k;
		while(m<=Math.min(end+k, c.length-1) && c[m]==0){
			m++;
		}
		System.out.println(m+" "+end);
		if(m>Math.min(end+k, c.length-1))
			return -1;
		for(int i = m-k; i <= Math.min(m+k,c.length-1);i++){
			if(!ref[i]) {
				if(check) {
					count++;
					check = false;
				}
				ref[i] = true;
			}
		}
		return getCountHelper(c,ref,n+k+1,m-k-1,k,count);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int k = sc.nextInt();
		int[] c = new int[count];
		for(int i = 0; i < count; i++) {
			c[i] = sc.nextInt();
		}
		int val = GoodlandElectricity.getCount(c, k);
		System.out.println(val);
	}
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] towers = new int[n];
        for (int i = 0; i < n; i++) {
            towers[i] = sc.nextInt();
        }
        int i = 0;
        int maxTower = k-1;
        int ans = 0;
        while (true) {
            int nextTower = -1;
            while (i <= maxTower && i < n) {
                if (towers[i] == 1) {
                    nextTower = i;
                }
                i++;
            }
            if (nextTower == -1) {
                System.out.println(-1);
                return;
            }
            ans++;
            i = nextTower + 1;
            maxTower = nextTower+2*k-1;
            if (nextTower+k>=n)
                break;
        }
        System.out.println(ans);
    }*/
}
