import java.util.*;

public class p_60058 {
	
	public static String solution(String p) {
        String answer = "";
        String u = "";
        String v = "";
        if(p.length()==0) {
        	return p;
        }
        else {
        	int count = 0;
        	if(p.charAt(0)=='(') {
        		count++;
        	}
        	else {
        		count--;
        	}
        	for(int i = 1; i < p.length(); i++) {
        		if(p.charAt(i)=='(') {
        			count++;
        		}
        		else {
        			count--;
        		}
        		if(count==0) {
        			u = p.substring(0,i+1);
        			v = p.substring(i+1,p.length());
        			break;
        		}
        	}
        	answer = correct(u,v);
        }
        
        return answer;
    }
	
	static String correct(String u, String v) {
		int c = 0;
		boolean pass = true;
		for(int i = 0; i < u.length(); i++) {
			if(u.charAt(i)=='(') {
				c++;
			}
			else {
				c--;
			}
			if(c<0) {
				pass = false;
				break;
			}
		}
		if(!pass) {
			String s = "(";
			s += solution(v);
			s += ")";
			u = u.substring(1,u.length()-1);
			for(int i = 0; i < u.length(); i++) {
				if(u.charAt(i)=='(') {
					s += ")";
				}
				else {
					s += "(";
				}
			}
			return s;
		}
		return u+solution(v);
	}

	public static void main(String[] args) {

		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));

	}

}
