package ArraysandStrings.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ArraysandStrings.BasicStringComp5;

public class BasicStringComp5Test {
	
	@Before
	public void before(){
		
	}
	
	@After
	public void after(){
		
	}
	
	@Test
	public void test() {
		BasicStringComp5 obj = new BasicStringComp5();
		String input = "aaabbcc";
		assertEquals("a3b2c2", obj.stringcomp(input));
	}
	
	@Test
	public void test1() {
		int[] a1 = {3,2,4,5,1,6};
		Arrays.sort(a1);
		int[] a2 = {1,2,3,4,5,6};
	assertArrayEquals(a2, a1);
	}
	
	@Test(timeout=10000)
	public void test2() {
		for(int i=1;i<100000000;i++){
			
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void test3() {
		int[] a = null;
		Arrays.sort(a);
	}

}
