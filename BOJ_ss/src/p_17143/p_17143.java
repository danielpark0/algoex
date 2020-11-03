package p_17143;

import java.util.*;
import java.io.*;

public class p_17143 {
	
	static int [] dy = {0, -1, 1, 0, 0};
	static int [] dx = {0, 0, 0, 1, -1};
	
	static int R, C, M;
	
	static Shark [][] map;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark [R+1][C+1];
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(s,d,z);
		}
		
		for(int i = 1; i <= C; i++) {
//			for(int y = 1; y <= R; y++) {
//				for(int x = 1; x <= C; x++) {
//					if(map[y][x]==null) {
//						System.out.print(0);
//					}
//					else{
//						System.out.print(map[y][x].z);
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();
			for(int j = 1; j <= R; j++) {
				if(map[j][i]!=null) {
					answer += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			move();
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void move() {
		Shark [][] cmap = new Shark[R+1][C+1];
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				cmap[i][j] = map[i][j];
				map[i][j] = null;
			}
		}
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(cmap[i][j]!=null) {
					int y=i;
					int x=j;
					int d=cmap[i][j].d;
					int a = cmap[i][j].s;
					if(d==1||d==2) {
						a %= 2*R;
					}
					if(d==3||d==4) {
						a %= 2*C;
					}
					for(int q = 0; q < a; q++) {
						if(y+dy[d]<=0) {
							d = 2;
						}
						else if(y+dy[d]>R) {
							d = 1;
						}
						else if(x+dx[d]<=0) {
							d = 3;
						}
						else if(x+dx[d]>C) {
							d = 4;
						}
						y += dy[d];
						x += dx[d];
					}
					if(map[y][x]==null||map[y][x].z<cmap[i][j].z) {
						map[y][x] = new Shark(cmap[i][j].s,d,cmap[i][j].z);
					}
				}
			}
		}
	}

}

class Shark{
	int s;
	int d;
	int z;
	public Shark(int s, int d, int z) {
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
