package fr.factory;

import static fr.escape.Utilitaire.MODE_CHALLENGER;
import static fr.escape.Utilitaire.MODE_DEFENSEUR;
import static fr.escape.Utilitaire.MODE_DUEL;
import fr.escape.*;

public class JeuFactory implements IJeuFactory {

	public IJeu creationDuMode(int type) {

		IJeu mode = null;

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