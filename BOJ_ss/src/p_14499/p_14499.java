package p_14499;

import java.util.*;
import java.io.*;

public class p_14499 {
	
	static int [] dy = {0,0,0,-1,1};
	static int [] dx = {0,1,-1,0,0};
	
	static int N, M, Y, X, K;
	
	static int [][] map;
	
	static int [] dice;
	
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		
		sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		dice = new int [7];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			roll(d);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	static void roll(int d) {
		int ty = Y + dy[d];
		int tx = X + dx[d];
		if(ty<0||ty>=N||tx<0||tx>=M) return;
		Y = ty;
		X = tx;
		if(d==1) {
			int t = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = t;
		}
		else if(d==2) {
			int t = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = t;
		}
		else if(d==3) {
			int t = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = t;
		}
		else {
			int t = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = t;
		}
		if(map[Y][X]==0) {
			map[Y][X] = dice[1];
		}
		else {
			dice[1] = map[Y][X];
			map[Y][X] = 0;
		}
		sb.append(dice[6]+"\n");
	}

}
