package CareerCup;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpressInFormPpowerQ {
	
	static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37};
	
	static boolean convertToPower(int n) {
		int i = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int temp = n;
		while(n!=1 && primes[i]<=temp) {
			if(primes[i]==temp)
				return false;
			if(n%primes[i]==0) {
				if(map.containsKey(primes[i])) {
					map.put(primes[i], map.get(primes[i]+1));
				} else {
					map.put(primes[i], 1);
				}
				n = n/primes[i];
			} else {
				i++;
			}
		}
		if(map.size()==1) {
			return true;
		}
		Set<Integer> set = map.keySet();
		int size = 0;
		for(Integer num: set) {
			if(size == 0)
				size = map.get(num);
			else if(size!=map.get(num))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(convertToPower(25));
	}
}
