package Day4;

import java.io.*;
import java.util.*;

public class p_14476 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] nums = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] ltor = new int [N];
		ltor[0] = nums[0];
		int [] rtol = new int [N];
		rtol[N-1] = nums[N-1];
		
		for(int i = 1; i < N; i++) {
			ltor[i] = gcd(nums[i],ltor[i-1]);
		}
		
		for(int i = N-2; i >= 0; i--) {
			rtol[i] = gcd(nums[i],rtol[i+1]);
		}
		
//		System.out.println(Arrays.toString(ltor));
//		System.out.println(Arrays.toString(rtol));
		
		int answer = 0;
		int K = 0;
		
		if(nums[0]%rtol[1]!=0) {
			answer = rtol[1];
			K = nums[0];
		}
		if(nums[N-1]%ltor[N-2]!=0&&answer<ltor[N-2]) {
			answer = ltor[N-2];
			K = nums[N-1];
		}
		
		for(int i = 1; i < N-2; i++) {
			int curr = gcd(ltor[i-1],rtol[i+1]);
			if(nums[i]%curr!=0) {
				if(answer < curr) {
					answer = curr;
					K = nums[i];
				}
			}
		}
		
		if(answer==0) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer+" "+K);
		}

	}
	
	static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

}
