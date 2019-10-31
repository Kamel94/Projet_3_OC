package fr.factory;

import fr.escape.AbstractMenu;
import fr.escape.IMenu;
import fr.escape.MenuPrincipal;
import fr.escape.SecondMenu;

public class MenuFactory implements IMenuFactory {
	
	@Override
	public IMenu creationMenu(String type) {

		AbstractMenu liste = null;
		if(type.equalsIgnoreCase("DEBUT")) {
			liste = new MenuPrincipal();
		} else if(type.equalsIgnoreCase("FIN")) {
			liste = new SecondMenu();
		}
		return liste;
	}

}
