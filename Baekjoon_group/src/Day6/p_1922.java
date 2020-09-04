package Day6;

import java.util.*;
import java.io.*;

public class p_1922 {
	
	static int N, M;
	
	static int [] root;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		PriorityQueue<Line> pq = new PriorityQueue<Line>(Comparator.comparingInt(Line::getC));
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Line(a,b,c));
		}
		
		root = new int [N+1];
		
		for(int i = 1; i <= N; i++) {
			root[i] = i;
		}
		
		int l = N-1;
		
		int answer = 0;
		
		while(l>0) {
			Line curr = pq.poll();
			System.out.println(curr);
			if(find(curr.a)!=find(curr.b)) {
				union(curr.a,curr.b);
				answer += curr.c;
				l--;
				System.out.println(Arrays.toString(root));
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int find(int a) {
		if(root[a]==a) {
			return a;
		}
		else {
			return root[a] = find(root[a]);
		}
	}
	
	static void union(int a, int b) {
		if(find(a) < find(b)) {
			root[find(b)] = root[find(a)];
		}
		else {
			root[find(a)] = root[find(b)];
		}
	}
}

class Line{
	int a;
	int b;
	int c;
	public Line(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int getC() {
		return c;
	}	
	public String toString() {
		return a+ " "+ b +" "+c;
	}
}
