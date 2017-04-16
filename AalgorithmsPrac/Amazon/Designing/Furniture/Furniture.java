package Designing.Furniture;

import java.util.List;


//You are on a team that is creating a program to model stress on furniture. Your task is to model the
//behavior of furniture under abuse such as excessive weight or application of fire. Someone has
//already created a prototype with a base class Furniture, and four derived classes WoodChair,
//SteelChair, WoodTable, and SteelTable. We will need to start adding other furniture like couches,
//beds, bookcases, and desks, and also new materials such as plastic, cloth, rubber, etc. Try to improve
//the class design - you are free to modify it however you wish since it is only a prototype.

//After the candidate has accomplished the task of removing duplication, I tell the candidate to
//support a table with a wood frame and glass inset on the top.

public class Furniture {
	Type type;
	List<Shape> shapes;
	State funitureState = State.OK;
	State getState() {
		return funitureState;
	}
	
	State applyWeight(int x, int y, int weight, int seconds) {
		this.funitureState = type.applyWeight(x,y,weight,seconds);
		return getState();
	}
	
	State applyFire(int x, int y, int fireStrength, int seconds) {
		for(Shape shape: shapes) {
			if(shape.xCoordinateStart<=x && shape.xCoordinateEnd>=x && 
					shape.yCoordinateStart<=y && shape.yCoordinateEnd>=y) {
				this.funitureState = shape.applyFire(x, y, fireStrength, seconds);
				break;
			}
		}
		return getState();
	}
}

enum State {
		OK, STABLE, UNSTABLE
}