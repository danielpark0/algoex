package sol;

import java.util.*;

public class sol3_1 {
	
	public static int countCandies(int friends_nodes, List<Integer> friends_from, List<Integer> friends_to, List<Integer> friends_weight) {
	    // Write your code here
	        Set<Integer> [] sets = new HashSet[101];
	        int [][] maxV = new int [101][2];
	        for(int i = 1; i <= 100; i++){
	            sets[i] = new HashSet<Integer>();
	        }
	        int n = friends_from.size();
	        for(int i = 0; i < n; i++){
	            int i1 = friends_from.get(i);
	            int i2 = friends_to.get(i);
	            int e = friends_weight.get(i);
	            sets[e].add(i1);
	            sets[e].add(i2);
	            if(i1>maxV[e][0]){
	                maxV[e][1] = maxV[e][0];
	                maxV[e][0] = i1;
	            }
	            else if(i1!=maxV[e][0]&&i1>maxV[e][1]){
	                maxV[e][1] = i1;
	            }
	            
	            if(i2>maxV[e][0]){
	                maxV[e][1] = maxV[e][0];
	                maxV[e][0] = i2;
	            }
	            else if(i2!=maxV[e][0]&&i2>maxV[e][1]){
	                maxV[e][1] = i2;
	            }
	        }
	        int max = 0;
	        int maxS = 0;
	        for(int i = 1; i <= 100; i++){
	            if(maxS<=sets[i].size()){
	                maxS = sets[i].size();
	                if(max<maxV[i][0]*maxV[i][1])
	                    max = maxV[i][0]*maxV[i][1];
	            }
	        }
	        return max;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
