package Day7;

import java.util.*;
import java.io.*;

public class p_1735 {
	
	static int INF = Integer.MAX_VALUE;
	
	static int V, E, K;
	
	static ArrayList<Edge> [] edges;
	
	static int [] d;
	
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[V+1];
		
		d = new int [V+1];
		
		for(int i = 1; i <= V; i++) {
			d[i] = INF;
			edges[i] = new ArrayList<>();
		}
		
		d[K] = 0;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v,w));
		}
		
		pq = new PriorityQueue<Edge>(Comparator.comparingInt(Edge::getw));
		
		dijkstra(K);
		
		for(int i = 1; i <= V; i++) {
			if(d[i]==INF) {
				bw.write("INF\n");
			}
			else {
				bw.write(Integer.toString(d[i])+"\n");
			}
		}
		bw.flush();
		bw.close();

	}
	
	static void dijkstra(int start) {
		for(int i = 0; i < edges[start].size(); i++) {
			Edge t = edges[start].get(i);
			if(d[t.e]>t.w) {
				d[t.e] = t.w;
				pq.add(t);
			}
		}
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(d[curr.e]>=curr.w) {
				for(int i = 0; i < edges[curr.e].size(); i++) {
					Edge t = edges[curr.e].get(i);
					if(d[curr.e]+t.w < d[t.e]) {
						d[t.e] = d[curr.e]+t.w;
						pq.add(new Edge(t.e, d[t.e]));
					}
				}
			}
		}
	}

}

class Edge{
	int e;
	int w;
	public Edge (int e, int w) {
		this.e = e;
		this.w = w;
	}
	public String toString() {
		return e+" "+w;
	}
	public int getw() {
		return w;
	}
}
