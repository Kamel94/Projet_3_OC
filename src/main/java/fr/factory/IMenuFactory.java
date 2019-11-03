package fr.factory;

import fr.escape.IA;
import fr.escape.IMenu;
import fr.escape.LancementDuMode;
import fr.escape.MenuPrincipal;
import fr.escape.SecondMenu;
import fr.escape.Utilitaire;

public interface IMenuFactory {
	
	public static Utilitaire utilitaire = new Utilitaire();
	public static IA IA = new IA();
	public static SecondMenu secondMenu = new SecondMenu();
	public static MenuPrincipal menuPrincipal = new MenuPrincipal();
	public static LancementDuMode mode = new LancementDuMode(new ModeFactory());
	public static MenuFactory menuFactory = new MenuFactory();
	
	public static IMenu creationMenu(String type) {
		return null;
	}
}