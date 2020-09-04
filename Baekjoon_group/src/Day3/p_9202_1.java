package Day3;

import java.util.*;
import java.io.*;

public class p_9202_1 {
	
	static int [] dy = {0,1,1,1,0,-1,-1,-1};
	static int [] dx = {1,1,0,-1,-1,-1,0,1};

	static int w;
	static int b;
	
	static Triee dic;
	
	static char map [][];
	static boolean visited [][];
	
	static StringBuilder sb;
	
	static int sum;
	static String answer;
	static int count;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		w = Integer.parseInt(br.readLine());
		
		dic = new Triee();
		
		for(int i = 0; i < w; i++) {
			dic.insert(br.readLine());
		}
		br.readLine();
		
		b = Integer.parseInt(br.readLine());
		for(int i = 0; i < b; i++) {
			map = new char[4][4];
			visited = new boolean[4][4];
			answer = "";
			sum = 0;
			count = 0;
			sb = new StringBuilder();
			for(int j = 0; j < 4; j++) {
				String in = br.readLine();
				for(int k = 0; k < 4; k++) {
					map[i][j] = in.charAt(k);
				}
			}
			
			for(int j = 0; j < 4; j++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			for(int y = 0; y < 4; y++) {
				for(int x = 0; x < 4; x++) {
					if(dic.root.hasChild(map[y][x])) {
						dfs(y,x,1,dic.root.getChild(map[y][x]));
					}
				}
			}
			dic.root.clearHit();
			
			if(i!=b-1)
				br.readLine();
		}
	}

	static void dfs(int y, int x, int length, TrieeNode node) {
		//1.체크인
		visited[y][x] = true;
		sb.append(map[y][x]);
		//2.목적지인가?
		if(node.isEnd==true && node.isHit==false) {
			//목적지 처리
			 
		}
		//3.갏수있는 곳을 순회
		for(int i = 0; i < 8; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			//4.갈수있는가?
			if(0<=ty && ty<4 && 0<=tx && tx<=4) {
				if(visited[ty][tx]==false && node.hasChild(map[ty][tx])) {
					//5.간다
					dfs(ty,tx,length+1,node.getChild(map[ty][tx]));
				}
			}
		}
		//6.체크아웃
		visited[y][x] = false;
		sb.deleteCharAt(length-1);
	}
	
}


class Triee {
	TrieeNode root = new TrieeNode();
	
	void insert(String word) {
		TrieeNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'A';
			if(current.hasChild(c)==false) {
				current.children[index] = new TrieeNode();
			}
			current = current.children[index];
		}
		current.isEnd = true;
	}
	
	boolean checkWord(String word) {
		TrieeNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(current.hasChild(c)) {
				current = current.getChild(c);
			}
			else {
				return false;
			}
		}
		return current.isEnd;
	}
	
	boolean checkWord_board(char[][]board,int y, int x) {
		TrieeNode current = root;
		char c = board[y][x];
		while(true) {
			
		}
	}
}

class TrieeNode{
	TrieeNode [] children = new TrieeNode[26];
	boolean isEnd;
	boolean isHit;
	
	void clearHit() {
		isHit = false;
		for(int i = 0; i < children.length; i++) {
			if(children[i] != null) {
				children[i].clearHit();
			}
		}
	}
	
	TrieeNode getChild(char c) {
		return children[c-'A'];
	}
	
	boolean hasChild(char c) {
		return children[c-'A'] != null;
	}
}
