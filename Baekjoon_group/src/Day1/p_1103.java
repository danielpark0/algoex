package Day1;

import java.util.*;
import java.io.*;

public class p_1103 {
	
	static int N, M;
	
	static int [][] map;
	
	static boolean infi;
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int answer;
	
	static int [][] max;

	public static void main(String[] args) throws Exception {
		
		answer = -1;
		
		infi = false;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		max = new int [N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j)=='H') {
					map[i][j] = -1;
				}
				else {
					map[i][j] = s.charAt(j)-'0';
				}
			}
		}
		
		boolean [][] visited = new boolean [N][M];
		
		dfs(visited,0,0,0);
		
		if(infi) {
			bw.write("-1");
		}
		else {
			bw.write(Integer.toString(answer));
		}
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(boolean [][] visited, int y, int x, int cnt) {
		if(infi) {
			
		}
		else {
			if(y<0||y>=N||x<0||x>=M||map[y][x]==-1) {
				answer = Math.max(answer, cnt);
			}
			else if(max[y][x]!=0&&max[y][x]>=cnt) {
				
			}
			else if(visited[y][x]) {
				infi = true;
			}
			else {
				max[y][x] = cnt;
				visited[y][x] = true;
				for(int i = 0; i < 4; i++) {
					if(!infi)
						dfs(visited,y+dy[i]*map[y][x],x+dx[i]*map[y][x],cnt+1);
				}
				visited[y][x] = false;
			}
		}
	}

}
