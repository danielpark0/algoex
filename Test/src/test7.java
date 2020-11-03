import java.util.*;
import java.io.*;

public class test7 {

	static int [] dy = {1,-1,0,0};
	static int [] dx = {0,0,1,-1};

	static int N,M,T;

	static ArrayList<Integer> [] board;

	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new ArrayList[N+1];

		for(int i = 1; i <= N; i++) {
			board[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i].add(Integer.parseInt(st.nextToken()));
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
							if(board[j].get(q)!=-1) {
								sum += board[j].get(q);
								c++;
							}
						}
					}

					float avg = (float) sum / c;

					//System.out.println(avg +" "+sum+" "+c);

					for(int j = 1; j <= N; j++) {
						for(int q = 0; q < M; q++) {
							if(board[j].get(q)==-1) continue;
							if(board[j].get(q)>avg) {
								board[j].add(q,board[j].remove(q)-1);
							}
							else if(board[j].get(q)<avg) {
								board[j].add(q,board[j].remove(q)+1);
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
				if(board[i].get(j)>0)
					answer += board[i].get(j);
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
                for(int j = 0; j < M; j++){
                    deque.add(board[i].get(j));
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
                ArrayList<Integer> list = new ArrayList<>();
                while(!deque.isEmpty()){
                    list.add(deque.remove());
                }
                board[i] = list;
			}
		}
	}
	
	static boolean is() {
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i].get(j)!=-1) {
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
				if(board[i].get(j)!=-1)
					for(int q = 0; q < 4; q++) {
						int ty = i+dy[q];
						int tx = j+dx[q];
						if(ty<1||ty>N) {
							continue;
						}
						if(tx<0) tx = M-1;
						if(tx>=M) tx = 0;
						if(board[i].get(j)==board[ty].get(tx)) {
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
					board[i].remove(j);
					board[i].add(j,-1);
				}
			}
		}

		return r;
	}

}

