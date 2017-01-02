package BehaviorPatterns.StratergyPattern;

/* In stratergy pattern a piece a code which is to be different for different subclass or
 *  a code has to changed dynamically for a class   */

public class mainclass {

	public static void main(String[] args) {
		Animal a1 = new Dog("Tommy","Dog");
		Animal a2 = new Bird("Parry","Parrot");
		a1.flyState();
		a2.flyState();
	}
	
	
}
