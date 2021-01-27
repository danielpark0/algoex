package segtree;

import java.util.*;
import java.io.*;

public class p_2042 {
	
	static int N, M, K;
	static int depth;
	static long [] segtree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		depth = 0;
		
		while(true) {
			if(Math.pow(2, depth)<N) {
				depth++;
			}
			else {
				break;
			}
		}
		
		segtree = new long [(int) Math.pow(2, depth+1)];
		
		for(int i = 0; i < N; i++) {
			segtree[(int) Math.pow(2, depth)+i] = Long.parseLong(br.readLine());
		}
		
		makeTree();
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) {
				changeTree(b,c);
			}
			else {
				bw.write(Long.toString(getSum(1, b,(int)c,1,(int)Math.pow(2, depth)))+"\n");
				bw.flush();
			}
//			for(int j = 0; j <= depth; j++) {
//				for(int q = (int) Math.pow(2,j); q < (int) Math.pow(2,j+1); q++) {
//					System.out.print(segtree[q]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
		}
		
		bw.close();
	}
	
	static void makeTree() {
		for(int i = (int)Math.pow(2, depth+1)-1; i > 0; i--) {
			segtree[i/2] += segtree[i];
		}
	}
	
	static void changeTree(int i, long n) {
		i = (int) Math.pow(2, depth) + i - 1;
		long diff = n - segtree[i];
		while(i > 0) {
			segtree[i] += diff;
			i /= 2;
		}
	}
	
	static long getSum(int curr, int i1, int i2, int l, int r) {
		if(r<i1||l>i2) {
			return 0;
		}
		else if(l>=i1&&r<=i2) {
			return segtree[curr];
		}
		else {
			int m = (l+r)/2;
			return getSum(curr*2,i1,i2,l,m) + getSum(curr*2+1,i1,i2,m+1,r);
		}
	}

}
