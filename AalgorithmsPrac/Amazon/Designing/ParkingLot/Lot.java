package Designing.ParkingLot;

public class Lot {
	int id;
	ParkingArea parkingArea;
	boolean isAvaliable;
	
	double getEarlyBirdPrice() {
		return parkingArea.getEarlyBirdPrice();
	}
	
	double getRegualrPrice() {
		return parkingArea.getRegualrPrice();
	}
	
	double getSpecialPrice() {
		return parkingArea.getSpecialPrice();
	}
}
