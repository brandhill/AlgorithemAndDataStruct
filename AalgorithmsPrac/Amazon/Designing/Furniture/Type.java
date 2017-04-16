package Designing.Furniture;

public abstract class Type {
	
	abstract State applyWeight(int x, int y, int weight, int seconds);
}

class Chair extends Type{

	@Override
	State applyWeight(int x, int y, int weight, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Table extends Type{

	@Override
	State applyWeight(int x, int y, int weight, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Bed extends Type{

	@Override
	State applyWeight(int x, int y, int weight, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class BookReck extends Type{

	@Override
	State applyWeight(int x, int y, int weight, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

