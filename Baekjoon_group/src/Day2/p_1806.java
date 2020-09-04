package Day2;

import java.io.*;
import java.util.*;

public class p_1806 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int [] arr = new int [N];

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = 0;

		int sum = arr[0];

		int answer = N+1;

		while(true) {
			if(sum==S) {
				if(r-l+1<answer) {
					answer = r-l+1;
				}
				if(r==N-1) break;
				r++;
				sum += arr[r];
			}
			else if(sum>S) {
				if(r-l+1<answer) {
					answer = r-l+1;
				}
				sum -= arr[l++];
			}
			else {
				if(r==N-1) break;
				sum += arr[++r];
			}
		}

		if(answer == N+1) {
			System.out.println(0);
		}
		else {
			System.out.println(answer);
		}

	}

}
