package Day5;

import java.io.*;
import java.util.*;

public class p_13251 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		
		int [] color = new int [M+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double answer = 0;
		
		int total = 0;
		
		for(int i = 1; i <= M; i++) {
			color[i] = Integer.parseInt(st.nextToken());
			total += color[i];
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= M; i++) {
			double sum = 1;
			int curr = total;
			for(int j = 0; j < K; j++) {
				if(color[i]==0) {
					sum = 0;
					break;
				}
				//System.out.println(color[i]+" "+curr+" "+sum);
				sum *= (double)color[i]--/(double)curr--;
			}
			answer += sum;
		}
		
		System.out.println(answer);

	}

}
