package Designing.Luggage;

public class Container {
	int Capacity;
	int currentCount;
}

class SmallContainer extends Container {
	ContainerQueue<Small> smallQueue;
	public SmallContainer() {
		smallQueue = new ContainerQueue<Small>(this);
	}
}

class MeidumContainer extends Container {
	ContainerQueue<Small> smallQueue;
	ContainerQueue<Medium> mediumQueue;
	public MeidumContainer() {
		smallQueue = new ContainerQueue<Small>(this);
		mediumQueue = new ContainerQueue<Medium>(this);
	}
}

class LargeContainer extends Container {
	ContainerQueue<Small> smallQueue;
	ContainerQueue<Medium> mediumQueue;
	ContainerQueue<Large> largeQueue;
	public LargeContainer() {
		smallQueue = new ContainerQueue<Small>(this);
		mediumQueue = new ContainerQueue<Medium>(this);
		largeQueue = new ContainerQueue<Large>(this);
	}
}