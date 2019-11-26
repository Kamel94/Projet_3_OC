package fr.escape;

import fr.configuration.Log;
import fr.factory.MenuFactory;
import fr.factory.ModeFactory;
import static fr.escape.Utilitaire.*;

public abstract class AbstractMenu {

	protected ModeFactory modeFactory;
	protected IA ia;
	protected int clef;
	protected MenuFactory menuFactory;
	protected SecondMenu secondMenu;
	protected MenuPrincipal menuPrincipal;

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public SecondMenu getSecondMenu() {
		return secondMenu;
	}

	public void setSecondMenu(SecondMenu secondMenu) {
		this.secondMenu = secondMenu;
	}

	public AbstractMenu() {
		modeFactory = ModeFactory.getInstance();
		ia = modeFactory.getIA();
		menuFactory = MenuFactory.getInstance();
	}

	public void fin() {
		Log.logger.info("\nVous avez choisi de quitter.");
		System.out.print("\n" + "Merci d'avoir joué et à bientôt !");
	}

	public String choisirOptionMenu(int typeDuMenu, int choixMenu, int constante1, int constante2, int constante3) {

		System.out.print("\nVeuillez entrer un chiffre parmis les choix proposés. \nEntrez votre choix : ");
		String saisie = ia.verifierSaisieUtilisateur(typeDuMenu);
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

	public abstract int choix(int choix);
}