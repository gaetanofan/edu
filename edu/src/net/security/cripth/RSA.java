package net.security.cripth;

import java.util.Scanner;

/**
 * @author Gaetano Anastasi
 * @date 12/01/2019
 */

/**
 * Naif implementation of the RSA Algorithm 
 */
public class RSA {
	private static long MCD(long e, long z) {
        long r = e % z;
        if (r==0){
            return z;
        }
        return MCD(z,r);
    }

    private static long encryption(long[] kplus, long m) {
    	
        long s = 1;
        for (long i=0; i<kplus[0]; i++){
            s = (s*m)%kplus[1];
        }
        return s;
    }
    
    private static long decryption(long[] kminus, long c) {
        long s = 1;
        for (long i=0; i<kminus[0]; i++){
            s = (s*c)%kminus[1];
        }
        return s;
    }
    
    public static void main(String[] args) {
        // inserimento di p e q da tastiera
        long p, q;
        System.out.println("Inserisci p");
        Scanner input = new Scanner(System.in);
        p = input.nextLong();
        System.out.println("Inserisci q");
        q = input.nextLong();
        
        // Calcolo n e z
        long n = p*q;
        long z = (p-1)*(q-1);
        System.out.println("n = p*q = " + n);
        System.out.println("z = (p-1)*(q-1) = " + z);
        
        long e = 11;
        if ( e<z && !(MCD(e,z)==1) ){
        	System.out.println("Errore nell'esponente pubblico" );
            input.close();
            return;
        }
        System.out.println("Esponente pubblico e: " + e);
        
        long d = 59;
        if (!((e*d) % z == 1)){
        	System.out.println("Errore nell'esponente privato" );
            input.close();
            return;
        }
        System.out.println("Esponente privato d: " + d);
        
        long kplus[] = {e,n};
        long kminus[] = {d,n};
        
        System.out.println("Inserisci il numero da cifrare: ");
        long m = input.nextLong();
        input.close();
        long c = encryption(kplus, m);
        System.out.println("cifrato c: " + c);
        long m1 = decryption(kminus,c);
        System.out.println("Numero originario: " + m1);
        
    }

    
}

