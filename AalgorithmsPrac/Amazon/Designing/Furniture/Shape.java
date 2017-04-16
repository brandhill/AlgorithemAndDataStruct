package Designing.Furniture;

public class Shape {
	Material material;
	int xCoordinateStart;
	int xCoordinateEnd;
	int yCoordinateStart;
	int yCoordinateEnd;
	
	State applyFire(int x, int y, int fireStrength, int seconds) {
		return material.applyFire(x, y, fireStrength, seconds);
	}
}
