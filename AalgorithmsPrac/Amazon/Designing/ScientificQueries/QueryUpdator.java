package Designing.ScientificQueries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryUpdator {
	
	// Key - scientistId, value - list blackholes with query id's. 
	Map<Integer,List<ScientistToBlackHoleDetails>> scientistQueriesOnABlackHole = new HashMap<Integer,List<ScientistToBlackHoleDetails>>();
	
	Map<Integer, Query> queryLookup = new HashMap<Integer, Query>();
	
	void addQuery(int scientistId, Query query, int blackHoleId) {
		
	}
}


class ScientistToBlackHoleDetails {
	int blackHoleId;
	List<Integer> queries;
}