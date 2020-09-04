package Day2;

import java.util.*;
import java.io.*;

public class p_2143 {

	public static void main(String[] args) throws Exception {
		
		long answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] A = new int[n];
		
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int [] B = new int[m];
		
		for(int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> subA = new ArrayList<Integer>();
		ArrayList<Integer> subB = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += A[j];
				subA.add(sum);
			}
		}
		
		for(int i = 0; i < m; i++) {
			int sum = 0;
			for(int j = i; j < m; j++) {
				sum += B[j];
				subB.add(sum);
			}
		}
		
		Collections.sort(subA);
		Collections.sort(subB);
		
		//System.out.println(subA.toString());
		//System.out.println(subB.toString());
		
		int curr=0;
		
		int s = subB.size()-1;
		int e = subB.size()-1;
		
		for(int i = 0; i < subA.size(); i++) {
			
			if(i==0||subA.get(i)!=curr) {
				
				while(s>=0) {
					if(subA.get(i)+subB.get(s)<T) {
						break;
					}
					else {
						s--;
					}
				}
				while(e>=0) {
					if(subA.get(i)+subB.get(e)==T) {
						break;
					}
					else if(subA.get(i)+subB.get(e)>T) {
						e--;
					}
					else {
						break;
					}
				}
				answer += e-s;
				curr = subA.get(i);
				//System.out.println(s+" "+e);
			}
			else {
				answer += e-s;
			}
		}
		
		System.out.println(answer);

	}

}
