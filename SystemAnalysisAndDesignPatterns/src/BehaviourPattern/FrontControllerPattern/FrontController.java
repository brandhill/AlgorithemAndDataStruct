package BehaviourPattern.FrontControllerPattern;

public class FrontController {
	
	// Dispatcher dispatcher = new Dispatcher();
	 Dispatcher dispatcher;
	 
	FrontController(){
		dispatcher = new Dispatcher();
	}
	
	void logger(){
		System.out.println("Request is logged");
	}
	
	void view(String request){
		System.out.println(request+" is requested");
	}
	boolean isAuthenticated(String request){
		//System.out.println(request+" is requested");
		if(request.equalsIgnoreCase("Home"))
		return true;
		else if(request.equalsIgnoreCase("Student"))
			return true;
		return false;
	}
	
	void dispatchrequest(String request){
		view(request);
		logger();
		if(isAuthenticated(request)){
			dispatcher.requestview(request);
		}
		else
			System.out.println(request+" view is not avaliable");
			
	}
}
