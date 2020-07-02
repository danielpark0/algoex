
import java.util.*;

public class p_64061 {
    static int answer;
    
    public static void main(String[] args) {
    	int [][] board = {{0,0,0,0,0},
    					  {0,0,1,0,3},
    					  {0,2,5,0,1},
    					  {4,2,4,4,2},
    					  {3,5,1,3,1}};
    	int [] moves = {1,5,3,5,1,2,1,4};
    	
    	System.out.println(solution(board,moves));
    	
    }
    
    public static int solution(int[][] board, int[] moves) {
        answer = 0;
        
        ArrayList<Integer>  bas = new ArrayList<Integer>();
        
        for(int e : moves){
            int t = pick(board,e-1);
            if(t != -1){
                bas.add(t);
            }
            check(bas);
        }
        
        return answer;
    }
    
    
    static int pick(int [][] board, int n){
        int k = 0;
        while(k < board[n].length){
            if(board[k][n]!=0){
                int t = board[k][n];
                board[k][n] = 0;
                return t;
            }
            k++;
        }
        return -1;
    }
    
    static void check(ArrayList<Integer> bas){
        boolean stop;
        
        if(bas.size()<2) return;
        
        do{
        	stop = true;
            for(int i = 0; i < bas.size()-1; i++){
                if(bas.get(i)==bas.get(i+1)){
                    stop = false;
                    int j;
                    for(j = i+1; j < bas.size(); j++){
                        if(bas.get(i)!=bas.get(j)){
                            break;
                        }
                    }
                    for(int q = j; q > i; q--){
                        bas.remove(i);
                        answer++;
                    }
                    i -= 2;
                    if(i==-2) i = -1;
                }
            }
        }while(!stop);
    }
}