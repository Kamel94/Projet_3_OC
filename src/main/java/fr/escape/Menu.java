package fr.escape;

import java.util.Scanner;

import fr.configuration.Log;

public class Menu extends Challenger {
	
	static Challenger modeC = new Challenger();
	static int clef = combIA();
	
	 public static String mode() {
		
		String modeChoisi = "";
		String mode1 = "Challenger";
		String mode2 = "Défenseur";
		String mode3 = "Duel";
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");
		System.out.println("");
		System.out.println("1 = Mode Challenger  " + "\n" + "2 = Mode Défenseur " + "\n" + "3 = Mode Duel");
        
        
		      boolean b = true; // b pour boucle.
		      while (b) {
		    	  
		    		  	System.out.println("");
				        System.out.println("Veuillez entrer un chiffre entre 1 et 3. \nEntrez votre choix : ");
				        
				        String choix = clavier.nextLine();
				        int c = Integer.parseInt(choix);
		            	
				        switch (c) {
				          case 1 :
				              modeChoisi = "Vous avez choisi le mode : " + mode1;
				              b = false;
				              if(b == false)
				        	  	System.out.println(modeChoisi);
				            	System.out.println(modeC.challenger(clef)); // Appel la méthode challenger.
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tout les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 2 :
				        	  modeChoisi = "Vous avez choisi le mode : " + mode2;
				              b = false;
				              if(b == false)
				            	modeChoisi = modeChoisi + "\n" + "Merci d'avoir joué !";
				        	  	System.out.println(modeChoisi);
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tout les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 3 :
				        	  modeChoisi = "Vous avez choisi le mode : " + mode3;
				              b = false;
				              if(b == false)
				              	modeChoisi = modeChoisi + "\n" + "Merci d'avoir joué !";
				              	System.out.println(modeChoisi);
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tout les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          default :
				              System.out.println("Votre chiffre n'est pas correct.");
				              b = true;
				        }
				        
		      } // fin while
		      
		      return modeChoisi + finPartie(); // Retourne le mode choisi et la méthode finPartie.
		      
		  } // fin méthode mode() 
	
	
	public static String finPartie() { // Méthode pour demander de rejouer, changer de mode ou quitter le jeu.
		
		String menuChoisi = "";
		boolean b = true;
		
		System.out.println("");
		System.out.println("Vous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.");
		
		
		while (b) {
		
		System.out.println("Tapez : ");
		System.out.println("");
		System.out.println("1 = Pour rejouer au même mode de jeu.");
		System.out.println("2 = Pour changer de mode de jeu.");
		System.out.println("3 = Pour quitter le jeu.");
		
		String choix;
		Scanner clavier = new Scanner(System.in);
		choix = clavier.nextLine();
		int c = Integer.parseInt(choix);
		
		switch (c) {
		case 1 : // Probleme : Revient au menu au lieu de retourner directement dans le mode choisi précédemment.
			b = false;
			if (b == false)
				System.out.println("Vous avez choisi de rejouer.");
				System.out.println("");
				menuChoisi = mode();
			break;
		case 2 : // Sort de la boucle et revient dans le menu pour changer de mode.
			menuChoisi = "Vous avez choisi de changer de mode.";
			b = false;
			if (b == false)
				System.out.println("Vous avez choisi de changer de mode.");
				System.out.println("");
				menuChoisi = mode(); // Pour revenir dans le menu pour choisir un autre mode.
			break;
		case 3 : // Sort de la boucle et ne revient pas dans le menu.
			b = false;
			if(b == false)
				System.out.print("Vous avez choisi de quitter le jeu, merci et à bientôt.");
			break;
		default :
			System.out.println("Vous n'avez pas choisi une réponse parmis les choix proposés.");
			b = true;
			}
		}
		
		return menuChoisi;
	}

}
