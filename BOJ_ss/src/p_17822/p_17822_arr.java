package p_17822;

import java.util.*;
import java.io.*;

public class p_17822_arr {

	static int [] dy = {1,-1,0,0};
	static int [] dx = {0,0,1,-1};

	static int N,M,T;

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

		board = new int[N+1][M];

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
			//			System.out.println();
			//			for(int j = 1; j <= N; j++) {
			//				System.out.println(board[j].toString());
			//			}
			//			System.out.println();
			if(is()) {
				if(!check()) {
					int sum=0;
					int c=0;
					for(int j = 1; j <= N; j++) {
						for(int q = 0; q < M; q++) {
							if(board[j][q]!=-1) {
								sum += board[j][q];
								c++;
							}
						}
					}

					float avg = (float) sum / c;

					//System.out.println(avg +" "+sum+" "+c);

					for(int j = 1; j <= N; j++) {
						for(int q = 0; q < M; q++) {
							if(board[j][q]==-1) continue;
							if(board[j][q]>avg) {
								board[j][q]--;
							}
							else if(board[j][q]<avg) {
								board[j][q]++;
							}
						}
					}
				}
			}

			//			1 1 2 3
			//			2 5 2 4
			//			3 1 3 5
			//			2 2 1 3

			//			System.out.println();
			//			for(int j = 1; j <= N; j++) {
			//				System.out.println(board[j].toString());
			//			}
			//			System.out.println();

		}

		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]>0)
					answer += board[i][j];
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	static void rotate(int x, int d, int k) {
		for(int i = 1; i <= N; i++) {
			if(i%x==0) {
				//				System.out.println(i);
				Deque<Integer> deque = new LinkedList<>();
				for(int j = 0; j < M; j++) {
					deque.add(board[i][j]);
				}
				if(d==0) {
					for(int j = 0; j < k; j++) {
						deque.addFirst(deque.removeLast());
					}
				}
				else {
					for(int j = 0; j < k; j++) {
						deque.add(deque.remove());
					}
				}
				for(int j = 0; j < M; j++) {
					board[i][j] = deque.poll();
				}
			}
		}
	}
	
	static boolean is() {
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean check(){

		boolean r = false;

		boolean [][] map = new boolean [N+1][M];

		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j]!=-1)
					for(int q = 0; q < 4; q++) {
						int ty = i+dy[q];
						int tx = j+dx[q];
						if(ty<1||ty>N) {
							continue;
						}
						if(tx<0) tx = M-1;
						if(tx>=M) tx = 0;
						if(board[i][j]==board[ty][tx]) {
							map[ty][tx] = true;
							map[i][j] = true;
							r = true;
						}
					}
			}
		}

		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]) {
					board[i][j]=-1;
				}
			}
		}

		return r;
	}

}
