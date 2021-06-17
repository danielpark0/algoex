import java.util.*;

public class p_77484 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        Set<Integer> set = new HashSet<Integer>();
        for(int e : win_nums)
            set.add(e);
        int hit = 0;
        int zero = 0;
        for(int e : lottos){
            if(e==0) zero++;
            else if(set.contains(e)) hit++;
        }
        if(hit+zero<2) {
        	answer[0] = answer[1] = 6;
        }
        else {
        	answer[0] = 7 - (hit + zero);
        	if(hit<2) answer[1] = 6;
        	else answer[1] = 7 - hit;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
