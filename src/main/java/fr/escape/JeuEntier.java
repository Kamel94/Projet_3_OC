package fr.escape;

import static fr.escape.Utilitaire.*;

public class JeuEntier {

	private IJeu choisir;

	public JeuEntier(IJeu choisir) {
		this.choisir = choisir;
	}

	public IJeu choisirMode(int type) {
		IJeu mode = (IJeu) choisir.creationDuMode(type);

		int clef = ordinateur.combinaisonAleatoire();

		mode.regleDuMode();
		mode.partie(clef);
		return mode;
	}
}