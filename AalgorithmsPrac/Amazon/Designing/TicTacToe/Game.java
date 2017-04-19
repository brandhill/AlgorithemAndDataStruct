package Designing.TicTacToe;

public class Game {
	Player p1;
	Player p2;
	private Symbol[][] board;
	final int size = 3;
	Game(String player1, String player2) {
		p1 = new Player(player1,Symbol.O);
		p2 = new Player(player2,Symbol.X);
		p1.currentGame = this;
		p2.currentGame = this;
		board = new Symbol[size][size];
	}
	
	 boolean checkIfSelectionIsValid(int x, int y) {
		if(x<0 || x>=size || y<0 || y>=size)
			return false;
		if(board[x][y]!=null)
			return false;
		else
			return true;
	}
	
	boolean selectGrid(Player p, int x, int y) {
		if(!checkIfSelectionIsValid(x, y))
			return false;
		board[x][y] = p.symbol;
		return checkIfWon(p,x,y);
	}
	
	private boolean checkIfWon(Player p, int x, int y) {
		if(checkHorizontal(p,x,y) || checkVertical(p,x,y) || checkDiagnol(p,x,y))
			return true;
		
		return false;
	}
	
	private boolean checkHorizontal(Player p, int x, int y) {
		for(int i=0;i<board[0].length;i++) {
			if(board[x][i] != p.symbol)
				return false;
		}
		return true;
	}
	
	private boolean checkVertical(Player p, int x, int y) {
		for(int i=0;i<board[0].length;i++) {
			if(board[i][y] != p.symbol)
				return false;
		}
		return true;
	}
	
	private boolean checkDiagnol(Player p, int x, int y) {
		if(x==y) {
			for(int i=0;i<board[0].length;i++) {
				if(board[i][i] != p.symbol)
					return false;
			}
			return true;
		}
		if(Math.abs(x-y)==(size-1) || (x==size/2 && y==size/2)) {
			for(int i=0;i<board[0].length;i++) {
				if(board[i][size-1-i] != p.symbol)
					return false;
			}
			return true;
		}
		return false;
	}
	
	void printBoard() {
		for(int i = 0; i < size; i++) {
			for(int j =0; j< size; j++) {
				if(board[i][j]==null) {
					System.out.print("E ");
				}
				else {
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
