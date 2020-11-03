package p_19236;

import java.util.*;
import java.io.*;

public class p_19236 {
	
	static int [] dy = {0,-1,-1,0,1,1,1,0,-1};
	static int [] dx = {0,0,-1,-1,-1,0,1,1,1};
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Fish [][] map = new Fish [4][4];
		
		Pos [] pos = new Pos[17];
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[i][j] = new Fish(n,d);
				pos[n] = new Pos(i,j);
			}
		}
		
		Fish start = map[0][0];
		
		map[0][0] = null;
		pos[start.n] = null;
		
		move(map,0,0,start.d,pos,start.n);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void move (Fish [][] map, int sy, int sx, int sd, Pos[] pos, int sum) {
		for(int i = 1; i <= 16; i++) {
			if(pos[i]!=null) {
				int y = pos[i].y;
				int x = pos[i].x;
				int n = map[y][x].n;
				int d = map[y][x].d;
				int dir = 0;
				for(int j = d; j <= d+8; j++) {
					int td = j;
					if(td>8) td -= 8;
					if(check(map,y,x,td,sy,sx)) {
						dir = td;
						break;
					}
				}
				if(dir>0) {
					int ty = y+dy[dir];
					int tx = x+dx[dir];
					if(map[ty][tx]!=null) {
						int tn = map[ty][tx].n;
						int td = map[ty][tx].d;
						
						map[ty][tx] = new Fish(n,dir);
						map[y][x] = new Fish(tn,td);
						pos[n] = new Pos(ty,tx);
						pos[tn] = new Pos(y,x);
					}
					else {
						map[ty][tx] = new Fish(n,dir);
						map[y][x] = null;
						pos[n] = new Pos(ty,tx);
					}
				}
			}
		}
		boolean go = false;
		int tsy = sy+dy[sd];
		int tsx = sx+dx[sd];
		while(tsy>=0&&tsy<4&&tsx>=0&&tsx<4) {
			if(map[tsy][tsx]!=null) {
				go = true;
				Fish [][] cmap = new Fish [4][4];
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 4; j++) {
						if(map[i][j]!=null)
							cmap[i][j] = new Fish(map[i][j].n,map[i][j].d);
					}
				}
				int tn = map[tsy][tsx].n;
				int td = map[tsy][tsx].d;
				Pos [] cpos = new Pos[17];
				for(int i = 1; i <= 16; i++) {
					if(pos[i]!=null) {
						cpos[i] = new Pos(pos[i].y,pos[i].x);
					}
				}
				cpos[tn] = null;
				cmap[tsy][tsx] = null;
				move(cmap,tsy,tsx,td,cpos,sum+tn);
			}
			tsy += dy[sd];
			tsx += dx[sd];
		}
		if(!go) {
			if(answer<sum) answer = sum;
		}
	} 
	
	static boolean check(Fish[][] map, int y, int x, int d, int sy, int sx) {
		int ty = y+dy[d];
		int tx = x+dx[d];
		if(ty<0||ty>=4||tx<0||tx>=4||(ty==sy&&tx==sx)) {
			return false;
		}
		return true;
	}

}

class Fish {
	int n;
	int d;
	public Fish(int n, int d) {
		this.n = n;
		this.d = d;
	}
}

class Pos {
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}


