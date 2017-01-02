package BehaviorPatterns.FactoryPattern;

public interface Shape {
	abstract void draw();
}

class circle implements Shape{
	
	public void draw() {
		System.out.println("Draw a circle: "+hashCode());
	}
}

class rectangle implements Shape{
	public void draw() {
		System.out.println("Rectangle a circle");
	}
}

class triangle implements Shape{
	public void draw() {
		System.out.println("Triangle a circle");
	}
}