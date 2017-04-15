package Designing.TicTacToe;

public class Player {
	String name;
	Symbol symbol;
	
	Player(String name, Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "["+name + " symbol=" + symbol + "]";
	}
	
	
	
}

