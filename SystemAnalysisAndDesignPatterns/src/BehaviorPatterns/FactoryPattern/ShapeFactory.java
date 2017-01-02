package BehaviorPatterns.FactoryPattern;

public class ShapeFactory {
	private Shape circle;
	private Shape rectangle;
	private Shape triangle;
	private String scope;
	ShapeFactory(String scope){
		if(scope.equals("Singleton")) {
			circle = new circle();
			rectangle = new rectangle();
			triangle = new triangle();
		}
		this.scope = scope;
	}
	
	Shape getShape(String name) {
		if(scope.equals("Prototype")) {
			if(name.equalsIgnoreCase("Circle"))
				return new circle();
			else if(name.equalsIgnoreCase("Rectangle"))
				return new rectangle();
			else if(name.equalsIgnoreCase("Triangle"))
				return new triangle();
		}
		else if(scope.equals("Singleton")) {
			if(name.equalsIgnoreCase("Circle"))
				return circle;
			else if(name.equalsIgnoreCase("Rectangle"))
				return rectangle;
			else if(name.equalsIgnoreCase("Triangle"))
				return triangle;
		}
		else {
			System.out.println("Incorrect configuration. Constructor scope value should be - 'Prototype' or 'Singleton'");
		}		
		return null;
	}
}
