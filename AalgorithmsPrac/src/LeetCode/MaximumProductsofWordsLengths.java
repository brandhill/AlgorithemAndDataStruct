package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumProductsofWordsLengths {
	
	 @SuppressWarnings("unchecked")
	public int maxProduct(String[] words) {
		 
		 if (words == null || words.length < 1) {
			 return 0;
		 }
		List<String> list = (List<String>) Arrays.asList(words);
		 Collections.sort(list,new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				if(s1.equals(s2))
					return 0;
				return s2.length()-s1.length();
				/*if(s1.length()>s2.length())
					return -1;
				else
					return 1;*/
			}
		 });
		 
		 //System.out.println(list.toString());
		 int max = 0;
		 for(int i = 0; i < list.size()-1; i++){
			 
			 char[] c = list.get(i).toCharArray();
			 Set<Character> c1 = new HashSet<Character>();
			    for (char chars : c) {
			        c1.add(chars);
			    }
			 for(int j = i+1; j < list.size(); j++){
				 System.out.println(i+" "+j);
				 boolean check = true;
				 char[] c2 = list.get(j).toCharArray();
				 	for(char chars: c2){
				 		if(c1.contains(chars)){
				 			check = false;
				 			break;
				 		}
				 	}
				 if(check){
				 	//	return list.get(i).length()*list.get(j).length();
					 max = Math.max(max, list.get(i).length()*list.get(j).length());
				 }
			 }
			 
		 }
		 
		 //System.out.println(list.toString());
		 return max;
	 }
	 
	 public static void main(String[] args) {
		 MaximumProductsofWordsLengths M = new MaximumProductsofWordsLengths();
		 String[] s = {"fdeeaedbebc","edfd","beecbafddbccffad","ccddfdbefadacbbe","acbaba","beaaea","aadfcffd","cbaedeaadf","daffafacfcbcdbb","ecaeacde","addaeddccbbdaeeabd","aacabefe","bcacccfdeafaebd","ccdcbabafccbceefcbea","abdcebfddec","feeeebdffcdfadd","cdcfbefdefabfadeb","faabcab","fbababbfebfa","baeb","efaaaeffcbeddcbcf","accadbadaa","eefccbacbebfccafedccb","dffceebdee","ebcadbbbcbfeaadbbd","feceadaacefdedfdddec","cdacdfbcdbbbfabaabaeb","eadfcfcedddaafecba","acd","ddebfbcacefacafddcfa","dfbdac","bc","eccbadcabcdebcfec","bcddbbfdcadf","eccaea","cdcfdbdaacfbeaaab","edbadadbecaafcaebac","be","ef","bdddc","dcbfbfd","dfdcdfcfedcabecddeef","faaababebf","daffbefabbdbd","bfafcccdfbbddedeecbad","baea","baafbdedefeadafe","afb","ebe","debcdcfcbecf","bccfd","dfeebdcbecaabdf","edaccaebaedebf","ddbcecedbdeaffcd","aefbdfcdcbaceaaadbbd","fefadebacbdafaba","aeedfecaaafddb","dfabdacfabceedffac","fedd","edaf","eadceaadcdebbbff","befadddcadeedceffacd","fcabfacaafeedd","fabcdaebcffeabdbaaccb","ecefeeceaf","ebafcbabebadb","defeafa","dfddcceadfdcffede","aaeafeaeebbebcef","edfbaddeabbbc","bcdcdcaf","fceffbabfc","efedeeab","beedeadcbebdeafc","ebfecbabaec","feb","fcafcfd","eecffceabffcccfcc","eaccadfdcfeeade","dbecabfbdddab","aaaeedeeadcefcba","ecafe","dcccdee","cffadcaecdaaeadcd","bfbabbfdeed","eaeeffadeeecdcfddfba","cebfcefdfdcfdadcbbf","fabdeefdada","aaceaffaaace","bfeccfbacfcbbbcbcdf","befcbafbadfaebaaded","deccccbebd","edfdcecaebfeaebbdaeab","dcaddc","eabdaeaafcacdaec","afcdadccbeffebbe","aeeaefeeedfaeabbaca","caeaddeaafdc","cbeeeeaadbbaeeecf","cfbdebcac","bafedbedebfafaaaea","afcedecccddbeafcddcbc","ebbfabfccbbafef","beffbcf","dbcaebfaadbfbbea","ffcafbd","effdfbaf","dffeeeecaccbdca","ccfbeeecadffcdeea","deafdebedefbfafead","acccbefeafafb","acaedbbfbfc","cbefadddcadbabcdf","daaeecaeedefc","fcbfddabcadc","ffddcceaceabcbfcc","facd","bccdfa","caddabecabaadeeacc","caddfdefaabbeaccbfda","ecceedc","bcbaceafebbcfee","adcdbaeaa","afccf","cfdcdbcfedaacdbaeb","bdfeccc","babcaddacbe","dfbcbcb","ec","ed","dcadaeebdec","daefafdbad","deadaacadacab","babaeabfaec","faeaac","ddecccdcbecfdedb","fc","fdfda","dceaaaafeecafeededfb","bfaefab","dfacbbefbabaf","ceabbdb","ccabeafccaf","fcfadbfdeac","bdfaacdabfabebee","dcdd","cceabceabbefdaaaeedb","fedbcffedbbcaeeb","fadbdeddcfcefdbdba","dbbdacdcdcdfdc","eacdf","ffcddcefbbcadfed","eddebebedbbabcbb","afbcafaaffcebefafe","eadbcaeeadadc","dafcfbefdabfbaadaa","aaffafefbe","abcdfda","ffddecfff","abeeafebdb","fcddffbaaccfbec","feeaaacdfe","dfeeefeacbbafed","dcfaaaaafedefb","feccfddbafbfadcfcb","eedefebc","efffcceefbeeaeccacfc","ddaafafedacbfc","eadbeeeffdcaf","dfefb","aadcaba","ba","bfbbbcbfbdbda","edcfd","dddadddcfa","defbecfbe","afbdccdfeabcaeeecb","fbdfee","aabcfbeeebdcccdba","ffafdbaffccb","cdaebb","eeadfdadcf","adcfaeccaafdeeecfd","afe","bdbccfe","daaaebcfcaadd","abffbbcfbddbbffcbebfa","ebfccaeefaacdeaece","feeb","eddbfefdaefeea","dadafadecac","fbfeefbdfb","fbcc","eeebd","adedeebafabdcbaebc","cc","dffddbdf","cfebadbadffceca","cbaefcbeddddfaabaefae","eaecbcbebaaebe","bdabafabbabdafaacd","feebefebbaeccafafedc","cdcfbcbaf","faafccafdcafeadf","ecdcede","fdafceadacff",
		                "aafdffbcffcfa","eefcfebadcecadcc","adebefcdaefbbeaeabff","cfcceadbdeadcababea","beca","bdbbcffcdceadcfefba"};
		 long startTime = System.currentTimeMillis();
		 System.out.println(M.maxProduct(s));
		 long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("TIme "+totalTime);
	}
	 
}


