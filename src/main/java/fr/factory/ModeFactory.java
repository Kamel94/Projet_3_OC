package fr.factory;

import static fr.escape.Utilitaire.*;
import fr.escape.*;

public class ModeFactory implements IModeFactory {

	public static int clef = IA.combinaisonAleatoire();
	
	public IMode creerMode(int type) {

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