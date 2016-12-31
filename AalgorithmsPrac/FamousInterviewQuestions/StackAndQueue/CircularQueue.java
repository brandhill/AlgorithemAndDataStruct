package StackAndQueue;

public class CircularQueue<T> {
	
	T[] data;
	int top;
	int end;
	int size;
	CircularQueue(int size) {
		this.size = size;
		data = (T[]) new Object[size];
		top = -1;
		end = -1;
	}
	
	void push(T t) {
		if(top == -1) {
			data[0] = t;
			top = 0;
			end = 0;
		}
		else{
			end = (end+1)%size;
			data[end] = t;
			
		}
	}
}
