package fr.escape;

import static fr.escape.Utilitaire.*;

public class MenuPrincipal extends AbstractMenu {

	@Override
	public int choix(int choixMenu) {

		System.out.println("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");
		System.out.println("\n1 = Mode Challenger" + "\n2 = Mode Défenseur" + "\n3 = Mode Duel" + "\n4 = Quitter le jeu");

		int typeDuMenu = MENU1;
		String menu = optionMenu(typeDuMenu, choixMenu, clef, MODE_CHALLENGER, MODE_DEFENSEUR, MODE_DUEL);

		if(menu.equalsIgnoreCase("choix 1")) {
			System.out.println("Vous avez choisi le mode : Challenger");
			mode.choisirMode(MODE_CHALLENGER);
			fin.choix(MODE_CHALLENGER);
		} else if(menu.equalsIgnoreCase("choix 2")) {
			System.out.println("Vous avez choisi le mode : Défenseur");
			mode.choisirMode(MODE_DEFENSEUR);
			fin.choix(MODE_DEFENSEUR);
		} else if(menu.equalsIgnoreCase("choix 3")) {
			System.out.println("Vous avez choisi le mode : Duel");
			mode.choisirMode(MODE_DUEL);
			fin.choix(MODE_DUEL);
		}
		return choixMenu;
	}
}