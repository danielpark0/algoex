package Day5;

import java.util.*;
import java.io.*;

public class p_5557 {
	
	static int N;
	static int [] nums;
	
	static long answer;
	
	static boolean [][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int [N];
		visited = new boolean [N][21];
		
		answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(nums[0],1);
		
		System.out.println(answer);

	}
	
	static void comb(int sum, int ind) {
		if(sum>20||sum<0) {
			
		}
		else if(ind==N-1) {
			if(sum==nums[ind])
				answer++;
		}
		else {
			comb(sum+nums[ind],ind+1);
			comb(sum-nums[ind],ind+1);
		}
	}

}
