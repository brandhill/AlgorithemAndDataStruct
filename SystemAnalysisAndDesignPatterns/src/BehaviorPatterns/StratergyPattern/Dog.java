package BehaviorPatterns.StratergyPattern;

public class Dog extends Animal {

	Dog(String name,String type){
		super(name,type);
		setFlyState(new cantFly());
	}
	
	
}
