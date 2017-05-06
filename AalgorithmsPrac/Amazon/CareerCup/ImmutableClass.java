package CareerCup;

public final class ImmutableClass implements Cloneable {
	
	private final String name;
	private Details details;
	ImmutableClass(String name, Details details) {
		this.name = name;
		this.details = details;
	}
	
	String getName() {
		return name;
	}
	
	Details getDetails() throws CloneNotSupportedException {
		return (Details) details.clone();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		ImmutableClass I = (ImmutableClass) super.clone();
		I.details = (Details) details.clone();
		return I;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ImmutableClass I = new ImmutableClass("Harsha",new Details(27));
		I.getDetails().age = 15;
		System.out.println(I.getDetails().age);
	}
}

class Details implements Cloneable {
	int age;
	
	Details(int age) {
		this.age = age;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		Details details = (Details) super.clone();
		return details;
	}
}