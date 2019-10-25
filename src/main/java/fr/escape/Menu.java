package fr.escape;

public abstract class Menu implements LancementDuMenu {

	public abstract void titre();
	public abstract void description();
	public abstract int choix(int choix);

	public void fin() {
		System.out.print("Le jeu est fini.\n" + "Merci d'avoir joué et à bientôt !");
	}

	@Override
	public LancementDuMenu lancement(String type) {

		Menu liste = null;
		if(type.equals("Début")) {
			liste = new MenuPrincipal();
		} else if(type.equals("Fin")) {
			liste = new FinDePartie();
		}
		return liste;
	}
}