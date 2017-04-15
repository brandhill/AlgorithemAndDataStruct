package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindShortestPath {
	
	String printShortestPath(Point start, Point end) {
		String path = null;
		
		
		
		return path;
	}
}

class Point {
	int val;
	List<ConnectedPoint> list;
	Point(int val) {
		this.val = val;
		list = new ArrayList<ConnectedPoint>();
	}
}

class ConnectedPoint {
	Point point;
	int weight;
	ConnectedPoint(Point point, int weight) {
		this.point = point;
		this.weight = weight;
	}
}
