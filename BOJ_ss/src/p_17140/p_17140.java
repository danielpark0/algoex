package p_17140;

import java.util.*;
import java.io.*;

public class p_17140 {
	
	static int [][] A;
	
	static int H,W;
	
	static int r,c,k;
	
	static int answer;

	public static void main(String[] args)throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		A = new int [100][100];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		H = 3;
		W = 3;
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(answer>100) {
				answer = -1;
				break;
			}
			if(r<H&&c<W&&A[r][c]==k) {
				break;
			}
			if(H>=W) R();
			else C();
			answer++;
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void R() {
		int maxW = 0;
		for(int i = 0; i < H; i++) {
			int idx = 0;
			Map<Integer,Integer> map = new HashMap<>();
			for(int j = 0; j < W; j++) {
				if(A[i][j]==0) continue;
				if(map.containsKey(A[i][j])) {
					map.put(A[i][j], map.remove(A[i][j])+1);
				}
				else {
					map.put(A[i][j], 1);
				}
			}
			PriorityQueue<Count> pq = new PriorityQueue<>();
			for(int e : map.keySet())
				pq.add(new Count(e,map.get(e)));
			while(idx<100&&!pq.isEmpty()) {
				Count curr = pq.poll();
				A[i][idx++] = curr.n;
				A[i][idx++] = curr.cnt;
			}
			if(idx>maxW) maxW = idx;
			for(int j = idx; j < 100; j++) {
				A[i][j] = 0;
			}
		}
		W = maxW;
	}
	
	static void C() {
		int maxH = 0;
		for(int i = 0; i < W; i++) {
			int idx = 0;
			Map<Integer,Integer> map = new HashMap<>();
			for(int j = 0; j < H; j++) {
				if(A[j][i]==0) continue;
				if(map.containsKey(A[j][i])) {
					map.put(A[j][i], map.remove(A[j][i])+1);
				}
				else {
					map.put(A[j][i], 1);
				}
			}
			PriorityQueue<Count> pq = new PriorityQueue<>();
			for(int e : map.keySet())
				pq.add(new Count(e,map.get(e)));
			while(idx<100&&!pq.isEmpty()) {
				Count curr = pq.poll();
				A[idx++][i] = curr.n;
				A[idx++][i] = curr.cnt;
			}
			if(idx>maxH) maxH = idx;
			for(int j = idx; j < 100; j++) {
				A[j][i] = 0;
			}
		}
		H = maxH;
	}
}

class Count implements Comparable<Count>{
	int n;
	int cnt;
	public Count(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Count o) {
		if(this.cnt<o.cnt) {
			return -1;
		}
		else if(this.cnt>o.cnt) {
			return 1;
		}
		else {
			if(this.n<o.n) {
				return -1;
			}
			else if(this.n>o.n) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	public String toString() {
		return n+" "+cnt;
	}
}
