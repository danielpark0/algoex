import java.util.*;
import java.io.*;

public class p_1012 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int M;
	static int N;
	
	static boolean [][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			int K = Integer.parseInt(st.nextToken());
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = true;
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j]) {
						answer++;
						search(i,j);
					}
				}
			}
			bw.write(Integer.toString(answer)+"\n");
			bw.flush();
		}
		bw.close();
	}
	
	static void search(int y, int x) {
		if(y<0||y>=N||x<0||x>=M||!map[y][x]) {
			return;
		}
		map[y][x] = false;
		for(int i = 0; i < 4; i++) {
			search(y+dy[i],x+dx[i]);
		}
	}

}
