package Designing.Luggage;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

// https://www.careercup.com/question?id=5709721782714368

public class BaggageCheckInController {
	SmallContainer smallContainer;
	MediumContainer mediumContainer;
	LargeContainer largeContainer;
	// Lookup table : key : id for a ContainerQueue
	Map<Integer,ContainerQueue<Luggage>> lookUp = new HashMap<Integer,ContainerQueue<Luggage>>();
	// key - Token, value: id of ContainerQueue 
	Map<Integer,Integer> ContainerQueueLookUp = new HashMap<Integer,Integer>();
	private int tokenCounter;
	
	public BaggageCheckInController() {
		this.smallContainer = new  SmallContainer();
		this.mediumContainer = new MediumContainer();
		this.largeContainer = new LargeContainer();
		this.tokenCounter =  1;
		lookUp.put(1, smallContainer.smallQueue);
		lookUp.put(2, mediumContainer.smallQueue);
		lookUp.put(3, mediumContainer.mediumQueue);
		lookUp.put(4, largeContainer.smallQueue);
		lookUp.put(5, largeContainer.mediumQueue);
		lookUp.put(6, largeContainer.largeQueue);
	}
	
	boolean addBaggage(String BaggageDeatils,LuggageType type) {
		Luggage luggage;
		if(type==LuggageType.Small)
			luggage = new Small(tokenCounter, BaggageDeatils);
		else if(type==LuggageType.Medium)
			luggage = new Medium(tokenCounter, BaggageDeatils);
		else
			luggage = new Large(tokenCounter, BaggageDeatils);
		if(smallContainer.currentCount<smallContainer.Capacity)
			return smallContainer.addInQueue(luggage);
		else if(mediumContainer.currentCount<mediumContainer.Capacity)
			return mediumContainer.addInQueue(luggage);
		else
			return largeContainer.addInQueue(luggage);
	}
	
	Luggage getBaggage(int token) {
		int id = ContainerQueueLookUp.get(token);
		ContainerQueue<Luggage> containerQueue = lookUp.get(id);
		List<Luggage> list = containerQueue.list;
		
		return null;
	}
}

enum LuggageType {
	Small, Medium, Large
}