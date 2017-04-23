package Designing.Chess;

import java.util.List;

public abstract class Piece {
	int pieceId;
	Color color;
	Board board;
	Position position;
	
	// Generates all possible moves from current position
	// validate which are valid moves using the "Board" method "isValidMove"
	abstract List<Move> getListDifferentMoves();
}

class Position {
	int x;
	int y;
}

class Move {
	Position position;
	Move next;
}


class Pawn extends Piece {
	@Override
	List<Move> getListDifferentMoves() {
		return null;
	}
}

class Rook extends Piece {
	@Override
	List<Move> getListDifferentMoves() {
		return null;
	}
}

class Knight extends Piece {
	@Override
	List<Move> getListDifferentMoves() {
		return null;
	}
}

class Bishop extends Piece {
	@Override
	List<Move> getListDifferentMoves() {
		return null;
	}
}

class King extends Piece {
	@Override
	List<Move> getListDifferentMoves() {
		return null;
	}
}

class Queen extends Piece {
	@Override
	List<Move> getListDifferentMoves() {
		return null;
	}
}