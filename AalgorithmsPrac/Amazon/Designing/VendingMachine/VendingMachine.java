package Designing.VendingMachine;

public interface VendingMachine {
	
	public Item getItem(Position position);
	
	public Receipt makePayment(Item item, Payment payment);
}
