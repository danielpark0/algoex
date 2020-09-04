package Day2;

import java.util.*;

public class p_2003 {

	public static void main(String[] args) {
		
		int answer = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long M = sc.nextLong();
		
		long [] A = new long[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextLong();
		}
		
		int start = 0;
		int end = 0;
		long sum = A[0];
		
		while(end<N) {
			if(sum<M) {
				end++;
				if(end>=N) break;
				sum += A[end];
			}
			else if(sum>M) {
				sum -= A[start];
				start++;
			}
			else {
				answer++;
				sum -= A[start];
				start++;
			}
		}
		
		System.out.println(answer);

	}

}
