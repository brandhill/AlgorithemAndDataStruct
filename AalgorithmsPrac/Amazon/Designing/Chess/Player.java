package Designing.Chess;

import java.util.HashSet;
import java.util.Set;

public class Player {
	int playerId;
	String name;
	Color color;
	// Pieces Id that are alive in game
	Set<Integer> pieces = new HashSet<Integer>();
	
	boolean isValidPiece(int pieceId) {
		
		return false;
	}
	
	void killPiece(int pieceId) {
//		remove from set
	}
	

}
