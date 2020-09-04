package Day6;

import java.util.*;
import java.io.*;

public class p_2252 {
	
	static int N, M;
	
	static ArrayList<Integer> [] list;
	
	static int [] count;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList [N+1];
		count = new int [N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			count[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(count[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int i = 0; i < list[curr].size(); i++) {
				count[list[curr].get(i)]--;
				if(count[list[curr].get(i)]==0) {
					queue.add(list[curr].remove(i));
					i--;
				}
			}
			bw.write(curr+" ");
		}
		bw.flush();
		bw.close();

	}

}
