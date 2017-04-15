package VeryImportantQuestions;

//The problem is to determine the dimensions (x,y) of a grid that is as square as possible 
//and large enough to contain n elements with no more than 2 empty spaces. Orientation of the 
//grid does not matter (tall vs. wide).
//Distilled problem statement: given n, minimize |x - y| such that n <= x * y <= n + 2 
//and n,y,x are positive integers.

public class GetOpitimizedGridToStoreNElements {
	
	static solution GetOptimizedGrid(int n) {
		solution s = new solution();
		int i =1;
		while(true){
			int m = i*i;
			if(m==n) {
				s.x = i;
				s.y = i;
				s.emptySpaces = 0;
				return s;
			}
			else if (m<n){
				i++;
			}
			else if(m>n) {
				int j = i;
				while(Math.addExact(m, -1*n)>2) {
					j -= 1; 
					m = i*j;
				}
				while(Math.addExact(m, -1*n)<0) {
					i += 1;
					m = i*j;
				}
				s.x = i;
				s.y = j;
				s.emptySpaces = Math.addExact(m, -1*n);
				return s;
			}
			
		}

	}
	
	public static void main(String[] args) {
		solution s = GetOptimizedGrid(18);
		System.out.println(s.x+" "+s.y+" "+s.emptySpaces);
	}
}

class solution {
	int x;
	int y;
	int emptySpaces;
	
}