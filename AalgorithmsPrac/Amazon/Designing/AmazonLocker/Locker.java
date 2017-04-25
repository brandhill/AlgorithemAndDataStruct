package Designing.AmazonLocker;

public abstract class Locker {
	int lockerId;
	Dimensions dimensions;
	LockerType type;
	abstract Dimensions getDimenstions();
}

class SmallLocker extends Locker {

	@Override
	Dimensions getDimenstions() {
		return null;
	}
	
}

class MediumLocker extends Locker {
	@Override
	Dimensions getDimenstions() {
		return null;
	}
}

class LargeLocker extends Locker {
	@Override
	Dimensions getDimenstions() {
		return null;
	}
}

class Dimensions {
int length;
int bredth;
int height;
}