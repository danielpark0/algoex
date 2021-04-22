import java.util.*;

public class p_68935 {
	
	public int solution(int n) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        while(n>2) {
        	stack.add(n%3);
        	n/=3;
        }
        stack.add(n);
        
        int m = 1;
        
        while(!stack.isEmpty()) {
        	answer += stack.pop()*m;
        	m *= 3;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
