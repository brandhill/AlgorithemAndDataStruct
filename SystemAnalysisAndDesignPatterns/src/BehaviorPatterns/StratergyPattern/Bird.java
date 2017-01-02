package BehaviorPatterns.StratergyPattern;

public class Bird extends Animal {

	Bird(String name,String type){
		super(name,type);
		setFlyState(new canFly());
	}
}
