package inf.oo.listino;
import javax.swing.JOptionPane;

/**
 * @author Gaetano Anastasi
 * @date 22/04/2019
 */

/**
 * Implementation of a price list management software
 * for educational purposes
 */
public class Listino {

	private static final int MAX_PRODUCTS = 50;
	
	int maxProductIndex = -1;
	boolean update = false;
	int numProducts = 0;
	String nomi[]= new String[MAX_PRODUCTS];
	double prezzi[]= new double[MAX_PRODUCTS];
	
	private int parseInt(String msg) {
		String stringa = JOptionPane.showInputDialog(msg);
		int num =Integer.parseInt(stringa);
		return num;
	}
	
	private double parseDouble(String msg) {
		String stringa = JOptionPane.showInputDialog(msg);
		double num = Double.parseDouble(stringa);
		return num;
	}
	
	public void inserisci() {
		int num = parseInt("Quanti sono i prodotti da inserire?");
		int partenza = numProducts;
		for (int i=0; i < num; i++) {
			nomi[partenza + i]= JOptionPane.showInputDialog(i + 1 +"° prodotto:");
			prezzi[partenza + i]=parseDouble("Prezzo:");
			numProducts++;
		}
		update = true;
	}

	private void calcolaMax() {
		double max = -1;
		for (int i=0; i< numProducts; i++) {
			if (prezzi[i]>max) {
				max = prezzi[i];
				maxProductIndex = i;
			}
		}
		update = false;
	}
	
	public void visualizzaMax() {
		if (update == true) { 
			calcolaMax();
		}
		JOptionPane.showMessageDialog(null, "Il prezzo massimo è " + prezzi[maxProductIndex] 
				+ " relativo all'articolo \"" + nomi[maxProductIndex] + "\"");
	}

	public void visualizza() {
		String mystring = "";
		
		if (numProducts > 0) {
			for (int i=0; i<numProducts; i++) {
				mystring += nomi[i] + " - ";
				mystring += prezzi[i] + "€" + "\n";
			}
		}
		else {
			mystring = "Listino vuto";
		}
		JOptionPane.showMessageDialog(null, mystring, "Visualizzazione listino", 1);
	}

	public void modifica() {
		String stringa = JOptionPane.showInputDialog("Inserisci il nome del prodotto");
		boolean trovato = false;
		int index = -1; 
		for (int i=0; i<numProducts && !trovato; i++) {
			if (stringa.equals(nomi[i])) {
				trovato = true;
				index = i;
			}
		}
		double prezzo = parseDouble("Inserisci il nuovo prezzo");
		prezzi[index]=prezzo;
		update=true;
	}
}
