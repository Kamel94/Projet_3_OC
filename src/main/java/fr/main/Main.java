package fr.main;

import java.lang.String;
import fr.escape.IMenu;
import fr.factory.MenuFactory;
import static fr.escape.Utilitaire.*;

public class Main {

	public static void main(String[] args) {
		
		IMenu menu = (IMenu) MenuFactory.creerMenu(DEBUT);
		int choix = 0;
		
		menu.choix(choix);
		menu.fin();
	}
}