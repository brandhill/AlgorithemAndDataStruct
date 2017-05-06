package Designing.VendingMachine;

import java.util.List;

public abstract class Payment {

}

class Cash extends Payment {
	List<Coin> coins;
}

class Card extends Payment {
	String cardNumber;
	String expriryDate;
}