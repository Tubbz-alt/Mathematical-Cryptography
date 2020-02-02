import java.util.Random; 
import java.math.BigInteger; 
import java.util.List; 
import java.util.ArrayList;

public class Main {
	public static BigInteger randomPrime() {
		BigInteger prime_number;
		do {
			prime_number = BigInteger.probablePrime(25, new Random());
		} while (!prime_number.isProbablePrime(1));
		return prime_number;
	}
	public static void main (String[] args) {
		
		// generate random prime number (40 bits)
		BigInteger prime = randomPrime();
		// find the primitive root of Group on number prime
		BigInteger generator = PrimitveRootSearch.primitiveRoot(prime);
		System.out.println("{ prime number : " + prime + ", generator : " + generator + " }");
		
	}
}