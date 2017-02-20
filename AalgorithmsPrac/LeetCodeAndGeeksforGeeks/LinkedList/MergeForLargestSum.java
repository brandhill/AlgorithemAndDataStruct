package LinkedList;

// http://www.geeksforgeeks.org/maximum-sum-linked-list-two-sorted-linked-lists-common-nodes/

// Time - O(m+n)
// Space - O(1)
public class MergeForLargestSum {
	
	public static Link maxChain(Link head1, Link head2) {
		if(head1==null)
			return head2;
		else if(head2==null)
			return head1;
		Link maxHead = null;
		Link endPoint = null;
		Link current1 = head1;
		Link current2 = head2;
		while(current1!=null && current2!=null) {
			int sum1 = 0;
			int sum2 = 0;
			Link start1 = current1;
			Link start2 = current2;
			while(current1!=null && current2!=null && current1.id != current2.id) {
				System.out.println(current1.id+" "+current2.id);
				if(current1.id>current2.id) {
					sum2 += current2.id;
					current2 = current2.next;
				}
				else {
					sum1 += current1.id;
					current1 = current1.next;
				}
			}
			if(current1==null || current2==null) {
				while(current1!=null) {
					sum1 += current1.id;
					current1 = current1.next;
				}
				while(current2!=null) {
					sum2 += current2.id;
					current2 = current2.next;
				}
			}
			
			if(maxHead == null) {
				maxHead = sum1>sum2?start1:start2;
				endPoint = sum1>sum2?current1:current2;
			}
			else {
				endPoint.next = sum1>sum2?start1:start2;
				endPoint = sum1>sum2?current1:current2;
			} 
			current1 = current1!=null?current1.next:null;
			current2 = current2!=null?current2.next:null;
		}
		
		return maxHead;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insert(511);
		list1.insert(240);
		list1.insert(120);
		list1.insert(90);
		list1.insert(30);
		list1.insert(3);
		list1.insert(1);
		LinkedList list2 = new LinkedList();
		list2.insert(249);
		list2.insert(240);
		list2.insert(125);
		list2.insert(90);
		list2.insert(32);
		list2.insert(12);
		list2.insert(3);
		list2.insert(0);
		
		Link result = MergeForLargestSum.maxChain(list1.firstlink, list2.firstlink);
		while(result!=null) {
			System.out.print(result.id+"->");
			result = result.next;
		}
	}
}
