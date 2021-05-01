package dfs_bfs;

import java.io.*;
import java.util.*;

public class p_1058 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean [][] conn = new boolean [N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				if(s.charAt(j)=='Y')
					conn[i][j] = true;
			}
		}
		
		for(int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = 0; j < N; j++) {
				if(conn[i][j]) {
					set.add(j);
					for(int q = 0; q<N; q++) {
						if(i!=q&&conn[j][q]) {
							set.add(q);
						}
					}
				}
				if(answer<set.size())
					answer = set.size();
			}
		}
		System.out.println(answer);
	}

}
