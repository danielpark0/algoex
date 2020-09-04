package Day7;

import java.io.*;
import java.util.*;

public class p_5719 {
	
	static int N, M;
	static int [][] road;
	static int S, D;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N==0&&M==0) {
				break;
			}
		}

	}

}
