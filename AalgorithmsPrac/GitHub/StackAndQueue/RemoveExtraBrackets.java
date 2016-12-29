package StackAndQueue;
import java.util.Arrays;
import java.util.Stack;

/* Given a string with unbalanced brackets how do you remove minimum number
* of extra brackets so that you are left with balanced brackets in the string
* 
* e.g )( -> empty string
*     (a) -> (a)
*     ((mnq)abc))) -> ((mna)abc)
*     (abc)(( -> (abc)
* 
* Solution 1
* Keep a stack. When non bracket character shows up just skip it.
* When an opening bracket shows up just add it.
* When closing bracket shows up, see if top of stack is opening bracket. If yes
* then just remove that from stack else add closing bracket into the stack.
* 
* Solution 2
* This can be done without stack as well. Keep count of open and close brackets.
* Any time closeBracket gets more than openBracket do not put it in result.
* After we are done iterating input again if openBracket is more than closeBracket
* get rid of last (openBracket-closeBracket) open brackets.
* 
* Test cases:
* empty string
* String with )(
* String with all opening brackets
* String with all closing brackets
* String with mix of open close brackets and characters between them
* String with already balanced parenthesis
*
*/


public class RemoveExtraBrackets {
	// Time - O(n)
	// Space - O(n)
	public int remove(char input[]){
		int count = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < input.length; i++) {
			if(input[i]=='(') {
				stack.push(i);
			}
			else if(input[i]==')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					input[i] = ' ';
					count++;
				}
			}
		}
		while(!stack.isEmpty()) {
			input[stack.pop()] = ' ';
			count++;
		}
		System.out.println(String.valueOf(input).replaceAll(" ",""));
		return count; 
	}
	
	// Time - O(n)
	// Space - O(1)
	public int removeWithoutExtraSpace(char input[]){
		int count1 = 0;
		int count2 = 0;
		int count = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i]=='(') {
				count1++;
			}
			else if(input[i]==')') {
				count2++;
			}
			if(count2>count1) {
				input[i] = ' ';
				count2--;
				count++;
			}
		}
		int i = input.length-1;
		while(count1>count2) {
			if(input[i]=='(') {
				input[i]=' ';
				count1--;
				count++;
			}
			i--;
		}
		
		System.out.println(String.valueOf(input).replaceAll(" ",""));
		return count; 
	}
	
	public static void printArray(char input[], int size) {
        for(int i=0; i < size; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        RemoveExtraBrackets reb = new RemoveExtraBrackets();
        char input1[] = ")(".toCharArray();
        int pos = reb.remove(input1);
        System.out.println(pos);
        //printArray(input1, pos);
      
        char input1_1[] = ")(".toCharArray();
        pos = reb.removeWithoutExtraSpace(input1_1);
        System.out.println(pos);
        //printArray(input1_1, pos);
      
        char input2[] = "(((abc)(lm)(()".toCharArray();
        pos = reb.remove(input2);
        System.out.println(pos);
        //printArray(input2, pos);
 
        char input2_1[] = "(((abc)(lm)(()".toCharArray();
        pos = reb.removeWithoutExtraSpace(input2_1);
        System.out.println(pos);
        //printArray(input2_1, pos);
 
        char input3[] = "(((c)(l))))(()))".toCharArray();
        pos = reb.remove(input3);
        System.out.println(pos);
        //printArray(input3, pos);
 
        char input3_1[] = "(((c)(l))))(()))".toCharArray();
        pos = reb.removeWithoutExtraSpace(input3_1);
        System.out.println(pos);
        //printArray(input3_1, pos);
 
        char input4[] = "((((".toCharArray();
        pos = reb.remove(input4);
        System.out.println(pos);
        //printArray(input4, pos);
 
        char input4_1[] = "((((".toCharArray();
        pos = reb.removeWithoutExtraSpace(input4_1);
        System.out.println(pos);
        //printArray(input4_1, pos);
 
        char input5[] = "))))".toCharArray();
        pos = reb.remove(input5);
        System.out.println(pos);
        //printArray(input5, pos);
 
        char input5_1[] = "))))".toCharArray();
        pos = reb.removeWithoutExtraSpace(input5_1);
        System.out.println(pos);
        //printArray(input5_1, pos);

        char input6[] = "((Test))(Great)".toCharArray();
        pos = reb.remove(input6);
        System.out.println(pos);
        //printArray(input6, pos);
 
        char input6_1[] = "((Test))(Great)".toCharArray();
        pos = reb.removeWithoutExtraSpace(input6_1);
        System.out.println(pos);
        //printArray(input6_1, pos);
        //System.out.println("Completed");
    }
	
}
