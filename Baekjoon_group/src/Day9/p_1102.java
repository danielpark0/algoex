package Day9;

import java.io.*;
import java.util.*;

public class p_1102 {

	static int N;
	static int [][] price;
	static boolean [] power;
	static int P;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		price = new int [N][N];
		power = new boolean [N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String s = br.readLine();
		
		for(int i = 0; i < N; i++) {
			if(s.charAt(i)=='Y') {
				power[i] = true;
			}
		}
		
		P = Integer.parseInt(br.readLine());
		
	}

}
