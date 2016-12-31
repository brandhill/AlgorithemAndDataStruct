package BineryTree1;

public class Node {
int id;
Node left;
Node right;
Node(int id){
	 this.id = id;
}
public void display(){
	 System.out.println("Id: "+id);
}

public boolean equals(Object obj){
	Node node = (Node) obj;
	if(this.id == node.id)
		return true;
	return false;
}
}
