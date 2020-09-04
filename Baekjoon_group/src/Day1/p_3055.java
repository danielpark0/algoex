package Day1;

import java.util.*;

import java.io.*;

public class p_3055 {
	
	//       			좌,우,위,아래
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0,0,-1,1};
	
	static int R, C;
	static char [][] map;
	static int [][] dp;
	
	static Queue<Point> queue;
	
	static boolean foundAnswer;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char [R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();
		
		List<Point> waterList = new ArrayList<>();
		for(int r = 0; r < R; r++) {
			String s = sc.next();
			for(int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
				if(map[r][c] == 'S') {
					queue.add(new Point(r,c,'S'));
				}
				else if(map[r][c] == '*') {
					waterList.add(new Point(r,c,'*'));
				}
			}
		}
		
		queue.addAll(waterList);
		
		while(!queue.isEmpty()) {
//			1. 큐에서 꺼내옴
			Point p = queue.poll();
//			2. 목적지인가? if(p == D)
			if(p.type == 'D') {
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true;
				break;
			}
//			3. 갈 수 있는 곳을 순회 for(좌, 우, 위, 아래)
			for(int i = 0; i < 4; i++) {
				int ty = p.y + dy[i];
				int tx = p.x + dx[i];
//				4. 갈 수 있는가? if(맵을 벗어나지 않고, X가 아니고, * 아니고)
				if(ty >= 0 && ty < R && tx >= 0 && tx < C) {
					if(p.type == '.' || p.type == 'S') {
						if(dp[ty][tx]==0 && checkSafe(ty, tx)) {
							dp[ty][tx] = dp[p.y][p.x]+1;
							queue.add(new Point(ty,tx,map[ty][tx]));
						}
					}
					else if (p.type == '*' && map[ty][tx] == '.') {
						queue.add(new Point(ty,tx,'*'));
						map[ty][tx] = '*';
					}
				}
//				5. 체크인 dp[r][c] = time
//				6. 큐에 넣음 queue.add(next)
			}
		}
		
		if(!foundAnswer){
			System.out.println("KAKTUS");
		}

	}
	
// X가 아니고, *아니고 체크 
	static boolean checkSafe(int y, int x) {
		if(map[y][x]=='D') {
			return true;
		}
		else if(map[y][x]=='.') {
			for(int i = 0; i < 4; i++) {
				int ty = y + dy[i];
				int tx = x + dx[i];
				if(ty >= 0 && ty < R && tx >= 0 && tx < C && map[ty][tx] == '*') {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}

}

class Point{
	int y;
	int x;
	char type;
	
	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}
	@Override
	public String toString() {
		return y+" "+x+" "+type;
	}
}
