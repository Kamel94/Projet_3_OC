package fr.escape;

import static fr.escape.Utilitaire.*;

import fr.configuration.Log;
import fr.factory.MenuFactory;
import fr.factory.ModeFactory;

public class SecondMenu extends AbstractMenu {

	private ModeFactory modeFactory = ModeFactory.getInstance();
	private IA ia = modeFactory.getIA();

	@Override
	public int choix(int choixFin) {

		System.out.println("Vous avez fini ce mode de jeu, faites un choix parmis les 3 propositions suivantes.\n" + "Tapez : \n");
		System.out.println("1 = Pour rejouer au même mode de jeu. \n2 = Pour changer de mode de jeu. \n3 = Pour quitter le jeu.");

		int choixMenu = 0;
		int typeDuMenu = MENU2;
		String menu = choisirOptionMenu(typeDuMenu, choixMenu, MODE_CHALLENGER, MODE_DEFENSEUR, MODE_DUEL);
		IMode mode;
		clef = ia.combinaisonAleatoire();

		if(menu.equalsIgnoreCase(CHOIX_1)) {
			if(choixFin == MODE_CHALLENGER) { 
				Log.logger.info("\nVous avez choisi de rejouer au mode : Challenger.");
				mode = modeFactory.creerMode(MODE_CHALLENGER);
				mode.regleDuMode();
				mode.partie(clef);
				choixMenu = choix(MODE_CHALLENGER);
			} else if (choixFin == MODE_DEFENSEUR) {
				Log.logger.info("\nVous avez choisi de rejouer au mode : Défenseur.");
				mode = modeFactory.creerMode(MODE_DEFENSEUR);
				mode.regleDuMode();
				mode.partie(clef);
				choixMenu = choix(MODE_DEFENSEUR);
			} else if (choixFin == MODE_DUEL) {
				Log.logger.info("\nVous avez choisi de rejouer au mode : Duel.");
				mode = modeFactory.creerMode(MODE_DUEL);
				mode.regleDuMode();
				mode.partie(clef);
				choixMenu = choix(MODE_DUEL);
			}
		} else if(menu.equalsIgnoreCase(CHOIX_2)) {
			Log.logger.info("Vous avez choisi de changer de mode." + "\n");
			MenuFactory.getInstance().getMenuPrincipal().choix(choixFin);
		}
		return choixMenu;
	}
}