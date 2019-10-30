package fr.escape;

import static fr.escape.Utilitaire.*;

import fr.configuration.Log;

public class SecondMenu extends AbstractMenu {

	@Override
	public int choix(int choixFin) {

		System.out.println("Vous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.\n" + "Tapez : \n");
		System.out.println("1 = Pour rejouer au même mode de jeu. \n2 = Pour changer de mode de jeu. \n3 = Pour quitter le jeu.");

		int choixMenu = 0;
		int typeDuMenu = MENU2;
		String menu = optionMenu(typeDuMenu, choixMenu, choixFin, MODE_CHALLENGER, MODE_DEFENSEUR, MODE_DUEL);

		if(menu.equalsIgnoreCase("choix 1")) {
			if(choixFin == MODE_CHALLENGER) { 
				Log.logger.info("\nVous avez choisi de rejouer au mode : Challenger.");
				clef = ordinateur.combinaisonAleatoire();
				mode.choisirMode(MODE_CHALLENGER);
				choixMenu = choix(MODE_CHALLENGER);
			} else if (choixFin == MODE_DEFENSEUR) {
				Log.logger.info("\nVous avez choisi de rejouer au mode : Défenseur.");
				mode.choisirMode(MODE_DEFENSEUR);
				choixMenu = choix(MODE_DEFENSEUR);
			} else if (choixFin == MODE_DUEL) {
				Log.logger.info("\nVous avez choisi de rejouer au mode : Duel.");
				mode.choisirMode(MODE_DUEL);
				choixMenu = choix(MODE_DUEL);
			}
		} else if(menu.equalsIgnoreCase("choix 2")) {
			Log.logger.info("Vous avez choisi de changer de mode." + "\n");
			principal.choix(choixFin);
		}
		return choixMenu;
	}
}