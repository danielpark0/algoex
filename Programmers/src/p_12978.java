import java.util.*;

public class p_12978 {
	
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int INF = 100000000;

        int [][] l = new int [N+1][N+1];
        
        int [] D = new int [N+1];
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		l[i][j] = INF;
        	}
        }
        
        for(int i = 0; i < road.length; i++) {
        	if(l[road[i][0]][road[i][1]]>road[i][2]){
                l[road[i][0]][road[i][1]] = road[i][2];
                l[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        
        for(int i = 2; i <= N; i++) {
        	D[i] = INF;
        }
        
        PriorityQueue<Dis> pq = new PriorityQueue<>(Comparator.comparingInt(Dis::getD));
        
        for(int i = 2; i <= N; i++) {
        	if(l[1][i]<INF) {
        		pq.add(new Dis(i,l[1][i]));
        		D[i] = l[1][i];
        	}
        }
        
        while(!pq.isEmpty()) {
        	Dis curr = pq.poll();
        	if(D[curr.dest]<curr.d) continue;
        	System.out.println(curr.dest+" "+curr.d);
        	D[curr.dest] = curr.d;
        	for(int i = 1; i <= N; i++) {
        		if(l[curr.dest][i]!=INF) {
        			pq.add(new Dis(i,curr.d+l[curr.dest][i]));
        		}
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	if(D[i]<=K) answer++;
        }

        return answer;
    }

	public static void main(String[] args) {
		
		
		int [][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		
		
		System.out.println(solution(5,road,3));

	}

}

class Dis{
	int dest;
	int d;
	public Dis(int dest, int d) {
		this.dest = dest;
		this.d = d;
	}
	public int getD() {
		return d;
	}	
}
