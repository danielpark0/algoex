package p_19237;

import java.io.*;
import java.util.*;

public class p_19237 {
	
	static int answer;
	
	static int [] dy = {0,-1,1,0,0};
	static int [] dx = {0,0,0,-1,1};
	
	static int N,M,K;
	
	static Smell [][] left;
	
	static int [][][] D;
	
	static int [][] pos;
	
	static int [] dir;
	static int [] next;
	
	static Set<Integer> sharks;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sharks = new HashSet<Integer>();
		
		for(int i = 1; i <= M; i++) {
			sharks.add(i);
		}
		
		left = new Smell[N+2][N+2];
		
		D = new int [M+1][5][5];
		
		pos = new int [M+1][2];
		
		dir = new int [M+1];
		next = new int [M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n != 0) {
					left[i][j] = new Smell(n,K);
					pos[n][0] = i;
					pos[n][1] = j;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= M; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= M; i++) {
			for(int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 1; k <= 4; k++) {
					D[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		while(sharks.size()>1&&answer<=10000) {
			finddir();
			decrease();
			move();
			answer++;
		}
		
		if(answer<=1000)
			bw.write(Integer.toString(answer));
		else 
			bw.write("-1");
		bw.flush();
		bw.close();
	}
	
	static void finddir() {
		
		for(int e: sharks) {
			int i = pos[e][0];
			int j = pos[e][1];
			
			int nd = -1;
			for(int k = 1; k <= 4; k++) {
				int ty = i + dy[D[e][dir[e]][k]];
				int tx = j + dx[D[e][dir[e]][k]];
				if(ty>=1&&ty<=N&&tx>=1&&tx<=N&&left[ty][tx]==null) {
					nd = D[e][dir[e]][k];
					break;
				}
			}
			if(nd==-1) {
				for(int k = 1; k <= 4; k++) {
					int ty = i + dy[D[e][dir[e]][k]];
					int tx = j + dx[D[e][dir[e]][k]];
					if(ty>=1&&ty<=N&&tx>=1&&tx<=N&&left[ty][tx].id==left[i][j].id) {
						nd = D[e][dir[e]][k];
						break;
					}
				}
			}
			next[e] = nd;
			
		}
		
	}
	
	static void decrease() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				Smell curr = left[i][j];
				if(curr != null) {
					if(curr.time==1) {
						left[i][j] = null;
					}
					else {
						left[i][j] = new Smell(curr.id,curr.time-1);
					}
				}
			}
		}
	}
	
	static void move() {
		Queue<Integer> out = new LinkedList<Integer>();
		for(int e : sharks) {
			int ty = pos[e][0] + dy[next[e]];
			int tx = pos[e][1] + dx[next[e]];
			if(left[ty][tx]==null||left[ty][tx].id==e) {
				left[ty][tx] = new Smell(e,K);
				pos[e][0] = ty;
				pos[e][1] = tx;
				dir[e] = next[e];
			}
			else if(left[ty][tx].id>e) {
				out.add(left[ty][tx].id);
				left[ty][tx] = new Smell(e,K);
				pos[e][0] = ty;
				pos[e][1] = tx;
				dir[e] = next[e];
			}
			else if(left[ty][tx].id<e) {
				out.add(e);
			}
		}
		while(!out.isEmpty()) {
			sharks.remove(out.poll());
		}
	}

}

class Smell{
	int id;
	int time;
	public Smell(int id, int time) {
		this.id = id;
		this.time = time;
	}
}
