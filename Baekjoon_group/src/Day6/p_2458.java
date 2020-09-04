package Day6;

import java.util.*;
import java.io.*;

public class p_2458 {

	static int N, M;
	static ArrayList<Integer> [] list;
	static int [] count;

	static Queue<Integer> queue;

	static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList [N+1];
		count = new int [N+1];

		answer = 0;

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

		queue = new LinkedList<Integer>();

		for(int i = 1; i <= N; i++) {
			if(count[i]==0) {
				queue.add(i);
			}
			if(list[i].size()==0) {
				answer--;
			}
		}

//		for(int i = 1; i <= N; i++) {
//			System.out.println(i+" "+list[i].toString());
//		}

		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(queue.isEmpty()) {
				answer++;
			}
			for(int i = 0; i < list[curr].size(); i++) {
				count[list[curr].get(i)]--;
				if(count[list[curr].get(i)]==0) {
					queue.add(list[curr].remove(i));
					i--;
				}
			}
		}

		System.out.println(answer);

	}

}
