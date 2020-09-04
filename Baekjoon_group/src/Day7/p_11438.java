package Day7;

import java.util.*;
import java.io.*;

public class p_11438 {
	
	static int N, M;
	static int max_depth = 17;
	static int max_n = 1000000;
	static ArrayList<Integer> [] connected;
	static int [] depth;
	static int [][] parent;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		connected = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			connected[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connected[a].add(b);
			connected[b].add(a);
		}
		
		depth = new int [N+1];
		parent = new int [N+1][max_depth+1];
		
		for(int i = 1; i <= N; i++) {
			depth[i] = -1;
		}
		
		dfs(1,0);
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a,b));
		}
		
//		System.out.println(Arrays.toString(depth));
//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(parent[i]));
//		}

	}
	
	static void dfs(int node, int d) {
		if(depth[node]!=-1)	return;
		depth[node] = d;
		for(int i = 0; i < connected[node].size(); i++) {
			int next = connected[node].get(i);
			if(depth[next]!=-1) continue;
			parent[next][0] = node;
			for(int j = 1; j <= max_depth; j++) {
				if(parent[next][j-1]==0) break;
				parent[next][j] = parent[parent[next][j-1]][j-1];
			}
			dfs(next,d+1);
		}
	}
	
	static int lca(int a, int b) {
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;	
		}
		for(int i = max_depth; i >= 0; i--) {
			int diff = depth[b] - depth[a];
			if(diff>=1<<i) {
				b = parent[b][i];
			}
		}
		if(a==b) {
			return a;
		}
		for(int i = max_depth; i>= 0; i--) {
			if(parent[a][i]!=parent[b][i]) {
				a =	parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}

}
