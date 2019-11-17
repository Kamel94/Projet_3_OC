package fr.factory;

import fr.escape.MenuPrincipal;
import fr.escape.SecondMenu;

public final class MenuFactory implements IMenuFactory {

	private static MenuFactory singleton = null;

	private MenuFactory() {
	}

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

	public MenuPrincipal creationMenu() {

		MenuPrincipal menuPrincipal = new MenuPrincipal();
		SecondMenu secondMenu = new SecondMenu();
		menuPrincipal.setSecondMenu(secondMenu);
		secondMenu.setMenuPrincipal(menuPrincipal);
		return menuPrincipal;
	}
}