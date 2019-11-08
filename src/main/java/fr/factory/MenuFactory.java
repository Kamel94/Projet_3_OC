package fr.factory;

import fr.escape.IMenu;
import fr.escape.MenuPrincipal;
import fr.escape.SecondMenu;

public class MenuFactory implements IMenuFactory {

	public static IMenu creerMenu(String type) {

		IMenu menu = null;
		if(type.equalsIgnoreCase("DEBUT")) {
			menu = new MenuPrincipal();
		} else if(type.equalsIgnoreCase("FIN")) {
			menu = new SecondMenu();
		}
		return menu;
	}
}