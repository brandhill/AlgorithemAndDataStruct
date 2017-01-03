package BineryTree1;


public class NParent {
int id;
NParent left;
NParent right;
NParent parent;

NParent(int id){
	 this.id = id;
}
public void display(){
	 System.out.println("Id: "+id);
}

public boolean equals(Object obj){
	NParent node = (NParent) obj;
	if(this.id == node.id)
		return true;
	return false;
}
}
