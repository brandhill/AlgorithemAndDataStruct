package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;

// On the whiteboard, please write a version of the unix utility "wc" in the language of your choice.

public class WordCount {
	
	static void wordCounts(String s) {
		char[] chars = s.toCharArray();
		int j = 0;
		int i = 0;
		int charsCount = 0;
		int wordsCount = 0;
		Set<String> set = new HashSet<String>();
		while (i<s.length()) {
			if(chars[i]==' ') {
				if(i==j) {
					i++;
					j++;
				}
				else if(chars[j]!=' ') {
					String subString = s.substring(j,i);
//					System.out.println(subString);
					if(!set.contains(subString)) {
						set.add(subString);
						wordsCount++;
					}
					i++;
					j = i;
				}
			}
			else if(chars[i]!=' ') {
					i++;
					charsCount++;
			}
		}

		if(j < s.length() && chars[j]!=' ' && !set.contains(s.substring(j)))
			wordsCount++;
		System.out.println(s);
		System.out.println("chars"+" "+charsCount);
		System.out.println("words "+wordsCount);
	}
	
	public static void main(String[] args) {
		wordCounts("asas hgfhg   gfhgfgf fgfgfg fftff f f g g");
		wordCounts("       ");
		wordCounts("    a   ");
		wordCounts("a       a");
		wordCounts("a       ");
		wordCounts("aaaaa aaaa aa a");
	}
}
