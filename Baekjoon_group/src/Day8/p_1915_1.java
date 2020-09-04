package Day8;

import java.util.*;
import java.io.*;

public class p_1915_1 {
	
	static int N,M;
	static int [][] map;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1)-'0';
				if(map[i][j]==1) {
					map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1]))+1;
					if(answer < map[i][j]) {
						answer = map[i][j];
					}
				}
			}
		}
		
		System.out.println(answer*answer);

	}

}
