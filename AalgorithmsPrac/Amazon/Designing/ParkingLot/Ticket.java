package Designing.ParkingLot;

import java.util.Date;

public class Ticket {
	int ticketId;
	Lot lot;
	PaymentType paymentType;
	Date checkIn;
	Date checkOut;
	UserDetails userDetails;
	Double price;
}

enum PaymentType {
	EarlyBird, Regular 
}
