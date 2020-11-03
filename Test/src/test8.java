import java.util.*;
import java.io.*;

class test8 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int [] A = new int [N];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            for(int j = 0; j < N; j++){
                B -= A[j];
                if(B<0) break;
                answer++;
            }
            bw.write("Case #"+Integer.toString(t)+": "+Integer.toString(answer)+"\n");
        }
        bw.flush();
        bw.close();
        
    }
}
