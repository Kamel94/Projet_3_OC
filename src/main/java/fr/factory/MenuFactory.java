package fr.factory;

import fr.escape.IMenu;
import fr.escape.MenuPrincipal;
import fr.escape.SecondMenu;

public final class MenuFactory implements IMenuFactory {

	private static volatile MenuFactory singleton = null;

	static {
		singleton = new MenuFactory();
	}

	private MenuFactory() {}

	public final static MenuFactory getInstance() {
		if (MenuFactory.singleton == null) {
			synchronized(MenuFactory.class) {
				if (MenuFactory.singleton == null) {
					MenuFactory.singleton = new MenuFactory();
				}
			}
		}
		return MenuFactory.singleton;
	}

	private SecondMenu secondMenu = new SecondMenu();
	private MenuPrincipal menuPrincipal = new MenuPrincipal(this.secondMenu);

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public SecondMenu getSecondMenu() {
		return secondMenu;
	}

	public IMenu creationMenu(String type) {

		IMenu menu = null;
		if(type.equalsIgnoreCase("DEBUT")) {
			menu = new MenuPrincipal(secondMenu);
		} else if(type.equalsIgnoreCase("FIN")) {
			menu = new SecondMenu();
		}
		return menu;
	}
}