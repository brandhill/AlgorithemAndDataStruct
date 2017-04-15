package VeryImportantQuestions;

public class CheckIfSkierPathExists {
	
	
	static boolean checkIfPathExits(int[][] mountain) {
		
		boolean[][] checkIfVisited = new boolean[mountain.length][mountain[0].length];
		
		checkIfPathExits(mountain,checkIfVisited,0,0);
		
		return checkIfVisited[mountain.length-1][mountain[0].length-1];
	}

	private static void checkIfPathExits(int[][] mountain,boolean[][] visited,int i, int j) {
		if(i>mountain.length-1 || j>mountain[0].length-1 || visited[i][j] || mountain[i][j]==1 || visited[mountain.length-1][mountain[0].length-1])
			return;
		System.out.println(i+","+j);
		visited[i][j] = true;
		checkIfPathExits(mountain,visited,i+1,j);
		checkIfPathExits(mountain,visited,i,j+1);
	}
	
	
	public static void main(String[] args) {
		int[][] mountain = new int[][]
				{{0,0,0,1,0,0,0,0},
				{0,0,0,1,0,0,0,0},
				{1,1,0,0,0,1,1,1},
				{0,1,1,1,0,0,0,0},
				{0,0,0,0,1,1,0,1},
				{0,0,1,0,1,0,0,0},
				{0,0,0,0,1,0,1,0}};
				System.out.println(mountain[0].length+" "+mountain.length);
		System.out.println(checkIfPathExits(mountain));
	}
}
