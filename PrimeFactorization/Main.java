import java.util.Random; 
import java.math.BigInteger; 
import java.util.List; 
import java.util.ArrayList;

public class Main {
	public static BigInteger randomPrime() {
		BigInteger prime_number;
		do {
			prime_number = BigInteger.probablePrime(50, new Random());
		} while (!prime_number.isProbablePrime(1));
		return prime_number;
	}
	public static void main (String[] args) {
		System.out.println("We use the different algorithm for finding the prime Factors for" + 
			" Euler's function phi(prime)");
		// generate random prime number (40 bits)
		BigInteger prime = randomPrime();
		//calculate the phi(prime)
		BigInteger phi = prime.subtract(BigInteger.ONE);
		System.out.println("phi : " + phi + ", factors : " + PrimeFactors.primeFactors(phi));
		
	}
}