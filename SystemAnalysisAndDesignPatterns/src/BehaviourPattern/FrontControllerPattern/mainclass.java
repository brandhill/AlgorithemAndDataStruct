package BehaviourPattern.FrontControllerPattern;

public class mainclass {

	public static void main(String[] args) {
		FrontController controller = new FrontController();
		controller.dispatchrequest("student");
		System.out.println("-----");
		controller.dispatchrequest("home");
	}
}
