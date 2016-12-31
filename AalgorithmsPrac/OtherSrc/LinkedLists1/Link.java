package LinkedLists1;

public class Link {
 int id;
 Link next;
 Link(int id){
	 this.id = id;
 }
 public void display(){
	 System.out.println(id);
 }

 public boolean equals(Object obj){
	 Link L = (Link) obj;
	 if(this.id == L.id)
		 return true;
	 
	 return false;
 }
 
 public int hashCode(){
	int value = this.id; 
	return value;
 }
 
}
