package Designing.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImp implements VendingMachine{
	
	Stock stock = new Stock();
	CashInventory cashInventory = new CashInventory();
	Map<Integer, Receipt> receipts = new HashMap<Integer, Receipt>();
	public Item getItem(Position position) {
		return null;
	}

	public Receipt makePayment(Item item, Payment payment) {
		return null;
	}

}
