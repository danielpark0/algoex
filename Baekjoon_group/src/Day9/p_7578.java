package Day9;

import java.util.*;
import java.io.*;

public class p_7578 {
	
	static int N;
	static int [] A;
	static Map<Integer,Integer> B;

	public static void main(String[] args) throws Exception {
		
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		A = new int [N+1];
		B = new HashMap<Integer,Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			B.put(Integer.parseInt(st.nextToken()), i);
		}
		
		int n = 1;
		int cnt = 0;
		
		while(n<N) {
			n *= 2;
			cnt++;
		}
		
		int lsize = (int) Math.pow(2, cnt);
		
		SegmentTree stree = new SegmentTree((int)Math.pow(2, cnt+1));
		
		for(int i = 1; i <= N; i++) {
			int curr = B.get(A[i]);
			answer += stree.query(1, 1, lsize, curr, lsize);
			stree.update(1,1,lsize,curr,1);
			System.out.println(stree.toString());
		}
		
		System.out.println(answer);

	}

}

class SegmentTree{
	int [] tree;
	int depth;
	int leafSize;
	public SegmentTree(int leafSize) {
		this.leafSize = leafSize;
		this.tree = new int [leafSize];
	}
	
	public int query(int node, int left, int right, int qleft, int qright) {
		if(qleft>right||qright<left) {
			return 0;
		}
		else if(left>=qleft&&qright>=right) {
			return tree[node];
		}
		else {
			int mid = (left+right)/2;
			return query(node*2,left,mid,qleft,qright) + query(node*2+1,mid+1,right,qleft,qright);
		}
	}
	
	public void update(int node, int left, int right, int idx, int diff) {
		if(idx<left||idx>right) {
			return;
		}
		else {
			tree[node] += diff;
			if(left!=right) {
				int mid = (left+right)/2;
				update(node*2,left,mid,idx,diff);
				update(node*2+1,mid+1,right,idx,diff);
			}
		}
	}
	
	public String toString() {
		return Arrays.toString(tree);
	}
}
