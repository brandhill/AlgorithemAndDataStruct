package Designing.FoodDeliveryApp;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	int menuId;
	Map<Integer, NonVegeterian> nonVegMenu = new HashMap<Integer, NonVegeterian>();
	Map<Integer, Vegeterian> vegMenu = new HashMap<Integer, Vegeterian>();
	Map<Integer, Staters> statersMenu = new HashMap<Integer, Staters>();
	Map<Integer, Beverages> beverageMenu = new HashMap<Integer, Beverages>();
}
