package fr.escape;

import fr.configuration.Log;
import fr.factory.ModeFactory;
import static fr.escape.Utilitaire.*;

public abstract class AbstractMenu implements IMenu {

	public void fin() {
		Log.logger.info("\nVous avez choisi de quitter.");
		System.out.print("\n" + "Merci d'avoir joué et à bientôt !");
	}

	public String choisirOptionMenu(int typeDuMenu, int choixMenu, int constante1, int constante2, int constante3) {

		System.out.print("\nVeuillez entrer un chiffre parmis les choix proposés. \nEntrez votre choix : ");
		String saisie = ModeFactory.IA.lireSaisieUtilisateur(typeDuMenu);
		choixMenu = Integer.parseInt(saisie);

		if(choixMenu == constante1) {
			saisie = CHOIX_1;
		} else if(choixMenu == constante2) {
			saisie = CHOIX_2;
		} else if(choixMenu == constante3) {
			saisie = CHOIX_3;
		}
		return saisie;
	}
}