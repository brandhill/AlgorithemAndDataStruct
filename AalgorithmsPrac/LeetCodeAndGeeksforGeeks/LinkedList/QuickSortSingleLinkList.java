package LinkedList;

public class QuickSortSingleLinkList {
	
	public static Link QuickSort(Link node) {
		Link end = getPivot(node);
		return QuickSort(node, end);
	}
	
	public static Link QuickSort(Link start,Link end){
		if(start.next==end || start==end  || end == null) {
			return start;
		}
		Link pivot = partition(start,end);
		QuickSort(start,pivot);
		if(pivot!=null && pivot.next!=null) {
			if(pivot!=start) {
				QuickSort(pivot.next.next,end);
			}
			else {
				QuickSort(pivot.next,end);
			}
		}
		return start;
	}
	
	public static Link partition(Link start,Link pivot) {
		Link pointer = start;
		Link index = start;
		Link prev = null;
		while(true) {
			if(pointer.id<pivot.id) {
				swap(pointer,index);
				prev = index;
				index = index.next;
			}
			if(pointer.next==pivot)
				break;
			pointer = pointer.next;
		}
		
		swap(pivot,index);
		if(prev == null)
			return index;
		else
			return prev;
	}
	
	public static void swap(Link node1, Link node2) {
		int temp = node1.id;
		node1.id = node2.id;
		node2.id = temp;
	}
	
	public static Link getPivot(Link node) {
		while(node.next!=null) {
			node = node.next;
		}
		return node;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(6);
		list.insert(5);
		list.insert(3);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(4);
		Link n = QuickSortSingleLinkList.QuickSort(list.firstlink);
		while(n!=null) {
			System.out.print(n.id+" ");
			n = n.next;
		}
	}
}
