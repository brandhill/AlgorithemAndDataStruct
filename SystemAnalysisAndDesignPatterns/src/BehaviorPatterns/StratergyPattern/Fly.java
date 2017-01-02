package BehaviorPatterns.StratergyPattern;

public interface Fly {

	void isFlyable();
}

class canFly implements Fly{

	@Override
	public void isFlyable() {
		
		System.out.println("I can fly");
		
	}
	
}

class cantFly implements Fly{

	@Override
	public void isFlyable() {
		
		System.out.println("I cannot fly");
		
	}
	
}