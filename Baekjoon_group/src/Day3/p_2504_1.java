package Day3;

import java.util.*;
import java.io.*;

public class p_2504_1 {
	
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		stack = new Stack<>();
		
		String s = br.readLine();
		
		int answer = 0;
		
		boolean correct = true;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(-1);
			}
			else if(c == ')') {
				if(stack.isEmpty()||stack.peek()==-2) {
					correct = false;
					break;
				}
				int sum = 0;
				while(stack.peek()>-1) {
					sum += stack.pop();
					if(stack.isEmpty()) {
						correct  = false;
						break;
					}
				}
				if(correct) {
					if(stack.peek()==-1) {
						stack.pop();
						if(sum==0) {
							stack.push(2);
						}
						else {
							stack.push(sum*2);
						}
					}
					else {
						correct = false;
						break;
					}
				}
			}
			else if(c == '[') {
				stack.add(-2);
			}
			else {
				if(stack.isEmpty()||stack.peek()==-1) {
					correct = false;
					break;
				}
				int sum = 0;
				while(stack.peek()>-1) {
					sum += stack.pop();
					if(stack.isEmpty()) {
						correct  = false;
						break;
					}
				}
				if(correct) {
					if(stack.peek()==-2) {
						stack.pop();
						if(sum==0) {
							stack.push(3);
						}
						else {
							stack.push(sum*3);
						}
					}
					else {
						correct = false;
						break;
					}
				}
			}
			if(!correct) break;
			//System.out.println(stack.toString());
		}
		
		if(stack.contains(-1)||stack.contains(-2)) {
			correct = false;
		}
		
		while(correct&&!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		if(correct) {
			System.out.println(answer);
		}
		else {
			System.out.println(0);
		}

	}

}
