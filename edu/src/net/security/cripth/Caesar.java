package net.security.cripth;

import java.util.Scanner;

public class Caesar {
	public static void main(String[] args) {
		//dichiaro alfabeto in chiaro e corrispondente alfabeto cifrato
		String alfabeto="abcdefghijklmnopqrstuvwxyz";
		String cifrato ="defghijklmnopqrstuvwxyzabc";
		String message="";
		
		//inserisco il messaggio da tastiera con la classe scanner 
		System.out.print("*** Cifrario di Cesare ***\n");
		System.out.print("Inserisci il messaggio da criptare\n");
		Scanner input = new Scanner(System.in);
		String ins = input.nextLine();
		
		//per ogni carattere del messaggio inserito, prendo il corrispondente carattere dall'alfabeto cifrato 
		for (int i=0;i<ins.length();i++){
			boolean trovato = false;
			for (int j=0;j<alfabeto.length();j++){
				if (ins.charAt(i) == alfabeto.charAt(j)){
					message += cifrato.charAt(j);
					trovato = true;
				}
			}
			if (trovato==false)
				message+=ins.charAt(i);
		}
		System.out.println("Il messaggio cifrato è" + message);
		input.close();
	}
}
