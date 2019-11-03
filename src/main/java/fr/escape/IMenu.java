package fr.escape;

import fr.factory.IMenuFactory;

public interface IMenu {
	
	IA IA = IMenuFactory.IA;
	SecondMenu secondMenu = IMenuFactory.secondMenu;
	MenuPrincipal menuPrincipal = IMenuFactory.menuPrincipal;
	LancementDuMode mode = IMenuFactory.mode;

	public String choisirOptionMenu(int typeDuMenu, int choixMenu, int constante1, int constante2, int constante3);
	public int choix(int choix);
	public void fin();
	
}