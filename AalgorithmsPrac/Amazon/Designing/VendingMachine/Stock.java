package Designing.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
	
	Map<Position, List<Item>> stock = new HashMap<Position, List<Item>>();
	
	
	Item getItem(Position position) throws Exception {
		List<Item> list = stock.get(position);
		if(list.size()==0)
			throw new Exception("Out of Stock");
			
		return list.get(list.size()-1);
	}
	
	Item removeItem(Position position) throws Exception {
		List<Item> list = stock.get(position);
		if(list.size()==0)
			throw new Exception("Out of Stock");
			
		return list.remove(list.size()-1);
	}
}

