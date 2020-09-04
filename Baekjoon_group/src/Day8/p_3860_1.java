package Day8;

import java.util.*;
import java.io.*;

public class p_3860_1 {

	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};

	static int W, H, G, E;

	static int [][] map;

	static int INF = Integer.MAX_VALUE;

	static ArrayList<Edge> edges;
	
	static long [] D;

	public static void main(String [] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W==0&&H==0) {
				break;
			}

			map = new int [H][W];
			D = new long [H*W];

			for(int i = 0; i < H*W; i++) {
				D[i]= INF;
			}

			G = Integer.parseInt(br.readLine());

			for(int i = 0; i < G; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = -1;
			}

			E = Integer.parseInt(br.readLine());

			edges = new ArrayList<Edge>();

			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new Edge(x1,y1,x2,y2,t));
				map[y1][x1] = -2;
			}

			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j]>=0&&!(i==H-1&&j==W-1)) {
						for(int q = 0; q < 4; q++) {
							int ty = i + dy[q];
							int tx = j + dx[q];
							if(ty>=0&&ty<H&&tx>=0&&tx<W&&map[ty][tx]!=-1) {
								edges.add(new Edge(j,i,tx,ty,1));
							}
						}
					}
				}
			}
			
//			System.out.println(edges.toString());
			
//			for(int i = 0; i < H; i++) {
//				for(int j = 0; j < W; j++) {
//					System.out.print(cnt[i][j]+" ");
//				}
//				System.out.println();
//			}

			D[0] = 0;

			boolean check = false;
			
			for(int i = 0; i < W*H-G; i++) {
				check = false;
				for(int j = 0; j < edges.size(); j++) {
					Edge curr = edges.get(j);
					//if(D[curr.y1*W+curr.x1]==INF) continue;
					if(D[curr.y2*W+curr.x2]>D[curr.y1*W+curr.x1]+curr.t) {
						D[curr.y2*W+curr.x2] = D[curr.y1*W+curr.x1]+curr.t;
						check = true;
					}
				}
				if(!check) {
					break;
				}
			}

			if(check) {
				bw.write("Never");
			}
			else if(D[H*W-1]==INF) {
				bw.write("Impossible");
			}
			else {
				bw.write(Long.toString(D[H*W-1]));
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();		

	}

}

class Edge {
	int y1, x1, y2, x2, t;
	public Edge(int x1, int y1, int x2, int y2, int t) {
		this.y1 = y1;
		this.x1 = x1;
		this.y2 = y2;
		this.x2 = x2;
		this.t = t;
	}
	public String toString() {
		return y1+","+x1+" "+y2+","+x2+" "+t;
	}
}


