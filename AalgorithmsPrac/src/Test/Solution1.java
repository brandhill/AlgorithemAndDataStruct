package Test;

import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import GraphsDataStructures.mainclass;

public class Solution1 {
	int x = 5;
	
	static String m() {
		String s = "ASA";
		try {
			try{
				throw new Exception();
			}
			catch(Exception e) {
				System.out.println("B");
			}
			throw new Exception();
		}
		catch(Exception e) {
			System.out.println("C");
		} finally {
			System.out.println("D");
		}
		System.out.println("asdasdasdasd");
		return s;
	}
	static String message;
	public static void main(String[] args) {
		try{
			message = m();
			System.out.println("try "+message);
		}
		catch(Exception e) {
			System.out.println("B");
		}
		finally {
			System.out.println(message);
		}
		List list = new ArrayList();
	}
	
}


interface a {
	
	int x() ;
}

abstract class b implements a {
	 public int x() {
		return 0;
		 
	 }
}
 