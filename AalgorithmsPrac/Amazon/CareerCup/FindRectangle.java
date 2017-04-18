package CareerCup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// https://www.careercup.com/question?id=5759911004733440

public class FindRectangle {
	
	Set<Rectangle> rectanglesInOrder = new TreeSet<Rectangle>();
	
	void ProcessRectangles(List<Rectangle> rectangles) {
		rectanglesInOrder.addAll(rectangles);
	}
	
	Rectangle findSmallestRectangleForPoint(Point p) {
		System.out.println("Satrted");
		for(Rectangle rec : rectanglesInOrder) {
			System.out.println(rec);
			if((p.x>=rec.x1 && p.x<=rec.x2) && (p.y>=rec.y1 && p.y<=rec.y2))
				return rec;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(1,2,4,5);
		Rectangle r2 = new Rectangle(1,1,4,2);
		Rectangle r3 = new Rectangle(2,3,3,4);
		Rectangle r4 = new Rectangle(3,3,4,5);
		List<Rectangle> list = new ArrayList<Rectangle>();
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		FindRectangle find = new FindRectangle();
		find.ProcessRectangles(list);
		System.out.println(find.findSmallestRectangleForPoint(new Point(5,6)));
	}
	
}

class Point {
	int x;
	int y;
	
	Point(int x, int y)  {
		this.x = x;
		this.y = y;
	}
}

class Rectangle implements Comparable<Rectangle>{
	int x1;
	int y1;
	int x2;
	int y2;
	
	Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1<x2?x1:x2;
		this.x2 = x1<x2?x2:x1;
		this.y1 = y1<y2?y1:y2;
		this.y2 = y1<y2?y2:y1;
	}
	
	int calculateArea() {
		int area = Math.abs((x2-x1)*(y2-y1));
		return area;
	}
	
	@Override
	public String toString() {
		return "Rectangle [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1  + ", y2=" + y2 + "]";
	}

	@Override
	public int compareTo(Rectangle p) {
		int area1 = this.calculateArea();
		int area2 = p.calculateArea();
		if(area1>area2)
			return 1;
		else if(area1<area2)
			return -1;
		return 0;
	}
	
	
}

