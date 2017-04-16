package Designing.TrafficController;

public class TrafficLightController {
	private Road North;
	private Road South;
	private Road West;
	private Road East;
	private static volatile TrafficLightController controller = null;
	private Road currentRoad;
	private TrafficLightController() {
		North = new Road();
		South = new Road();
		West = new Road();
		East = new Road();
		North.nextRoad = West;
		West.nextRoad = North;
		North.prevRoad = East;
		East.nextRoad = North;
		West.nextRoad = South;
		South.prevRoad = West;
		South.nextRoad = East;
		East.prevRoad = South;
		currentRoad = null;
	}
	
	static TrafficLightController getInstances() {
		if(controller == null) {
			synchronized(TrafficLightController.class) {
				if(controller == null) {
					controller = new TrafficLightController();
				}
			}
		}
		return controller;
	}
	
	void ToggleTrafficSignals() throws InterruptedException {
		if(currentRoad==null) {
			currentRoad = North;
		}
		currentRoad.GreenLight();
		Thread.sleep(10000);
		currentRoad.YellowLight();
		Thread.sleep(5000);
		currentRoad.RedLight();
		currentRoad = currentRoad.nextRoad;
		ToggleTrafficSignals();
	}
	
}
