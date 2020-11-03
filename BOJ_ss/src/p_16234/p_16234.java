package p_16234;

import java.util.*;
import java.io.*;

public class p_16234 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int N, L, R;
	static int [][] A;
	
	static boolean go;
	
	static boolean [][] visited;
	static Queue<Pos> queue;
	static int sum;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go = true;
		
		while(go) {
			go = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						queue = new LinkedList<Pos>();
						sum = 0;
						union(i,j);
						if(queue.size()>1) {
							go = true;
							int avg = sum/queue.size();
							while(!queue.isEmpty()) {
								Pos curr = queue.poll();
								A[curr.y][curr.x] = avg;
							}
						}
					}
				}
			}
			if(go) answer++;
		}
		
		bw.write(Integer.toString(answer));;
		bw.flush();
		bw.close();

	}
	
	static void union(int y, int x) {
		visited[y][x] = true;
		sum += A[y][x];
		queue.add(new Pos(y,x));
		for(int i = 0; i < 4; i++) {
			int ty = y+dy[i];
			int tx = x+dx[i];
			if(ty>=0&&ty<N&&tx>=0&&tx<N&&!visited[ty][tx]&&Math.abs(A[y][x]-A[ty][tx])>=L&&Math.abs(A[y][x]-A[ty][tx])<=R) {
				union(ty,tx);
			}
		}
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
