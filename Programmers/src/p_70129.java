import java.util.Arrays;

public class p_70129 {
	
	static int [] answer;
	
	static public int[] solution(String s) {
        answer = new int[2];
        
        while(s.length()>1) {
        	answer[0]++;
        	int n = removeZero(s);
        	s = decimalToBinary(n);
        }
        
        return answer;
    }
	
	static Integer removeZero(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='1') {
				sb.append(1);
			}
			else {
				answer[1]++;
			}
		}
		return sb.length();
	}
	
	static String decimalToBinary(int n) {
		StringBuilder sb = new StringBuilder();
		while(n>1) {
			sb.insert(0, n%2);
			n /= 2;
		}
		sb.insert(0, 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Arrays.toString(solution("110010101001")));
	}

}
