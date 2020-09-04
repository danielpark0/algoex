package Day3;

import java.util.*;
import java.io.*;

public class p_9202 {

	static int [] dy = {0,1,1,1,0,-1,-1,-1};
	static int [] dx = {1,1,0,-1,-1,-1,0,1};

	static int w;
	static int b;

	static Trie dic;

	static int score;
	static String word;
	static int count;

	static StringBuilder sb;

	static char [][] board;

	static boolean [][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		w = Integer.parseInt(br.readLine());

		dic = new Trie();

		for(int i = 0; i < w; i++) {
			dic.insertWord(br.readLine());
		}

		br.readLine();

		b = Integer.parseInt(br.readLine());
		for(int i = 0; i < b; i++) {
			board = new char [4][4];
			for(int j = 0; j < 4; j++) {
				String s = br.readLine();
				for(int k = 0; k < 4; k++) {
					board[j][k] = s.charAt(k);
				}
			}
			//			for(char [] e: board)
			//				System.out.println(Arrays.toString(e));
			boggle();
			dic.root.clearHit();
			System.out.println(score+" "+word+" "+count);
			if(i!=b-1)
				br.readLine();
		}
	}

	static void boggle() {
		count = 0;
		score = 0;
		word = "";
		sb = new StringBuilder();
		visited = new boolean[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(dic.root.children[board[i][j]-'A']!=null) {
					dfs(i,j,dic.root.children[board[i][j]-'A']);
				}
			}
		}
	}

	static void dfs(int i, int j, TrieNode tn) {
		sb.append(board[i][j]);
		visited[i][j] = true;

		if(tn.isEnd) {
			if(tn.isHit) {

			}
			else {
				String s = sb.toString();
				if(s.length()<3) {

				}
				else if(s.length()<5) {
					score += 1;
				}
				else if(s.length()<6) {
					score += 2;
				}
				else if(s.length()<7) {
					score += 3;
				}
				else if(s.length()<8) {
					score += 5;
				}
				else {
					score += 11;
				}
				tn.isHit = true;
				count++;
				if(word.length()==0||word.length()<=s.length()) {
					if(word.length()==s.length()) {
						if(word.compareTo(s)>0) {
							word = s;
						}
					}
					else {
						word = s;
					}
				}
			}
		}
		for(int q = 0; q < 8; q++) {
			int ty = i+dy[q];
			int tx = j+dx[q];
			if(ty<0||ty>=4||tx<0||tx>=4||visited[ty][tx]||tn.children[board[ty][tx]-'A']==null) {

			}
			else {
				dfs(ty,tx,tn.children[board[ty][tx]-'A']);
			}
		}

		sb.deleteCharAt(sb.length()-1);
		visited[i][j] = false;
	}

}



class Trie{

	TrieNode root = new TrieNode();

	void insertWord(String s) {
		TrieNode curr = root;
		for(int i = 0; i < s.length(); i++) {
			if(curr.children[s.charAt(i)-'A']==null) {
				curr.children[s.charAt(i)-'A'] = new TrieNode();
			}
			curr = curr.children[s.charAt(i)-'A'];
		}
		curr.isEnd = true;
	}

	boolean checkWord(String s) {
		TrieNode curr = root;
		for(int i = 0; i < s.length(); i++) {
			if(curr.children[s.charAt(i)-'A']==null) {
				return false;
			}
			curr = curr.children[s.charAt(i)-'A'];
		}
		return true;
	}

}

class TrieNode{
	TrieNode [] children = new TrieNode[26];
	boolean isEnd;
	boolean isHit;

	void clearHit() {
		isHit = false;
		for(int i = 0; i < 26; i++) {
			if(children[i]!=null) {
				children[i].clearHit();
			}
		}
	}
}
