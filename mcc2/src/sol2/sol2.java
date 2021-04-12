package sol2;

import java.util.*;

public class sol2 {
	
	public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++) {
        	if(correct(sb.toString())) {
        		answer++;
        	}
        	char c = sb.charAt(0);
        	sb.deleteCharAt(0);
        	sb.append(c);
        }
        
        return answer;
    }
	
	boolean correct(String s) {
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') {
				c1++;
			}
			else if(s.charAt(i)==')') {
				c1--;
			}
			else if(s.charAt(i)=='[') {
				c2++;
			}
			else if(s.charAt(i)==']') {
				c2--;
			}
			else if(s.charAt(i)=='{') {
				c3++;
			}
			else if(s.charAt(i)=='}') {
				c3--;
			}
			if(c1<0||c2<0||c3<0) {
				return false;
			}
		}
		if(c1!=0||c2!=0||c3!=0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
