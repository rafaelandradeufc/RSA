package criptografia.crateus.ufc.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
	private BigInteger n, d, e;

	private int bitlen = 1024;

	public RSA(BigInteger n, BigInteger e) {
		this.n = n;
		this.e = e;
	}
	
	public RSA(int bits) {
		bitlen = bits;
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		n = p.multiply(q);
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

		e = new BigInteger("3");

		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		d = e.modInverse(m);
	}

	public String criptografa(String message) {
		return (new BigInteger(message.getBytes())).modPow(e, n).toString();
	}

	public BigInteger criptografa(BigInteger message) {
		return message.modPow(e, n);
	}

	public String desencripta(String message) {
		return new String((new BigInteger(message)).modPow(d, n).toByteArray());
	}

	public BigInteger desencripta(BigInteger message) {
		return message.modPow(d, n);
	}

	/** Geração de chaves pública e privada. */

	public void geradoreChaves() {
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		n = p.multiply(q);
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		e = new BigInteger("3");
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		d = e.modInverse(m);
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getE() {
		return e;
	}

}