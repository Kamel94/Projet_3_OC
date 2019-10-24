package fr.escape;

import fr.configuration.Log;

public class FinDePartie extends Menu {

	Challenger challenger = new Challenger();
	Defenseur defenseur = new Defenseur();
	Duel duel = new Duel();
	Ordinateur ordinateur = new Ordinateur();
	int clef = ordinateur.combinaisonAleatoire();

	public final static int MENU2 = 2;
	public final static int REJOUER = 1;
	public final static int CHANGER_MODE = 2;
	public final static int QUITTER = 3;

	public final static int MODE_CHALLENGER = 1;
	public final static int MODE_DEFENSEUR = 2;
	public final static int MODE_DUEL = 3;
	public final static int JEU_FINI = 4;

	@Override
	public void titre() {
		System.out.println("\nVous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.\n" + "Tapez : \n");
	}

	@Override
	public void description() {
		System.out.println("1 = Pour rejouer au même mode de jeu. \n2 = Pour changer de mode de jeu. \n3 = Pour quitter le jeu.");
	}

	@Override
	public int choix(int choixFin) {
		Demarrer menu = new Demarrer(new Lancement());
		titre();
		description();

		String saisie = ordinateur.lireSaisieUtilisateur(MENU2);
		int choixMenu = 0;
		try {
			choixMenu = Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
		} 

		if(choixMenu == REJOUER) {
			if(choixFin == MODE_CHALLENGER) { 
				Log.logger.info("\nVous avez choisi de rejouer au mode : Challenger.");
				clef = ordinateur.combinaisonAleatoire();
				challenger.partie(clef);
				choixFin = choix(MODE_CHALLENGER);
			} else if (choixFin == MODE_DEFENSEUR) {
				Log.logger.info("\nVous avez choisi de rejouer au mode : Défenseur.");
				defenseur.partie(clef);
				choixFin = choix(MODE_DEFENSEUR);
			} else if (choixFin == MODE_DUEL) {
				Log.logger.info("\nVous avez choisi de rejouer au mode : Duel.");
				duel.partie(clef);
				choixFin = choix(MODE_DUEL);
			}
		} else if(choixMenu == CHANGER_MODE) {
			Log.logger.info("Vous avez choisi de changer de mode." + "\n");
			menu.choisirMenu("Début");
			choixMenu = 0;
		} else if(choixMenu == QUITTER) {
			Log.logger.info("Vous avez choisi de quitter.");
			fin();
		}
		return choixMenu;
	}
}