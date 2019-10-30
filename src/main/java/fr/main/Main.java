package fr.main;

import java.lang.String;

import fr.escape.MenuPrincipal;
import fr.escape.DeroulageMenu;

public class Main {

	public static void main(String[] args) {

		DeroulageMenu menu = new DeroulageMenu(new MenuPrincipal());
		menu.choisirMenu("DEBUT");
	}
}