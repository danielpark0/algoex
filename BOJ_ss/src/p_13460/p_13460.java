package p_13460;

import java.util.*;
import java.io.*;

public class p_13460 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int N, M;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int [N][M];
		
		int Ry = 0, Rx = 0, By = 0, Bx = 0;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j)=='#'||s.charAt(j)=='R'||s.charAt(j)=='B') {
					map[i][j] = -1;
					if(s.charAt(j)=='R') {
						Ry = i;
						Rx = j;
					}
					else if(s.charAt(j)=='B') {
						By = i;
						Bx = j;
					}
				}
				else if(s.charAt(j)=='O') {
					map[i][j] = 1;
				}
			}
		}
		
		simulation(0,map,Ry,Rx,By,Bx);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void simulation(int cnt, int [][] map, int Ry, int Rx, int By, int Bx) {
//		if(cnt==1) {
//			System.out.println(cnt+" "+Ry+" "+Rx);
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//		}
		if(cnt==10) return;
		cnt++;
		for(int i = 0; i < 4; i++) {
			int [][] cmap = new int [N][M];
			for(int z = 0; z < N; z++) {
				for(int x = 0; x < M; x++) {
					cmap[z][x] = map[z][x];
				}
			}
			int cRy = Ry;
			int cRx = Rx;
			int cBy = By;
			int cBx = Bx;
			if(i==0) {
				if(Rx>Bx) {
					cRx = move(i,Ry,Rx,cmap);
					cBx = move(i,By,Bx,cmap);
					if(cBx==-1) {
						continue;
					}
					else if(cRx==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
				else {
					cBx = move(i,By,Bx,cmap);
					cRx = move(i,Ry,Rx,cmap);
					if(cBx==-1) {
						continue;
					}
					else if(cRx==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
			}
			else if(i==1) {
				if(Ry>By) {
					cRy = move(i,Ry,Rx,cmap);
					cBy = move(i,By,Bx,cmap);
					if(cBy==-1) {
						continue;
					}
					else if(cRy==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
				else {
					cBy = move(i,By,Bx,cmap);
					cRy = move(i,Ry,Rx,cmap);
					if(cBy==-1) {
						continue;
					}
					else if(cRy==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
			}
			else if(i==2) {
				if(Rx<Bx) {
					cRx = move(i,Ry,Rx,cmap);
					cBx = move(i,By,Bx,cmap);
					if(cBx==-1) {
						continue;
					}
					else if(cRx==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
				else {
					cBx = move(i,By,Bx,cmap);
					cRx = move(i,Ry,Rx,cmap);
					if(cBx==-1) {
						continue;
					}
					else if(cRx==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
			}
			else {
				if(Ry<By) {
					cRy = move(i,Ry,Rx,cmap);
					cBy = move(i,By,Bx,cmap);
					if(cBy==-1) {
						continue;
					}
					else if(cRy==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
				else {
					cBy = move(i,By,Bx,cmap);
					cRy = move(i,Ry,Rx,cmap);
					if(cBy==-1) {
						continue;
					}
					else if(cRy==-1) {
						if(answer==-1||cnt<answer) answer = cnt;
						return;
					}
				}
			}
			if(!(Ry==cRy&&Rx==cRx&&By==cBy&&Bx==cBx))
				simulation(cnt,cmap,cRy,cRx,cBy,cBx);
		}
	}
	static int move(int d, int y, int x, int [][] map) {
		map[y][x] = 0;
		while(map[y][x]!=-1&&map[y][x]!=1) {
			y += dy[d];
			x += dx[d];
		}
		if(map[y][x]==1) {
			return -1;
		}
		else {
			if(d==0) {
				map[y][x-1] = -1;
				return x-1;
			}
			else if(d==1) {
				map[y-1][x] = -1;
				return y-1;
			}
			else if(d==2) {
				map[y][x+1] = -1;
				return x+1;
			}
			else {
				map[y+1][x] = -1;
				return y+1;
			}
		}
	}

}
