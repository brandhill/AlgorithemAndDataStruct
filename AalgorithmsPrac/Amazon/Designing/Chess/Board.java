package Designing.Chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	private final int size = 8;
	Piece[][] boxs = new Piece[size][size];
	Map<Integer, Piece> whitePieces = new HashMap<Integer, Piece>();
	Map<Integer, Piece> blackPieces = new HashMap<Integer, Piece>();
	Board() {
		// create board
	}
	
	List<Move> getListPossibleMoves(int pieceId, Color color) {
		// get Piece from map
		// calls Piece "getListPossibleMoves" method
		return null;
	}
	
	boolean isValidMove(Piece piece,Position toPosition) {
		// Check the properties(Color) of piece and check if the piece can go the requested position
		return false;
	}
	
	List<Piece> getPieces(Color color) {
		
		return null;
	}
	
	boolean moveTo(int pieceId, Position position) {
		//isValidMove()
		// if yes move piece and update piece position
		return false;
	}
	
	
	
}
