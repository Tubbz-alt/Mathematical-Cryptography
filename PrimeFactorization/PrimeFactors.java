import java.util.Set; 
import java.util.Random;
import java.util.HashSet; 
import java.math.BigInteger;
public class PrimeFactors {
	//simple algorithm for finding prime factorization of number.
	public static Set<BigInteger> primeFactorsV1(BigInteger number) {
		Set<BigInteger> factors = new HashSet<BigInteger>();
		while(number.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			factors.add(BigInteger.valueOf(2));
			number = number.divide(BigInteger.valueOf(2));
		}
		for (int i = 3; BigInteger.valueOf(i*i).compareTo(number) <= 0; i+=2) {
			while(number.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
				factors.add(BigInteger.valueOf(i));
				number = number.divide(BigInteger.valueOf(i));
			}
		}
		if (number.compareTo(BigInteger.ONE) > 0) {
			factors.add(number);
		}
		return factors;
	}
	public static Set<BigInteger> primeFactorsV2(BigInteger number) {
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


	public static void main(String[] args) { 
		System.out.println("this is sample");
		BigInteger prime; 
		do {
			prime = BigInteger.probablePrime(40, new Random());
		} while (!prime.isProbablePrime(1));
		//BigInteger number = new BigInteger("840759203630041");
		BigInteger phi = prime.subtract(BigInteger.ONE);
		System.out.println("this is prime number : " + prime);
		System.out.println("prime factors in f1 : " + primeFactorsV2(phi));
	}
}