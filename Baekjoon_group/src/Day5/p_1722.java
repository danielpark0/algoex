package Day5;

import java.util.*;
import java.io.*;

public class p_1722 {

	static int N;
	
	static long [] factorial;
	static boolean [] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		factorial = new long [N+1];
		visited = new boolean [N+1];
		
		factorial[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			factorial[i] = factorial[i-1]*i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		if(Integer.parseInt(st.nextToken())==1) {
			
			StringBuilder sb = new StringBuilder();
			
			long k = Long.parseLong(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				//System.out.println(k);
				for(int j = 1; j <= N; j++) {
					if(visited[j]) {
						continue;
					}
					
					if(k > factorial[N-i-1]) {
						k -= factorial[N-i-1];
					}
					else {
						sb.append(j+" ");
						visited[j] = true;
						break;
					}
				}
			}
			
			System.out.println(sb.toString());
			
		}
		else {
			long sum = 0;
			
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				int cnt = 0;
				for(int j = 1; j < N; j++) {
					if(j==n) {
						visited[j] = true;
						break;
					}
					if(!visited[j]) {
						cnt++;
					}
				}
				sum += cnt*factorial[N-i-1];
			}
			System.out.println(sum+1);
		}

	}

}
