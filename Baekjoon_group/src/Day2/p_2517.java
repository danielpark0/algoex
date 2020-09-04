package Day2;

import java.io.*;
import java.util.*;

public class p_2517 {
	
	static int N;
	
	static Runner[] runners;
	static Runner[] temp2;
	
	static int [] ranks;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		runners = new Runner[N];
		temp2 = new Runner[N];
		ranks = new int [N];
	
		for(int i = 0; i < N; i++) {
			runners[i] = new Runner(Long.parseLong(br.readLine()),i);
			ranks[i] = i+1;
		}
		
		mergeSort(0,N-1);
		
		for(int e : ranks)
		System.out.println(e);

	}
	
	static void mergeSort(int s, int e) {
		if(s < e) {
			int mid = (s+e)/2;
			mergeSort(s,mid);
			mergeSort(mid+1,e);
			merge(s,mid,e);
		}
	}

	static void merge(int s, int m, int e) {
		int p1 = s;
		int p2 = m+1;
		int k = s;
		while(p1 <= m && p2 <= e) {
			if(runners[p1].value < runners[p2].value) {
				temp2[k++] = runners[p1++];
			}
			else {
				int count = p1-s;
				ranks[runners[p2].position] -= count;
				temp2[k++] = runners[p2++];
			}
		}
		while(p1 <= m) {
			temp2[k++] = runners[p1++];
		}
		while(p2 <= e) {
			int count = p1-s;
			ranks[runners[p2].position] -= count;
			temp2[k++] = runners[p2++];
		}
		for(int i = s; i <= e; i++) {
			runners[i] = temp2[i];
		}
	}

}

class Runner{
	long value;
	int position;
	public Runner(long value, int position) {
		super();
		this.value = value;
		this.position = position;
	}
	@Override
	public String toString() {
		return "Runner [value=" + value + ", position=" + position + "]";
	}
	
	
}