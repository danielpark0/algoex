package p_17472;

import java.util.*;
import java.io.*;

public class p_17472 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int N, M;
	static int [][] map;
	static int I;
	
	static int [][] D;
	
	static int [] P;
	
	static int answer;

	public static void main(String[] args) throws Exception {

		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		I = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t==1) {
					map[i][j] = -1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==-1) {
					I++;
					island(i,j);
				}
			}
		}
		
		D = new int [I+1][I+1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]>0) {
					for(int d = 0; d < 4; d++) {
						search(i,j,d,0,map[i][j]);
					}
				}
			}
		}
		
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= I; i++) {
			for(int j = i+1; j <= I; j++) {
				if(D[i][j]>0) {
					pq.add(new Bridge(i,j,D[i][j]));
				}
			}
		}
		
		P = new int [I+1];
		
		for(int i = 1; i <= I; i++) {
			P[i] = i;
		}
		
		while(!connected()) {
			if(pq.isEmpty()) {
				answer = -1;
				break;
			}
			Bridge curr = pq.poll();
			if(find(curr.a)!=find(curr.b)) {
				union(curr.a,curr.b);
				//System.out.println(curr);
				answer += curr.d;
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void island(int y, int x) {
		if(map[y][x]!=-1) {
			return;
		}
		map[y][x] = I;
		for(int i = 0; i < 4; i++) {
			int ty = y+dy[i];
			int tx = x+dx[i];
			if(ty>=0&&ty<N&&tx>=0&&tx<M&&map[ty][tx]==-1) {
				island(ty,tx);
			}
		}
	}
	
	static void search(int y, int x, int d, int sum, int n) {
		if(map[y][x]>0&&map[y][x]!=n) {
			int curr = map[y][x];
			if(sum-1>1&&(D[curr][n]==0||D[curr][n]>sum-1)) {
				D[curr][n] = sum-1;
				D[n][curr] = sum-1;
			}
			return;
		}
		int ty = y+dy[d];
		int tx = x+dx[d];
		if(ty>=0&&ty<N&&tx>=0&&tx<M&&map[ty][tx]!=n) {
			search(ty,tx,d,sum+1,n);
		}
		
	}
	
	static boolean connected() {
		int a = find(1);
		for(int i = 2; i <= I; i++) {
			if(find(i)!=a) {
				return false;
			}
		}
		return true;
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa<pb) {
			P[pb] = pa;
		}
		else {
			P[pa] = pb;
		}
	}
	
	static int find(int a) {
		if(P[a]==a) {
			return a;
		}
		return P[a] = find(P[a]);
	}

}

class Bridge implements Comparable<Bridge>{
	int a;
	int b;
	int d;
	public Bridge(int a, int b, int d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}
	@Override
	public int compareTo(Bridge o) {
		return this.d-o.d;
	}
	public String toString() {
		return a+" "+b+" "+d;
	}
}
