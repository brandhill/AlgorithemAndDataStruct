package Designing.DeckofCards;


import java.util.Random;

public class DeckofCards {
	
	Card[] cards;
	private int dealCount;
	DeckofCards() {
		Type[] types = {Type.Clubs,Type.Diamonds,Type.Hearts,Type.Spades};
		Number[] values = {Number.Ace, Number.Two, Number.Three, Number.Four, Number.Five, Number.Six, Number.Seven, 
				Number.Eight, Number.Nine, Number.Ten, Number.Jack, Number.Queen, Number.King};
		int k = 0;
		cards = new Card[52];
		dealCount = 0;
		for(int i = 0; i < types.length; i++) {
			for(int j=0; j< values.length; j++) {
				cards[k] = new Card(types[i],values[j]);
				System.out.println(cards[k].type+" "+cards[k].value);
				k++;
			}
		}
	}
	
	void ShuffleCards() {
		dealCount = 0;
		Random random = new Random();
		int len = cards.length;
		for(int i=0; i< len; i++) {
			int temp = i + (Math.abs(random.nextInt()))%(len-i);
			swap(cards, i, temp);
		}
	}
	
	Card Deal() {
		if(dealCount==cards.length)
			return null;
		Card c = cards[dealCount];
		dealCount++;
		return c;
	}
	
	void Reset() {
		dealCount = 0;
		ShuffleCards();
	}
	
	void printCards() {
		for(int i=0; i< cards.length; i++) {
			System.out.println(cards[i].type+" "+cards[i].value);
		}
	}
	
	void swap(Card[] cards, int index1, int index2) {
		Card temp = cards[index1];
		cards[index1] = cards[index2];
		cards[index2] = temp;
	}
	
	public static void main(String[] args) {
		DeckofCards cards = new DeckofCards();
		cards.ShuffleCards();
		System.out.println("----");
		cards.printCards();
		System.out.println("----");
		Card c = cards.Deal();
		System.out.println("Deal "+ c.type+" "+c.value);
		c = cards.Deal();
		System.out.println("Deal "+ c.type+" "+c.value);
		c = cards.Deal();
		System.out.println("Deal "+ c.type+" "+c.value);
	}
	
}


class Card {
	Type type;
	Number value;
	
	Card(Type type, Number value) {
		this.type = type;
		this.value = value;
	}
}

enum Type {
	Spades, Diamonds, Clubs, Hearts
}

enum Number {
	Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
}