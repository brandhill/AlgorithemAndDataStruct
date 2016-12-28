package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class MultipleStacks3 {
List<Node> stackList = new ArrayList<Node>();
Node last;
int pointer = 0;
int StackSize = 2;
public MultipleStacks3() {
	last = null;
}
void push(String name,int id){
	Node add = new Node(name,id);
	if(stackList.isEmpty()){
		stackList.add(add);
		last= add;
		pointer++;
	}
	else if(pointer%StackSize==0){
		stackList.add(add);
		add.next = last;
		last= add;
		pointer++;
	}
	else{
		add.next = last;
		last= add;
		pointer++;
	}
}

Node pop(){
	Node pop = last;
	last = last.next;
	pointer--;
	return pop;
}

Node popAt(int index){
	System.out.println("List "+stackList.size());
	if(index>pointer)
		return null;
	int listIndex = (int) Math.ceil(index/((double)StackSize)) ;
	System.out.println("Index "+listIndex);
	int count = (StackSize+1) - (index%StackSize==0?StackSize:index%StackSize);
	//int count = (listIndex*)
	System.out.println("Count "+count);
	Node n = null;
	if((listIndex)==stackList.size()){
		n = last;
	}
	else{
		n = stackList.get(listIndex);
	}
	
/*	Node pop = null;
	if((listIndex)==stackList.size()){
		n = last;
	
	}
	
	else{
		System.out.println("started");
		n = stackList.get(listIndex);
		Node check = n;
		while(count>1){
			System.out.println("Loop" +count);
			check = n;
			n = n.next;
			System.out.println(check.id);
			System.out.println(n.id);
			System.out.println();
			count--;
			if(n==null)
				return null;
		}	
		pop = n;zx
		check.next = n.next; 
	}*/
	

	
	pointer--;
	return null;
}

Node peek(){
	return last;
}

void display(){
	Node n = last;
	while(n!=null){
	System.out.println(n.id);
	n = n.next;
	}
}

public static void main(String[] args) {
	MultipleStacks3 MS = new MultipleStacks3();
	MS.push("name1", 1);
	MS.push("name2", 2);
	MS.push("name3", 3);
	MS.push("name4", 4);
	MS.push("name5", 5);
	MS.push("name6", 6);
	System.out.println(MS.popAt(2).id);
	System.out.println("---");
	MS.display();
}

}
