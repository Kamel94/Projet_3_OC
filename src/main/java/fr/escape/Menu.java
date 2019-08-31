package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.escape.Challenger;

public class Menu {
	
	 Challenger challenger = new Challenger();
	 Defenseur defenseur = new Defenseur();
	 Duel duel = new Duel();
	 Configuration conf = new Configuration();
	 Ordinateur ordinateur = new Ordinateur();
	 int clef = ordinateur.combinaisonAleatoire();
	 String mode1 = "Challenger";
	 String mode2 = "Défenseur";
	 String mode3 = "Duel";
	 
	 
	
	 public  String mode() {
		
		String modeChoisi = "";
		Scanner clavier = new Scanner(System.in);
		
		Log.logger.trace("Démarrage du jeu.");
		System.out.println("\nBienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");
        
		      boolean b = true; // b pour boucle.
		      while (b) {
		    	  
		    		  	System.out.println("\nTapez :");
		  				System.out.println("\n1 = Mode Challenger" + "\n2 = Mode Défenseur" + "\n3 = Mode Duel" + "\n4 = Quitter le jeu");
				        System.out.println("\nVeuillez entrer un chiffre entre 1 et 4. \nEntrez votre choix : ");
				        
				        String choix = clavier.nextLine();
				        int c = 0;
				        
				        try {
				        	c = Integer.parseInt(choix);
				        } catch (NumberFormatException e) {
				        	Log.logger.fatal("Vous avez entré : " + choix + "\nVeuillez entrer uniquement des chiffres svp !");
				        	b = true;
				        } 
				        
				        switch (c) {
				          case 1 :
				        	  Log.logger.info("Vous avez choisi le mode : " + mode1 + "\n");
				             // modeChoisi = "Vous avez choisi le mode : " + mode1 + "\n";
				              b = false;
				              if(b == false)
				        	  	//System.out.println(modeChoisi);
				              	Log.logger.info(challenger.challenger(clef));
				            	//System.out.println(challenger.etapeJoueur(clef)); // Appel la méthode challenger.
				        	  	System.out.println(finPartie(1));
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tous les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 2 :
				        	  modeChoisi = "\nVous avez choisi le mode : " + mode2;
				              b = false;
				              if(b == false)
				            	//modeChoisi = modeChoisi + "\n" + "Merci d'avoir joué !"; // En attendant de créer le mode Défenseur.
				            	Log.logger.info(defenseur.defenseur());
				        	  	System.out.println(finPartie(2));
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tous les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 3 :
				        	  modeChoisi = "\nVous avez choisi le mode : " + mode3;
				              b = false;
				              if(b == false)
				              	modeChoisi = modeChoisi + "\n" + "Merci d'avoir joué !"; // En attendant de créer le mode Duel.
				              	Log.logger.info(duel.duel());
				              	System.out.println(finPartie(3));
				        	  	modeChoisi = ""; // Réinitialise pour ne pas afficher tous les choix de l'utilisateur quand il quitte le jeu.
				              break;
				          case 4 :
				        	  modeChoisi = "\nVous avez choisi de quitter le jeu.";
				        	  Log.logger.trace("Fin du jeu. " + modeChoisi);
				        	  modeChoisi = "";
				        	  b = false;
				        	  break;
				          default :
				        	  Log.logger.error("Vous avez entré : " + c + "\nVous n'avez pas choisi une réponse parmis les choix proposés.");
				              b = true;
				        }
				        
		      } // fin while
		      
		      return modeChoisi ; // Retourne le mode choisi et la méthode finPartie.
		      
		 
		      
		  } // fin méthode mode() 
	
	
	public String finPartie(int choixFin) { // Méthode pour demander de rejouer, changer de mode ou quitter le jeu.
		
		String menuChoisi = "";
		String mode = "";
		
		boolean b = true;
		
		System.out.println("");
		Log.logger.info("Vous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.");
		
		
		while (b) {
		
		System.out.println("\nTapez : ");
		System.out.println("");
		System.out.println("1 = Pour rejouer au même mode de jeu. \n2 = Pour changer de mode de jeu. \n3 = Pour quitter le jeu.");
		System.out.println("\nVeuillez entrer un chiffre entre 1 et 3. \nEntrez votre choix : ");
		
		String choix;
		Scanner clavier = new Scanner(System.in);
		choix = clavier.nextLine();
		int c = 0;
        try {
        	c = Integer.parseInt(choix);
        } catch (NumberFormatException e) {
        	Log.logger.fatal("Vous avez entré : " + c + "\nVeuillez entrer uniquement des chiffres svp !");
        	b = true;
        } 
		
		switch (c) {
		case 1 : // Entre directement dans le mode choisi précédemment sans passer par le menu.
			b = false;
			if (b == false)
				if(choixFin == 1) { 
					mode = mode1;
					Log.logger.info("\nVous avez choisi de rejouer au mode : " + mode + "\n");
					clef = ordinateur.combinaisonAleatoire();
					Log.logger.info(challenger.challenger(clef));
					menuChoisi = "";
				} else if (choixFin == 2) {
					mode = mode2;
					Log.logger.info("\nVous avez choisi de rejouer au mode : " + mode + "\n");
					clef = ordinateur.combinaisonAleatoire();
					Log.logger.info(defenseur.defenseur());
					menuChoisi = "";
				} else if (choixFin == 3) {
					mode = mode3;
					Log.logger.info("\nVous avez choisi de rejouer au mode : " + mode + "\n");
					clef = ordinateur.combinaisonAleatoire();
					Log.logger.info(duel.duel());
					menuChoisi = "";
				}
			menuChoisi += finPartie(choixFin); 
			break;
		case 2 : // Sort de la boucle et revient dans le menu pour changer de mode.
			menuChoisi = "\nVous avez choisi de changer de mode.";
			b = false;
			if (b == false)
				Log.logger.info(menuChoisi);
				System.out.println("");
				menuChoisi = mode(); // Appel le menu pour choisir un autre mode.
			break;
		case 3 : // Sort de la boucle et ne revient pas dans le menu.
			b = false;
			if(b == false)
				menuChoisi = "\nVous avez choisi de quitter le jeu, merci et à bientôt.";
				Log.logger.trace("Fin du jeu. " + menuChoisi);
				menuChoisi = "";
			break;
		default :
			Log.logger.error("Vous avez entré : " + c + "\nVous n'avez pas choisi une réponse parmis les choix proposés.");
			b = true;
			}
		}
		
		return menuChoisi;
		
	}
	

}




