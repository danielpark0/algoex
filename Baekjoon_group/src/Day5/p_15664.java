package Day5;

import java.io.*;
import java.util.*;

public class p_15664 {
	
	static int N,M;
	
	static int [] nums;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int [N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int [] ans = new int [M];
		
		comb(0,0,ans);

	}
	
	static void comb(int n, int ind, int [] ans) {
		if(ind==M) {
			for(int e : ans)
				System.out.print(e+" ");
			System.out.println();
		}
		else if(n>=N) {
			
		}
		else {
			ans[ind] = nums[n];
			comb(n+1,ind+1,ans);
			while(n<N&&ans[ind]==nums[n]) {
				n++;
			}
			comb(n,ind,ans);
		}
	}

}
