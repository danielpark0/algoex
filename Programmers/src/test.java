import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long N = Long.parseLong(st.nextToken());
			Long M = Long.parseLong(st.nextToken());
			System.out.println(N+M);
		}
	}
}