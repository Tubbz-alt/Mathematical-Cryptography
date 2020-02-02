

import java.math.*;
import java.util.*;
public class PrimitveRootSearch {
	public static Boolean checkPrimitive(BigInteger number, Set<BigInteger> factors,
		BigInteger phi, BigInteger prime) {
		for (BigInteger i : factors)
			if (number.modPow(phi.divide(i), prime).equals(BigInteger.ONE))
				return false;
		return true; 
	}
	public static BigInteger primitiveRoot(BigInteger prime) {
		BigInteger phi = prime.subtract(BigInteger.ONE);
		Set<BigInteger> primeFactors = PrimeFactors.primeFactors(phi);
		BigInteger generator = BigInteger.ONE;
		do {
			generator = generator.add(BigInteger.ONE);
		} while (!checkPrimitive(generator, primeFactors, phi, prime));
		return generator;
	}
}