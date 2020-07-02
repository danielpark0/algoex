import java.util.*;

public class p_43165 {
	
	static int answer;

	public static void main(String[] args) {
		
		int [] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers,target));
	}
	
	public static int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers,0,0,target);
        
        return answer;
    }
	
	static void dfs(int [] numbers, int curr, int sum, int target) {
		if(curr==numbers.length) {
			if(sum==target) {
				answer++;
			}
		}
		else {
			dfs(numbers,curr+1,sum+numbers[curr],target);
			dfs(numbers,curr+1,sum-numbers[curr],target);
		}
	}

}
