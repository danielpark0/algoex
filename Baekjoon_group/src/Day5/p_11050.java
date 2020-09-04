package Day5;

import java.io.*;
import java.util.*;

public class p_11050 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		long [][] comb = new long [N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= i; j++) {
				if(j==0||j==i) {
					comb[i][j] = 1;
				}
				else {
					comb[i][j] = comb[i-1][j-1]+comb[i-1][j];
				}
			}
		}
		
		bw.write(Long.toString(comb[N][K]));
		bw.flush();
		bw.close();
	}
	
}
