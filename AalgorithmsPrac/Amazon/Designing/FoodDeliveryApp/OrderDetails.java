package Designing.FoodDeliveryApp;

import java.util.Date;

public class OrderDetails {
	int orderDetailId;
	Order order;
	Status status;
	Date time;
}


enum Status {
	InProgress, OnWay, Delivered
}