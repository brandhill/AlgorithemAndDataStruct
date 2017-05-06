package CareerCup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.careercup.com/question?id=5140007057620992

public class SerachForLoyalCustomersFromLogs {
	
	static Set<String> getLoyalCustomers(String[] logs, String separator) {
		
		Set<String> loyalCustomers = new HashSet<String>();
		Map<String,Set<LocalDate>> map = new HashMap<String,Set<LocalDate>>();
		for(int i=0; i< logs.length; i++) {
			
			String[] log = logs[i].split(separator);
			String customerId = log[1].trim();
			if(loyalCustomers.contains(customerId)) {
				continue;
			} else {
				LocalDate date = convertToDate(log[0]);
				if(!map.containsKey(customerId)) {
					Set<LocalDate> dates = new HashSet<LocalDate>();
					dates.add(date);
					map.put(customerId, dates);
				} else {
					Set<LocalDate> dates = map.get(customerId);
					if(dates.contains(date.plusDays(-1)) && dates.contains(date.plusDays(-2))) {
						loyalCustomers.add(customerId);
						map.remove(customerId);
					} else {
						map.get(customerId).add(date);
					}
				}		
			}
			
			
		}
		return loyalCustomers;
		
	}
	
	static LocalDate convertToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("MM/DD/YYYY"));
		LocalDate day = LocalDate.parse(date.trim(), formatter);
		return day;
	}
	
	public static void main(String[] args) {
		String[] logs = {"04/11/2017 /t 003","04/12/2017 /t 0003","04/13/2017 /t 0003","04/13/2017 /t 0004",
				"04/14/2017 /t 0005","04/15/2017 /t 0005","04/16/2017 /t 0005","04/17/2017 /t 0003","04/18/2017 /t 0004"};
		System.out.println(getLoyalCustomers(logs,"/t"));
	}
}
