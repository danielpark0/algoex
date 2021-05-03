package kakao2021blind;

import java.util.*;

public class p_67258 {
	
	public int[] solution(String[] gems) {
        int[] answer = new int [2];
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        int cnt = 0;
        
        for(String s : gems) {
        	if(!map.containsKey(s)) {
        		System.out.println(s+" "+cnt);
        		map.put(s, cnt++);
        	}
        }
        
        int [] cntGems = new int [cnt];
        
        Set<Integer> set = new HashSet<>();
        
        boolean first = true;
        
        int front = 0;
        int back = 0;
        while(first||back!=cnt&&back<gems.length) {
        	while(set.size()<cnt&&back<gems.length) {
        		int curr = map.get(gems[back++]);
        		set.add(curr);
        		cntGems[curr]++;
        		if(back==cnt) break;
        	}
        	if(set.size()==cnt && (first || back-1-front < answer[1]-answer[0])) {
        		answer[0] = front;
        		answer[1] = back-1;
        		first = false;
        		System.out.println(front+" "+back);
        	}
        	while(set.size()==cnt) {
        		int curr = map.get(gems[front++]);
        		cntGems[curr]--;
        		if(cntGems[curr]==0) {
        			set.remove(curr);
        			break;
        		}
        		if(set.size()==cnt && (first || back-1-front < answer[1]-answer[0])) {
            		answer[0] = front;
            		answer[1] = back-1;
            		first = false;
            	}
        	}
        }
        answer[0]+=1;
        answer[1]+=1;
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
