package CareerCup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.careercup.com/question?id=5631361818820608

public class ItemRecommendations {
	
	static int[] getStrongAndWeakRelatedItems(String item, String[] trans) {
		
		Set<String> usedCustomers = new HashSet<String>();
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		int totalCount = 0;
		for(int i=0; i< trans.length; i++) {
			String[] tran = trans[i].split(":");
			String product = tran[1];
			String customer = tran[0];
			if(product.equals(item)) {
				usedCustomers.add(customer);
			} else {
				if(!map.containsKey(customer)) {
					Set<String> products = new HashSet<String>();
					map.put(customer, products);
				}  
				map.get(customer).add(product);
			}
		}
		Set<String> stronRecommendItems = new HashSet<String>();
		for(String customer: usedCustomers) {
			stronRecommendItems.addAll(map.get(customer));
		}
		Set<String> weakRecommendItems = new HashSet<String>();
		for(String customer: map.keySet()) {
			Set<String> products = map.get(customer);
			if(!usedCustomers.contains(customer) && products.size()>1) {
				for(String prod: products) {
					if(!stronRecommendItems.contains(prod))
						weakRecommendItems.add(prod);
				}
			}
		}
		
		int[] output = {stronRecommendItems.size(), weakRecommendItems.size()};
		return output;
	}
	
	public static void main(String[] args) {
		String[] trans = {"first:ABC","first:EDF","second:ABC","second:ERT",
		"third:ASD","third:XYZ"};
		System.out.println(Arrays.toString(getStrongAndWeakRelatedItems("ABC", trans)));
	}
	
}
