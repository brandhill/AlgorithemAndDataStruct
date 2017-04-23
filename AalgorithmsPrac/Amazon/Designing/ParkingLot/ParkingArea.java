package Designing.ParkingLot;

import java.util.List;
import java.util.Queue;

public class ParkingArea {
	int id;
	String name;
	Payment payment;
	List<Lot> lots;
	
	double getEarlyBirdPrice() {
		return payment.earlyBirdPrice;
	}
	
	double getRegualrPrice() {
		return payment.regularPrice;
	}

	public double getSpecialPrice() {
		
		return payment.specialOfferPrice;
	}
}
