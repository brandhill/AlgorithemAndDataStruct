package ArraysandStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TwoCharacter {
	static int max = 0;
	static boolean isAlternative(String S){
		char[] chars1 = S.toCharArray();
		for(int i=0;i<=S.length()-3;i++){
			if(chars1[i]!=chars1[i+2]){
				return false;
			}
		}
		return true;
	}
	
	static void deletechars(String s,char x,char y){
		String ans = s.replaceAll(String.valueOf(x), "").replaceAll(String.valueOf(y),"");
		System.out.println(ans);
		if(isAlternative(ans)){
			System.out.println(ans);
			max = Math.max(max, ans.length());
		}
	}
	
	static void deletechars1(String s,char x,char y){
		for(int i =0;i<s.length();i++){
			if(s.charAt(i)!=x && s.charAt(i)!=y){
				s = s.replaceAll(String.valueOf(s.charAt(i)),"");
				i=0;
			}
				
		}
		
		//System.out.println(s);
		if(isAlternative(s)){
			//System.out.println(s);
			max = Math.max(max, s.length());
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        char[] chars = s.toCharArray();
        if(s.isEmpty() || s.length() < 2){
        	System.out.println("0");
        }
        
        else if(s.length()==2){
        	
        	System.out.println(s.length());
        }
        else {
        	Map<Character,Integer> map = new HashMap<Character,Integer>();
            for(int i=0;i<s.length();i++){
            	
            	if(!map.keySet().contains(chars[i])){
            		map.put(chars[i],1);
            	}
            	else{
            		map.put(chars[i], map.get(chars[i])+1);
            	}
            	}
            
            Iterator<Character> it = map.keySet().iterator();
            
            while(it.hasNext()){
            	char x = it.next();
            	Iterator<Character> it1 = map.keySet().iterator();
            	while(it1.hasNext()){
            		char y = it1.next();
            		if(x!=y){
                   		int diff = Math.abs(Math.subtractExact(map.get(x),map.get(y)));
                		if(diff==0 || diff==1){
                			TwoCharacter.deletechars1(s,x,y);
                		}
            		}
            	}
            }
            System.out.println(TwoCharacter.max);
            //System.out.println(count);
        }
        	
        	/*List<Character> list = new ArrayList<Character>();
            for(int i=0;i<s.length();i++){
            	
            	if(!list.contains(chars[i])){
            		System.out.println(chars[i]);
            		list.add(chars[i]);
            	}
            }
            System.out.println(list.size());
            for(int i=0;i<list.size()-1;i++){
            	for(int j=i+1;j<list.size();j++){
            	
            	TwoCharacter.deletechars(s,list.get(i),list.get(j));
            	}
            }
            
            System.out.println(TwoCharacter.max);
            

        }*/
    }
}
