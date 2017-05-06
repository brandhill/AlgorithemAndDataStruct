package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;

//You are given a 2D grid in which each cell is either empty, contains an entry “D” which stands 
//for Door, or an entry “W” which stands for wall (Obstacle). You can move in any of the four
//directions from each empty position in the grid. Of course you cannot move into a cell that 
//has “W” in it. You need to fill each empty cell with a number that represents the distance of 
//the closest door to that cell.

public class FindShortestDistanceForEmptyCells {
	
	
	static void updateShortestCount(Cell[][] cells) {
		
		Set<Cell> visitedDoors = new HashSet<Cell>();
		for(int i=0; i<cells.length; i++) {
			for(int j=0; j<cells[0].length; j++) {
				Cell cell = cells[i][j];
				if(cell.type==CellType.D && !visitedDoors.contains(cell)) {
					visitedDoors.add(cell);
					updateCounts(visitedDoors, cells, i, j-1, 0);
					updateCounts(visitedDoors, cells, i-1, j, 0);
					updateCounts(visitedDoors, cells, i, j+1, 0);
					updateCounts(visitedDoors, cells, i+1, j, 0);
				}
			}
		}
		
	}
	
	static void updateCounts(Set<Cell> visitedDoors,Cell[][] cells, int row, int column, int prevCount) {
		
		if(row<0 || row >= cells.length || column <0 || column >=cells[0].length || cells[row][column].type == CellType.W)
			return;
		Cell cell = cells[row][column];
		if(cell.type==CellType.D) {
			if(!visitedDoors.contains(cell)) {
			visitedDoors.add(cell);
			updateCounts(visitedDoors, cells, row, column-1, 0);
			updateCounts(visitedDoors, cells, row-1, column, 0);
			updateCounts(visitedDoors, cells, row, column+1, 0);
			updateCounts(visitedDoors, cells, row+1, column, 0);
			}
			return;
		}
		if(cell.shortestDoorCount!=0 && cell.shortestDoorCount<prevCount+1)
			return;
		cell.shortestDoorCount = prevCount +1;
		updateCounts(visitedDoors, cells, row, column-1, cell.shortestDoorCount);
		updateCounts(visitedDoors, cells, row-1, column, cell.shortestDoorCount);
		updateCounts(visitedDoors, cells, row, column+1, cell.shortestDoorCount);
		updateCounts(visitedDoors, cells, row+1, column, cell.shortestDoorCount);
	}
	
	public static void main(String[] args) {
		Cell[][] cells = new Cell[4][5];
		
		CellType[][] c = {{CellType.E,CellType.E,CellType.E,CellType.E,CellType.D},
						  {CellType.E,CellType.W,CellType.E,CellType.W,CellType.W},
						  {CellType.W,CellType.D,CellType.W,CellType.E,CellType.D},
						  {CellType.E,CellType.E,CellType.D,CellType.E,CellType.E}};
		for(int i=0; i <4; i++) {
			for(int j=0; j<5; j++) {
				cells[i][j] = new Cell(c[i][j],0);
			}
		}
		
		updateShortestCount(cells);
		for(int i=0; i <4; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(cells[i][j].type+"("+cells[i][j].shortestDoorCount+")");
			}
			System.out.println();
		}
	}
}


// E(4) E(3) E(2) E(1) D(0)
// E(5) W(0) E(3) W(0) W(0)
// W(0) D(0) W(0) E(1) D(0)
// E(2) E(1) D(0) E(1) E(1)


class Cell {
	CellType type;
	int shortestDoorCount;
	public Cell(CellType type, int shortestDoorCount) {
		this.type = type;
		this.shortestDoorCount = shortestDoorCount;
	}
	
}

enum CellType {
	D,W,E
}
