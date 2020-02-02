import java.util.Set; 
import java.util.Random;
import java.util.HashSet; 
import java.math.BigInteger;
import java.util.List; 
import java.util.ArrayList; 

public class PrimeFactors {
	// one of the best algorithm for finding prime factors .
	public static Set<BigInteger> primeFactors(BigInteger number) {
		Set<BigInteger> factors = new HashSet<BigInteger>();
		while(number.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			factors.add(BigInteger.valueOf(2));
			number = number.divide(BigInteger.valueOf(2));
		}
		BigInteger nextprime = BigInteger.valueOf(3);
		while (nextprime.pow(2).compareTo(number) <= 0) {
			while (number.mod(nextprime).equals(BigInteger.ZERO)){
				factors.add(nextprime);
				number = number.divide(nextprime);
			}
			nextprime = nextprime.nextProbablePrime();
		}
		if (number.compareTo(BigInteger.ONE) > 0 ) {
			factors.add(number);
		}
		return factors;
	}
}