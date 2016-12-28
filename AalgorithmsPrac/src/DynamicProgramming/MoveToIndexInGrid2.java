package DynamicProgramming;

public class MoveToIndexInGrid2 {
	
	static int moveTo(int X,int Y,int[][] map) {
		if(X < 0 || Y < 0)
			return 0;
		if( X == 0 && Y == 0 )
			return 1;
		else if (map[X][Y] != -1)
			return map[X][Y];
		else {
			map[X][Y] = moveTo(X-1,Y,map) + moveTo(X,Y-1,map);
		}
		
		return map[X][Y];
	}
	
	public static void main(String[] args) {
		int[][] map = {{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1}};
		//System.out.println(map[2][2]);
		int i = MoveToIndexInGrid2.moveTo(4, 4, map);
		System.out.println(i);
	}
}
