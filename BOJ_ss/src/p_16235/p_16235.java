package p_16235;

import java.util.*;
import java.io.*;

public class p_16235 {
	
	static int [] dy = {0,1,1,1,0,-1,-1,-1};
	static int [] dx = {1,1,0,-1,-1,-1,0,1};
	
	static int N,M,K;
	static int [][] A;
	static int [][] left;
	static Deque<Integer> [][] trees;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int [N][N];
		left = new int [N][N];
		trees = new Deque[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				left[i][j] = 5;
				trees[i][j] = new LinkedList<>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees[x-1][y-1].add(z);
		}
		
		for(int k = 0; k < K; k++) {
			springNsummer();
			autumn();
			winter();
//			System.out.println();
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(trees[i][j].size()+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answer += trees[i][j].size();
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
	}
	
	static void springNsummer() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int n = trees[i][j].size();
				int dead = 0;
				for(int q = 0; q < n; q++) {
					if(trees[i][j].peek()<=left[i][j]) {
						left[i][j] -= trees[i][j].peek();
						trees[i][j].add(trees[i][j].poll()+1);
					}
					else {
						dead += trees[i][j].poll()/2;
					}
				}
				left[i][j] += dead;
			}
		}
	}
	
	static void autumn() {
		int [][] add = new int [N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int q = 0; q < trees[i][j].size(); q++) {
					if(trees[i][j].peek()%5==0) addTree(i,j,add);
					trees[i][j].add(trees[i][j].poll());
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < add[i][j]; k++) {
					trees[i][j].addFirst(1);
				}
			}
		}
	}
	
	static void addTree(int y, int x, int [][] add) {
		for(int i = 0; i < 8; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty>=0&&ty<N&&tx>=0&&tx<N) {
				add[ty][tx]++;
			}
		}
	}
	
	static void winter() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				left[i][j] += A[i][j];
			}
		}
	}

}
