package Day7;

import java.util.*;
import java.io.*;

public class p_18227 {
	
	static int N, C, Q;
	
	static ArrayList<Integer> [] adj;
	static boolean [] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Node root = new Node(C);
		
		Tree tree = new Tree(root);
		
		adj = new ArrayList [N+1];
		visited = new boolean[N+1];
		
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
		
		tree.makeTree(adj,visited);
		
		Q = Integer.parseInt(br.readLine());

	}

}

class Tree{
	static Node root;
	public Tree(Node root) {
		this.root = root;
	}
	
	static void makeTree(ArrayList<Integer> [] tree,boolean [] visited) {
		Node curr = root;
		visited[curr.num] = true;
		for(int i = 0; i < tree[curr.num].size(); i++) {
			if(!visited[tree[curr.num].get(i)]) {
				Node next = new Node(tree[curr.num].get(i));
				next.parent[0] = curr;
				for(int j = 1; j < 15; j++) {
					if(next.parent[j-1].equals(root)) break;
					next.parent[j] = next.parent[j-1].parent[j-1];
				}
			}
		}
	}
}

class Node{
	int num;
	int water;
	Node [] parent;
	public Node(int num) {
		this.num = num;
		this.water = 0;
		this.parent = new Node[15];
	}
}