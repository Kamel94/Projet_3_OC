package fr.escape;

import fr.factory.IMenuFactory;

public class Menu {

	private IMenuFactory choisir;

	public Menu(IMenuFactory choisir) {
		this.choisir = choisir;
	}

	public IMenu choisirMenu(String type) {
		IMenu menu = (IMenu) choisir.creationMenu(type);
		int choix = 0;

		menu.choix(choix);
		menu.fin();
		return menu;
	}

}