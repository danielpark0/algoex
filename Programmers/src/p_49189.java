import java.util.*;

public class p_49189 {

	public static void main(String[] args) {
		int [][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6,vertex));
	}
	
	public static int solution(int n, int [][] edge) {
        int answer = 0;
        
        boolean [][] e = new boolean [n+1][n+1];
        
        for(int i = 0; i < edge.length; i++) {
        	e[edge[i][0]][edge[i][1]] = true;
        	e[edge[i][1]][edge[i][0]] = true;
        }
        
        int [] d = new int [n+1];
        
        for(int i = 2; i <= n; i++) {
        	d[i] = Integer.MAX_VALUE;
        }
        
        dfs(e,1,0,n,d);
        
        Arrays.sort(d);
        
        for(int i = n; i > 1; i--) {
        	if(d[n]!=d[i]) {
        		break;
        	}
        	answer++;
        }
        
        return answer;
    }
	
	static void dfs(boolean [][] e, int curr, int count, int n, int [] d) {
		if(d[curr] < count) {
			return;
		}
		else {
			d[curr] = count;
			for(int i = 2; i <= n; i++) {
				if(e[curr][i]) {
					dfs(e,i,count+1,n,d);
				}
			}
		}
	}

}
