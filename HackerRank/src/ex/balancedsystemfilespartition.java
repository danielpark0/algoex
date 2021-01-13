package ex;


/////wrong answer/////



import java.util.*;

public class balancedsystemfilespartition {
	
	public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
	    // Write your code here
	        int n = parent.size();
	        int [] segTree = new int [n];
	        int [] check = new int [n];
	        for(int e : parent){
	            if(e>=0){
	                check[e]++;
	            }
	        }
	        Queue<Integer> queue = new LinkedList<>();
	        for(int i = 0; i < n; i++){
	            if(check[i]==0){
	                queue.add(i);
	            }
	        }
	        while(!queue.isEmpty()){
	            int curr = queue.poll();
	            int p = parent.get(curr);
	            segTree[curr] += files_size.get(curr);
	            segTree[p] += segTree[curr];
	            check[p]--;
	            if(check[p]==0&&p!=0){
	                queue.add(p);
	            }
	        }
	        
	        for(int e : segTree)
	            System.out.println(e);
	        
	        int answer = Integer.MAX_VALUE;
	        for(int i = 1; i < n; i++){
	            if(answer > segTree[parent.get(i)]-segTree[i]){
	                answer = segTree[parent.get(i)] - segTree[i];
	            }
	        }
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
