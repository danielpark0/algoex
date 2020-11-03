package p_17142;

import java.util.*;
import java.io.*;

public class p_17142 {
	
	static int answer;
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};

	static int N;
	static int M;
	
	static boolean [][] virus;
	
	public static void main(String[] args) throws Exception {
		
		answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int [N][N];
		virus = new boolean[N][N];
		
		ArrayList<Pos> pos = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t==2) {
					pos.add(new Pos(i,j));
					virus[i][j] = true;
				}
				else if(t==1) {
					map[i][j] = -1;
				}
			}
		}
		
		Pos [] sp = new Pos[M];
		
		findPlace(map,pos,0,sp,0);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void findPlace(int [][] map, ArrayList<Pos> pos, int n, Pos[] sp, int ind) {
		if(ind==M) {
			int [][] cmap = new int [N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cmap[i][j] = map[i][j];
				}
			}
			Queue<Pos> queue = new LinkedList<>();
			for(int i = 0; i < M; i++) {
				cmap[sp[i].y][sp[i].x] = -2;
				queue.add(new Pos(sp[i].y,sp[i].x));
			}
			bfs(cmap,queue);
			int tanswer = 0;
			int max = allClear(cmap);
			if(max==0) {
				tanswer = -1;
			}
			else if(max==-2){
				tanswer = 0;
			}
			else {
				tanswer = max;
			}
			if(answer==-1||(tanswer!=-1&&tanswer<answer)) {
				answer = tanswer;
			}
		}
		else if(n==pos.size()) {
			return;
		}
		else {
			sp[ind] = pos.get(n);
			findPlace(map,pos,n+1,sp,ind+1);
			findPlace(map,pos,n+1,sp,ind);
		}
	}
	
	static void bfs(int [][] map, Queue<Pos> queue) {
		while(!queue.isEmpty()) {
			Pos curr = queue.poll();
			int n = map[curr.y][curr.x];
			if(n==-2) n = 0;
			for(int i = 0; i < 4; i++) {
				int ty = curr.y+dy[i];
				int tx = curr.x+dx[i];
				if(ty>=0&&ty<N&&tx>=0&&tx<N&&map[ty][tx]==0) {
					queue.add(new Pos(ty,tx));
					map[ty][tx] = n+1;
				}
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	
	static int allClear(int [][] map) {
		int max = -2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) return 0;
				if(map[i][j]!=-1&&map[i][j]>max&&!virus[i][j]) max = map[i][j];
			}
		}
		return max;
	}

}

class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
	public String toString() {
		return "[ "+y+", "+x+" ]";
	}
}
