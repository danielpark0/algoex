package m2;

public class s2 {
	
	static int [] answer;
	
	public int[] solution(int[][] arr) {
        answer = new int [2];
        
        int l = arr.length;
        
        
        
        return answer;
    }
	
	static void comp(int [][] arr, int y, int x, int l) {
		int s = arr[y][x];
		for(int i = y; i < y+l; i++) {
			for(int j = x; j < x+l; j++) {
				if(arr[i][j]!=s) {
					if(l==1) {
						answer[s]++;
					}
					else {
						comp(arr,y,x,l/2);
						comp(arr,y+l/2,x,l/2);
						comp(arr,y,x+l/2,l/2);
						comp(arr,y+l/2,x+l/2,l/2);
					}
					return;
				}
			}
		}
		answer[s]++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
