package fr.escape;

import static fr.escape.Utilitaire.*;

import fr.configuration.Log;

public abstract class AbstractMenu implements IMenu {

	public int clef = ordinateur.combinaisonAleatoire();

	public void fin() {
		Log.logger.info("\nVous avez choisi de quitter.");
		System.out.print("\n" + "Merci d'avoir joué et à bientôt !");
	}

	public String optionMenu(int typeDuMenu, int choixMenu, int secondChoix, int constante1, int constante2, int constante3) {

		String saisie = ordinateur.lireSaisieUtilisateur(typeDuMenu);
		choixMenu = Integer.parseInt(saisie);

		if(choixMenu == constante1) {
			saisie = "choix 1";
			secondChoix = MODE_CHALLENGER;
		} else if(choixMenu == constante2) {
			saisie = "choix 2";
			secondChoix = MODE_DEFENSEUR;
		} else if(choixMenu == constante3) {
			saisie = "choix 3";
			secondChoix = MODE_DUEL;
		}
		return saisie;
	}

	@Override
	public IMenu creationMenu(String type) {

		AbstractMenu liste = null;
		if(type.equalsIgnoreCase("DEBUT")) {
			liste = new MenuPrincipal();
		} else if(type.equalsIgnoreCase("FIN")) {
			liste = new SecondMenu();
		}
		return liste;
	}
}