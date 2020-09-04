package Day6;

import java.util.*;
import java.io.*;

public class p_2458_1 {

	static int N, M;

	static int [][] D;
	
	static int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		
		int answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		D = new int [N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) {
					D[i][j] = 0;
				}
				else {
					D[i][j] = INF;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			D[a][b] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(D[i][k]+D[k][j]<D[i][j]) {
						D[i][j] = D[i][k]+D[k][j];
					}
				}
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(D[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(D[i][j]==INF&&D[j][i]==INF) {
					break;
				}
				if(j==N) answer++;
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
	}

}
