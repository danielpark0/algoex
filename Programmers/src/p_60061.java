import java.util.*;

public class p_60061 {
	
	public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        
        boolean [][] pillar = new boolean [n+3][n+3];
        boolean [][] floor = new boolean [n+3][n+3];
        
        for(int i = 0; i < build_frame.length; i++) {
        	int x = build_frame[i][0];
        	int y = build_frame[i][1];
        	int a = build_frame[i][2];
        	int b = build_frame[i][3];
        	if(a==0) { //기둥
        		if(b==1) { //설치
        			if(y==0||(x-1>=0&&floor[y][x-1])||floor[y][x]||pillar[y-1][x]) {
        				pillar[y][x] = true;
        			}
        		}
        		else { //삭제
        			if((x-1>=0&&floor[y+1][x-1]&&!pillar[y][x-1]&&(x-2<0||!floor[y+1][x-2]||!floor[y+1][x]))
        					||(floor[y+1][x]&&!pillar[y][x+1]&&(x-1<0||!floor[y+1][x-1]||!floor[y+1][x+1]))
        					||(pillar[y+1][x]&&(x-1<0||!floor[y+1][x-1])&&!floor[y+1][x])) {
        				
        			}
        			else {
        				pillar[y][x] = false;
        			}
        		}
        	}
        	else { //보
        		if(b==1) { //설치
        			if(pillar[y-1][x]||pillar[y-1][x+1]||(x-1>=0&&floor[y][x-1]&&floor[y][x+1])) {
        				floor[y][x] = true;
        			}
        		}
        		else { //삭제
        			if((x-1>=0&&floor[y][x-1]&&!pillar[y-1][x-1]&&!pillar[y-1][x])
        					||(floor[y][x+1]&&!pillar[y-1][x+1]&&!pillar[y-1][x+2])
        					||(pillar[y][x]&&!pillar[y-1][x]&&(x-1<0||!floor[y][x-1]))
        					||(pillar[y][x+1]&&pillar[y-1][x+1]&&!floor[y][x+1])) {
        				
        			}
        			else {
        				floor[y][x] = false;
        			}
        		}
        	}
        }
        
        PriorityQueue<BuildInfo> pq = new PriorityQueue<>();
        
        for(int i = 0; i <= n; i++) {
        	for(int j = 0; j <= n; j++) {
        		if(pillar[i][j]) {
        			pq.add(new BuildInfo(j,i,0));
        		}
        		if(floor[i][j]) {
        	        pq.add(new BuildInfo(j,i,1));
        		}
        	}
        }
       
        answer = new int [pq.size()][3];
        
        int t = pq.size();
        
        for(int i = 0; i < t; i++) {
        	BuildInfo info = pq.poll();
        	answer[i][0] = info.x;
        	answer[i][1] = info.y;
        	answer[i][2] = info.a;
        	//System.out.println(info.x+" "+info.y+" "+info.a);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		int n = 5;
		int [][]build_frame = {{1,0,0,1},
							   {1,1,1,1},
							   {2,1,0,1},
							   {2,2,1,1},
							   {5,0,0,1},
							   {5,1,0,1},
							   {4,2,1,1},
							   {3,2,1,1}};

		solution(n, build_frame);
		
	}

}

class BuildInfo implements Comparable<BuildInfo>{
	int x;
	int y;
	int a;
	public BuildInfo(int x, int y, int a) {
		this.x = x;
		this.y = y;
		this.a = a;
	}
	public String toString() {
		return x+" "+y+" "+a;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getA() {
		return a;
	}
	@Override
	public int compareTo(BuildInfo o) {
		if(o.x>this.x) {
			return -1;
		}
		else if(o.x<this.x) {
			return 1;
		}
		else {
			if(o.y>this.y) {
				return -1;
			}
			else if(o.y<this.y) {
				return 1;
			}
			else {
				if(o.a>this.a) {
					return -1;
				}
				else if(o.a<this.a) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
	}
}
