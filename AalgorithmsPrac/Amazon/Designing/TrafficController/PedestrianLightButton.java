package Designing.TrafficController;

public class PedestrianLightButton {
	Light pedestrainLight;
	boolean flag;
	
	PedestrianLightButton(Light pedestrainLight) {
		this.pedestrainLight = pedestrainLight;
	}
	
	void pressButton(boolean flag) {
		this.flag = flag;
	}
	
	void ToggleLight(Colore colore) {
		pedestrainLight.setColor(colore);
	}
	
}
