import java.util.*;
import java.io.*;

public class p_1389 {
	
	static int INF = 1000000;
	
	static int N, M;
	
	static int [][] D;
	
	static int [] S;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		D = new int [N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i!=j) {
					D[i][j] = INF;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			D[a][b] = 1;
			D[b][a] = 1;
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
		
		S = new int [N+1];
		
		int max = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				S[i] += D[i][j];
			}
			if(S[i]<S[max])
				max = i;
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(D[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}

}
