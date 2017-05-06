package Designing.FoodDeliveryApp;

import java.util.Date;
import java.util.List;

public class Order {
	int orderId;
	Restaurent restaurent;
	List<Item> orderItems;
	User user;
	Date date;
}
