package net.security.cripth;

import java.util.Scanner;

/**
 *  @author Gaetano Anastasi
 *
 */
public class CaesarAscii {
	char letters [];
	int pos;
	final static int lNum = 26;
	final static int defaultPos = 3;
	
	private void init(int position){
		pos = position;
		letters = new char[lNum];
		for (int i=0; i<letters.length; i++){
			letters[i] = (char) ('a'+i);
		}
	}
	
	CaesarAscii (int position){
		init(position);
	}
	
	CaesarAscii (){
		init(defaultPos);
	}
	
	public String cripth(String str) {
		String finalMessage = "";
		for (int i=0; i<str.length(); i++){
			finalMessage += this.subst_forward(str.charAt(i), pos);
		}
		return finalMessage;
	}
	
	public String decripth(String str) {
		String finalMessage = "";
		for (int i=0; i<str.length(); i++){
			finalMessage += this.subst_back(str.charAt(i), pos);
		}
		return finalMessage;
	}
	
	private char subst_back(char c, int pos){
		int i = c - 'a';
		i = i-pos;
		if (i < 0)
			i += lNum;
		return (letters[i%lNum]);
	}
	
	private char subst_forward(char c, int pos){
		int i = c - 'a';
		return (letters[(i+pos)%(lNum)]);
	}
	
	public static void main(String[] args) {
		CaesarAscii c = new CaesarAscii();
		System.out.println("Insert the word to cipher:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String message = c.cripth(str);
		System.out.println(message);
		System.out.println(c.decripth(message));
	}

	

}
