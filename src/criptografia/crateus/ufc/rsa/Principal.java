package criptografia.crateus.ufc.rsa;

import java.math.BigInteger;

public class Principal {

	public static void main(String[] args) {
		RSA rsa = new RSA(1024);

		String texto1 = "Bem vindo";
		System.out.println("Texto simples: " + texto1);
		BigInteger textosimples = new BigInteger(texto1.getBytes());
		

		BigInteger textocriptografado = rsa.criptografa(textosimples);

		System.out.println("Texto criptografado: " + textocriptografado);
		
		textosimples = rsa.desencripta(textocriptografado);
		String texto2 = new String(textosimples.toByteArray());
		System.out.println("Texto desencriptado: " + texto2);
	}
	
}
