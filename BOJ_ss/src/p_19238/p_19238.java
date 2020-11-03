package p_19238;

import java.util.*;
import java.io.*;

public class p_19238 {
	
	static int [] dy = {0, 1, 0, -1};
	static int [] dx = {1, 0, -1, 0};
	
	static int N, M, F;
	
	static int [][] map;
	
	static int Y, X;
	
	static int [][] target;
	
	static PriorityQueue<Pos> starts;
	static boolean [][] visited;
	static int [] D;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		map = new int [N+2][N+2];
		
		target = new int [M+1][2];
		
		D = new int [M+1];
		
		for(int i = 0; i <= N+1; i++) {
			for(int j = 0; j <= N+1; j++) {
				if(i==0||j==0||i==N+1||j==N+1) {
					map[i][j] = -1;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					map[i][j] = -1;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		
//		for(int i = 0; i <= N+1; i++) {
//			for(int j = 0; j <= N+1; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			map[sy][sx] = i;
			target[i][0] = Integer.parseInt(st.nextToken());
			target[i][1] = Integer.parseInt(st.nextToken());
		}
		
		while(M>0) {
			starts = new PriorityQueue<Pos>();
			visited = new boolean [N+2][N+2];
			visited[Y][X] = true;
			findStart(Y,X,0);
			if(starts.isEmpty()) break;
			Pos sp = starts.poll();
			F -= sp.d;
			if(F<=0) break;
			int id = map[sp.y][sp.x];
			map[sp.y][sp.x] = 0;
			visited = new boolean [N+2][N+2];
			visited[sp.y][sp.x] = true;
			drive(sp.y,sp.x,0,id);
			if(D[id]==0) break;
			F -= D[id];
			if(F<0) break;
			F += D[id]*2;
			Y = target[id][0];
			X = target[id][1];
			M--;
		}
		
		if(M>0) {
			bw.write("-1");
		}
		else {
			bw.write(Integer.toString(F));
		}
		bw.flush();
		bw.close();

	}
	
	static void findStart(int y, int x, int d) {
		Queue<Pos> queue = new LinkedList<Pos>();
		if(map[y][x]>0) {
			starts.add(new Pos(y,x,d));
		}
		queue.add(new Pos(y,x,d));
		while(!queue.isEmpty()) {
			Pos curr = queue.poll();
			for(int i = 0; i < 4; i++) {
				int ty = curr.y+dy[i];
				int tx = curr.x+dx[i];
				if(!visited[ty][tx]&&map[ty][tx]>=0) {
					visited[ty][tx] = true;
					if(map[ty][tx]>0) {
						starts.add(new Pos(ty,tx,curr.d+1));
					}
					queue.add(new Pos(ty,tx,curr.d+1));
				}
			}
		}
	}
	
	static void drive(int y, int x, int d, int id) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(y,x,d));
		while(!queue.isEmpty()) {
			Pos curr = queue.poll();
			if(curr.y==target[id][0]&&curr.x==target[id][1]) {
				D[id] = curr.d;
				break;
			}
			for(int i = 0; i < 4; i++) {
				int ty = curr.y+dy[i];
				int tx = curr.x+dx[i];
				if(!visited[ty][tx]&&map[ty][tx]>=0) {
					visited[ty][tx] = true;
					queue.add(new Pos(ty,tx,curr.d+1));
				}
			}
		}
	}

}

class Pos implements Comparable<Pos> {
	int y;
	int x;
	int d;
	public Pos(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
	@Override
	public int compareTo(Pos o) {
		if(o.d > this.d) {
			return -1;
		}
		else if(o.d < this.d) {
			return 1;
		}
		else {
			if(o.y > this.y) {
				return -1;
			}
			else if(o.y < this.y) {
				return 1;
			}
			else {
				if(o.x > this.x) {
					return -1;
				}
				else if(o.x < this.x) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
	}
	public String toString() {
		return y+" "+x+" "+d;
	}
}
