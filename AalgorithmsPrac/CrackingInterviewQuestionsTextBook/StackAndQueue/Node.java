package StackAndQueue;

public class Node {
String name;
int id;
Node next;
Node(String name,int id){
	 this.name = name;
	 this.id = id;
}
public void display(){
	 System.out.println(name+": "+id);
}
}
