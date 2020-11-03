package m2;

import java.util.*;

public class s3 {

	static int [][] D;
	
	static int answer;

	public static int solution(int n, int[][] edges) {
		answer = 0;

		D = new int [n+1][n+1];
		
		Set<Integer> visited = new HashSet<>();

		for(int i = 0; i < n-1; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			for(int q : visited) {
				if(q!=a&&q!=b) {
					if(D[a][q]>0&&D[b][q]==0) {
						D[b][q] = D[a][q]+1;
						D[q][b] = D[a][q]+1;
					}
					if(D[b][q]>0&&D[a][q]==0) {
						D[a][q] = D[b][q]+1;
						D[q][a] = D[b][q]+1;
					}
				}
			}
			D[a][b] = 1;
			D[b][a] = 1;
			visited.add(a);
			visited.add(b);
		}
		
		int [] arr = new int [3];
		
		comb(0,1,n,arr);

		return answer;
	}
	
	static void comb(int ind, int num, int n, int [] arr) {
		if(ind == 3) {
			int t = D[arr[0]][arr[1]]+D[arr[1]][arr[2]]+D[arr[0]][arr[2]];
			t /= 3;
			if(t > answer) answer = t;
			return;
		}
		if(num>n) return;
		else {
			arr[ind] = num;
			comb(ind+1,num+1,n,arr);
			comb(ind,num+1,n,arr);
		}
	}

	public static void main(String[] args) {
		int [][] edges = {{1,2},{2,3},{3,4}};
		System.out.println(solution(4,edges));
	}

}
