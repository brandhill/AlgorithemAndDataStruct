package StackAndQueue1;

public class Node {
 int id;
 Node next;
 Node(int id){
	 this.id = id;
 }
 public void display(){
	 System.out.println(id);
 }

 public boolean equals(Object obj){
	 Node L = (Node) obj;
	 if(this.id == L.id)
		 return true;
	 
	 return false;
 }
 
 public int hashCode(){
	int value = this.id; 
	return value;
 }
 
}
