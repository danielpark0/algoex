
public class p_81301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String s) {
		int answer = 0;

		String num = "";

		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9) {
				num += s.charAt(i);
			}
			else if(s.charAt(i)=='z') {
				num += 0;
				i+=3;
			}
			else if(s.charAt(i)=='o') {
				num += 1;
				i+=2;
			}
			else if(s.charAt(i)=='t') {
				if(s.charAt(i+1)=='w') {
					num += 2;
					i+=2;
				}
				else {
					num += 3;
					i+=4;
				}
			}
			else if(s.charAt(i)=='f') {
				if(s.charAt(i+1)=='o') {
					num += 4;
					i+=3;
				}
				else {
					num += 5;
					i+=3;
				}
			}
			else if(s.charAt(i)=='s') {
				if(s.charAt(i+1)=='i') {
					num += 6;
					i+=2;
				}
				else {
					num += 7;
					i+=4;
				}
			}
			else if(s.charAt(i)=='e') {
				num += 8;
				i+=4;
			}
			else if(s.charAt(i)=='n') {
				num += 9;
				i+=3;
			}
		}
		
		answer = Integer.parseInt(num);

		return answer;
	}

}
