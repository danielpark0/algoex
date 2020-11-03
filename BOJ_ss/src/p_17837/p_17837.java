package p_17837;

import java.util.*;
import java.io.*;

public class p_17837 {

	static int [] dy = {0,0,0,-1,1};
	static int [] dx = {0,1,-1,0,0};

	static int N, K;

	static int [][] board;
	static int [][] pos;

	static Stack<Integer> [][] nums;

	static boolean go;

	static int answer;

	public static void main(String[] args) throws Exception {

		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int [N][N];
		pos = new int [K+1][3];

		nums = new Stack [N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				nums[i][j] = new Stack<Integer>();
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			pos[i][0] = y;
			pos[i][1] = x;
			pos[i][2] = d;
			nums[y][x].push(i);
		}
		
		go = true;

		while(go) {
			answer++;
			if(answer>1000) {
				answer = -1;
				break;
			}
			for(int i = 1; i <= K&&go; i++) {
				move(i);
			}
			
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	static void move(int n) {
		int y = pos[n][0];
		int x = pos[n][1];
		int d = pos[n][2];
		int ty = y + dy[d];
		int tx = x + dx[d];
		if(ty<0||ty>=N||tx<0||tx>=N||board[ty][tx]==2) {
			d = rdir(d);
			int by = y+dy[d];
			int bx = x+dx[d];
			pos[n][2] = d;
			if(by<0||by>=N||bx<0||bx>=N||board[by][bx]==2) {
				
			}
			else if(board[by][bx]==1) {
				mtoRed(n);
			}
			else {
				mtoWhite(n);
			}
		}
		else if(board[ty][tx]==1) {
			mtoRed(n);
		}
		else {
			mtoWhite(n);
		}
	}

	static int rdir(int n) {
		if(n==1) return 2;
		else if(n==2) return 1;
		else if(n==3) return 4;
		else return 3;
	}

	static void mtoWhite(int n) {
		int y = pos[n][0];
		int x = pos[n][1];
		int d = pos[n][2];
		int ty = y+dy[d];
		int tx = x+dx[d];
		Stack<Integer> stack = new Stack<Integer>();
		int t = 0;
		while(t!=n) {
			t = nums[y][x].pop();
			stack.push(t);
		}
		while(!stack.isEmpty()) {
			t = stack.pop();
			pos[t][0] = ty;
			pos[t][1] = tx;
			nums[ty][tx].push(t);
		}
		if(nums[ty][tx].size()>=4)	go = false;
	}

	static void mtoRed(int n) {
		int y = pos[n][0];
		int x = pos[n][1];
		int d = pos[n][2];
		int ty = y+dy[d];
		int tx = x+dx[d];
		Queue<Integer> queue = new LinkedList<Integer>();
		int t = 0;
		while(t!=n) {
			t = nums[y][x].pop();
			queue.add(t);
		}
		while(!queue.isEmpty()) {
			t = queue.poll();
			pos[t][0] = ty;
			pos[t][1] = tx;
			nums[ty][tx].push(t);
		}
		if(nums[ty][tx].size()>=4)	go = false;
	}



}