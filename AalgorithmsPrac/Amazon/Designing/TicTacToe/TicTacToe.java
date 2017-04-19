package Designing.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter player 1 name");
		String player1  = sc.next();
		System.out.println("Enter player 2 name");
		String player2  = sc.next();
		Game newGame = new Game(player1,player2);
		Player currentPlayerName = newGame.p1;
		int count = 0;
		int maxCount = newGame.size*newGame.size;
		System.out.println(newGame.p1.toString());
		System.out.println(newGame.p2.toString());
		System.out.println("Game Started");
		Random random = new Random();
		while(count < maxCount) {
			newGame.printBoard();
			System.out.println(currentPlayerName.name+" turn");
			System.out.println("Enter grid coordinates");
			int x =  (Math.abs(random.nextInt())%3);
			int y = (Math.abs(random.nextInt())%3);
			while(!currentPlayerName.checkIfSelectionIsValid(x, y)) {
				System.out.println(x+" "+y);
				System.out.println("Please enter valid co-ordinate in range:" +newGame.size+"X"+newGame.size);
				x = (Math.abs(random.nextInt())%3);
				y = (Math.abs(random.nextInt())%3);
			}
			if(currentPlayerName.selectGrid(x, y)) {
				System.out.println(currentPlayerName.name+" "+"won the game");
				break;
			}
			count++;
			if(count==maxCount)
				System.out.println("Match Tie");
			currentPlayerName = (currentPlayerName==newGame.p1)?newGame.p2:newGame.p1;
		}
		newGame.printBoard();
	}
}
