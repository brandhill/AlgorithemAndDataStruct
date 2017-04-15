package VeryImportantQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordSuggestions {
	
	static List<String> passwordSuggestions(String password, Map<Character,Character> map) {
		List<String> suggestions = new ArrayList<String>();
		suggestions.add(password);
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(map.containsKey(c)) {
				List<String> temp = new ArrayList<String>();
				for(String s: suggestions) {
					char[] chars = s.toCharArray();
					chars[i] = map.get(c);
					temp.add(String.valueOf(chars));
				}
				suggestions.addAll(temp);
//				System.out.println(suggestions);
			}
		}
		suggestions.remove(password);
		return suggestions;
	}
	
	public static void main(String[] args) {
		String pass = "password";
		Map<Character,Character> map = new HashMap<Character,Character>();
		map.put('i', '!');
		map.put('a', '@');
		map.put('s', '$');
		map.put('o', '0');
		map.put('E', '3');
		List<String> sugg = passwordSuggestions(pass,map);
		System.out.println(sugg.size());
		for(String s: sugg) {
			System.out.println(s);
		}
	}
}


// Map:{{'i','!'},{'a','@'},{'s','$'},{'o','0'}, {'E','3'}}