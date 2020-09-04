package Day2;

import java.io.*;
import java.util.*;

public class p_2096 {
	
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lmax = Integer.parseInt(st.nextToken());
		int lmin = lmax;
		
		int mmax = Integer.parseInt(st.nextToken());
		int mmin = mmax;
		
		int rmax = Integer.parseInt(st.nextToken());
		int rmin = rmax;
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int tlmax = Math.max(lmax, mmax)+l;
			int tmmax = Math.max(lmax, Math.max(mmax, rmax))+m;
			int trmax = Math.max(mmax, rmax)+r;
			
			int tlmin = Math.min(lmin, mmin)+l;
			int tmmin = Math.min(lmin, Math.min(mmin, rmin))+m;
			int trmin = Math.min(mmin, rmin)+r;
			
			lmax = tlmax;
			mmax = tmmax;
			rmax = trmax;
			
			lmin = tlmin;
			mmin = tmmin;
			rmin = trmin;
		}
		
		System.out.println(Math.max(lmax, Math.max(mmax, rmax))+" "+Math.min(lmin, Math.min(mmin, rmin)));

	}

}
