package Day3;

import java.io.*;
import java.util.*;

public class p_10845 {

	static List<Integer> queue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		queue = new ArrayList<Integer>();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.contains("push")) {
				String [] t = s.split(" ");
				push(Integer.parseInt(t[1]));
			}
			else if(s.contains("pop")) {
				System.out.println(pop());
			}
			else if(s.contains("size")) {
				System.out.println(size());
			}
			else if(s.contains("empty")) {
				System.out.println(empty());
			}
			else if(s.contains("front")) {
				System.out.println(front());
			}
			else {
				System.out.println(back());
			}
		}

	}

	static void push(int X) {
		queue.add(X);
	}

	static int pop() {
		if(queue.isEmpty()) {
			return -1;
		}
		else {
			return queue.remove(0);
		}
	}

	static int size() {
		return queue.size();
	}

	static int empty() {
		if(queue.isEmpty()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	static int front() {
		if(queue.isEmpty()) {
			return -1;
		}
		else {
			return queue.get(0);
		}
	}

	static int back() {
		if(queue.isEmpty()) {
			return -1;
		}
		else {
			return queue.get(queue.size()-1);
		}
	}

}
