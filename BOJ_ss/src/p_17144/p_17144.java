package p_17144;

import java.util.*;
import java.io.*;

public class p_17144 {

	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};

	static int R, C, T;

	static int [][] map;

	static int Y1, Y2;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int [R][C];

		Y1 = 0;
		Y2 = 0;

		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==-1) {
					Y2 = i;
				}
				map[i][j] = n;
			}
		}

		Y1 = Y2-1;

		for(int t = 0; t < T; t++) {
			diff();
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			cir();
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j]!=-1) {
					answer += map[i][j];
				}
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	static void diff() {
		int [][] cmap = new int [R][C];
		cmap[Y1][0] = -1;
		cmap[Y2][0] = -1;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j]>0) {
					int t = map[i][j];
					for(int d = 0; d < 4; d++) {
						int ty = i + dy[d];
						int tx = j + dx[d];
						if(ty>=0&&ty<R&&tx>=0&&tx<C&&cmap[ty][tx]!=-1) {
							cmap[ty][tx] += t/5;
							map[i][j] -= t/5;
						}
					}
				}
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j]!=-1) {
					map[i][j] += cmap[i][j];
				}
			}
		}
	}

	static void cir() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		for(int i = 1; i < C; i++) {
			queue.add(map[Y1][i]);
		}
		for(int i = Y1-1; i >= 0; i--) {
			queue.add(map[i][C-1]);
		}
		for(int i = C-2; i >= 0; i--) {
			queue.add(map[0][i]);
		}
		for(int i = 1; i < Y1-1; i++) {
			queue.add(map[i][0]);
		}
		
		for(int i = 1; i < C; i++) {
			map[Y1][i] = queue.poll();
		}
		for(int i = Y1-1; i >= 0; i--) {
			map[i][C-1] = queue.poll();
		}
		for(int i = C-2; i >= 0; i--) {
			map[0][i] = queue.poll();
		}
		for(int i = 1; i < Y1; i++) {
			map[i][0] = queue.poll();
		}
		
		queue.clear();
		queue.add(0);
		for(int i = 1; i < C; i++) {
			queue.add(map[Y2][i]);
		}
		for(int i = Y2+1; i < R; i++) {
			queue.add(map[i][C-1]);
		}
		for(int i = C-2; i >= 0; i--) {
			queue.add(map[R-1][i]);
		}
		for(int i = R-2; i >= Y2; i--) {
			queue.add(map[i][0]);
		}
		
		for(int i = 1; i < C; i++) {
			map[Y2][i] = queue.poll();
		}
		for(int i = Y2+1; i < R; i++) {
			map[i][C-1] = queue.poll();
		}
		for(int i = C-2; i >= 0; i--) {
			map[R-1][i] = queue.poll();
		}
		for(int i = R-2; i >= Y2+1; i--) {
			map[i][0] = queue.poll();
		}
	}

}
