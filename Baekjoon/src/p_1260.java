import java.util.*;
import java.io.*;

public class p_1260 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		boolean [][] e = new boolean [N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			e[i1][i2] = true;
			e[i2][i1] = true;
		}
		
		boolean [] dfs_v = new boolean [N+1];
		boolean [] bfs_v = new boolean [N+1];
		
		StringBuilder dfs = new StringBuilder();
		StringBuilder bfs = new StringBuilder();
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(V);

		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(!dfs_v[curr]) {
				dfs.append(curr+" ");
				dfs_v[curr] = true;
				for(int i = N; i > 0; i--) {
					if(e[curr][i]) {
						if(!dfs_v[i]) {
							stack.add(i);
						}
					}
				}
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(!bfs_v[curr]) {
				bfs.append(curr+" ");
				bfs_v[curr] = true;
				for(int i = 1; i <= N; i++) {
					if(e[curr][i]) {
						if(!bfs_v[i]) {
							queue.add(i);
						}
					}
				}
			}
		}
		
		bw.write(dfs.toString().trim()+"\n");
		bw.write(bfs.toString().trim());
		bw.flush();
		bw.close();
		
	}

}
