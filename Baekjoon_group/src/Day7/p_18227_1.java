package Day7;

import java.util.*;
import java.io.*;

public class p_18227_1 {

	static int N, C, Q;

	static ArrayList<Integer> [] adj;
	static boolean [] visited;
	static int [][] tree;
	static long [] water;

	static int idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		adj = new ArrayList [N+1];
		visited = new boolean[N+1];
		tree = new int [N+1][4]; //0-트리에서 현재번호, 1-깊이, 2-들어가는거, 3-나오는거

		int leafSize = 0;

		while(Math.pow(2, leafSize)<N) {
			leafSize++;
		}

		water = new long [(int)Math.pow(2,leafSize+1)+1];

		idx = 1;

		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		makeTree(C,1);

//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(tree[i]));
//		}

		Q = Integer.parseInt(br.readLine());

		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1) {
				update(1, tree[b][0], 1, (int) Math.pow(2, leafSize));
//				System.out.println(Arrays.toString(water));
			}
			else {
				System.out.println(query(1,tree[b][2],tree[b][3],1,(int)Math.pow(2, leafSize))*tree[b][1]);
			}
		}
		
//		System.out.println(water[1]);
//		for(int i = 2; i < 4; i++) {
//			System.out.print(water[i]+" ");
//		}
//		System.out.println();
//		for(int i = 4; i < 8; i++) {
//			System.out.print(water[i]+" ");
//		}
//		System.out.println();
//		for(int i = 8; i < 16; i++) {
//			System.out.print(water[i]+" ");
//		}

	}

	static void makeTree(int curr, int depth) {
		visited[curr] = true;
		tree[curr][0] = idx;
		tree[curr][1] = depth;
		tree[curr][2] = idx++;
		for(int i = 0; i < adj[curr].size(); i++) {
			int next = adj[curr].get(i);
			if(!visited[next]) {
				makeTree(next,depth+1);
			}
		}
		tree[curr][3] = idx-1;
	}

	static void update(int node, int num, int left, int right) {
		if(num<left||num>right) {

		}
		else {
			water[node]++;
			if(left<right) {
				int mid = (left+right)/2;
				update(node*2,num,left,mid);
				update(node*2+1,num,mid+1,right);
			}
		}
	}

	static long query(int node, int qleft, int qright, int left, int right) {
		if(qleft>right||qright<left) {
			return 0;
		}
		else if(qleft<=left&&qright>=right) {
			return water[node];
		}
		else {
			int mid = (left+right)/2;
			return	query(2*node,qleft,qright,left,mid)+query(2*node+1,qleft,qright,mid+1,right);
		}
	}


}
