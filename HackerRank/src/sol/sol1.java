package sol;

import java.util.*;

public class sol1 {

	static int max;

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
    // Write your code here
        max = 0;
        dfs(0,0,weights,maxCapacity);
        return max;
    }
    
    static void dfs(int ind, int sum, List<Integer> weights, int maxCapacity){
        if(sum > maxCapacity) return;
        if(sum > max) max = sum;
        if(ind>=weights.size()) return;
        dfs(ind+1,sum+weights.get(ind),weights,maxCapacity);
        dfs(ind+1,sum,weights,maxCapacity);
    }

	public static void main(String[] args) {



	}

}
