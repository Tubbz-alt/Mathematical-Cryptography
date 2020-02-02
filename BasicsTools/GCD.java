public class GCD {
	public static BigInteger recursiveGcd(BigInteger a, BigInteger b){
		if (b.equals(BigInteger.ZERO))
			return a;
		return recursiveGcd(b, a.mod(b));
	}
}