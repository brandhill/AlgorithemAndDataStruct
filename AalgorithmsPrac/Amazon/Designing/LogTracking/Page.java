package Designing.LogTracking;

import java.util.HashMap;
import java.util.Map;

public class Page implements Comparable<Page>{
	int pageId;
	// key - UserId, value - no of visits to this page
	Map<Integer,Integer> userVisitedCount = new HashMap<Integer,Integer>();
	@Override
	public int compareTo(Page o) {
		if(this.userVisitedCount.size()>o.userVisitedCount.size())
			return 1;
		else if(this.userVisitedCount.size()<o.userVisitedCount.size())
			return -1;
		return 0;
	}
	
	
}
