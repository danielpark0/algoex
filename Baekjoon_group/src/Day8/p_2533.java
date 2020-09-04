package Day8;

import java.util.*;
import java.io.*;

public class p_2533 {

	static int N;

	static ArrayList<Integer> [] adj;

	static boolean [] visited;

	static int root;
	static int rootNot;

	static int [][] min;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		adj = new ArrayList [N+1];

		visited = new boolean [N+1];

		min = new int [N+1][2];

		for(int i = 1 ; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		for(int i = 1; i <= N; i++) {
			if(adj[i].size()==1&&i!=1) {
				min[i][0] = 0;
				min[i][1] = 1;
			}
			else {
				min[i][0] = -1;
				min[i][1] = -1;
			}
		}

		min[1][0] = getEarly(1,false);
		min[1][1] = getEarly(1,true);

		bw.write(Integer.toString(Math.min(min[1][0], min[1][1])));
		bw.flush();
		bw.close();
	}

	static int getEarly(int n, boolean bool) {
		visited[n] = true;
		int b = bool ? 1 : 0;
		if(min[n][b]==-1) {
			min[n][b] = 0;
			if(bool) {
				min[n][b] = 1;
				for(int i = 0; i < adj[n].size(); i++) {
					int next = adj[n].get(i);
					if(!visited[next])
						min[n][b] += Math.min(getEarly(next,true),getEarly(next,false));
				}
			}
			else {
				for(int i = 0; i < adj[n].size(); i++) {
					int next = adj[n].get(i);
					if(!visited[next])
						min[n][b] += getEarly(next,true);
				}
			}
		}
		visited[n] = false;
		return min[n][b];
	}

}
