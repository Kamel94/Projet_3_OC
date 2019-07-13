package fr.escape;

import java.util.Scanner;

public class ModeJeu {
	
	
	static String mode() {
		
		String modeChoisi = "";
		String mode1 = "Challenger";
		String mode2 = "Défenseur";
		String mode3 = "Duel";
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");
		System.out.println("");
		System.out.println("1 = Mode Challenger  ||  2 = Mode Défenseur  ||  3 = Mode Duel");
		
		      boolean r = true;
		      while (r) {
		    	System.out.println("");
		        System.out.println("Veuillez entrer un chiffre entre 1 et 3. \nEntrez votre choix : ");
		        String choix = clavier.nextLine();
		        int c = Integer.parseInt(choix);

		        switch (c) {
		          case 1 :
		              modeChoisi = "Vous avez choisi le mode : " + mode1;
		              r = false;
		              break;
		          case 2 :
		        	  modeChoisi = "Vous avez choisi le mode : " + mode2;
		              r = false;
		              break;
		          case 3 :
		        	  modeChoisi = "Vous avez choisi le mode : " + mode3;
		              r = false;
		              break;
		          default :
		              System.out.println("Votre chiffre n'est pas correct.");
		              r = true;
		        }
		         
		      }
		     
		      return modeChoisi;
		  }  
	
	public static void main(String[] args) {

		System.out.println(mode());
	}

}
