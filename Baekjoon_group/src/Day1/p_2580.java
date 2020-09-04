package Day1;

import java.util.*;
import java.io.*;

public class p_2580 {

	static int [][] sudoku;
	static ArrayList<Pos> empty;
	
	static boolean go;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int [9][9];
		
		empty = new ArrayList<Pos>();
		
		go = true;
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j]==0) {
					empty.add(new Pos(i,j));
				}
			}
		}
		
		DFS(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	static void DFS(int ind) {
		if(go) {
			if(ind == empty.size()) {
				go = false;
			}
			else{
				int curr_y = empty.get(ind).y;
				int curr_x = empty.get(ind).x;
				for(int i = 1; i < 10; i++) {
					if(check(curr_y,curr_x,i)) {
						sudoku[curr_y][curr_x] = i;
						DFS(ind+1);
						if(go)
							sudoku[curr_y][curr_x] = 0;
					}
				}
			}
		}
	}
	
	static boolean check(int y, int x, int n) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[y][i]==n) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][x]==n) {
				return false;
			}
		}
		for(int i = y/3*3; i < y/3*3+3; i++) {
			for(int j = x/3*3; j < x/3*3+3; j++) {
				if(sudoku[i][j]==n) {
					return false;
				}
			}
		}
		return true;
	}

}

class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
	public String toString() {
		return y +" "+ x;
	}
}
