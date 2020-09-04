package Day3;

import java.util.*;
import java.io.*;

public class p_1202_sol {
	
	static int N, K;
	static Jewelry1[] jewelry;
	static int [] bags;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelry[i] = new Jewelry1(m,v);
		}
		
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewelry, Comparator.comparingInt(Jewelry1::getWeight));
		Arrays.sort(bags);
		
		PriorityQueue<Jewelry1> pq = new PriorityQueue<>(Comparator.comparingInt(Jewelry1::getValue).reversed());

	}

}

class Jewelry1{
	int weight;
	int value;
	
	public int getWeight() {
		return weight;
	}
	
	public int getValue() {
		return value;
	}

	public Jewelry1(int weight, int value) {
		super();
		this.weight = weight;
		this.value = value;
	}
}
