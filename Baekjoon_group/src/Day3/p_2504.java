package Day3;

import java.util.*;
import java.io.*;

public class p_2504 {
	
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		stack = new Stack<>();
		
		String s = br.readLine();
		
		int sum = 0;
		int mult = 1;
		
		boolean correct = true;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.add('(');
			}
			else if(c == ')') {
				if(stack.isEmpty()) {
					correct = false;
					break;
				}
				else {
					if(stack.peek()=='(') {
						stack.pop();
						if(stack.isEmpty()) {
							sum += mult*2;
							mult = 1;
						}
						else {
							if(mult == 1) {
								mult = 2;
							}
							else {
								mult += 2;
							}
						}
					}
					else {
						correct = false;
						break;
					}
				}
			}
			else if(c == '[') {
				stack.add('[');
			}
			else {
				if(stack.isEmpty()) {
					correct = false;
					break;
				}
				else {
					if(stack.peek()=='[') {
						stack.pop();
						if(stack.isEmpty()) {
							sum += mult*3;
							mult = 1;
						}
						else {
							if(mult == 1) {
								mult = 3;
							}
							else {
								mult += 3;
							}
						}
					}
					else {
						correct = false;
						break;
					}
				}
			}
		}
		
		if(!stack.isEmpty()) {
			correct = false;
		}
		
		if(correct) {
			System.out.println(sum);
		}
		else {
			System.out.println(0);
		}

	}

}
