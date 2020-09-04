package Day8;

import java.util.*;
import java.io.*;

public class p_1915 {

	static int N;
	static int M;
	
	static int [][] map;
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					int t = square(i,j);
					if(answer < t*t) {
						//System.out.println(i+" "+j+" "+t);
						answer = t*t;
					}
					//j += t-1;
				}
			}
		}
		
		System.out.println(answer);

	}
	
	static int square(int y,int x) {
		boolean go = true;
		int n = 1;
		while(true) {
			go = check(y,x,n);
			if(!go) {
				n--;
				break;
			}
			n++;
		}
		return n;
	}
	
	static boolean check(int y,int x, int n) {
		x += n-1;
		if(x==M) {
			return false;
		}
		for(int i = 0; i < n; i++) {
			if(y+i==N) {
				return false;
			}
			if(map[y+i][x]==0) {
				return false;
			}
		}
		y += n-1;
		if(y==N) {
			return false;
		}
		for(int i = 0; i < n; i++) {
			if(map[y][x-i]==0) {
				return false;
			}
		}
		return true;
	}

}
