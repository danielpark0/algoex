package Day5;

import java.util.*;
import java.io.*;

public class p_5557_1 {
	
	static int N;
	static int [] nums;
	
	static	long [][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int [N];
		dp = new long [N][21];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][nums[0]] = 1;
		
		for(int i = 0; i < N-2; i++) {
			for(int j = 0; j < 21; j++) {
				if(dp[i][j]>0&&j+nums[i+1]>=0&&j+nums[i+1]<=20) {
					dp[i+1][j+nums[i+1]] += dp[i][j];
				}
				if(dp[i][j]>0&&j-nums[i+1]>=0&&j-nums[i+1]<=20) {
					dp[i+1][j-nums[i+1]] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N-2][nums[N-1]]);

	}

}
