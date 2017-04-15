package VeryImportantQuestions;

public class FirstOccurrenceOf1inStream {
	
	static int findIndexOf1(boolean[] stream) {
		int n = stream.length;
		int low = 0;
		int high = n-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(stream[mid] && !stream[mid-1]) {
				return mid;
			}
			else if(stream[mid]) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		boolean[] stream = {false,false,false,false};
		int n = findIndexOf1(stream);
		System.out.println(n);
	}
}
