package StandardAlgorithems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class DijkstrasAlgorithem {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int connections = sc.nextInt();
		int start = sc.nextInt();
		int end = sc.nextInt();
		// Input distances between nodes is saved in matrix
		int[][] matrix = new int[size][size];
		// least distance of to reach the node is stored
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		// previous node which is used to reach node with shortest distance is stored
		int[] prevNode = new int[size];
		// If node is visited we add it in the visited set
		Set<Integer> visited = new HashSet<Integer>();
		for(int i = 0; i < size; i++) {
			Arrays.fill(matrix[i],Integer.MAX_VALUE);
		}
		//Adding all distances between nodes in the matrix from input
		for(int i = 0; i < connections; i++) {
					matrix[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		// Actual Alogoritem starts 
		// Initilizing the values for start node
		int nextNode = start;
		dist[nextNode] = 0;
		prevNode[nextNode] = -1;
		visited.add(nextNode);
		
		for(int i = 0; i < size; i++) {
			// min - maintain distance of nextNode with least distance 
			int min = Integer.MAX_VALUE;
			// node - temp variable to store nextNode
			int node = nextNode;
			
			// loop check all the connected nodes for 'nextNode'
			for(int j = 0; j < size; j++) {
				// if j node is not visited
				if(j!=nextNode && !visited.contains(j)) {
					
					int dis = matrix[nextNode][j]== Integer.MAX_VALUE?Integer.MAX_VALUE:dist[nextNode] + matrix[nextNode][j];
					
					// if new distance to reach j node is less than previous distance 
					if(dis<dist[j]) {
						dist[j] = dis;
						prevNode[j] = nextNode;
					}
					
					// maintains the nextNode which has least distance from start
					if(min>dist[j]) {
						min = dist[j];
						node = j;
					}
				}
			}
			nextNode = node;
			visited.add(nextNode);
		}
		
		int exit = end;
		Stack<Integer> stack = new Stack<Integer>();
		while(exit!=-1) {
			stack.push(exit);
			exit = prevNode[exit];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}
}


/*
 * 
7 9 
0 5
0 1 6
0 2 10
1 3 5
1 4 2
3 5 6
4 2 3
4 3 1
4 6 2
6 5 3
 */
