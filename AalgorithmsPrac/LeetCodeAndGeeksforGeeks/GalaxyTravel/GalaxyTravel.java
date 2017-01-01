package GalaxyTravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// https://www.hackerrank.com/contests/5800-f16-galaxy-trek/challenges

public class GalaxyTravel {
	
	static String findBestPath(Galaxy start,Galaxy end,Map<String,Galaxy> map, float fuel) {
		ShortPath shortPath = new ShortPath();
		findBestPathHelper(start,end,map,fuel,0,start.name,shortPath);
		//return shortPath.path;
		return end.path;
	}
	
	static void findBestPathHelper(Galaxy start,Galaxy end,Map<String,Galaxy> map, double fuel, int time,String path, ShortPath shortPath) {
		
		/*if(start.name.equals(end.name)) {
			//System.out.println(path+" "+fuel);
			if(shortPath.fuel < fuel) {
				shortPath.fuel = fuel;
				shortPath.path = path;
			}
			return;
		}*/
		
		if(start.maxFuel < fuel) {
			start.maxFuel = fuel;
			start.path = path;
		}
		else {
			return;
		}
		
		for (LinkedGalaxy LG: start.linkedGalaxies) {
			if(LG.warmhole && time%2 != 0){
				//System.out.println(start.name+" "+LG.name+" "+(fuel*0.5)+" "+time);
				findBestPathHelper(map.get(LG.name),end,map,fuel*0.5,time,path+" "+LG.name,shortPath);
			}
			else if(!LG.warmhole) {
				//System.out.println(start.name+" "+LG.name+" "+(fuel-1)+" "+(time+1));
				findBestPathHelper(map.get(LG.name),end,map,fuel-1,time+1,path+" "+LG.name,shortPath);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int galaxycount = sc.nextInt();
		int fuel = sc.nextInt();
		Galaxy start = null;
		Galaxy end = null;
		Map<String,Galaxy> map = new HashMap<String,Galaxy>();
		for ( int i = 0; i < galaxycount; i++) {
			String name = sc.next();
			Galaxy  gal = new Galaxy(name);
			if(i==0)
				start = gal;
			else if(i==galaxycount-1)
				end = gal;
			
			map.put(name,gal);
		}
		sc.nextLine();
		while(sc.hasNextLine()) {
			String s1 = sc.nextLine();
			if (s1.equals("exit")) {
			    break;
			}
			String[] s = s1.split(" ");
			if(s.length > 2) {
				map.get(s[0]).addGalaxy(s[1], true);
			}
			else{
				map.get(s[0]).addGalaxy(s[1], false);
			}
		}
		String path = GalaxyTravel.findBestPath(start,end,map,fuel);
		System.out.println(path);
	}
}

class LinkedGalaxy{
	String name;
	boolean warmhole;
	LinkedGalaxy(String name,boolean warmhole){
		this.name = name;
		this.warmhole = warmhole;
	}
}

class Galaxy {
	String name;
	List<LinkedGalaxy> linkedGalaxies;
	double maxFuel;
	String path;
	Galaxy(String name){
		linkedGalaxies = new ArrayList<LinkedGalaxy>();
		this.name = name;
	}
	
	void addGalaxy(String name,boolean warmhole){
		LinkedGalaxy G = new LinkedGalaxy(name,warmhole);
		linkedGalaxies.add(G);
	}
}

class ShortPath {
	double fuel;
	String path;
}

/*
6 100
V0
V1
V2
V3
V4
V5
V0 V1
V0 V4 *
V1 V2
V1 V4 *
V2 V3
V3 V4
V4 V5
exit

4 10
V0
V1
V2
V3
V0 V1
V1 V2 *
V1 V3
V2 V3 *
exit

6 5
v0
v1
v2
v4
v6
v5
v0 v1
v0 v4 *
v1 v2
v1 v4 *
v2 v4
v4 v5 *
v4 v6
v6 v5
exit
 */
