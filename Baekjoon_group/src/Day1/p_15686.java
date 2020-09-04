package Day1;

import java.util.*;

public class p_15686 {
	
	static int N, M;
	static int [][] map;
	static ArrayList<Pos> home;
	static ArrayList<Pos> chicken;
	
	static int answer;

	public static void main(String[] args) {
		
		answer = Integer.MAX_VALUE;

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int curr = sc.nextInt();
				if(curr==1) {
					home.add(new Pos(i,j));
				}
				else if(curr==2) {
					chicken.add(new Pos(i,j));
				}
			}
		}
		ArrayList<Pos> selected = new ArrayList<>();
		comb(selected,0);
		System.out.println(answer);
	}

	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public String toString() {
			return y +" "+ x;
		}
	}
	
	static void comb(ArrayList<Pos> selected, int n) {
		if(selected.size()==M) {
			checkDis(selected);
			return;
		}
		if(n >= chicken.size()) {
			return;
		}
		else {
			selected.add(new Pos(chicken.get(n).y,chicken.get(n).x));
			comb(selected,n+1);
			selected.remove(selected.size()-1);
			comb(selected,n+1);
		}
	}
	
	static void checkDis(ArrayList<Pos> selected) {
		int sum = 0;
		for(int i = 0; i < home.size(); i++) {
			int homey = home.get(i).y;
			int homex = home.get(i).x;
			int t = Math.abs(selected.get(0).y-homey)+Math.abs(selected.get(0).x-homex);
			for(int j = 1; j < selected.size(); j++) {
				int chiy = selected.get(j).y;
				int chix = selected.get(j).x;
				t = Math.min(t, Math.abs(chiy-homey)+Math.abs(chix-homex));
			}
			sum += t;
		}
		answer = Math.min(sum,answer);
	}
}


