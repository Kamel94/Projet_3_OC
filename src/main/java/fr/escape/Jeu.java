package fr.escape;

import static fr.escape.Utilitaire.*;

import fr.factory.IJeuFactory;

public class Jeu {

	private IJeuFactory choisir;

	public Jeu(IJeuFactory choisir) {
		this.choisir = choisir;
	}

	public IJeu choisirMode(int type) {
		IJeu mode = choisir.creationDuMode(type);

		int clef = IA.combinaisonAleatoire();

		mode.regleDuMode();
		mode.partie(clef);
		return mode;
	}
}