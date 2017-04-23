package BinaryTree;

public class Node {
public int id;
public Node left;
public Node right;
public Node(int id){
	 this.id = id;
}
public void display(){
	 System.out.println("Id: "+id);
}



@Override
public String toString() {
	return ""+id;
}
public boolean equals(Object obj){
	Node node = (Node) obj;
	if(this.id == node.id)
		return true;
	return false;
}
}
