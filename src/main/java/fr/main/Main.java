package fr.main;

import java.lang.String;

import fr.escape.MenuPrincipal;
import fr.escape.ListeDuMenu;

public class Main {

	public static void main(String[] args) {

		ListeDuMenu menu = new ListeDuMenu(new MenuPrincipal());
		menu.choisirMenu("Début");
	}
}