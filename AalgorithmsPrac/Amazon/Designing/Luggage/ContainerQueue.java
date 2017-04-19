package Designing.Luggage;

import java.util.ArrayList;
import java.util.List;

public class ContainerQueue<T extends Luggage> {
	Container container;
	List<T> list;
	
	public ContainerQueue(Container container) {
		this.container = container;
		list = new ArrayList<T>();
	}
	
	boolean addLuggage(T luggage) {
		return list.add(luggage);
	}
}

