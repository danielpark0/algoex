package Day5;

import java.io.*;
import java.util.*;

public class p_15663 {
	
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
		boolean [] visited = new boolean [N];
		
		comb(0,ans,visited);

	}
	
	static void comb(int ind, int [] ans, boolean [] visited) {
		if(ind==M) {
			for(int i = 0; i < M; i++) {
				System.out.print(ans[i]);
				if(i < M-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		else {
			int p = 0;
			for(int i = 0; i < N; i++) {
				if(!visited[i]&&p!=nums[i]) {
					p = nums[i];
					ans[ind] = nums[i];
					visited[i] = true;
					comb(ind+1,ans,visited);
					visited[i] = false;
				}
			}
		}
	}

}
