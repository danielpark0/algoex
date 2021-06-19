
public class p_81301_1 {

	public static void main(String[] args) {

		System.out.println(solution("one4seveneight"));
	}

	public static int solution(String s) {
		
		String [] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		for(int i = 0; i < 10; i++) {
			s = s.replaceAll(num[i], i+"");
		}
		
		return Integer.parseInt(s);

	}

}
