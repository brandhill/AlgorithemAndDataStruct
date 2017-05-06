package CareerCup;

import java.util.HashMap;
import java.util.Map;

import BinaryTree.Node;
import VeryImportantQuestions.BSTtoArrayAndViceVersa;

// https://www.careercup.com/question?id=6222056925429760

public class FindMaximumLengthSequence {
	
	
	static int findMaxLengthSequence(Node root) {
		if(root==null)
			return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Length maxLen = new Length();
		findMaxLengthSeqHelper(root,maxLen,map);
		return maxLen.len;
	}

	private static void findMaxLengthSeqHelper(Node node, Length maxLen, Map<Integer, Integer> map) {
		if(node==null)
			return;
		if(!map.containsKey(node.id)) {
			int left = map.containsKey(node.id-1)?map.get(node.id-1):0;
			int right = map.containsKey(node.id+1)?map.get(node.id+1):0;
			int newLen = left+right+1;
			map.put(node.id, newLen);
			if(left>0) {
				map.put(node.id-left, newLen);
			}
			if(right>0) {
				map.put(node.id+right, newLen);
			}
			if(newLen>maxLen.len) {
				maxLen.len = newLen;
				System.out.println(node.id+" "+maxLen.len);
			}
		}
		
		findMaxLengthSeqHelper(node.left, maxLen, map);
		findMaxLengthSeqHelper(node.right, maxLen, map);
	}
	
	public static void main(String[] args) {
		int[] array = {0,-1,2,3,5,7,8,9,10};
		Node n = BSTtoArrayAndViceVersa.sortedArrayTOBST(array);
		System.out.println(findMaxLengthSequence(n));
	}
}

class Length {
	int len;
}
