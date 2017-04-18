package Designing.Luggage;

import java.util.HashSet;
import java.util.Set;

public class ContainerQueue<T extends Luggage> {
	Container container;
	Set<T> set;
	
	public ContainerQueue(Container container) {
		this.container = container;
		set = new HashSet<T>();
	}

}

