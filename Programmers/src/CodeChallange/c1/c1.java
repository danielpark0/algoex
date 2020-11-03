package CodeChallange.c1;

class c1 {
    public int[] solution(int n) {
        int max = n*(1+n)/2;
        
        int[] answer = new int [max];
        
        int curr = 0;
        int num = 1;
        int depth = 1;
        int l = n-1;
        int b = n-1;
        int r = n-2;
        int m = 2;
        
        answer[0] = 1;
        
        while(num<=max){
            for(int i = 0; i < l; i++){
                curr += depth;
                num++;
                depth++;
                answer[curr]  = num;
                if(num==max) break;
            }
                if(num==max) break;
            for(int i = 0; i < b; i++){
                answer[++curr]  = ++num;
                if(num==max) break;
            }
                if(num==max) break;
            for(int i = 0; i < r; i++){
                curr -= depth;
                num++;
                depth--;
                answer[curr] = num;
                if(num==max) break;
            }
                if(num==max) break;
            l -= m;
            b -= m+1;
            r -= m+1;
            m++;
        }
        
        return answer;
    }
}