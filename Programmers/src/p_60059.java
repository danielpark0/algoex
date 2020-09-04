import java.util.*;

public class p_60059 {
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        for(int i = 0; i < 4; i++) {
        	for(int y = 0; y < lock.length+key.length+1; y++) {
        		for(int x = 0; x < lock.length+key.length+1; x++) {
        			int [][] t = new int [lock.length+key.length*2][lock.length+key.length*2];
        			
        			for(int q = 0; q < key.length; q++) {
        				for(int w = 0; w < key.length; w++) {
        					t[y+q][x+w] = key[q][w];
        				}
        			}
        			boolean skip = false;
        			for(int q = 0; q < lock.length; q++) {
        				for(int w = 0; w < lock.length; w++) {
        					if(t[key.length+q][key.length+w]==1&&lock[q][w]==1) {
        						skip = true;
        						break;
        					}
        					else if(t[key.length+q][key.length+w]==0) {
        						t[key.length+q][key.length+w] = lock[q][w];
        					}
        				}
        				if(skip) break;
        			}
        			
        			if(!skip) {
        				for(int q = 0; q < lock.length; q++) {
        					for(int w = 0; w < lock.length; w++) {
        						if(t[key.length+q][key.length+w]==0) {
        							skip = true;
        							break;
        						}
        						if(q == lock.length-1 && w == lock.length-1) {
        							return true;
        						}
        					}
        					if(skip) break;
        				}
        			}
        			
        		}
        	}
        	rotateKey(key);
        }
        
        return answer;
    }
	
	static void rotateKey(int [][] key) {
		int n = key.length;
		for(int i = 0; i < n/2; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int j = i; j < n-1-i; j++) {
				queue.add(key[j][i]);
			}
			for(int j = i; j < n-1-i; j++) {
				queue.add(key[n-1-i][j]);
			}
			for(int j = n-1-i; j> i; j--) {
				queue.add(key[j][n-1-i]);
			}
			for(int j = n-1-i; j> i; j--) {
				queue.add(key[i][j]);
			}
			
			for(int j = i; j < n-1-i; j++) {
				key[n-1-i][j] = queue.poll();
			}
			for(int j = n-1-i; j> i; j--) {
				key[j][n-1-i] = queue.poll();
			}
			for(int j = n-1-i; j> i; j--) {
				key[i][j] = queue.poll();
			}
			for(int j = i; j < n-1-i; j++) {
				key[j][i] = queue.poll();
			}
		}
	}

	public static void main(String[] args) {

		int [][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int [][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		//int [][] key = {{1,1,1,1},{1,0,1,0},{0,0,0,0},{0,0,0,0}};
		
		System.out.println(solution(key,lock));

	}

}
