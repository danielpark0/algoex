package Day4;

import java.util.*;
import java.io.*;

public class p_2725 {
	
	static int C;
	
	static boolean [] primeN;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		primeN = new boolean[1001];
		
		for(int i = 2; i < 1001; i++) {
			primeN[i] = true;
		}
		
		for(int i = 2; i < 1001; i++) {
			if(primeN[i]) {
				for(int j = 2; i*j < 1001; j++) {
					primeN[i*j] = false;
				}
			}
		}
		
		C = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < C; i++) {
			System.out.println(prime(Integer.parseInt(br.readLine())));
		}
		
	}
	
	static int prime(int n) {
		int sum = 0;
		for(int i = 2; i <= n; i++) {
			if(primeN[i]) {
				sum += i-1;
			}
			else {
				int mult = 1;
				int t = i;
				for(int j = 2; j < i && t > 1; j++) {
					if(t%j==0) {
						int cnt = 0;
						while(t%j==0) {
							t/=j;
							cnt++;
						}
						mult *= Math.pow(j, cnt)-Math.pow(j, cnt-1);
					}
				}
				sum += mult;
			}
		}
		return sum*2+3;
	}

}
