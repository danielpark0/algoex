import java.util.*;

public class test5 {
	
	static int N;
	
	static ArrayList<Integer> [] board;

	public static void main(String[] args) {

		N = 6;
		
		board = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			board[i] = new ArrayList<>();
			for(int j = 1; j <= 7; j++) {
				board[i].add(j);
			}
		}
		
		rotate(2,0,1);
		print();
		rotate(3,1,3);
		print();
	}
	
	static void print() {
		for(int i = 1; i <= N; i++) {
			System.out.println(board[i].toString());
		}
		System.out.println();
	}
	
	static void rotate(int x, int d, int k) {
		for(int i = 1; i <= N; i++) {
			if(i%x==0) {
				//				System.out.println(i);
				if(d==0) {
					for(int j = 0; j < k; j++) {
						int t = board[i].remove(board[i].size()-1);
						board[i].add(0,t);
					}
				}
				else {
					for(int j = 0; j < k; j++) {
						int t = board[i].remove(0);
						board[i].add(t);
					}
				}
			}
		}
	}

}
