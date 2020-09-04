import java.util.*;

public class p_42884 {
	
	static public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]) {
					return -1;
				}
				else if(o1[1]>o2[1]) {
					return 1;
				}
				else {
					if(o1[0]<o2[0]) {
						return -1;
					}
					else if(o1[0]>o2[0]) {
						return 1;
					}
					else {
						return 0;
					}
				}
			}
        	
        });

        int curr = routes[0][1];
        answer++;
        
        for(int i = 1; i < routes.length; i++) {
        	if(routes[i][0]>curr) {
        		curr = routes[i][1];
        		answer++;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		int [][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};

		System.out.println(solution(routes));

	}

}
