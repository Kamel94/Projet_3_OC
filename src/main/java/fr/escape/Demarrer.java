package fr.escape;

public class Demarrer {

	private ListeDuMenu liste;
	public final static int JEU_FINI = 4;

	public Demarrer(ListeDuMenu liste) {
		this.liste = liste;
	}

	public Menu choisirMenu(String type) {
		Menu menu = (Menu) liste.liste(type);
		int choix = 0;

		menu.titre();
		menu.description();
		menu.choix(choix);
		return menu;
	}

}