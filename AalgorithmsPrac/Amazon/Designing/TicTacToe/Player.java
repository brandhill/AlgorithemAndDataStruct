package Designing.TicTacToe;

public class Player {
	String name;
	Symbol symbol;
	Game currentGame;
	Player(String name, Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
		currentGame = null;
	}

	@Override
	public String toString() {
		return "["+name + " symbol=" + symbol + "]";
	}
	
	public boolean selectGrid(int x, int y) {
		return currentGame.selectGrid(this, x, y);
	}
	
	public boolean checkIfSelectionIsValid(int x, int y) {
		return currentGame.checkIfSelectionIsValid(x, y);
	}
	
}

