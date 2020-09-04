package Day1;

import java.util.*;
import java.io.*;

public class p_1039_1 {
	
	static int [] N;
	static int K;
	
	static int answer;
	
	static boolean [][] visited;

	public static void main(String[] args) throws Exception {
		
		answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		
		N = new int [s.length()];
		
		visited = new boolean [1000001][11];
		
		for(int i = 0; i < s.length(); i++) {
			N[i] = s.charAt(i)-'0';
		}
		
		K = Integer.parseInt(st.nextToken());
		
		comb(0);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void comb(int cnt) {
		if(N[0]==0) {
			
		}
		else if(cnt == K) {
			int sum = 0;
			for(int i = 0; i < N.length; i++) {
				sum *= 10;
				sum += N[i];
			}
			answer = Math.max(answer, sum);
		}
		else {
			for(int i = 0; i < N.length; i++) {
				for(int j = i+1; j < N.length; j++) {
					swap(i,j);
					if(check(cnt+1)) {
						comb(cnt+1);
					}
					swap(i,j);
				}
			}
		}
	}
	
	static void swap(int i1, int i2) {
		int temp = N[i1];
		N[i1] = N[i2];
		N[i2] = temp;
	}
	
	static boolean check(int k) {
		int sum = 0;
		for(int i = 0; i < N.length; i++) {
			sum *= 10;
			sum += N[i];
		}
		if(visited[sum][k]) {
			return false;
		}
		else {
			visited[sum][k] = true;
			return true;
		}
	}

}
