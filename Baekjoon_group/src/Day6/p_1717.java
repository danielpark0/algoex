package Day6;

import java.util.*;
import java.io.*;

public class p_1717 {

	static int N, M;
	
	static int [] num;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			num[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(n==0) {
				union(a,b);
			}
			else {
				if(find(a)==find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}

	}
	
	static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if(ar<br){
			num[br] = ar;
		}
		else {
			num[ar] = br;
		}
	}
	
	static int find(int n) {
		if(num[n]==n) {
			return n;
		}
		else {
			return num[n] = find(num[n]);
		}
	}

}
