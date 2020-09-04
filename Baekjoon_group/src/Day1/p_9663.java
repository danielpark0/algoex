package Day1;

import java.util.*;

public class p_9663 {
	
	static int N;
	
	static int answer;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int [] pos = new int [N];
		
		answer = 0;
		
		nqueen(pos,0);
		
		System.out.println(answer);

	}
	
	static void nqueen(int [] pos, int ind) {
		if(ind==N) {
			answer++;
		}
		else {
			for(int i = 0;i < N; i++) {
				if(isPromising(pos,ind,i)) {
					pos[ind] = i;
					nqueen(pos,ind+1);
				}
			}
		}
	}
	
	static boolean isPromising(int [] pos, int ind, int n) {
		for(int i = 0; i < ind; i++) {
			if(pos[i]==n||pos[i]+i==ind+n||pos[i]-i==n-ind) {
				return false;
			}
		}
		return true;
	}
 
}
