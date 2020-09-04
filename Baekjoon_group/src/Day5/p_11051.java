package Day5;

import java.util.*;
import java.io.*;

public class p_11051 {
	
	static int [][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int [10001][10001];
		
		System.out.println(bionomal(N,K));

	}
	
	static int bionomal(int N, int K) {
		//System.out.println(N+" "+K);
		if(N==K||K==0) {
			return 1;
		}
		if(K==1||N==K-1) {
			return N;
		}
		if(arr[N][K]==0) {
			return arr[N][K] = (bionomal(N-1,K-1)+bionomal(N-1,K))%10007;
		}
		else {
			return arr[N][K];
		}
	}

}
