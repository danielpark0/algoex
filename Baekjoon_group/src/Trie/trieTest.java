package Trie;

public class trieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Trie{
	TrieNode root = new TrieNode();
	
	void insert(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'A';
			if(current.hasChild(c)==false) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isEnd = true;
	}
	
	boolean checkWord(String word) {
		TrieNode current = root;
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
}

class TrieNode{
	TrieNode [] children = new TrieNode[26];
	boolean isEnd;
	
	TrieNode getChild(char c) {
		return children[c-'A'];
	}
	
	boolean hasChild(char c) {
		return children[c-'A'] != null;
	}
}
