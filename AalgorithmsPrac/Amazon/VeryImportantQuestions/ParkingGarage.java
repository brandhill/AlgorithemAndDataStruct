package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//I own a parking garage that provides valet parking service. When a customer pulls up to the entrance they
//are either rejected because the garage is full, or they are given a ticket they can use to collect their car, and
//the car is parked for them.
//Given a set of different parking bays (Small, Medium, Large), write a control program to accept/reject cars
//(also small, medium or large) as they arrive, and issue/redeem tickets.


public class ParkingGarage {
	
	Map<Slot, Integer> layout;
	
	ParkingGarage(int[] slots) {
		layout = new HashMap<Slot, Integer>();
		layout.put(Slot.Small, slots[0]);
		layout.put(Slot.Medium, slots[1]);
		layout.put(Slot.Large, slots[2]);
	}
	
	List<Integer> acceptCars(List<CarInput> cars) {
		List<Integer> status = new ArrayList<Integer>();
		int prev = 0;
		for(int i=0; i<cars.size(); i++) {
			CarInput car = cars.get(i);
			if(car.movement== Movement.Arrival) {
				if(!getSlotForCar(car)) {
					status.add(-1);
				} else {
					prev +=1;
					status.add(prev);
				}
			} else {
				car = cars.get(car.index);
				claimTheSlot(car);
			}
		}
		
		return status;
	}
	
	private void claimTheSlot(CarInput car) {
		layout.put(car.slot, layout.get(car.slot)+1);
	}
	
	private boolean getSlotForCar(CarInput car) {
		if(car.size== Slot.Small)
			return getSlotForSmallCar(car);
		else if(car.size==Slot.Medium)
			return getSlotForMediumCar(car);
		else
			return getSlotForLargeCar(car);
	}
	
	private boolean getSlotForSmallCar(CarInput car) {
		if(layout.get(Slot.Small)>0) {
			layout.put(Slot.Small,layout.get(car.size)-1);
			car.slot = Slot.Small;
			return true;
		} 
		return getSlotForMediumCar(car);
	}

	private boolean getSlotForMediumCar(CarInput car) {
		if(layout.get(Slot.Medium)>0) {
			layout.put(Slot.Medium,layout.get(car.size)-1);
			car.slot = Slot.Medium;
			return true;
		} 
		return getSlotForLargeCar(car);
	}
	
	private boolean getSlotForLargeCar(CarInput car) {
		if(layout.get(Slot.Large)>0) {
			layout.put(Slot.Large,layout.get(car.size)-1);
			car.slot = Slot.Large;
			return true;
		} 
		return false;
	}
	
	public static void main(String[] args) {
		CarInput input1 = new CarInput(Slot.Small, Movement.Arrival, -1);
		CarInput input2 = new CarInput(Slot.Large, Movement.Arrival, -1);
		CarInput input3 = new CarInput(Slot.Medium, Movement.Arrival, -1);
		CarInput input4 = new CarInput(null, Movement.Depart, 3);
		CarInput input5 = new CarInput(Slot.Medium, Movement.Arrival, -1);
		int[] slots = {1,1,2};
		ParkingGarage parking = new ParkingGarage(slots);
		List<CarInput> carsInputs = new ArrayList<CarInput>();
		carsInputs.add(input1);
		carsInputs.add(input2);
		carsInputs.add(input3);
		carsInputs.add(input2);
		carsInputs.add(input4);
		carsInputs.add(input5);
		System.out.println(parking.acceptCars(carsInputs));
	}
}

class CarInput {
	Slot size;
	Movement movement;
	Slot slot;
	int index;
	public CarInput(Slot size, Movement movement, int index) {
		super();
		this.size = size;
		this.movement = movement;
		this.index = index;
	}
	
}

enum Slot {
	Small, Medium, Large
}

enum Movement {
	Arrival, Depart
}
