package p_3190;

import java.util.*;
import java.io.*;

public class p_3190 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int N, K, L;
	
	static int [][] map;
	
	static int answer;
	
	static int Y, X, D;
	
	static Queue<Pos> snake;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];

		answer = Y = X = D = 0;
		
		snake = new LinkedList<>();
		
		map[0][0] = -1;
		
		snake.add(new Pos(0,0));
		
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		Queue<Cd> queue = new LinkedList<>();
		
		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if(d=='L') {
				queue.add(new Cd(t,-1));
			}
			else {
				queue.add(new Cd(t,1));
			}
		}
		
		while(true) {
			answer++;
			Y += dy[D];
			X += dx[D];
			if(Y<0||Y>=N||X<0||X>=N||map[Y][X]==-1) {
				break;
			}
			
			if(map[Y][X]==1) {
				map[Y][X] = 0;
			}
			else {
				Pos tail = snake.poll();
				map[tail.y][tail.x] = 0;
			}
			
			map[Y][X] = -1;
			snake.add(new Pos(Y,X));
			if(!queue.isEmpty()&&queue.peek().time==answer) {
				D += queue.poll().dir;
				if(D==-1) D = 3;
				if(D==4) D = 0;
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
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

class Cd{
	int time;
	int dir;
	public Cd(int time, int dir) {
		this.time = time;
		this.dir = dir;
	}
}
