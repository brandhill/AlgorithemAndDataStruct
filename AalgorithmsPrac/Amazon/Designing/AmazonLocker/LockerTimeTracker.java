package Designing.AmazonLocker;

public class LockerTimeTracker {
	LockerTransactions lockerTransactions;
	LockerTimeTracker prev;
	LockerTimeTracker next;
	public LockerTimeTracker(LockerTransactions lockerTransactions) {
		this.lockerTransactions = lockerTransactions;
	}
	
	
}
