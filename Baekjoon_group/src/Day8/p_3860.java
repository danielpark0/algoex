package Day8;

import java.util.*;
import java.io.*;

public class p_3860 {

	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};

	static int max_i = (int)1e9;

	static int W, H;
	static int G;
	static int E;
	static int [][] map; // -1 묘비, 0 잔디, 1 귀신구멍 입구, 2 귀신구멍 출구

	static ArrayList<Pos> nodes; //각 노드 위치
	static ArrayList<Line> lines; //a->b 걸리는 시

	static int [][] start;
	static boolean [][] start_v;

	static int [][] end;
	static boolean [][] end_v;

	static int [] d;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if(W==0&&H==0) {
				break;
			}

			map = new int [H][W];

			G = Integer.parseInt(br.readLine());

			for(int i  = 0; i < G; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = -1;
			}

			E = Integer.parseInt(br.readLine());

			nodes = new ArrayList<>();

			nodes.add(new Pos(0,0));

			lines = new ArrayList<>();

			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				map[y1][x1] = 1;
				map[y2][x2] = 2;
				nodes.add(new Pos(y1,x1));
				nodes.add(new Pos(y2,x2));
				lines.add(new Line(nodes.size()-2,nodes.size()-1,t));
			}

			nodes.add(new Pos(H-1,W-1));

			Queue<Pos> queue = new LinkedList<>();

			queue.add(new Pos(0,0,0));

			start = new int [H][W];

			start_v = new boolean[H][W];

			while(!queue.isEmpty()) {
				Pos curr = queue.poll();
				start[curr.y][curr.x] = curr.d;
				start_v[curr.y][curr.x] = true;
				if(map[curr.y][curr.x]==-1||map[curr.y][curr.x]==1) {

				}
				else {
					for(int i = 0; i < 4; i++) {
						int ty = curr.y+dy[i];
						int tx = curr.x+dx[i];
						if(ty>=0&&ty<H&&tx>=0&&tx<W&&!start_v[ty][tx]) {
							queue.add(new Pos(ty,tx,curr.d+1));
						}
					}
				}

			}

			for(int i = 1; i < 1+2*E; i+=2) {
				if(start[nodes.get(i).y][nodes.get(i).x]==0) {
					lines.add(new Line(0,i,max_i));
				}
				else {
					lines.add(new Line(0,i,start[nodes.get(i).y][nodes.get(i).x]));
				}
			}

			end = new int [H][W];

			end_v = new boolean[H][W];

			queue.add(new Pos(H-1,W-1,0));

			while(!queue.isEmpty()) {
				Pos curr = queue.poll();
				end[curr.y][curr.x] = curr.d;
				end_v[curr.y][curr.x] = true;
				if(map[curr.y][curr.x]==-1||map[curr.y][curr.x]==1) {

				}
				else {
					for(int i = 0; i < 4; i++) {
						int ty = curr.y+dy[i];
						int tx = curr.x+dx[i];
						if(ty>=0&&ty<H&&tx>=0&&tx<W&&!end_v[ty][tx]) {
							queue.add(new Pos(ty,tx,curr.d+1));
						}
					}
				}

			}

			for(int i = 2; i < 2+2*E; i+=2) {
				if(end[nodes.get(i).y][nodes.get(i).x]==0) {
					lines.add(new Line(i,2*E+1,max_i));
				}
				else {
					lines.add(new Line(i,2*E+1,end[nodes.get(i).y][nodes.get(i).x]));
					lines.add(new Line(i,0,start[nodes.get(i).y][nodes.get(i).x]));
				}
			}
			if(start[H-1][W-1]!=0) {
				lines.add(new Line(0,2*E+1,start[H-1][W-1]));
			}
			else {
				lines.add(new Line(0,2*E+1,max_i));
			}
			
			
			for(int i = 1; i <= E; i++) {
				int [][] tmap = new int [H][W];
				boolean [][] tvisit = new boolean [H][W];

				for(int j = 0; j < 4; j++) {
					int ty = nodes.get(i).y+dy[j];
					int tx = nodes.get(i).x+dx[j];
					if(ty>=0&&ty<H&&tx>=0&&tx<W&&!tvisit[ty][tx]) {
						queue.add(new Pos(ty,tx,1));
					}
				}
				
				while(!queue.isEmpty()) {
					Pos curr = queue.poll();
					tmap[curr.y][curr.x] = curr.d;
					tvisit[curr.y][curr.x] = true;
					if(map[curr.y][curr.x]==-1||map[curr.y][curr.x]==1) {

					}
					else {
						for(int j = 0; j < 4; j++) {
							int ty = curr.y+dy[j];
							int tx = curr.x+dx[j];
							if(ty>=0&&ty<H&&tx>=0&&tx<W&&!tvisit[ty][tx]) {
								queue.add(new Pos(ty,tx,curr.d+1));
							}
						}
					}
				}
				
//				for(int [] e: tmap)
//					System.out.println(Arrays.toString(e));
//				
//				System.out.println(nodes.toString());
				
				for(int j = 1; j <=E; j++) {
//					System.out.println("aa "+nodes.get(j*2-1));
					if(tmap[nodes.get(j*2-1).y][nodes.get(j*2-1).x]==0) {
						lines.add(new Line(j*2,i*2-1,max_i));
					}
					else {
						lines.add(new Line(j*2,i*2-1,tmap[nodes.get(j*2-1).y][nodes.get(j*2-1).x]));
					}
				}
			}
			

			d = new int [2*E+2];

			for(int i = 1; i < d.length; i++) {
				d[i] = max_i;
			}

			for(int i = 0; i < 3*E+1+E*E; i++) {
				for(Line e:lines) {
					int a = e.a;
					int b = e.b;
					int t = e.t;
					if(d[a]+t < d[b]) {
						d[b] = d[a]+t;
					}
				}
			}
			boolean flag = false;
			for(Line e:lines) {
				int a = e.a;
				int b = e.b;
				int t = e.t;
				if(d[a]+t < d[b]) {
					d[b] = d[a]+t;
					flag = true;
				}
			}


//			for(Line e : lines) {
//				System.out.println("    "+e);
//			}


			if(flag) {
				System.out.println("Never");
			}
			else {
				if(d[2*E+1]!=max_i) {
					System.out.println(d[2*E+1]);
				}
				else {
					System.out.println("Impossible");
				}
			}

		}


	}

}

class Pos{
	int y;
	int x;
	int d;
	public Pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
		d = -1;
	}
	public Pos(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
	public String toString() {
		return y+" "+x+" "+d;
	}
}

class Line{
	int a;
	int b;
	int t;
	public Line(int a, int b, int t) {
		super();
		this.a = a;
		this.b = b;
		this.t = t;
	}
	public String toString() {
		return a +" "+b+" "+t;
	}
}
