import java.util.*;

public class p_62048 {

	public static void main(String[] args) {

		System.out.println(solution(8,12));

	}

	public static long solution(int w, int h) {
		long answer = (long) w*h;

		for(int i = 1; i <= w; i++) {
			long l = (long) h*(i-1)/w;
			long r;
			if((long)h*i%w==0) {
				r = (long) h*i/w;
			}
			else {
				r = (long) h*i/w+1;
			}
			answer -= r-l;
		}

		return answer;
	}

}
