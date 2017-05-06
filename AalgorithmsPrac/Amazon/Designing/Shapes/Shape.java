package Designing.Shapes;

public abstract class Shape implements Comparable {
	int Area;
	abstract void calculateArea();
	
	@Override
	public int compareTo(Object o) {
		
		return 0;
	}
}

class Rectangle extends Shape {

	@Override
	void calculateArea() {
	}


	
}

class Square extends Shape {
	@Override
	void calculateArea() {
	}
}

class Circle extends Shape {
	@Override
	void calculateArea() {
	}
}