package Day5;

import java.io.*;
import java.util.*;

public class p_1256_1 {

	static int N, M, K;
	static int [][] dp = new int [201][201];
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K > combination(N+M,M)) {
			System.out.println("-1");
		}
		else {
			query(N,M,K);
			System.out.println(sb.toString());
		}
		
	}
	
	//n : a의 개수, m : z의 개수, k 번째.
	static void query(int n, int m, int k) {
		//n+m == 0 끝
		if(n+m==0) {
			return;
		}
		else if(n==0) {
			sb.append("z");
			query(n, m-1, k);
		}
		else if(m==0) {
			sb.append("a");
			query(n-1,m,k);
		}
		else {
			int aCount = combination(n+m-1,m);
			if(aCount >= k) {
				sb.append('a');
				query(n-1,m,k);
			}
			else {
				sb.append('z');
				query(n,m-1,k-aCount);
			}
		}
	}
	
	public static int combination(int n, int r) {
		if(n==r||r==0) {
			return 1;
		}
		else if(dp[n][r]!=0) {
			return dp[n][r];
		}
		else {
			return dp[n][r] = Math.min(combination(n-1, r-1) + combination(n-1,r),(int)1e9);
		}
	}
	
	
}
