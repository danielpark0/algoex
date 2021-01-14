package fail;

import java.util.*;





// -------timeout--------





public class climbingtheleaderboard {
	
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
	    // Write your code here
	        List<Integer> returnList = new ArrayList<Integer>();
	        List<Integer> score = new ArrayList<Integer>();
	        for(int i = 0; i < ranked.size(); i++){
	            if(score.isEmpty()||score.get(score.size()-1)>ranked.get(i)){
	                score.add(ranked.get(i));
	            }
	            else{
	                System.out.println("aa"+ranked.get(i));
	            }
	        }
	        System.out.println(score.size());
	        for(int e : player){
	            boolean found = false;
	            for(int i = 0; i < score.size(); i++){
	                if(e>=score.get(i)){
	                    returnList.add(i+1);
	                    if(e>score.get(i)){
	                        score.add(i,e);
	                    }
	                    found = true;
	                    break;
	                }
	            }
	            if(!found){
	                score.add(e);
	                returnList.add(score.size());
	            }
	        }
	        return returnList;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
