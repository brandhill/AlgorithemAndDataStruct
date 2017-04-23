package Designing.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class TicketDao  implements TicketDaoInterface {
	
	Map<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
	int currentTicketId = 0;
	@Override
	public Ticket addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		currentTicketId += 1;
		return null;
	}

	@Override
	public Ticket getTicket(int ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}

interface TicketDaoInterface {
	
	Ticket addTicket(Ticket ticket);
	
	Ticket getTicket(int ticketId);
	
	Ticket updateTicket(Ticket ticket);
	
}