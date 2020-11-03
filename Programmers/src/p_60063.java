import java.util.*;

public class p_60063 {
	
	static int N;
	
	static int answer;
	
	static int [] hdy1 = {-1,0,1,0,1,0,0,-1};
	static int [] hdx1 = {0,1,0,-1,1,0,0,1};
	static int [] hdy2 = {-1,0,1,0,0,1,-1,0};
	static int [] hdx2 = {0,1,0,-1,0,-1,-1,0};
	
	static int [] vdy1 = {-1,0,1,0,1,0,1,0};
	static int [] vdx1 = {0,1,0,-1,1,0,-1,0};
	static int [] vdy2 = {-1,0,1,0,0,-1,0,-1};
	static int [] vdx2 = {0,1,0,-1,0,1,0,-1};
	
	static boolean [][][] visited;
	
	public static int solution(int[][] board) {
        answer = 0;
        
        N = board.length;
    	
    	visited = new boolean [N][N][2];
        
        Queue<Pos> queue = new LinkedList<>();
        
        queue.add(new Pos(0,0,0,1,0));
        
        while(!queue.isEmpty()) {
        	Pos curr = queue.poll();
        	//System.out.println(curr);
        	if((curr.x1==N-1&&curr.y1==N-1)||(curr.x2==N-1&&curr.y2==N-1)) {
        		answer = curr.d;
        		break;
        	}
        	Pos next = null;
        	if(curr.y1==curr.y2) {
        		for(int i = 0; i < 8; i++) {
        			if(hor(curr,i,board)) {
        				next = movehor(curr,i);
        	        	queue.add(next);
        			}
        		}
        	}
        	else {
        		for(int i = 0; i < 8; i++) {
        			if(ver(curr,i,board)) {
        				next = movever(curr,i);
        	        	queue.add(next);
        			}
        		}
        	}
        }
        
        return answer;
    }
	
	static boolean hor(Pos curr, int n, int [][] board) {
		int ty1 = curr.y1+hdy1[n];
		int tx1 = Math.min(curr.x1, curr.x2)+hdx1[n];
		int ty2 = curr.y2+hdy2[n];
		int tx2 = Math.max(curr.x1, curr.x2)+hdx2[n];
		if(ty1<0||ty1>=N||tx1<0||tx1>=N||tx2<0||tx2>=N||ty2<0||ty2>=N||board[ty1][tx1]==1||board[ty2][tx2]==1) {
			return false;
		}
		if(ty1==ty2) {
			if(visited[ty1][Math.min(tx1, tx2)][0])
				return false;
		}
		if(tx1==tx2) {
			if(visited[Math.min(ty1, ty2)][tx1][1])
				return false;
		}
		if(n==4||n==7) {
			if(board[ty1][tx1-1]==1) {
				return false;
			}
		}
		else if(n==5||n==6) {
			if(board[ty2][tx2+1]==1) {
				return false;
			}
		}
		return true;
	}
	
	static boolean ver(Pos curr, int n, int [][] board) {
		int ty1 = Math.min(curr.y1, curr.y2)+vdy1[n];
		int tx1 = curr.x1+vdx1[n];
		int ty2 = Math.max(curr.y1, curr.y2)+vdy2[n];
		int tx2 = curr.x2+vdx2[n];
		if(ty1<0||ty1>=N||tx1<0||tx1>=N||tx2<0||tx2>=N||ty2<0||ty2>=N||board[ty1][tx1]==1||board[ty2][tx2]==1) {
			return false;
		}
		if(ty1==ty2) {
			if(visited[ty1][Math.min(tx1, tx2)][0])
				return false;
		}
		if(tx1==tx2) {
			if(visited[Math.min(ty1, ty2)][tx1][1])
				return false;
		}
		if(n==4||n==6) {
			if(board[ty1-1][tx1]==1) {
				return false;
			}
		}
		else if(n==5||n==7) {
			if(board[ty2+1][tx2]==1) {
				return false;
			}
		}
		return true;
	}
	
	static Pos movehor(Pos curr, int n) {
		int ty1 = curr.y1+hdy1[n];
		int tx1 = Math.min(curr.x1, curr.x2)+hdx1[n];
		int ty2 = curr.y2+hdy2[n];
		int tx2 = Math.max(curr.x1, curr.x2)+hdx2[n];
		visit(ty1,tx1,ty2,tx2);
		return new Pos(ty1,tx1,ty2,tx2,curr.d+1);
	}
	
	static Pos movever(Pos curr, int n) {
		int ty1 = Math.min(curr.y1, curr.y2)+vdy1[n];
		int tx1 = curr.x1+vdx1[n];
		int ty2 = Math.max(curr.y1, curr.y2)+vdy2[n];
		int tx2 = curr.x2+vdx2[n];
		visit(ty1,tx1,ty2,tx2);
		return new Pos(ty1,tx1,ty2,tx2,curr.d+1);
	}
	
	static void visit(int ty1,int tx1,int ty2,int tx2) {
		if(ty1==ty2) {
			visited[ty1][Math.min(tx1, tx2)][0] = true;
		}
		else {
			visited[Math.min(ty1, ty2)][tx1][1] = true;
		}
	}

	public static void main(String[] args) {

		int [][] board = {{0, 0, 0, 1, 1},
						 {0, 0, 0, 1, 0},
						 {0, 1, 0, 1, 1},
						 {1, 1, 0, 0, 1},
						 {0, 0, 0, 0, 0}};
		
		System.out.println(solution(board));
		
	}

}

class Pos{
	int y1;
	int x1;
	int y2;
	int x2;
	int d;
	public Pos(int y1, int x1, int y2, int x2, int d) {
		super();
		this.y1 = y1;
		this.x1 = x1;
		this.y2 = y2;
		this.x2 = x2;
		this.d = d;
	}
	public String toString() {
		return y1+" "+x1+" "+y2+" "+x2+" | "+d;
	}
}
