package StandardAlgorithems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
	
	static List<Item> knapsack(List<Item> items, int totalWeight) {
		int[][] matrix = new int[items.size()][totalWeight+1];
		matrix[0][0] = 0;
		List<Item> pickedItems = new ArrayList<Item>();
		Collections.sort(items, new Comparator<Item>() {

			public int compare(Item o1, Item o2) {
				if(o1.weight>o2.weight)
					return 1;
				else if(o1.weight<o2.weight)
					return -1;
				else {
					if(o1.value>o2.value)
						return 1;
					else if(o1.value<o2.value)
						return -1;
				}
				return 0;
			}
			
		});
		System.out.println(items);
		for(int i = 0; i< items.size(); i++) {
			Item item = items.get(i);
			for(int j = 0; j<=totalWeight; j++) {
				if(j<item.weight) {
					matrix[i][j] = i==0?0:matrix[i-1][j];
				} else {
					if(i==0) {
						matrix[i][j] = item.value;
					} else {
						matrix[i][j] = Math.max(item.value+matrix[i-1][j-item.weight], matrix[i-1][j]);
					}
				}
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		int i = items.size()-1;
		int j = totalWeight;
		while(i>=0) {
			if(i==0) {
				if(j!=0)
					pickedItems.add(items.get(i));
				break;
			}
			if(matrix[i][j]!=matrix[i-1][j]) {
				pickedItems.add(items.get(i));
				j = j-items.get(i).weight;
			}
			i = i-1;
		}
		
		return pickedItems;
	}
	
	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1,1));
		items.add(new Item(4,3));
		items.add(new Item(5,4));
		items.add(new Item(7,5));
		System.out.println(knapsack(items,9));
	}
}


class Item {
	int value;
	int weight;
	Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Item [value=" + value + ", weight=" + weight + "]";
	}
	
	
}