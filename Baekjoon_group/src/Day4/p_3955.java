package Day4;

import java.util.*;

import java.io.*;

public class p_3955 {

	static int N, A, B;
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// X : 인당 나눠줄 사탕의 수
		// Y : 사탕 봉지의 수
		// A * x+1 = B+y
		//Ax + By = C의 형태로 변환.
		//-Ax + By = 1

		for(int i = 0; i < N; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			
			System.out.println(A+" "+B);
			
			ExtendedGcdResult result= eGcd(-A,B);
			
			//D = gcd(A,B);
			//Ax + By = C 일때 C % D == 0 이여야만 해를 가질 수 있다. : 배주의 항등식
			if(Math.abs(result.r)!=1) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				//x0=s*C/D;
				//y0=t*C/D;
				long x = result.s*1 / result.r;
				long y = result.t*1 / result.r;
				
				//x = x0 + B / D*k
				//y = y0 - A / D*k
				while(y <= 0 || x <=0) {
					x += B;
					y -= -A;
					if(y > 1e9) {
						break;
					}
				}
				
				//*범위를 이용하여 k를 유도
				
				/*
				 * x < 0
				 * x + B*k < 0
				 * k < -x/B
				 * 
				 * 0 < y <= le9
				 * 0 < y - A*k <= 1e9
				 * -y < -A * k <= 1e9 - y
				 * (y-1e9) / A <= k < y/A
				 * 
				 * k < -x/B
				 * (y-1e9)/A <= k < y/A
				 */
				
//				long kFromY = (long) Math.ceil((double) y / (double) A);
//				long kFromX = (long) Math.ceil((double) -x / (double) B);
//				long k = Math.min(kFromX, kFromY) - 1;
//				y -= A*k;
//				
//				if(y>1e9) {
//					System.out.println("IMPOSSIBLE");
//				}
//				else {
//					System.out.println(y);
//				}
				
				
				if(y > 1e9) {
					System.out.println("IMPOSSIBLE");
				}
				else {
					System.out.println(y);
				}
			}
		}

	}
	
	static ExtendedGcdResult eGcd(long a, long b) {
		long s0 = 1, t0 = 0, r0 = a;
		long s1 = 0, t1 = 1, r1 = b;
		
		long temp;
		while(r1 != 0) {
			long q = r0/r1;
			
			temp = r0 - r1*q;
			r0 = r1;
			r1 = temp;
			
			temp = s0 - s1*q;
			s0 = s1;
			s1 = temp;
			
			temp = t0 - t1*q;
			t0 = t1;
			t1 = temp;
		}
		return new ExtendedGcdResult(s0,t0,r0);
	}

}

class ExtendedGcdResult{
	long s;
	long t;
	long r;
	
	public ExtendedGcdResult(long s, long t, long r) {
		super();
		this.s = s;
		this.t = t;
		this.r = r;
	}
	
	@Override
	public String toString() {
		return "ExtendedGcdResult [s=" + s + ", t=" + t + ", r=" + r + "]";
	}
	
}