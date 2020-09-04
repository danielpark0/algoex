package Day1;

import java.io.*;
import java.util.*;

public class p_1920 {
	
	static int N, M;
	
	static Set<Integer> A;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();
		
		A = new HashSet<Integer>();
		
		for(int i = 0; i < N; i++) {
			A.add(sc.nextInt());
		}
		
		M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			if(A.contains(sc.nextInt())) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}

	}

}
