package p_14503;

import java.io.*;
import java.util.*;

public class p_14503 {

	static int [] dy = {-1,0,1,0};
	static int [] dx = {0,1,0,-1};

	static int N, M;

	static int [][] map;

	static int Y,X,D;

	static int answer;

	public static void main(String[] args) throws Exception {

		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int [N][M];

		st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			if(map[Y][X]==0) {
				answer++;
				map[Y][X] = 2;
			}
			int nd = search();
			if(nd>-1) {
				D = nd;
				Y += dy[D];
				X += dx[D];
			}
			else {
				int by = Y+dy[(D+2)%4];
				int bx = X+dx[(D+2)%4];
				if(map[by][bx]==1) {
					break;
				}
				else {
					Y = by;
					X = bx;
				}
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	static int search() {
		for(int i = 1; i <= 4; i++) {
			int nd = D-i;
			if(nd<0) nd+=4;
			if(map[Y+dy[nd]][X+dx[nd]]==0) return nd;
		}
		return -1;
	}

}
