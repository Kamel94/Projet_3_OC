package fr.escape;

public class ListeDuMenu {

	private LancementDuMenu lancement;

	public ListeDuMenu(LancementDuMenu lancement) {
		this.lancement = lancement;
	}

	public Menu choisirMenu(String type) {
		Menu menu = (Menu) lancement.lancement(type);
		int choix = 0;

		menu.titre();
		menu.description();
		menu.choix(choix);
		return menu;
	}

}