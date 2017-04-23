package Designing.ParkingLot;

import java.util.Date;

public class ParkingController {
	
	ParkingLotDao parkingLotDAO;
	TicketDao ticketDAO;
	private volatile static ParkingController parkingController;
	private ParkingController() {
		
	}
	
	static ParkingController getInstance() {
		if(parkingController==null) {
			synchronized (ParkingController.class) {
				if(parkingController==null) { 
					parkingController = new ParkingController();
				}
			}
		}
		return parkingController;
	}
	
	Ticket vehicleEnter(Ticket ticket, int parkingAreaId) throws Exception {
		Lot lot = parkingLotDAO.getParkingLot(parkingAreaId);
		if(lot==null)
			throw new Exception("Parking Lot is full");
		ticket.lot = lot;
		Ticket updateTicket = ticketDAO.addTicket(ticket);
		return updateTicket;
	}
	
	Ticket getTicket(int ticketId) {
		Ticket ticket = ticketDAO.getTicket(ticketId);
		return ticket;
	}
	
	Ticket vehicleExit(int ticketId, Date exitTime) {
		Ticket ticket = getTicket(ticketId);
		ticket.checkOut = exitTime;
		ticket.price = CalculatePrice(ticket);
		ticketDAO.updateTicket(ticket);
		parkingLotDAO.addParkingLot(ticket.lot);
		return ticket;
	}
	
	boolean checkIfParkingAreaIsFull(int parkingAreaId) {
		return parkingLotDAO.checkIfFull(parkingAreaId);
	}
	
	static double CalculatePrice(Ticket ticket) {
		Double price = null;
		if(ticket.paymentType == PaymentType.EarlyBird) {
			price = ticket.lot.getEarlyBirdPrice()*9;
		} else {
			// time diff
			double timeDiff = 1;
			price =   timeDiff*ticket.lot.getRegualrPrice();
		}
		return price;
   }
}


