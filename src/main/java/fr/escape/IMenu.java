package fr.escape;

import fr.factory.JeuFactory;
import fr.factory.MenuFactory;

public interface IMenu {

	Challenger challenger = new Challenger();
	Defenseur defenseur = new Defenseur();
	Duel duel = new Duel();
	IA IA = new IA();
	SecondMenu fin = new SecondMenu();
	Menu menu = new Menu(new MenuFactory());
	MenuPrincipal principal = new MenuPrincipal();
	Jeu mode = new Jeu(new JeuFactory());

	public String optionMenu(int typeDuMenu, int choixMenu, int secondChoix, int constante1, int constante2, int constante3);
	public abstract int choix(int choix);
	public void fin();
}