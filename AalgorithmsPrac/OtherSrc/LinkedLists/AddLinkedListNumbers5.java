package LinkedLists;

public class AddLinkedListNumbers5 {
	
	void AddListsValues(LinkedList L1,LinkedList L2){
		StringBuffer S1 = new StringBuffer();
		StringBuffer S2 = new StringBuffer();
		Link list1 = L1.firstlink;
		while(list1!=null){
			Integer i = new Integer(list1.millionsold); 
			S1.append(i.toString());
			list1 = list1.next;
		}
		Link list2 = L2.firstlink;
		while(list2!=null){
			Integer i = new Integer(list2.millionsold); 
			S2.append(i.toString());
			list2 = list2.next;
		}
		Integer i1 = new Integer(S1.reverse().toString());
		Integer i2 = new Integer(S2.reverse().toString());
		System.out.println(i1.intValue());
		System.out.println(i2.intValue());
		
		Integer sum = new Integer(i1+i2);
		StringBuffer S3 = new StringBuffer(sum.toString());
		Integer sum1 = new Integer(S3.reverse().toString());
		System.out.println(sum1.intValue());
		LinkedList L3 = new LinkedList();
		int len = S3.length();
		for(int i=0;i<len;i++){
			int val = sum1%10;
			sum1 = sum1/10;
			L3.insertlink("",val);
		}
		L3.firstlink.display();
		Removeduplicates1 r = new Removeduplicates1();
		r.printlists(L3);
	}
	
	public static void main(String[] args) {
		LinkedList L1 = new LinkedList();
		LinkedList L2 = new LinkedList();
		L1.insertlink("",6);
		L1.insertlink("",1);
		L1.insertlink("",7);
		L2.insertlink("",2);
		L2.insertlink("",9);
		L2.insertlink("",5);
		L1.firstlink.display();
		L2.firstlink.display();
		AddLinkedListNumbers5 q5 = new AddLinkedListNumbers5();
		q5.AddListsValues(L1, L2);
	}
}
