package VeryImportantQuestions;

public class MinStack {
	private StackNode stack;
	
	private class StackNode {
		int value;
		int min;
		StackNode next;
		StackNode prev;
		StackNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	
	public MinStack() {
		stack = null;
	}
	
	void push(int value) {
		StackNode node = new StackNode(value);
		if(stack==null) {
			node.min = value;
			stack = node;
		}
		else {
			node.min = node.value<stack.min?node.value:stack.min;
			stack.next = node;
			node.prev = stack;
			stack = node;
		}
	}
	
	Integer pop() {
		if(stack==null)
			return null;
		else {
			int val = stack.value;
			stack = stack.prev;
			stack.next = null;
			return val;
		}
	}
	
	Integer min() {
		if(stack==null)
			return null;
		else {
			int min = stack.min;
			return min;
		}
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		System.out.println(stack.min());
		stack.push(2);
		System.out.println(stack.min());
		stack.push(1);
		System.out.println(stack.min());
		stack.push(-1);
		System.out.println(stack.min());
		stack.push(0);
		System.out.println(stack.min());
		stack.push(1);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());

	}
}


