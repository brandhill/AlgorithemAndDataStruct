package GraphsDataStructures;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainclass {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		//graph.print();
		
		//GraphBreadthFirstSearch.BreadthFirstSearch1(graph);
		//GraphDepthFirstSearch.DFS(graph);
		graph.findShortPath("Sara", "Maria");
	}
}

//File/SocialNetwork.txt