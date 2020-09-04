package Day1;

import java.util.*;
import java.io.*;

public class p_1039 {
	
	static int [] N;
	static int K;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		
		N = new int [s.length()];
		
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
					comb(cnt+1);
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

}
