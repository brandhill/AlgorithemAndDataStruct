package ArraysProblems;

import java.util.ArrayList;
import java.util.List;

public class GreedyTextJustification {
	static public List<String> fullJustify(String[] words, int maxWidth) {
		
		List<String> list = new ArrayList<String>();
		metaData data = new metaData();
		for(String s: words) {
			data.totalChars += s.length();
		}
		if(data.totalChars<=1) {
			list.add(words[0]+generateSpaces(maxWidth - words[0].length()));
			return list;
		} 
			
		data.lines = data.totalChars/maxWidth;
		if(data.totalChars%maxWidth!=0) {
			data.lines += 1;
		}
		//data.spacesCharCount = (data.lines*maxWidth) - data.totalChars;
		//if(spacesCharCount < (words.length))
		//data.spaces = words.length - data.lines - 2;	
		//data.maxSpaceWidth = (data.spacesCharCount-data.spaces)+1;
		fullJustifyHelper(words, maxWidth, 0, data, list, 1);
		return list;
	}
	
	static public void fullJustifyHelper(String[] words, int maxWidth,int index,metaData data,List<String> list,int linenumber) {
		
		if(index >=words.length) {
			return;
		}
		int wordsCount = 0;
		StringBuffer s= new StringBuffer("");
		if(linenumber==data.lines) {	
			
			while(index < words.length && s.length()+words[index].length() <= maxWidth) {
				s.append(words[index]+"~");
				index++;
				wordsCount++;
			}
			String s1;
			if(index<words.length) {
				data.lines++;
				s1 = getString(maxWidth, s, wordsCount);
				list.add(s1);
			}
			else {
				s1 = s.toString().replaceAll("~", " ")+generateSpaces(maxWidth-s.length());
				list.add(s1.substring(0, maxWidth));
			}
			//String s1 = getString(maxWidth, s, wordsCount);
			fullJustifyHelper(words, maxWidth, index, data, list, linenumber+1);
			return;
		}
		
		while(index < words.length) {
			if(wordsCount==0 || (s.length()+words[index].length()) <= maxWidth) {
				s.append(words[index]+"~");
				//System.out.println(s.toString()+" "+(s.length())+" "+maxWidth);
				wordsCount++;
			}
			else {
				String s1 = getString(maxWidth, s, wordsCount);
				//System.out.println(s1+" "+s1.length());
				list.add(s1);
				fullJustifyHelper(words, maxWidth, index, data, list, linenumber+1);
				break;
			}
			index++;
		}
	}
	
	
	static String getString(int maxWidth,StringBuffer s,int wordsCount) {
		String[] chars = s.toString().split("~"); 
		int diff = maxWidth - s.length() + 1;
		String s1 = "";
		if(wordsCount>2) {
		int spaceWidth = diff/(wordsCount-1) + 1;
		//System.out.println(diff+" "+wordsCount);
		int extraSpace = diff%(wordsCount-1);
		for(int i = 0; i < chars.length; i++) {
				if(extraSpace > 0 ) {
					chars[i] = chars[i]+generateSpaces(spaceWidth+1);
					extraSpace--;
				}
				else {
					if(i!=chars.length-1) {
						chars[i] = chars[i]+generateSpaces(spaceWidth);
					}
				}
				s1 += chars[i];
				//System.out.println(s1);
			}
			//System.out.println(s1);
		}
		else {
			s1 = s.toString().replaceFirst("~", generateSpaces(diff+1)).substring(0, maxWidth);
		}
		System.out.println(s1+" "+s1.length());
		return s1;
	}
	static String generateSpaces(int n) {
		StringBuffer s = new StringBuffer("");
		for(int i = 0; i < n ; i++) {
			s.append(" ");
		}
		return s.toString();
 	}
	
	public static void main(String[] args) {
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		//String[] words = {"a","b","c","d","e"};
		//String[] words = {"Listen","to","many,","speak","to","a","few."};
		//12
		//String[] words ={"What","must","be","shall","be."};
		//12
		//String[] words = {"What","must","be","shall","be."};
				
		String[] words = {"Here","is","an","example","of","text","justification."};
				
		List<String> list = GreedyTextJustification.fullJustify(words, 16);
		System.out.println(list.toString());
	}
}

class metaData {
	// Total chars avaliable
	int totalChars;
	// Total lines in the output
	int lines;
	// Total minimum spaces in the output
	//int spaces;
	// Total count of each space ' '
	//int spacesCharCount;
	// Max spacewidth allowable
	//int maxSpaceWidth;
}
