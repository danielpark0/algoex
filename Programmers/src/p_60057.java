
public class p_60057 {

	public static void main(String[] args) {

		String s1 = "aabbaccc";
		String s2 = "ababcdcdababcdcd";
		
		System.out.println(solution(s1));
		System.out.println(solution(s2));

	}
	
	public static int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++) {
        	int t = com(s,i);
        	if(answer > t) {
        		answer = t;
        	}
        }
        
        return answer;
    }
	
	static int com(String s, int l) {
		String rs = "";
		String curr = "";
		int count = 0;
		for(int i = 0; i < s.length(); i+=l) {
			if(i+l>s.length()) {
				if(count>1) {
					rs += count+curr;
				}
				else {
					rs += curr;
				}
				count = 1;
				curr = s.substring(i,s.length());
			}
			else if(s.substring(i,i+l).equals(curr)) {
				count++;
			}
			else {
				if(count==0) {
					
				}
				else if(count==1) {
					rs += curr;
				}
				else {
					rs += count+curr;
				}
				curr = s.substring(i,i+l);
				count = 1;
			}
			if(i+l>=s.length()) {
				if(count>1) {
					rs += count+curr;
				}
				else {
					rs += curr;
				}
			}
		}
		return rs.length();
	}
	
	

}
