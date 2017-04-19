package CareerCup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://www.careercup.com/question?id=4922725080498176

public class GroupPeopleByAttributes {
	
	static Set<List<People>> groupByPeople(List<People> peoples, List<String> attributes) {
		Map<List<String>,List<People>> map = new HashMap<List<String>,List<People>>();
		for(People p: peoples) {
			List<String> attribs = new ArrayList<String>();
			for(String attri:attributes) {
				attribs.add(p.getAttributes(attri));
			}
			if(map.containsKey(attribs)) {
				map.get(attribs).add(p);
			} else {
				List<People> people = new ArrayList<People>();
				people.add(p);
				map.put(attribs, people);
			}
		}
		Set<List<People>> set = new HashSet<List<People>>();
		set.addAll(map.values());
		return set;
	}
	
	public static void main(String[] args) {
		People p1 = new People("Mark","MALE","CEO");
		People p2 = new People("Sundhar","MALE","CEO");
		People p3 = new People("Mandela","MALE","CEO");
		People p4 = new People("Jenny","FEMALE","CEO");
		People p5 = new People("Shwetha","FEMALE","Analyst");
		People p6 = new People("Sikander","MALE","Analyst");
		People p7 = new People("BHUKYA","FEMALE","Analyst");
		List<People> peoples = new ArrayList<People>();
		peoples.add(p1);
		peoples.add(p2);
		peoples.add(p3);
		peoples.add(p4);
		peoples.add(p5);
		peoples.add(p6);
		peoples.add(p7);
		List<String> attributes = new ArrayList<String>();
		attributes.add("sex");
//		attributes.add("position");
		Set<List<People>> set = groupByPeople(peoples,attributes);
		for(List<People> list: set) {
			for(People p : list) {
				System.out.print(p.name+"; ");
			}
			System.out.println();
		}
	}
}

class KeyObject {
	List<String> attribs;
	KeyObject(List<String> attribs) {
		this.attribs = attribs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		for(String s: attribs) {
			result += s.hashCode();
		}
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyObject other = (KeyObject) obj;
		List<String> list1 = this.attribs;
		List<String> list2 = other.attribs;
		for(int i=0; i<list1.size(); i++) {
			if(!list1.get(i).equals(list2.get(i)))
				return false;
		}
		return true;
	}
	

}

class People {
	String name;
	String sex;
	String position;
	
	
	public People(String name, String sex, String position) {
		this.name = name;
		this.sex = sex;
		this.position = position;
	}


	public String getAttributes(String attri) {
		if(attri.equals("name"))
			return this.name;
		else if(attri.equals("sex"))
			return this.sex;
		return this.position;
	}
}