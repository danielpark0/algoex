package p_17779;

import java.util.*;
import java.io.*;

public class p_17779 {
	
	static int N;
	static int [][] A;
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = Integer.MAX_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int [N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 2; r < N; r++) {
			for(int c = 2; c < N; c++) {
				for(int d1 = 1; r - d1 > 0; d1++) {
					for(int d2 = 1; r + d2 < N+1; d2++) {
						cal(r,c,d1,d2);
					}
				}
			}
		}
		
//		cal(4,2,1,1);
//		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(A[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	public static void cal(int r, int c, int d1, int d2) {
		int [] a = new int [6];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i>=1&&i<r&&j>=1&&j<=c+d1) {
					if(j>=c) {
						if(i<-j+r+c) {
							a[1]+=A[i][j];
							//A[i][j] = 1;
						}
						else {
							a[5]+=A[i][j];
							//A[i][j] = 5;
						}
					}
					else {
						a[1]+=A[i][j];
						//A[i][j] = 1;
					}
				}
				else if(i>=1&&i<=r-d1+d2&&j>c+d1&&j<=N) {
					if(j<=c+d1+d2) {
						if(i<j+r-c-2*d1) {
							a[2]+=A[i][j];
							//A[i][j] = 2;
						}
						else {
							a[5]+=A[i][j];
							//A[i][j] = 5;
						}
					}
					else {
						a[2]+=A[i][j];
						//A[i][j] = 2;
					}
				}
				else if(i>=r&&i<=N&&j>=1&&j<c+d2) {
					if(j>=c) {
						if(i>j+r-c) {
							a[3]+=A[i][j];
							//A[i][j] = 3;
						}
						else {
							a[5]+=A[i][j];
							//A[i][j] = 5;
						}
					}
					else {
						a[3]+=A[i][j];
						//A[i][j] = 3;
					}
				}
				else if(i>r-d1+d2&&i<=N&&j>=c+d2&&j<=N) {
					if(j<=c+d1+d2) {
						if(i>-j+r+c+2*d2) {
							a[4]+=A[i][j];
							//A[i][j] = 4;
						}
						else {
							a[5]+=A[i][j];
							//A[i][j] = 5;
						}
					}
					else {
						a[4]+=A[i][j];
						//A[i][j] = 4;
					}
				}
				else {
					a[5]+=A[i][j];
					//A[i][j] = 5;
				}
			}
		}
		int max = a[1];
		int min = a[1];
		for(int i = 2; i < 6; i++) {
			if(a[i]>max) max = a[i];
			if(a[i]<min) min = a[i];
		}
		if(max-min<answer) {
			answer = max-min;
			//System.out.println(answer+" "+r+" "+c+" "+d1+" "+d2);
		}
	}

}
