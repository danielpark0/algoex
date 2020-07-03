import java.util.*;

class Node{
	int num;
	int dis;
	public Node(int num, int dis) {
		this.num = num;
		this.dis = dis;
	}
}

public class p_49189_1 {

	public static void main(String[] args) {
		int [][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6,vertex));
	}

	public static int solution(int n, int [][] edge) {
		int answer = 0;

		boolean [][] e = new boolean [n+1][n+1];

		for(int i = 0; i < edge.length; i++) {
			e[edge[i][0]][edge[i][1]] = true;
			e[edge[i][1]][edge[i][0]] = true;
		}

		int [] d = new int [n+1];

		Queue<Node> queue = new LinkedList<Node>();

		for(int i = 2; i <= n; i++) {
			d[i] = 0;
		}

		queue.add(new Node(1,0));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			for(int i = 2; i <= n; i++) {
				if(d[i]==0) {
					if(e[curr.num][i]) {
						queue.add(new Node(i,curr.dis+1));
						d[i] = curr.dis+1;
					}
				}
			}
		}
		
		Arrays.sort(d);
		
		for(int i = n; i > 1; i--) {
			if(d[n]!=d[i]) {
				break;
			}
			answer++;
		}

		return answer;
	}

}
