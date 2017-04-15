package VeryImportantQuestions;

public class findIsland {
	static int countIslands(int[][] ocean) {
		boolean[][] visited = new boolean[ocean.length][ocean[0].length];
		int count = 0;
		for(int i=0; i< ocean.length; i++) {
			for(int j = 0; j < ocean[0].length; j++) {
				if(!visited[i][j] && ocean[i][j]==1) {
//					System.out.println(i+" "+j);
					visited[i][j] = true;
					findIslandHelper(ocean,visited,i,j);
					count++;
				}
			}
		}
	return count;	
	}
	
	private static void findIslandHelper(int[][] ocean, boolean[][] visited, int row, int column) {
		int rowStart =  Math.max(row-1, 0);
		int rowEnd = Math.min(row+1,ocean.length-1);
		int columnStart = Math.max(column-1, 0);
		int columnEnd = Math.min(column+1, ocean[0].length-1);
		for(int i = rowStart; i <=rowEnd; i++) {
			for(int j = columnStart; j <= columnEnd; j++) {
				if(!visited[i][j] && ocean[i][j]==1) {
					visited[i][j] = true;
					findIslandHelper(ocean, visited, i, j);
				}
			}
		}
	}
	
	static int countIslands1(int[][] ocean) {
//		boolean[][] visited = new boolean[ocean.length][ocean[0].length];
		int count = 0;
		for(int i=0; i< ocean.length; i++) {
			for(int j = 0; j < ocean[0].length; j++) {
				if(ocean[i][j]==1) {
//					System.out.println(i+" "+j);
					ocean[i][j] = 0;
					findIslandHelper1(ocean,i,j);
					count++;
				}
			}
		}
	return count;	
	}
	
	private static void findIslandHelper1(int[][] ocean, int row, int column) {
		int rowStart =  Math.max(row-1, 0);
		int rowEnd = Math.min(row+1,ocean.length-1);
		int columnStart = Math.max(column-1, 0);
		int columnEnd = Math.min(column+1, ocean[0].length-1);
		for(int i = rowStart; i <=rowEnd; i++) {
			for(int j = columnStart; j <= columnEnd; j++) {
				if(ocean[i][j]==1) {
					ocean[i][j] = 0;
					findIslandHelper1(ocean, i, j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] map = new int[][]
			   {{0,0,0,0,0,0,1,0},
				{0,0,1,1,0,0,1,0},
				{0,0,0,0,0,1,1,1},
				{1,1,1,0,0,0,0,0},
				{0,1,1,0,1,1,0,1},
				{0,0,0,0,1,0,0,1},
				{0,1,0,0,1,0,0,0}};
		
		System.out.println(countIslands1(map));
	}
}
