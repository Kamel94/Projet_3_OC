package fr.escape;

public class DeroulageMenu {

	private IMenu choisir;

	public DeroulageMenu(IMenu choisir) {
		this.choisir = choisir;
	}

	public IMenu choisirMenu(String type) {
		IMenu menu = (IMenu) choisir.creationMenu(type);
		int choix = 0;

		menu.choix(choix);
		menu.fin();
		return menu;
	}

}