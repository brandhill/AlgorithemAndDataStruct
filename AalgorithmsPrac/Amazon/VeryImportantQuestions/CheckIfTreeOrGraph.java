package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIfTreeOrGraph {
	
	static boolean checkIfTree(Item node) {
		if(node==null){
			return true;
		}
		Set<Item> vistiedNodes = new HashSet<Item>();
		vistiedNodes.add(node);
		return checkIfTreeHelper(vistiedNodes,node,null);
	}
	
	private static boolean checkIfTreeHelper(Set<Item> visitedNodes, Item node, Item prev) {
		for(Item item : node.items) {
			if(item==prev)
				continue;
			if(visitedNodes.contains(item)) {
				return false;
			}
			visitedNodes.add(item);
			if(!checkIfTreeHelper(visitedNodes,item,node))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Item i1 = new Item(1);
		Item i2 = new Item(2);
		Item i3 = new Item(3);
		Item i4 = new Item(4);
		i1.items.add(i2);
		i2.items.add(i1);
		i1.items.add(i3);
		i3.items.add(i1);
		i2.items.add(i4);
		i4.items.add(i2);
//		i1.items.add(i4);
//		i4.items.add(i1);
		System.out.println(checkIfTree(i4));
	}
}


class Item {
	int n;
	List<Item> items;
	
	Item(int n) {
		this.n = n;
		items = new ArrayList<Item>();
	}
}