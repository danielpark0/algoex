package Dijkstra;

import java.util.*;

public class Main {
	
	static void Dijkstra(int N) {
		//N개의 점, 출발점1
		
		int INF = (int)1e10;
		
		int [][] path = new int [N+1][N+1]; //연결되있는 점들의 거리 
		
		int [] D = new int [N+1];
		
		for(int i = 1; i <= N; i++) {
			D[i] = INF;
		}
		
		PriorityQueue<Distance> pq = new PriorityQueue<>();
		
		pq.add(new Distance(1,0));
		
		while(!pq.isEmpty()) {
			Distance curr = pq.poll();
			if(D[curr.dest] < curr.dis) continue;
			D[curr.dest] = curr.dis;
			for(int i = 1; i <= N; i++) {
				if(path[curr.dest][i]<INF) {
					pq.add(new Distance(i,curr.dis+path[curr.dest][i]));
				}
			}
		}
		
	}

	public static void main(String[] args) {

		

	}

}

class Distance{
	int dest;
	int dis;
	public Distance(int dest, int dis) {
		super();
		this.dest = dest;
		this.dis = dis;
	}
	public int getDis() {
		return dis;
	}
}
