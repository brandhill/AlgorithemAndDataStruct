package VeryImportantQuestions;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

// http://www.programcreek.com/2012/12/leetcode-word-ladder/

public class WordLadder {

	private class Word {
		String word;
		int numSteps;
		Word prev;
		
		Word(String word, int steps) {
			this.word = word;
			this.numSteps = steps;
		}
	}
	
	public List<String> ladderLength(String start, String end, Set<String> dict) throws Exception{
        List<String> result = new ArrayList<String>();
		Queue<Word> queue = new LinkedList<Word>();
		if(!dict.contains(start))
			throw new Exception(start+ "is not in dictionary");
		if(!dict.contains(end))
			throw new Exception(end+ "is not in dictionary");
		queue.add(new Word(start,1));
// 		Set<String> visited = new HashSet<String>();
		while(!queue.isEmpty()) {
			Word word = queue.poll();
			char[] str = word.word.toCharArray();
			for(int i=0; i<str.length; i++) {
				char temp = str[i];
				for(char c='a'; c<='z';c++) {
					str[i] = c;
					String check = String.valueOf(str);
					if(dict.contains(check)) {
						Word w = new Word(check, word.numSteps+1);
						w.prev = word;
						if(check.equals(end)) {
							List<String> tempList = new ArrayList<String>();
							while(w!=null) {
								tempList.add(w.word);
								w = w.prev;
							}
							for(int j = tempList.size()-1; j>=0; j++) {
								result.add(tempList.get(j));
							} 
							return result;
						}
						queue.add(w);
						dict.remove(check);
					}
				}
				str[i] = temp;
			}
		}
		
		return null;

	}
	 
	 
	 public static void main(String[] args) {

	}
}
