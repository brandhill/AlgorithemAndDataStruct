package hackerrank.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumAverageWaitingTime {
	
	static long CalculateAvgTime(Order[] orders){
		
		PriorityQueue<Order> queue = new PriorityQueue<Order>(new orderByPizzaTime());
		queue.add(orders[0]);
		int pointer = 1;
		long timeCounter = 0;
		long totalTime = 0;
		long sum = 0;
		while( !queue.isEmpty() ) {
			Order activeOrder = queue.poll();
			/*long i = 0;
			while ( i < activeOrder.pizzaTime) {
				i = Math.min(pointer < orders.length?(orders[pointer].arrived):Integer.MAX_VALUE, activeOrder.pizzaTime);
				//System.out.println(i);
				if(pointer < orders.length && orders[pointer].arrived==(i)) {
					queue.add(orders[pointer]);
					System.out.println("Added "+orders[pointer].arrived+" when "+activeOrder.arrived+" is getting cooked");
					pointer++;
				}
			}*/
			//42675689
			for ( long i = 0; i < activeOrder.pizzaTime; i++){
				timeCounter++;
				if(pointer < orders.length && orders[pointer].arrived==timeCounter){
					queue.add(orders[pointer]);
					//System.out.println("Added "+orders[pointer].arrived+" when "+activeOrder.arrived+" is getting cooked");
					pointer++;
				}
			}
			
			//timeCounter = i;
			//System.out.println(timeCounter);
			//totalTime += i ;
			//System.out.println(totalTime);
			sum += timeCounter - activeOrder.arrived;
			//System.out.println(totalTime+" "+timeCounter+" "+activeOrder.arrived);
		}
		long avg = sum / orders.length;
		return avg;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Order[] orders = new Order[count];
		for ( int i = 0; i < count; i++) {
			orders[i] = new Order(sc.nextInt(),sc.nextInt());
		}
		//-orders[0].arrived
		Arrays.sort(orders,new orderByArrivedTime());
		long sub = orders[0].arrived;
		for ( int i = 0; i < count; i++) {
			orders[i].arrived = orders[i].arrived - sub; 
		}
		for ( int i = 0; i < count; i++) {
			System.out.println(orders[i].arrived+" "+orders[i].pizzaTime); 
		}
		
		long avg = MinimumAverageWaitingTime.CalculateAvgTime(orders);
		System.out.println(avg);
	}
}

class Order {
	long arrived;
	long pizzaTime;
	Order(long Arraived, long PizzaTime){
		this.arrived = Arraived;
		this.pizzaTime = PizzaTime;
	}
}

class orderByPizzaTime implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Order a = (Order) o1;
		Order b = (Order) o2;
		if(a.pizzaTime>b.pizzaTime)
			return 1;
		else
			return -1;
	}
	
}

class orderByArrivedTime implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Order a = (Order) o1;
		Order b = (Order) o2;
		if(a.arrived>b.arrived)
			return 1;
		else
			return -1;
	}
	
}

//1418670047