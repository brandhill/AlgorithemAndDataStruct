package Designing.AmazonLocker;

public abstract class Package {
	int packageId;
	Dimensions dimenstions;
	
	abstract Dimensions getDimenstions();
}

class SmallPackage extends Package {

	@Override
	Dimensions getDimenstions() {
		return null;
	}
	
}

class MediumPackage extends Package {
	@Override
	Dimensions getDimenstions() {
		return null;
	}
}

class LargePackage extends Package {
	@Override
	Dimensions getDimenstions() {
		return null;
	}
}