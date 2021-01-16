package sol;

import java.util.*;

public class sol3 {
	
	public static int countCandies(int friends_nodes, List<Integer> friends_from, List<Integer> friends_to, List<Integer> friends_weight) {
	    // Write your code here
	        Set<Integer> [] sets = new HashSet[101];
	        for(int i = 1; i <= 100; i++){
	            sets[i] = new HashSet<Integer>();
	        }
	        int n = friends_from.size();
	        for(int i = 0; i < n; i++){
	            sets[friends_weight.get(i)].add(friends_from.get(i));
	            sets[friends_weight.get(i)].add(friends_to.get(i));
	        }
	        int max = 0;
	        int maxP = 0;
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 1; i <= 100; i++){
	            if(sets[i].size()>maxP){
	                maxP = sets[i].size();
	                set.clear();
	                set.add(i);
	            }
	            else if(sets[i].size()==maxP){
	                set.add(i);
	            }
	        }
	        for(int e : set){
	            int m1 = 0;
	            int m2 = 0;
	            for(int q : sets[e]){
	                if(q>m1){
	                    m2 = m1;
	                    m1 = q;
	                }
	                else if(q>m2){
	                    m2 = q;
	                }
	            }
	            if(m1*m2>max) max = m1*m2;
	        }
	        return max;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
