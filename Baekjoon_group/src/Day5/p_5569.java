package Day5;

import java.util.*;
import java.io.*;

public class p_5569 {

	static int W, H;
	
	static int [][] map_w;
	static int [][] map_s;
	
	static boolean [][] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map_w = new int [W+1][H+1];
		map_s = new int [W+1][H+1];
		
		visited = new boolean[W+1][H+1];
		
		PriorityQueue<Pos> queue = new PriorityQueue<Pos>(Comparator.comparingInt(Pos::getSum));
		
		queue.add(new Pos(1,2));
		queue.add(new Pos(2,1));

		map_s[1][2] = 1;
		map_w[2][1] = 1;
		
		visited[W][H] = true;
		
		while(!queue.isEmpty()) {
			Pos curr = queue.poll();
			if(curr.w<W) {
				map_w[curr.w+1][curr.h] = (map_w[curr.w+1][curr.h] + map_w[curr.w][curr.h])%100000;
				if(!visited[curr.w+1][curr.h]) {
					queue.add(new Pos(curr.w+1,curr.h));
					visited[curr.w+1][curr.h] = true;
				}
			}
			if(curr.h+1<H) {
				map_s[curr.w][curr.h+2] = (map_s[curr.w][curr.h+2] + map_w[curr.w][curr.h])%100000;
				if(!visited[curr.w][curr.h+2]) {
					queue.add(new Pos(curr.w,curr.h+2));
					visited[curr.w][curr.h+2] = true;
				}
			}
			if(curr.h<H) {
				map_s[curr.w][curr.h+1] = (map_s[curr.w][curr.h+1] + map_s[curr.w][curr.h])%100000;
				if(!visited[curr.w][curr.h+1]) {
					queue.add(new Pos(curr.w,curr.h+1));
					visited[curr.w][curr.h+1] = true;
				}
			}
			if(curr.w+1<W) {
				map_w[curr.w+2][curr.h] = (map_w[curr.w+2][curr.h] + map_s[curr.w][curr.h])%100000;
				if(!visited[curr.w+2][curr.h]) {
					queue.add(new Pos(curr.w+2,curr.h));
					visited[curr.w+2][curr.h] = true;
				}
			}
		}
		
		map_s[W][H] = (map_s[W][H] + map_s[W-1][H])%100000;
		map_w[W][H] = (map_w[W][H] + map_w[W][H-1])%100000;
		
//		for(int i = H; i > 0; i--) {
//			for(int j = 1; j <= W; j++) {
//				System.out.print(map_s[j][i]+" ");
//			}
//			System.out.println();
//		}
//		
//		for(int i = H; i > 0; i--) {
//			for(int j = 1; j <= W; j++) {
//				System.out.print(map_w[j][i]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println((map_w[W][H]+map_s[W][H])%100000);

	}

}

class Pos{
	int w;
	int h;
	public Pos(int w, int h) {
		this.w = w;
		this.h = h;
	}
	public String toString() {
		return w +" "+ h;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int getSum() {
		return w+h;
	}
	
}
