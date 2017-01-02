package BehaviourPattern.FrontControllerPattern;

public class Dispatcher {
	private HomeView home;
	private StudentView student;
	Dispatcher(){
		home = new HomeView();
		student = new StudentView();
	}
	
	public void requestview(String request){
		if(request.equalsIgnoreCase("home"))
			home.display();
		else if(request.equalsIgnoreCase("student"))
			student.display();
	}
}
