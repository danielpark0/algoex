package Day3;

import java.util.*;
import java.io.*;

public class p_10828 {
	
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.contains("push")) {
				String [] t = s.split(" ");
				stack.push(Integer.parseInt(t[1]));
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
			else {
				System.out.println(top());
			}
		}

	}
	
	static void push(int X) {
		stack.push(X);
	}
	
	static int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		else {
			return stack.pop();
		}
	}
	
	static int size() {
		return stack.size();
	}
	
	static int empty() {
		if(stack.isEmpty()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	static int top() {
		if(stack.isEmpty()) {
			return -1;
		}
		else {
			return stack.peek();
		}
	}

}
