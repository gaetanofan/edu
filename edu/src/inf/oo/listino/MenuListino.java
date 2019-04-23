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
class Menu{
	
   public static void main(String[] args){
      String menu="........... Listino ................. \n" +
                  "1. Inserimento prodotti\n" +
                  "2. Visualizzazione listino\n" +
                  "3. Modifica prezzo\n" +
                  "4. Visualizzazione prezzo più alto\n" +
                  "0. Uscita                         \n" +
                  "                     \n" +
                  "Cosa scegli?\n";
      String stringa;
      int scelta;
      
      Listino mylistino = new Listino();
		
      do {
         stringa=JOptionPane.showInputDialog(menu);
         try {
        	 scelta = Integer.parseInt(stringa);
         }
         catch (Exception e) {
        	 scelta = 0;
         }
         switch(scelta){
            case  0: //uscita 
            	break;
            case  1:
            	mylistino.inserisci();
                break;
            case  2: 
            	mylistino.visualizza();
            	break;
            case  3: 
            	mylistino.modifica();
            	break;
            case  4: 
            	mylistino.visualizzaMax();
            	break;
            default: 
            	break;
         }
      }
      while(scelta != 0);
   }
}
