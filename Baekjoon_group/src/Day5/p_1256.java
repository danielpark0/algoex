package Day5;

import java.io.*;
import java.util.*;

public class p_1256 {

	static int N, M, K;

	static int [][] comb;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		comb = new int [N+M+1][N+M+1];

		StringBuilder sb = new StringBuilder();

		if(K>combination(N+M,N)) {
			System.out.println(-1);
		}
		else {
			while(K>=0) {
				int curr = combination(N+M-1,N-1);
				//System.out.println(N+" "+M+" "+K+" "+curr+" "+sb.toString());
				if(K <= curr) {
					N--;
					sb.append('a');
				}
				else {
					M--;
					K -= curr;
					sb.append('z');
				}
				if(N==0) {
					while(M-->0) {
						sb.append('z');
					}
					break;
				}
			}
			System.out.println(sb.toString());
		}

	}

	static int combination(int N, int M) {
		if(N==M||M==0) {
			return 1;
		}
		else if(comb[N][M]!=0) {
			return comb[N][M];
		}
		else {
			return comb[N][M] = Math.min(combination(N-1,M-1)+combination(N-1,M),(int)1e9);
		}
	}

}
