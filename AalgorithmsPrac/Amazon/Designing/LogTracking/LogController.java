package Designing.LogTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.careercup.com/question?id=5751698318426112

public class LogController {
	// key - UserId, value - list of pageId's visited
	Map<Integer, List<Integer>> userToPageLookUp = new HashMap<Integer,List<Integer>>();
	// key - pageId, value - page object
	Map<Integer, Page> pageLookUp = new HashMap<Integer, Page>();
	// Sorted list based on no of users visited;
	List<Page> pageList = new ArrayList<Page>();
	
	
	
	
}
