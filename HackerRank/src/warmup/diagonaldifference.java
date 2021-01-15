package warmup;

import java.util.*;

public class diagonaldifference {
	
	public static int diagonalDifference(List<List<Integer>> arr) {
	    // Write your code here
	        int n = arr.size();
	        int lr = 0;
	        int rl = 0;
	        for(int i = 0; i < n; i++){
	            lr += arr.get(i).get(i);
	            rl += arr.get(i).get(n-1-i);
	        }
	        return Math.abs(lr-rl);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
