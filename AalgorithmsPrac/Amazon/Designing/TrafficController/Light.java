package Designing.TrafficController;

public class Light {
	Colore colore;
	
	Light(Colore color) {
		this.colore = color;
	}
	
	Colore getColor() {
		return this.colore;
	}
	
	void setColor(Colore color) {
		this.colore = color;
	}
}

class ArrowLight extends Light {
	final Direction direction;
	ArrowLight(Colore colore,Direction direction) {
		super(colore);
		this.direction = direction;
	}
}



enum Colore {
	RED,GREEN,YELLOW
}

enum Direction {
	LEFT,NONE
}