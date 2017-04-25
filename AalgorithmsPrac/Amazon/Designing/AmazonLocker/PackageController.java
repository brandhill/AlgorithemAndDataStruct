package Designing.AmazonLocker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PackageController {
	
	// Locker DAO Layer
	Queue<SmallLocker> smallQueue = new LinkedList<SmallLocker>();
	Queue<MediumLocker> mediumQueue = new LinkedList<MediumLocker>();
	Queue<LargeLocker> largeQueue = new LinkedList<LargeLocker>();
	// Locker Transactions DAO Layer
	Map<Integer, LockerTimeTracker> trans= new HashMap<Integer, LockerTimeTracker>();
	LockerTimeTracker oldest = null;
	LockerTimeTracker current = null;
	
	LockerTransactions assignLocker(Package packet) {
		Locker locker = null;
		if(packet instanceof SmallPackage) {
			locker = getLockerForSmallPackage();
		} else if(packet instanceof SmallPackage) {
			locker = getLockerForMediumPackage();
		} else {
			locker = getLockerForLargePackage();
		}
		if(locker == null ){
			return null;
		}
		return createLockerTransactions(packet, locker);
	}
	
	void RetriveLocker(int transactionId) {
		LockerTimeTracker timeTracker = trans.get(transactionId);
		trans.remove(transactionId);
		addLockerToQueue(timeTracker.lockerTransactions.locker);
		removeFromTracker(timeTracker);
	}
	
	// LockerTransactions DAO layer
	
	LockerTransactions createLockerTransactions(Package packet, Locker locker) {
		LockerTransactions tran = new LockerTransactions(packet, locker);
		updateMap(tran);
		return tran;
	}
 	
	private void removeFromTracker(LockerTimeTracker timeTracker) {
		if(timeTracker==oldest) {
			oldest = oldest.next;
		} else if(timeTracker==current) {
			current = current.prev;
		} else {
			timeTracker.prev.next = timeTracker.next;
			timeTracker.next.prev = timeTracker.prev;
		}
	}
	
	void updateMap(LockerTransactions tran) {
		LockerTimeTracker timeTracker = new LockerTimeTracker(tran);
		if(oldest==null) {
			oldest = timeTracker;
			current = timeTracker;
		} else {
			current.next = timeTracker;
			timeTracker.prev = current;
			current = timeTracker;
		}
		trans.put(tran.transactionId, timeTracker);
	}
	
	
	// Locker Dao Layer
	Locker getLockerForSmallPackage() {
		if(smallQueue.isEmpty())
			return getLockerForMediumPackage();
		
		return smallQueue.poll();
	}
		
	Locker getLockerForMediumPackage() {
		if(mediumQueue.isEmpty())
			return getLockerForLargePackage();
		
		return mediumQueue.poll();
		}
	
	Locker getLockerForLargePackage() {
		return largeQueue.poll();
	}
	
	void addLockerToQueue(Locker locker) {
		if(locker instanceof SmallLocker)
			smallQueue.offer((SmallLocker) locker);
		else if(locker instanceof MediumLocker)
			mediumQueue.offer((MediumLocker) locker);
		else
			largeQueue.offer((LargeLocker) locker);

	}
	
}
