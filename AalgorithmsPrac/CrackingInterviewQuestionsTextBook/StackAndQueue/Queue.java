package StackAndQueue;

public class Queue {
Node first,last;

Queue(){
	first = null;
}

boolean isEmpty(){
	if(first==null)
		return true;
	return false;
}

void Enqueue(String name,int id){
	Node add = new Node(name,id);
	if(isEmpty()){
		first = add;
		last = first;
	}
	else{
		last.next = add;
		last = add;
	}
}

Node Dequeue(){
	if(isEmpty())
		return null;
	else{
		Node pop = first;
		first = first.next;
		return pop;
	}
}

void display(){
	Node temp = first;
	while(temp!=null){
		System.out.println(temp.id+" "+temp.name);
		temp = temp.next;
	}
}

public static void main(String[] args) {
	Queue q = new Queue();
	q.Enqueue("abc", 1);
	q.Enqueue("harsha", 2);
	q.Enqueue("abc1", 3);
	q.Enqueue("abc2", 4);
	q.display();
	System.out.println("------");
	q.Dequeue();
	q.display();
	System.out.println("------");
	q.Dequeue();
	q.display();
}
}
