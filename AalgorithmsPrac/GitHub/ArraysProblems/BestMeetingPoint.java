package ArraysProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * Find the total distance that needs to be travelled to reach this meeting point.
 *
 * Time complexity O(m*n)
 * Space complexity O(m + n)
 *
 * https://leetcode.com/problems/best-meeting-point/
 */

public class BestMeetingPoint {
	
	static int findMeetPointDistance(int[][] grid) {
		
		if(grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		List<Integer> vert = new ArrayList<Integer>();
		List<Integer> hori = new ArrayList<Integer>();
		
		for ( int i = 0; i < grid.length; i++ ){
			for ( int j = 0; j < grid[0].length; j++ ) {
				if(grid[i][j]==1) {
					vert.add(i);
					hori.add(j);
				}
			}
		}
		
		Collections.sort(vert);
		Collections.sort(hori);
		int centriod = vert.size()/2;
		int x = hori.get(centriod);
		int y = vert.get(centriod);
		int distance = 0;
		for (int i = 0; i < hori.size(); i++) {
			distance += Math.abs(hori.get(i) - x) + Math.abs(vert.get(i) - y); 
		}
		return distance;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,1}};
		int dist = BestMeetingPoint.findMeetPointDistance(grid);
		System.out.println(dist);
	}
}
