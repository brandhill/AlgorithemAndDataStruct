package Designing.Luggage;

import java.util.HashMap;
import java.util.Map;

// https://www.careercup.com/question?id=5709721782714368

public class BaggageCheckInController {
	Container smallContainer;
	Container mediumContainer;
	Container largeContainer;
	Map<Integer,ContainerQueue<Luggage>> lookUp = new HashMap<Integer,ContainerQueue<Luggage>>();
	private int tokenCounter = 1;
	public BaggageCheckInController() {
		super();
		this.smallContainer = new  SmallContainer();
		this.mediumContainer = new MeidumContainer();
		this.largeContainer = new LargeContainer();
		this.tokenCounter =  1;
	}
	
	
}
