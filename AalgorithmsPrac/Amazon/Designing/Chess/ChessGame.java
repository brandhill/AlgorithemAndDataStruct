package Designing.Chess;

import java.util.List;
import java.util.Map;

public class ChessGame {
	Board board;
	Player player1;
	Player player2;
	
	ChessGame(Player player1, Player player2) {
		// Create a board and add respective pieces to player map
	}
	
	List<Move> getListMoves(Player player, int pieceId) {
		//get piece from player
		boolean isValidPiece =  player.isValidPiece(pieceId);
		// if valid piece get list of valid moves from board
		return board.getListPossibleMoves(pieceId, player.color);
	}
	
	boolean MoveTo(Player player, int pieceId, Position position) {
		// check if valid piece 
		// if yes call board moveTo method
		return false;
	}
	
}
