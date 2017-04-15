package LinkedList;

public class RotateList {

	public static Link rotateRight(Link node, int k) {
		if(node == null || node.next == null)
			return node;
		Link n = node;
		Link head = node;
		int size = getSize(n);
		int index = 0;
		Link output = null;
		
		if(size > k && k != 0) {
			index = size - k + 1;
		}
		else {
			if(k%size==0)
				index = 0;
			else
				index = size - (k%size) + 1;
		}
		System.out.println(index);
		if(index==0)
			return head;
		else {
			int count = 0;
			while(count<index) {
				node = node.next;
				count++;
			}
			Link end = node;
			output = node.next;
			while(node.next!=null) {
				node = node.next;
			}
			node.next = head;
			end.next = null;
		}
		
		return output;
	}
	
	private static int getSize(Link node) {
		int count = 0;
		while(node!=null) {
			count++;
			node = node.next;
		}	
		return count;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(6);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		Link n = RotateList.rotateRight(list.firstlink, 1);
		
		while(n!=null) {
			System.out.print(n.id+"->");
			n = n.next;
		}
	}
}
