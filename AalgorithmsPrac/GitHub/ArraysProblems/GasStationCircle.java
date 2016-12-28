package ArraysProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GasStationCircle {
	
	static int startPoint(int[] petrol,int[] distance) {
		
		
		for(int i = 0; i < petrol.length; i++) {
			if(petrol[i]-distance[i] < 0) {
				continue;
			}
			//int end = i;
			//int start = -1;
			int start = i;
			int netPetrol = 0;
			/*while(start!=end){
				//System.out.println(end);
				if(end==i)
					netPetrol = petrol[end];
				else if (end==0) {
					netPetrol += petrol[end] - distance[petrol.length-1];
				}
				else {
					netPetrol += petrol[end] - distance[end-1];
				}
				if(netPetrol < distance[end]) {
					netPetrol -= distance[end];
					break;
				}
				if(start==-1) {
					start = end;
				}
				end++;
				if(end>=petrol.length-1) {
					end = 0;
				}
			}*/
			for(int j = start; j <= petrol.length-1; j++) {
				if(j==start) {
					netPetrol = petrol[j];
				}
				else {
					netPetrol += petrol[j] - distance[j-1];
					if(netPetrol < distance[j]) {
						netPetrol -= distance[j];
						break;
					}
				}
			}
			
			if(netPetrol>=0) {
				for(int j = 0 ; j < start; j++) {
					if(j==0) {
						netPetrol += petrol[j] - distance[petrol.length-1];
					}
					else{
						netPetrol += petrol[j] - distance[j-1];
					}
					if(netPetrol < distance[j]) {
						netPetrol -= distance[j];
						break;
					}
						
				}
			}
			
			if(netPetrol>=0) {
				//System.out.println("start "+start);
				return start;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		//int[] petrol = {4,6,7,4};
		//int[] distance = {6,5,3,5};
		
		  //int[] petrol = {6,3,7};
		  //int[] distance = {4,6,3};
		Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] petrol = new int[count];
        int[] distance = new int[count];
        for(int i = 0; i < count; i++) {
            petrol[i] = sc.nextInt();
            distance[i] = sc.nextInt();
        }
		int ans = GasStationCircle.startPoint(petrol, distance);
		System.out.println(ans);
		
	}
}
