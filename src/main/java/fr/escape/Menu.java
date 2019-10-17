package fr.escape;

import fr.configuration.Log;
import fr.escape.Challenger;

public class Menu {

	Challenger challenger = new Challenger();
	Defenseur defenseur = new Defenseur();
	Duel duel = new Duel();
	Ordinateur ordinateur = new Ordinateur();
	Utilitaire utilitaire = new Utilitaire();

	int clef = ordinateur.combinaisonAleatoire();
	String mode1 = "Challenger";
	String mode2 = "Défenseur";
	String mode3 = "Duel";

	public void demarrage() {

		Log.logger.trace("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");

		boolean menuChoisi = false; // Pour boucler tant que le choix n'est pas fait.
		while (!menuChoisi) {

			System.out.println("\nTapez :");
			System.out.println("\n1 = Mode Challenger" + "\n2 = Mode Défenseur" + "\n3 = Mode Duel" + "\n4 = Quitter le jeu");
			System.out.print("\nVeuillez entrer un chiffre entre 1 et 4. \nEntrez votre choix : ");

			String choix = ordinateur.lireSaisieUtilisateur(1);
			int c = 0;
			try {
				c = Integer.parseInt(choix);
			} catch (NumberFormatException e) {
			} 
			if(choixDebut(c, menuChoisi) == true) {
				menuChoisi = true;
			}
		} // Fin while
	} // Fin méthode demarrage() 

	public void finPartie(int choixFin) { // Méthode pour demander de rejouer, changer de mode ou quitter le jeu.

		String mode = "";
		String choix;
		int essai = 0;
		int c = 0;

		System.out.println("");
		Log.logger.info("Vous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.");

		boolean menuChoisi = false; // Pour boucler tant que le choix n'est pas fait.
		while (!menuChoisi) {
			System.out.println("\nTapez : " + "\n");
			System.out.println("1 = Pour rejouer au même mode de jeu. \n2 = Pour changer de mode de jeu. \n3 = Pour quitter le jeu.");
			System.out.print("\nVeuillez entrer un chiffre entre 1 et 3. \nEntrez votre choix : ");
			choix = ordinateur.lireSaisieUtilisateur(1);

			try {
				c = Integer.parseInt(choix);
			} catch (NumberFormatException e) {
			} 

			switch (c) {
			case 1 : // Entre directement dans le mode choisi précédemment sans passer par le menu.
				if(choixFin == 1) { 
					mode = mode1;
					Log.logger.info("\nVous avez choisi de rejouer au mode : " + mode + "\n");
					clef = ordinateur.combinaisonAleatoire();
					challenger.partie(clef);
				} else if (choixFin == 2) {
					mode = mode2;
					Log.logger.info("\nVous avez choisi de rejouer au mode : " + mode);
					defenseur.partie(clef);
				} else if (choixFin == 3) {
					mode = mode3;
					Log.logger.info("\nVous avez choisi de rejouer au mode : " + mode);
					duel.partie(essai);
				}
				menuChoisi = true;
				finPartie(choixFin); 
				break;
			case 2 : // Sort de la boucle et revient dans le menu pour changer de mode.
				Log.logger.info("\nVous avez choisi de changer de mode." + "\n");
				demarrage(); // Appel le menu pour choisir un autre mode.
				menuChoisi = true;
				break;
			case 3 : // Sort de la boucle et ne revient pas dans le menu.
				Log.logger.trace("\nFin du jeu. " + "\nVous avez choisi de quitter le jeu, merci et à bientôt.");
				menuChoisi = true;
				break;
			default :
				Log.logger.error("\nVous n'avez pas choisi une réponse parmis les choix proposés.");
				menuChoisi = false;
			}
		} // Fin while
	} // Fin méthode finPartie()
	
	public boolean choixDebut(int choix, boolean menuChoisi) {
		switch (choix) {
		case 1 :
			Log.logger.info("\nVous avez choisi le mode : " + mode1);
			challenger.partie(clef);// Appel la méthode challenger. 
			finPartie(1);
			menuChoisi = true; // Sort de la boucle une fois la partie quittée.
			break;
		case 2 :
			Log.logger.info("\nVous avez choisi le mode : " + mode2);
			defenseur.partie(clef);
			finPartie(2);
			menuChoisi = true;
			break;
		case 3 :
			Log.logger.info("\nVous avez choisi le mode : " + mode3);
			duel.partie(clef);
			finPartie(3);
			menuChoisi = true;
			break;
		case 4 :
			Log.logger.trace("Fin du jeu. " + "\nVous avez choisi de quitter le jeu.");
			menuChoisi = true;
			break;
		default :
			Log.logger.error("\nVous n'avez pas choisi une réponse parmis les choix proposés.");
			menuChoisi = false;
		}
		return menuChoisi;
	}
}