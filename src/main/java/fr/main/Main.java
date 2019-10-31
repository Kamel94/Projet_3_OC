package fr.main;

import java.lang.String;

import fr.factory.MenuFactory;
import fr.escape.Menu;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu(new MenuFactory());
		menu.choisirMenu("DEBUT");
	}
}