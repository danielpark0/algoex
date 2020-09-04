package Day2;

import java.io.*;
import java.util.*;

public class p_2805 {

	public static void main(String[] args) throws Exception {
		
		long answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		long [] A = new long [N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		
		long l = 0;
		long h = A[N-1];
		while(true) {
			long m = (l+h)/2;
			long sum = 0;
			//System.out.println(m);
			for(int i = 0; i < N; i++) {
				if(A[i]>m) {
					sum += A[i]-m;
				}
			}
			if(sum==M) {
				answer = m;
				break;
			}
			else if(sum>M) {
				answer = m;
				l = m+1;
			}
			else {
				h = m-1;
			}
			if(l > h) {
				break;
			}
		}
		
		System.out.println(answer);

	}

}
