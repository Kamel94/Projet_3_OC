package fr.escape;

import java.util.Scanner;

import fr.configuration.Log;

public class Menu extends Challenger {
	
	
	static Challenger modeC = new Challenger();
	static int clef = combIA(); 
	static String mode1 = "Challenger";
	static String mode2 = "Défenseur";
	static String mode3 = "Duel";
	
	 public static String mode() {
		 
		String modeChoisi = "";
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");
		//System.out.println("");
		//System.out.println("1 = Mode Challenger  " + "\n" + "2 = Mode Défenseur " + "\n" + "3 = Mode Duel");
        
		      boolean b = true; // b pour boucle.
		      while (b) {
		    	  
		    		  	System.out.println("\nTapez :");
		  				System.out.println("\n1 = Mode Challenger  " + "\n" + "2 = Mode Défenseur " + "\n" + "3 = Mode Duel");
				        System.out.println("\nVeuillez entrer un chiffre entre 1 et 3. \nEntrez votre choix : ");
				        
				        String choix = clavier.nextLine();
				        int c = 0;
				        
				        try {
				        	c = Integer.parseInt(choix);
				        } catch (NumberFormatException e) {
				        	System.out.println("Veuillez entrer uniquement des chiffres svp !");
				        	b = true;
				        } 
				        
				        switch (c) {
				          case 1 :
				              modeChoisi = "Vous avez choisi le mode : " + mode1 + "\n";
				              b = false;
				              if(b == false)
				        	  	System.out.println(modeChoisi);
				            	System.out.println(modeC.challenger(clef)); // Appel la méthode challenger.
				        	  	System.out.println(finPartie(1));
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tous les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 2 :
				        	  modeChoisi = "Vous avez choisi le mode : " + mode2;
				              b = false;
				              if(b == false)
				            	modeChoisi = modeChoisi + "\n" + "Merci d'avoir joué !"; // En attendant de créer le mode Défenseur.
				              	System.out.println(modeChoisi);
				        	  	System.out.println(finPartie(2));
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tous les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 3 :
				        	  modeChoisi = "Vous avez choisi le mode : " + mode3;
				              b = false;
				              if(b == false)
				              	modeChoisi = modeChoisi + "\n" + "Merci d'avoir joué !"; // En attendant de créer le mode Duel.
				              	System.out.println(modeChoisi);
				              	System.out.println(finPartie(3));
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tous les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          default :
				        		  System.out.println("Vous n'avez pas choisi une réponse parmis les choix proposés.");
				              b = true;
				        }
				        
		      } // fin while
		      
		      return modeChoisi ;//+ finPartie(); // Retourne le mode choisi et la méthode finPartie.
		      
		 
		      
		  } // fin méthode mode() 
	
	
	public static String finPartie(int choixFin) { // Méthode pour demander de rejouer, changer de mode ou quitter le jeu.
		
		String menuChoisi = "";
		String mode = "";
		
		boolean b = true;
		
		System.out.println("");
		System.out.println("Vous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.");
		
		
		while (b) {
		
		System.out.println("\nTapez : ");
		System.out.println("");
		System.out.println("1 = Pour rejouer au même mode de jeu. \n2 = Pour changer de mode de jeu. \n3 = Pour quitter le jeu.");
		System.out.println("\nVeuillez entrer un chiffre entre 1 et 3. \nEntrez votre choix : ");
		
		String choix;
		Scanner clavier = new Scanner(System.in);
		choix = clavier.nextLine();
		int ch = 0;
        try {
        	ch = Integer.parseInt(choix);
        } catch (NumberFormatException e) {
        	System.out.println("Veuillez entrer uniquement des chiffres svp !");
        	b = true;
        } 
		
		switch (ch) {
		case 1 : // Entre directement dans le mode choisi précédemment sans passer par le menu.
			b = false;
			if (b == false)
				if(choixFin == 1) { 
					mode = mode1;
					System.out.println("Vous avez choisi de rejouer au mode : " + mode + "\n");
					clef = combIA();
					menuChoisi = modeC.challenger(clef);
					System.out.println(menuChoisi);
					menuChoisi = "";
				} else if (choixFin == 2) {
					mode = mode2;
					System.out.println("Vous avez choisi de rejouer au mode : " + mode + "\n");
					menuChoisi = "Bienvenue dans le mode : " + mode2 + "\n" + "Merci d'avoir joué !";
					System.out.println(menuChoisi);
					menuChoisi = "";
				} else if (choixFin == 3) {
					mode = mode3;
					System.out.println("Vous avez choisi de rejouer au mode : " + mode + "\n");
					menuChoisi = "Bienvenue dans le mode : " + mode3 + "\n" + "Merci d'avoir joué !";
					System.out.println(menuChoisi);
					menuChoisi = "";
				}
			menuChoisi += finPartie(choixFin); 
			break;
		case 2 : // Sort de la boucle et revient dans le menu pour changer de mode.
			menuChoisi = "Vous avez choisi de changer de mode.";
			b = false;
			if (b == false)
				System.out.println("Vous avez choisi de changer de mode.");
				System.out.println("");
				menuChoisi = mode(); // Appel le menu pour choisir un autre mode.
			break;
		case 3 : // Sort de la boucle et ne revient pas dans le menu.
			b = false;
			if(b == false)
				System.out.print("Vous avez choisi de quitter le jeu, merci et à bientôt.");
				menuChoisi = "";
			break;
		default :
			System.out.println("Vous n'avez pas choisi une réponse parmis les choix proposés.");
			b = true;
			}
		}
		
		return menuChoisi;
		
	}
	

}




