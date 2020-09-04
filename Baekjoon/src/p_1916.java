import java.util.*;
import java.io.*;

public class p_1916 {
	
	static int N, M;
	
	static ArrayList<Edge> [] edges;
	
	static int d[];
	
	static int INF = Integer.MAX_VALUE;
	
	static int start, end;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[N+1];
		
		d = new int [N+1];
		
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
			d[i] = INF;
		}
		
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[a].add(new Edge(a,b,w));
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		d[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
		
		for(int i = 0; i < edges[start].size(); i++) {
			pq.add(edges[start].get(i));
		}
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(d[curr.s]+curr.w<d[curr.e]) {
				d[curr.e] = d[curr.s]+curr.w;
				for(int i = 0; i < edges[curr.e].size(); i++) {
					pq.add(edges[curr.e].get(i));
				}
			}
		}
		
		bw.write(Integer.toString(d[end]));
		bw.flush();
		bw.close();

	}

}

class Edge{
	int s;
	int e;
	int w;
	public int getW() {
		return w;
	}
	public Edge(int s, int e, int w) {
		super();
		this.s = s;
		this.e = e;
		this.w = w;
	}
}
