package fr.escape;

import static fr.escape.Utilitaire.*;

public class MenuPrincipal extends AbstractMenu {

	private SecondMenu secondMenu;

	public MenuPrincipal(SecondMenu secondMenu) {
		this.secondMenu = secondMenu;
	}

	@Override
	public int choix(int choixMenu) {

		System.out.println("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.\n" + "\nTapez :");
		System.out.println("\n1 = Pour le Mode Challenger" + "\n2 = Pour le Mode Défenseur" + "\n3 = Pour le Mode Duel" + "\n4 = Pour quitter le jeu");

		int typeDuMenu = MENU1;
		String menu = choisirOptionMenu(typeDuMenu, choixMenu, MODE_CHALLENGER, MODE_DEFENSEUR, MODE_DUEL);
		IMode mode;
		clef = ia.combinaisonAleatoire();

		if(menu.equalsIgnoreCase(CHOIX_1)) {
			System.out.println("Vous avez choisi le mode : Challenger");
			mode = modeFactory.creerMode(MODE_CHALLENGER);
			mode.regleDuMode();
			mode.partie(clef);
			secondMenu.choix(MODE_CHALLENGER);
		} else if(menu.equalsIgnoreCase(CHOIX_2)) {
			System.out.println("Vous avez choisi le mode : Défenseur");
			mode = modeFactory.creerMode(MODE_DEFENSEUR);
			mode.regleDuMode();
			mode.partie(clef);
			secondMenu.choix(MODE_DEFENSEUR);
		} else if(menu.equalsIgnoreCase(CHOIX_3)) {
			System.out.println("Vous avez choisi le mode : Duel");
			mode = modeFactory.creerMode(MODE_DUEL);
			mode.regleDuMode();
			mode.partie(clef);
			secondMenu.choix(MODE_DUEL);
		}
		return choixMenu;
	}
}