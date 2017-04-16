package Designing.TrafficController;

public class Road {
	Light frontLight;
	ArrowLight directionLight;
	PedestrianLightButton button;
	Road prevRoad;
	Road nextRoad;
	
	Road() {
		frontLight = new Light(Colore.RED);
		directionLight = new ArrowLight(Colore.RED, Direction.NONE);
		Light pedestrainLight = new Light(Colore.RED);
		button = new PedestrianLightButton(pedestrainLight);
	}
	
	void GreenLight() {
		frontLight.setColor(Colore.GREEN);
		if(button.flag) {
			button.pedestrainLight.setColor(Colore.GREEN);
		}
	}
	
	void YellowLight() {
		frontLight.setColor(Colore.YELLOW);
		if(button.flag) {
			button.pedestrainLight.setColor(Colore.GREEN);
		}
	}
	
	void RedLight() {
		frontLight.setColor(Colore.RED);
		if(button.flag) {
			button.pedestrainLight.setColor(Colore.GREEN);
		}
		button.flag = false;
	}
}
