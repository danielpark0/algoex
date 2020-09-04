package GCD;

public class gcd_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return Math.abs(a);
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