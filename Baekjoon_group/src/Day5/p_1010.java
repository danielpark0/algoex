package Day5;

import java.io.*;
import java.util.*;

public class p_1010 {

	static int [][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int [30][30];

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(bio(M,N));
		}

	}

	static int bio(int N, int K) {
		if(K==N||K==0||N==0) {
			return 1;
		}
		else if(arr[N][K]!=0) {
			return arr[N][K];
		}
		else {
			return arr[N][K]=bio(N-1,K-1)+bio(N-1,K);
		}
	}

}
