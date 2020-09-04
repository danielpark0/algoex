import java.util.*;
import java.io.*;

public class p_1865 {

	static int TC;

	static int N, M, W;

	static int [] D;

	static int INF = Integer.MAX_VALUE;

	static ArrayList<Edge2> edges;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			D = new int [N+1]; 
			
			edges = new ArrayList<>();

			for(int i = 2; i <= N; i++) {
				D[i] = INF;
			}
			D[1] = 0;

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new Edge2(s,e,t));
				edges.add(new Edge2(e,s,t));
			}

			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new Edge2(s,e,t*-1));
			}

			for(int i = 0; i < N-1; i++) {
				for(int j = 0; j < edges.size(); j++) {
					Edge2 curr = edges.get(j);
					if(D[curr.s]==INF) continue;
					if(D[curr.s]+curr.t<D[curr.e]) {
						D[curr.e] = D[curr.s] + curr.t;
					}
				}
			}
			boolean bool = false;
			for(int j = 0; j < edges.size(); j++) {
				Edge2 curr = edges.get(j);
				//if(D[curr.s]==INF) continue;
				if(D[curr.s]+curr.t<D[curr.e]) {
					D[curr.e] = D[curr.s] + curr.t;
					bool = true;
				}
			}
			
			if(bool) {
				bw.write("YES\n");
			}
			else {
				bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();

	}

}

class Edge2{
	int s;
	int e;
	int t;
	public Edge2(int s, int e, int t) {
		super();
		this.s = s;
		this.e = e;
		this.t = t;
	}
}
