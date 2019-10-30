package fr.escape;

public interface IMenu {

	Challenger challenger = new Challenger();
	Defenseur defenseur = new Defenseur();
	Duel duel = new Duel();
	Ordinateur ordinateur = new Ordinateur();
	SecondMenu fin = new SecondMenu();
	DeroulageMenu menu = new DeroulageMenu(new MenuPrincipal());
	MenuPrincipal principal = new MenuPrincipal();
	JeuEntier mode = new JeuEntier(new Challenger());

	public IMenu creationMenu(String type);
	public String optionMenu(int typeDuMenu, int choixMenu, int secondChoix, int constante1, int constante2, int constante3);
	public abstract int choix(int choix);
	public void fin();
}