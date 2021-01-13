package ex;

import java.util.*;

public class parallelprocessing {
	
	public static long minTime(List<Integer> files, int numCores, int limit) {
	    // Write your code here
	        long answer = 0;
	        Collections.sort(files);
	        for(int i = files.size()-1; i >= 0; i--){
	            int e = files.get(i);
	            if(limit>0&&e%numCores==0){
	                e/=numCores;
	                limit--;
	            }
	            answer += e;
	        }
	        
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
