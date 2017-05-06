package CareerCup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.careercup.com/question?id=5176529815339008

public class MatchEmployess {
	
	List<List<String>> findMatches(List<List<String>> details) {
		List<List<String>> matches = new ArrayList<List<String>>();
		Map<Buildings, List<String>> map = new HashMap<Buildings,List<String>>();
		for(List<String> row: details) {
			Buildings b = new Buildings(row.get(2),row.get(1));
			if(map.containsKey(b)) {
				List<String> match = new ArrayList<String>();
				List<String> emps = map.get(b);
				String name = emps.remove(emps.size()-1);
				if(emps.size()==0)
					map.remove(b);
				match.add(name);
				match.add(row.get(0));
			} else {
				b = new Buildings(row.get(1),row.get(2));
				if(map.containsKey(b)) {
					map.get(b).add(row.get(0));
				} else {
					List<String> emps = new ArrayList<String>();
					emps.add(row.get(0));
					map.put(b, emps);
				}
			}
		}
		return matches;
	}
	
}


class Buildings {
	String b1;
	String b2;
	
	Buildings(String b1, String b2) {
		this.b1 = b1;
		this.b2 = b2;
	}
	
	public boolean equals(Object o) {
		Buildings b = (Buildings) o;
		if(this.b1.equals(b.b1) && this.b2.equals(b.b2))
			return true;
		return false;
	}
	
	public int hashCode() {
		int val = (this.b1.hashCode()*31)+(this.b2.hashCode()*(31*31));
		return val;
	}
}