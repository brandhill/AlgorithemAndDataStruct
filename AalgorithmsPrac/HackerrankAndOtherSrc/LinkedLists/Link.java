package LinkedLists;

public class Link {
 String Bookname;
 int millionsold;
 Link next;
 Link(String bookname,int millionsold){
	 this.Bookname = bookname;
	 this.millionsold = millionsold;
 }
 public void display(){
	 System.out.println(Bookname+": "+millionsold);
 }

 public boolean equals(Object obj){
	 Link L = (Link) obj;
	 if(L.Bookname.equalsIgnoreCase(this.Bookname)&&(L.millionsold == this.millionsold))
		 return true;
	 return false;
 }
 
 public int hashCode(){
	int value = 31*(this.millionsold)*(this.Bookname.hashCode()); 
	return value;
 }
 
}
