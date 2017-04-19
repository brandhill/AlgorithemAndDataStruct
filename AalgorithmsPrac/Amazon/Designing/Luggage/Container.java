package Designing.Luggage;

import static org.hamcrest.CoreMatchers.instanceOf;

public abstract class Container {
	int Capacity;
	int currentCount;
}

class SmallContainer extends Container {
	ContainerQueue<Luggage> smallQueue;
	public SmallContainer() {
		smallQueue = new ContainerQueue<Luggage>(this);
	}
	
	protected boolean addInSmallQueue(Luggage luggage) {
		return smallQueue.addLuggage(luggage);
	}
	
	public boolean addInQueue(Luggage luggage) {
		if(luggage instanceof Small)
			return addInSmallQueue(luggage);
		return false;
	}
}

class MediumContainer extends SmallContainer {
	ContainerQueue<Luggage> mediumQueue;
	public MediumContainer() {
		mediumQueue = new ContainerQueue<Luggage>(this);
	}
	
	protected boolean addInMediumQueue(Luggage luggage) {
		return mediumQueue.addLuggage(luggage);
	}
	
	public boolean addInQueue(Luggage luggage) {
		if (luggage instanceof Small)
			return addInSmallQueue(luggage);
		else if(luggage instanceof Medium)
			return addInMediumQueue(luggage);
		return false;
	}
	
	
}

class LargeContainer extends MediumContainer {
	ContainerQueue<Luggage> largeQueue;
	public LargeContainer() {
		largeQueue = new ContainerQueue<Luggage>(this);
	}
	
	protected boolean addInLargeQueue(Luggage luggage) {
		return largeQueue.addLuggage(luggage);
	}
	
	public boolean addInQueue(Luggage luggage) {
		if(luggage instanceof Small)
			return addInSmallQueue(luggage);
		else if(luggage instanceof Medium)
			return addInMediumQueue(luggage);
		else
			return addInLargeQueue(luggage);
	}
}