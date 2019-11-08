package fr.factory;

import static fr.escape.Utilitaire.*;
import fr.configuration.Configuration;
import fr.escape.*;

public class ModeFactory implements IModeFactory {

	Configuration configuration = Configuration.getInstance();
	public static IA IA = new IA();
	public static Utilitaire utilitaire = new Utilitaire();
	public static Joueur joueur = new Joueur();
	public static MenuPrincipal menuPrincipal = new MenuPrincipal();
	public static SecondMenu secondMenu = new SecondMenu();

	public static int clef = IA.combinaisonAleatoire();

	public static IMode creerMode(int type) {
		IMode mode = null;

		if(type == MODE_CHALLENGER) {
			mode = new Challenger();
		} else if(type == MODE_DEFENSEUR) {
			mode = new Defenseur();
		} else if(type == MODE_DUEL) {
			mode = new Duel();
		}
		return mode;
	}
}