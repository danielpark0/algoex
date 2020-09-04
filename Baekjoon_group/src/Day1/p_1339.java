package Day1;

import java.util.*;
import java.io.*;

public class p_1339 {

	static int N;

	static Map<Character,Integer> map;

	static String [] words;

	static boolean [] visited;

	static int [] nums;

	static int answer;

	public static void main(String[] args) throws Exception {

		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		words = new String[N];

		visited = new boolean [26];

		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			for(int j = 0; j < words[i].length(); j++) {
				if(!visited[words[i].charAt(j)-'A']) {
					visited[words[i].charAt(j)-'A'] = true;
					map.put(words[i].charAt(j),map.size());
				}
			}
		}

		nums = new int [map.size()];

		int n = 9;

		for(int i = 0; i < nums.length; i++) {
			nums[i] = n--;
		}

		comb(0);

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	static void comb(int a) {
		if(a==nums.length) {
			int temp = 0;
			for(int i = 0; i < words.length; i++) {
				for(int j = 0; j < words[i].length(); j++) {
					temp += nums[map.get(words[i].charAt(j))]*Math.pow(10, words[i].length()-(j+1));
				}
			}
			if(temp > answer) {
				answer = temp;
			}
		}
		for(int i = a; i < nums.length; i++) {
			swap(a,i);
			comb(a+1);
			swap(a,i);
		}
	}

	static void swap(int i1, int i2) {
		int temp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = temp;
	}

}
