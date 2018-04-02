package net.security.cripth;

import java.util.Scanner;
/**
 * @author Gaetano Anastasi
 * @date 2017/05/04
 */
public class CaesarKey {

	public static void main(String[] args) {
		System.out.println("Insert the key for Caesar cipher algorithm:");
		Scanner input = new Scanner(System.in);
		Integer key = input.nextInt();
		CaesarAscii c = new CaesarAscii(key);
		System.out.println("Insert the word to cipher:");
		Scanner input1 = new Scanner(System.in);
		String str = input1.nextLine();
		input1.close();
		input.close();
		String message = c.cripth(str);
		System.out.println("Encrypted message is: " + message);
		System.out.println("Decrypted message is: " + c.decripth(message));
	}
}
