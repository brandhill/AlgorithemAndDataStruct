package Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import BinaryTree.Node;

// https://www.careercup.com/question?id=5648826070204416

public class PrintPathOfSumEqualToN {
	
	
	void printPath(Node root, int sum) {
		
		if(root==null) {
			return;
		}
		
		Map<Integer,Set<Node>> prevSumAtNode = new HashMap<Integer,Set<Node>>();
		Map<Node,Boolean> currentDirectionInNode = new HashMap<Node,Boolean>();
		printPathHelper(root,0,sum,prevSumAtNode,currentDirectionInNode);
		
	}
	
	
	private void printPathHelper(Node node,int prevSum, int sum, Map<Integer,Set<Node>> prevSumAtNode, Map<Node,Boolean> currentDirectionInNode) {
		if(node==null)
			return;
		
		if(prevSumAtNode.containsKey(prevSum)) {
			prevSumAtNode.get(prevSum).add(node);
		}
		else {
			Set<Node> set = new HashSet<Node>();
			set.add(node);
			prevSumAtNode.put(prevSum, set);
		}
		
		if(prevSumAtNode.containsKey(prevSum+node.id-sum)) {
			Set<Node> set = prevSumAtNode.get(prevSum+node.id-sum);
			for(Node n: set) {
				printPath(n,node,currentDirectionInNode);
			}
		}
		
		currentDirectionInNode.put(node, false);
		printPathHelper(node.left, prevSum+node.id, sum, prevSumAtNode, currentDirectionInNode);	
		currentDirectionInNode.put(node, true);
		printPathHelper(node.right, prevSum+node.id, sum, prevSumAtNode, currentDirectionInNode);
		RemoveNodeFromMaps(prevSumAtNode, currentDirectionInNode, prevSum, node);
	}
	
	
	private void RemoveNodeFromMaps(Map<Integer,Set<Node>> prevSumAtNode,Map<Node,Boolean> currentDirectionInNode, int sum, Node node) {
		Set<Node> list = prevSumAtNode.get(sum);
		list.remove(node);
		currentDirectionInNode.remove(node);
		if(list.size()==0)
			prevSumAtNode.remove(sum);
	}
	
	private void printPath(Node start, Node end,Map<Node,Boolean> currentDirectionInNode) {
		
		while(start!=end) {
			System.out.print(start.id+"->");
			start = currentDirectionInNode.get(start)?start.right:start.left;
		}
		System.out.print(start.id);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(2);
		Node n3 = new Node(4);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(-1);
		n2.left = n4;
		Node n5 = new Node(2);
		n2.right = n5;
		Node n6 = new Node(1);
		n3.left = n6;
		Node n7 = new Node(1);
		n3.right = n7;
		Node n8 = new Node(3);
		n4.left = n8;
		Node n9 = new Node(4);
		n5.left = n9;
		Node n10 = new Node(-2);
		n5.right = n10;
		Node n11 = new Node(1);
		n6.right = n11;
		Node n12 = new Node(0);
		n7.left = n12;
		Node n13 = new Node(1);
		n8.left = n13;
		Node n14 = new Node(1);
		n8.right = n14;
		Node n15 = new Node(3);
		n10.left = n15;
		PrintPathOfSumEqualToN p = new PrintPathOfSumEqualToN();
		p.printPath(n1, 8);
	}
}
