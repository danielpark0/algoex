package p_17822;

import java.util.*;
import java.io.*;

public class p_17822_1 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};

	static int N, M, T;

	static int [][] board;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new int [N+1][M];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotate(x,d,k);
			if(checkBoard()) {
				boolean erased = erase();
				if(!erased) avg();
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1) answer += board[i][j];
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	static void rotate(int x, int d, int k) {
		for(int i = 1; i <= N; i++) {
			if(i%x==0) {
				Deque<Integer> deque = new LinkedList<>();
				for(int j = 0; j < M; j++) {
					deque.add(board[i][j]);
				}
				if(d==0) {
					for(int j = 0; j < k; j++) {
						deque.addFirst(deque.pollLast());
					}
				}
				else {
					for(int j = 0; j < k; j++) {
						deque.addLast(deque.pollFirst());
					}
				}
				for(int j = 0; j < M; j++) {
					board[i][j] = deque.poll();
				}
			}
		}
	}
	
	static boolean checkBoard() {
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1) return true;
			}
		}
		return false;
	}
	
	static boolean erase() {
		boolean erased = false;
		boolean [][] check = new boolean [N+1][M];
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1) {
					for(int q = 0; q < 4; q++) {
						int ty = i+dy[q];
						int tx = j+dx[q];
						if(ty<1||ty>N) continue;
						if(tx<0) tx = M-1;
						if(tx>=M) tx = 0;
						if(board[i][j]==board[ty][tx]) {
							check[i][j] = true;
							check[ty][tx] = true;
							erased = true;
						}
					}
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(check[i][j]) {
					board[i][j] = -1;
				}
			}
		}
		return erased;
	}
	
	static void avg() {
		int cnt=0;
		int sum=0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1) {
					cnt++;
					sum += board[i][j];
				}
			}
		}
		float n = (float)sum/cnt;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1) {
					if(board[i][j]>n) {
						board[i][j]--;
					}
					else if(board[i][j]<n) {
						board[i][j]++;
					}
				}
			}
		}
	}

}
