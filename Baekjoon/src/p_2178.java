import java.io.*;
import java.util.*;


class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class p_2178 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int N;
	static int M;
	
	static int [][] map;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j)-'0'==0) {
					map[i][j] = -1;
				}
			}
		}
		
		map[0][0] = 1;
		
		Queue<Pos> queue = new LinkedList<Pos>();
		
		queue.add(new Pos(0,0));
		
		while(!queue.isEmpty()) {
			Pos curr = queue.poll();
			for(int i = 0; i < 4; i++) {
				if(curr.y+dy[i]<0||curr.y+dy[i]>=N||curr.x+dx[i]<0||curr.x+dx[i]>=M||map[curr.y+dy[i]][curr.x+dx[i]]==-1) {
					
				}
				else if(map[curr.y+dy[i]][curr.x+dx[i]]==0||map[curr.y+dy[i]][curr.x+dx[i]]>map[curr.y][curr.x]+1) {
					map[curr.y+dy[i]][curr.x+dx[i]] = map[curr.y][curr.x]+1;
					queue.add(new Pos(curr.y+dy[i],curr.x+dx[i]));
				}
			}
		}
		
		System.out.println(map[N-1][M-1]);

	}

}
