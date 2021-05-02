package dfs_bfs;

import java.io.*;
import java.util.*;

public class p_1068 {
	
	public static void main(String[] args) throws Exception {
		
		int answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int root = 0;
		
		Set<Integer> [] child = new HashSet [N];
		
		for(int i = 0; i < N; i++) {
			child[i] = new HashSet<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if(p == -1) {
				root = i;
			}
			else {
				child[p].add(i);
			}
		}
		
		int D = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		stack.add(root);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(curr == D) continue;
			if(child[curr].isEmpty()) {
				answer++;
			}
			else {
				for(int e : child[curr])
					stack.add(e);
			}
		}
		
		System.out.println(answer);

	}

}
