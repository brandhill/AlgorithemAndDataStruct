	package hackerrank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumPerimeterTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < count; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list,Collections.reverseOrder());
        int i = 2;
        int a = list.get(0);
        int b = list.get(1);
        int c = -1;
        while(i < list.size()) {
            c = list.get(i);
            if(a < b+c) {
                System.out.println(c+" "+b+" "+a);
                break;
            }
            a = b;
            b = c;
            i++;
        }
        	
        if(i >= list.size()) {
           System.out.println(-1);
        }
    }
}
