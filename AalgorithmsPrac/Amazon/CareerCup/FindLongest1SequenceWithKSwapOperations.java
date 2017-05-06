package CareerCup;

// https://www.careercup.com/question?id=5185036367167488

public class FindLongest1SequenceWithKSwapOperations {
	
	static int findLongestSequence(int[] array, int K) {

		int countOf1s = 0;
		int countOf0s = 0;
		int maxLen = 0;
		int start = 0;
		int end = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i]==1)
				countOf1s += 1;
		}
		if(countOf1s<=1 || K>=countOf1s-1)
			return countOf1s;
		
		while(end<array.length) {
			if(array[end]==0)
				countOf0s++;
			else
				countOf1s--;
//			System.out.println(start+" "+end+": "+countOf0s+" "+countOf1s);
			while(countOf0s>K || countOf1s==K) {
//				System.out.println(start+" "+end);
				int len = end-start;
				if(array[end]==1)
					len++;
				if(len>maxLen) {
					maxLen = len;
//					System.out.println(maxLen);
				}
				if(array[start]==0)
					countOf0s--;
				else
					countOf1s++;
				start++;
			} 
			end++;
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] array = {0,1,1,0,0,1,0,1,1,1,1,0,0,1,0,0,1};
		int[] array1 = {0,1,1,0,0,1};
		System.out.println(findLongestSequence(array1,2));
	}
	
}
