package BehaviorPatterns.StratergyPattern;

public class Animal {

	private String name;
	private String type;
	private Fly flyState;
	
	Animal(String name,String type){
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Fly getFlyState() {
		return flyState;
	}
	public void setFlyState(Fly flyState) {
		this.flyState = flyState;
	}
	void flyState(){
		getFlyState().isFlyable();
	}
	
}
