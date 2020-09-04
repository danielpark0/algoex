package Day5;

import java.util.*;
import java.io.*;

public class p_1722_sol {

	static int N;
	
	static long [] factorial;
	static int [] nums;
	
	static boolean [] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		factorial = new long [N+1];
		
		factorial[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			factorial[i] = factorial[i-1]*i;
		}
		
		visited = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		if(Integer.parseInt(st.nextToken())==1) {
			
			long k = Long.parseLong(st.nextToken());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				for(int j = 1; j <= N; j++) {
					if(visited[j]) {
						continue;
					}
					if(k > factorial[N-i-1]) {
						k -= factorial[N-i-1];
					}
					else {
						sb.append(j);
						sb.append(" ");
						visited[j] = true;
						break;
					}
				}
			}
			System.out.println(sb.toString());
		}
		else {
			nums = new int [N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			long result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 1; j < nums[i]; j++) {
					if(visited[j] == false) {
						result += factorial[N-i-1];
					}
					visited[nums[i]] = true;
				}
			}
			System.out.println(result+1);
		}

	}

}
