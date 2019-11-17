package fr.main;

import java.lang.String;
import fr.escape.MenuPrincipal;
import fr.factory.MenuFactory;

public class Main {

	public static void main(String[] args) {

		MenuFactory menuFactory = MenuFactory.getInstance();
		MenuPrincipal menu = menuFactory.creationMenu();

		menu.choix(0);
		menu.fin();
	}
}