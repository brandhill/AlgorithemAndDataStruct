package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Amazon Air operates an airport runway. Throughout the year pot holes will develop on the runway,
//when a pot hole is patched we record the endpoints of the patch. At the end of the year we need to
//inspect all of the patches, but only the patches that have not been completely covered by a later
//patch.
//For this example we will treat the runway like a line and so the endpoints of a patch represent the
//two points on a line.
//
//Write a method which can accept two arrays of endpoints in chronological order and return the
//number of inspections we need to perform.
//
//Example signature: int inspect(int[] x1, int[]x2)
//For example, if the patches correspond to the following segments: (1, 3), (30, 35), and (10, 40), then
//the input arrays would be [ 1, 30, 10 ] and [ 3, 35, 40 ], and the expected number of inspections
//would be 2 as the second patch is covered by the last one.


public class RunwayInspections {
    
    int inspect(int[] x1, int[] x2) {
        int len = x1.length;
        if(len==0)
            return 0;
        if(len==1)
            return 1;
        List<PointA> list = new ArrayList<PointA>();
        for(int i =0; i< len; i++) {
        	int x,y;
        	if(x1[i]>x2[i]) {
        		x = x2[i];
        		y = x1[i];
        	} else {
        		x = x1[i];
        		y = x2[i];
        	}
            list.add(new PointA(x,y));
        }
        Collections.sort(list);
        
        int count = 1;
        int max = list.get(0).y;
        for(int i = 0; i < len; i++) {
            PointA p = list.get(i);    
            if(p.x>max || p.y>max) {
                count++;
                max = p.y;
            }
        }
        
        return count;
    }   
    
    
    
    public static void main(String[] args) {
		int[] x1 = {1,30,11,38,45};
		int[] x2 = {3,35,40,45,45};
//    	int[] x1 = {1,3,3, 25, 5};
//		int[] x2 = {10,15,14, 27, 20};
		RunwayInspections r = new RunwayInspections();
		int count = r.inspect(x1, x2);
		System.out.println(count);
	}
}

class PointA implements Comparable<PointA>{
   int x;
   int y;
   
   PointA(int x, int y) {
       this.x = x;
       this.y = y;
   }
   
   @Override
   public int compareTo(PointA p) {
       if(this.x>p.x) {
           return 1;
       } else if(this.x<p.x) {
           return -1;
       } else {
           if(this.y>p.y) {
           return -1;
       } else if(this.y<p.y) {
           return 1;
       }
       }
       return 0;
   }


}
