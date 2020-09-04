package Day5;

import java.util.*;
import java.io.*;

public class p_5568 {

	static int N;
	static int K;

	static int [] cards;

	static Set<Integer> set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		cards = new int [N];

		set = new HashSet<Integer>();

		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}
		
		int [] nums = new int [K];
		
		combination(0,0,nums);
		
		System.out.println(set.size());

	}

	static void combination(int n, int ind, int [] nums) {
		if(ind==K) {
			permutation(nums, 0);
			return;
		}
		else if(n>=N) {
			return;
		}
		else {
			nums[ind] = cards[n];
			combination(n+1,ind+1,nums);
			combination(n+1,ind,nums);
		}
	}

	static void permutation(int [] nums,int n) {
		if(n==K) {
			String s = "";
			for(int e:nums) {
				s += e;
			}
			set.add(Integer.parseInt(s));
		}
		else {
			for(int i = n; i < K; i++) {
				swap(nums,i,n);
				permutation(nums,n+1);
				swap(nums,i,n);
			}
		}
	}

	static void swap(int [] nums, int i1, int i2) {
		int t = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = t;
	}


}
