package p_19235;

import java.util.*;
import java.io.*;

public class p_19235 {

	static int answer;

	static int count;

	public static void main(String[] args) throws Exception {

		answer = 0;

		count = 1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int [][] green = new int [6][4];
		int [][] blue = new int [6][4];

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			put(green,t,0,x);
			if(t==1) {
				put(blue,1,0,3-y);
			}
			else if(t==2) {
				put(blue,3,0,3-y);
			}
			else {
				put(blue,2,0,2-y);
			}
			while(checkFilled(green)) {
				removeFilled(green);
				moveDown(green);
			}
			while(checkFilled(blue)) {
				removeFilled(blue);
				moveDown(blue);
			}
			while(checkZone(blue)) {
				for(int j = 0; j < 4; j++) {
					blue[5][j] = 0;
				}
				moveDown(blue);
			}
			while(checkZone(green)) {
				for(int j = 0; j < 4; j++) {
					green[5][j] = 0;
				}
				moveDown(green);
			}
//			System.out.println(t+" "+y+" "+x);
//			for(int q = 0; q < 6; q++) {
//				for(int w = 0; w < 4; w++) {
//					System.out.print(green[q][w]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			for(int q = 0; q < 6; q++) {
//				for(int w = 0; w < 4; w++) {
//					System.out.print(blue[q][w]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int answer1 = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(green[i][j]>0) answer1++;
				if(blue[i][j]>0) answer1++;
			}
		}
		
		bw.write(Integer.toString(answer)+"\n");
		bw.write(Integer.toString(answer1));
		bw.flush();
		bw.close();

	}

	static void put(int [][] board, int n, int y, int x) {
		if(n==1) {
			while(y<6&&board[y][x]==0) {
				y++;
			}
			if(y==0) board[y][x] = count++;
			else board[--y][x] = count++;
		}
		else if(n==2) {
			while(y<6&&board[y][x]==0&&board[y][x+1]==0) {
				y++;
			}
			if(y==0) {
				board[y][x] = count;
				board[y][x+1] = count++;
			}
			else {
				board[--y][x] = count;
				board[y][x+1] = count++;
			}
		}
		else {
			while(y+1<6&&board[y+1][x]==0) {
				y++;
			}
			if(y==0) {
				board[y][x] = count;
				board[y][x] = count++;
			}
			else {
				board[y][x] = count;
				board[--y][x] = count++;
			}
		}
	}

	static boolean checkFilled(int [][] board) {
		for(int i = 2; i < 6; i++) {
			if(rowFilled(board,i)) return true;
		}
		return false;
	}

	static void removeFilled(int [][] board) {
		for(int i = 2; i < 6; i++) {
			if(rowFilled(board,i)) {
				for(int j = 0; j < 4; j++) {
					board[i][j] = 0;
				}
				answer++;
			}
		}
	}

	static boolean rowFilled(int [][] board, int n) {
		for(int i = 0; i < 4; i++) {
			if(board[n][i]==0) {
				return false;
			}
		}
		return true;
	}

	static void moveDown(int [][] board) {
		for(int i = 4; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j]!=0) {
					int t = board[i][j];
					if(j<3&&board[i][j]==board[i][j+1]) {
						board[i][j] = 0;
						board[i][j+1] = 0;
						int ti = i;
						while(ti<6&&board[ti][j]==0&&board[ti][j+1]==0) {
							ti++;
						}
						board[ti-1][j] = t;
						board[ti-1][j+1] = t;
						j++;
					}
					else {
						board[i][j] = 0;
						int ti = i;
						while(ti<6&&board[ti][j]==0) {
							ti++;
						}
						board[ti-1][j] = t;
					}
				}
			}
		}
	}

	static boolean rowEmpty(int [][] board, int n) {
		for(int i = 0; i < 4; i++) {
			if(board[n][i]!=0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean checkZone(int [][] board) {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j]!=0) {
					return true;
				}
			}
		}
		return false;
	}

}
