package Day3;

import java.io.*;
import java.util.*;

public class p_1202 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Jewelry> jewelry = new PriorityQueue<>();
		PriorityQueue<Integer> bags = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelry.add(new Jewelry(m,v));
		}
		
		for(int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		
		PriorityQueue<Jewelry> cand = new PriorityQueue<>(new Comparator<Jewelry>() {

			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				if(o1.V>o2.V) {
					return -1;
				}
				else if(o1.V<o2.V) {
					return 1;
				}
				else {
					return 0;
				}
			}
			
		});
		
		long answer = 0;
		while(!bags.isEmpty()) {
			int curr = bags.poll();
			while(!jewelry.isEmpty()&&curr >= jewelry.peek().M) {
				cand.add(jewelry.poll());
			}
			if(cand.isEmpty()) {
				
			}
			else {
				answer += cand.poll().V;
			}
		}
		
		System.out.print(answer);

	}

}

class Jewelry implements Comparable<Jewelry>{
	int M;
	int V;
	public Jewelry(int M, int V) {
		this.M = M;
		this.V = V;
	}
	
	@Override
	public int compareTo(Jewelry o) {
		if(M>o.M) {
			return 1;
		}
		else if(M < o.M) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public String toString() {
		return M+" "+V;
	}
}
