package warmup;

import java.util.*;

public class birthdaycakecandles {

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here
		Collections.sort(candles);
		int cnt = -1;
		// for(int i = candles.size()-2; i >= 0; i--){
		//     if(candles.get(i)!=candles.get(candles.size()-1)){
		//         break;
		//     }
		//     cnt++;
		// }
		int max = 0;
		for(int e : candles){
			if(e > max){
				max = e;
				cnt = 1;
			}
			else if(e == max){
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
