package warmup;

public class timeconversion {

	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */

		String answer = "";

		String [] t = s.split(":");

		if(t[2].substring(2,4).equals("AM")) {
			if(Integer.parseInt(t[0])==12) {
				answer = "00:"+t[1]+":"+t[2].substring(0,2);
			}
			else {
				answer = s.substring(0,8);
			}
		}
		else {
			if(Integer.parseInt(t[0])==12) {
				answer = s.substring(0,8);
			}
			else {
				answer = Integer.parseInt(t[0])+12+":"+t[1]+":"+t[2].substring(0,2);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
