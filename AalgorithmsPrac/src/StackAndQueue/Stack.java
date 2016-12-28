package StackAndQueue;

public class Stack {
Node node;
//Maintains the minimum value for every push and pop
Node min;

Stack(){
	node = null;
	min = null;
}
boolean isEmpty(){
	if(node==null){
		return true;
	}
	return false;
}

void push(String name,int id){
	Node point = new Node(name,id);
	//holds copy of new added object to check for minimum value
	if(isEmpty()){
		node =point;
		min = new Node(name,id);
	}
	else{
		point.next = node;
		node = point;
		//Adding corresponding min value to list
		Node minvalue;
		if(id<min.id){
			minvalue = new Node(name,id);
		}
		else{
			minvalue = new Node(min.name,min.id);
		}
		minvalue.next = min;
		min = minvalue;
	}
}
	
Node pop(){
	if(isEmpty()){
		return null;
	}
	else{
		Node pop = node;
		node = node.next;
		min = min.next;
		return pop;
	}
}

Node peek(){
	if(isEmpty()){
		return null;
	}
	else{
		return node;
	}
}

Node min(){
	if(isEmpty()){
		return null;
	}
	/*else{
		Node pointer = node;
		Node min = pointer;
		while(pointer.next!=null){
			if(min.id>pointer.next.id){
				min = pointer.next;
			}
			pointer = pointer.next;
		}
		return min;
	}*/
	return min;
	
}

public static void main(String[] args) {
	Stack stack = new Stack();
	stack.push("name1",4);
	stack.push("name1",2);
	stack.push("name2", 3);
	stack.push("name3", 1);
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);
	System.out.println("min prev "+stack.min().next.id);
	System.out.println("min prev prev "+stack.min().next.next.id);
	System.out.println("min prev prev prev "+stack.min().next.next.next.id);
	stack.push("name4", 0);
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);
	System.out.println("-------");
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);
	stack.pop();
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);
	stack.pop();
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);
	stack.pop();
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);
	stack.pop();
	System.out.println(stack.peek().id);
	System.out.println("min "+stack.min().id);	


}

}
