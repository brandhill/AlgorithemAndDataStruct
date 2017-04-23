package Designing.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class ParkingLotDao implements  ParkingLotDAOInterface {
	
	//Key - Parking Area Id , value - queue of avaliable lots
	Map<Integer, Queue<Lot>> parkingAreaQueues = new HashMap<Integer, Queue<Lot>>();
	List<ParkingArea> parkingAreaList = new ArrayList<ParkingArea>();
	
	@Override
	public Lot addParkingLot(Lot lot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lot getParkingLot(int parkingAreaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean checkIfFull(int parkingAreaId) {
		return parkingAreaQueues.get(parkingAreaId).isEmpty();
	}
}

interface ParkingLotDAOInterface {
	
	Lot getParkingLot(int parkingAreaId);
	
	Lot addParkingLot(Lot lot);
	
}