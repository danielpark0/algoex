import java.util.*;
import java.io.*;

public class p_1005 {

	static int T;
	static int N, K;
	static int [] time;

	static Set<Integer> [] pre;
	static Set<Integer> [] post;
	
	static int [] max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int [N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			pre = new HashSet[N+1];
			post = new HashSet[N+1];
			
			for(int i = 1; i <= N; i++) {
				pre[i] = new HashSet<Integer>();
				post[i] = new HashSet<Integer>();
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pre[b].add(a);
				post[a].add(b);
			}
			
			max = new int[N+1];
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 1; i <= N; i++) {
				if(pre[i].size()==0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				for(int e:post[curr]) {
					if(max[curr]+time[curr]>max[e]) {
						max[e] = max[curr]+time[curr];
					}
					pre[e].remove(curr);
					if(pre[e].size()==0) {
						queue.add(e);
					}
				}
			}
			
			int W = Integer.parseInt(br.readLine());
					
			bw.write(Integer.toString(max[W]+time[W])+"\n");
			bw.flush();
		}
		bw.close();
		

	}

}
