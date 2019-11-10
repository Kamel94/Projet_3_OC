package fr.main;

import java.lang.String;
import fr.escape.IMenu;
import fr.factory.MenuFactory;

public class Main {

	public static void main(String[] args) {

		MenuFactory menuFactory = MenuFactory.getInstance();
		IMenu menu = (IMenu) menuFactory.creationMenu("DEBUT");
		int choix = 0;

		menu.choix(choix);
		menu.fin();
	}
}