import java.util.*;

public class test9 {
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	static int answer;

	public static void main(String[] args) {
		
		answer = 0;

		int [][] map = {{2,1,0,0,0,0,1},
						{3,1,0,0,0,1,1},
						{2,3,0,0,0,0,2},
						{1,2,1,2,0,0,0},
						{2,3,2,0,0,1,1},
						{1,2,0,0,0,2,3},
						{2,2,0,0,0,0,1},
						{2,1,0,0,0,0,0}};
		
		calSize(map);
		
		System.out.println(answer);

	}
	
	static void calSize(int [][] map) {
		int [][] cmap = new int [map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j]>0) cmap[i][j] = -1;
			}
		}
		count(cmap);
	}
	
	static void count(int [][] cmap) {
		int n = 1;
		for(int i = 0; i < cmap.length; i++) {
			for(int j = 0; j < cmap[i].length; j++) {
				if(cmap[i][j]==-1) dfs(cmap,i,j,n++);
			}
		}
		int [] ns = new int [n];
		for(int i = 0; i < cmap.length; i++) {
			for(int j = 0; j < cmap[i].length; j++) {
				System.out.print(cmap[i][j]+" ");
				ns[cmap[i][j]]++;
			}
			System.out.println();
		}
		for(int i = 1; i < n; i++) {
			if(answer<ns[i]) answer = ns[i];
		}
	}
	
	static void dfs(int [][] cmap, int y, int x, int n) {
		cmap[y][x] = n;
		for(int i =0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty>=0&&ty<cmap.length&&tx>=0&&tx<cmap[0].length&&cmap[ty][tx]==-1) {
				dfs(cmap,ty,tx,n);
			}
		}
	}

}


