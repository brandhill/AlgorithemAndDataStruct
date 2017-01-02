package BehaviorPatterns.FactoryPattern;

public class mainclass {

	public static void main(String[] args) {
		ShapeFactory shapes = new ShapeFactory("Singleton");
		Shape circle = shapes.getShape("Circle");
		circle.draw();
		Shape circle1 = shapes.getShape("Circle");
		circle1.draw();
		ShapeFactory shapes1 = new ShapeFactory("Prototype");
		Shape circle2 = shapes1.getShape("Circle");
		circle2.draw();
		Shape circle3 = shapes1.getShape("Circle");
		circle3.draw();
	}
}
