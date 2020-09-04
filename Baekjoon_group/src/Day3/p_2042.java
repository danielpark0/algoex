package Day3;

import java.util.*;
import java.io.*;

public class p_2042 {
	
	static int N, M, K;
	
	static long [] nums;
	
	static long [] segTree;
	
	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new long [N+1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		int leafSize = 0;
		
		while(Math.pow(2, leafSize)<N) {
			leafSize++;
		}
		
		segTree = new long [(int)Math.pow(2, leafSize+1)];
		
		makeTree(1,1,(int)Math.pow(2, leafSize));
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long diff = c - nums[b];
				nums[b] += diff;
				update(1,b,1,(int)Math.pow(2, leafSize),diff);
//				for(int j = 1; j < 2; j++) {
//					System.out.print(segTree[j]+" ");
//				}
//				System.out.println();
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				bw.write(Long.toString(query(1,b,c,1,(int)Math.pow(2, leafSize)))+"\n");
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	static long makeTree(int node, int left, int right) {
		if(left>N) {
			return 0;
		}
		else if(left==right) {
			return segTree[node] = nums[left];
		}
		else {
			int mid = (left+right)/2;
			return segTree[node] = makeTree(node*2,left,mid) + makeTree(node*2+1,mid+1,right);
		}
	}
	
	static void update(int node, int ind, int left, int right, long diff) {
		if(ind<left||ind>right) {
			return;
		}
		else if(left>right) {
			return;
		}
		else {
			segTree[node] += diff;
			if(left<right) {
				int mid = (left+right)/2;
				update(node*2,ind,left,mid,diff);
				update(node*2+1,ind,mid+1,right,diff);
			}
		}
	}
	
	static long query(int node, int qleft, int qright, int left, int right) {
		if(right<qleft||left>qright) {
			return 0;
		}
		else if(qleft<=left&&right<=qright) {
			return segTree[node];
		}
		else {
			int mid = (left+right)/2;
			return query(node*2,qleft,qright,left,mid)+query(node*2+1,qleft,qright,mid+1,right);
		}
	}
	
}
