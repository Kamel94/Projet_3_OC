package fr.factory;

import static fr.escape.Utilitaire.*;
import fr.escape.*;

public final class ModeFactory implements IModeFactory {

	private Utilitaire utilitaire;
	private IA ia;
	private Joueur joueur;

	private static ModeFactory singleton = null;

	private ModeFactory() {
		utilitaire = new Utilitaire();
		ia = new IA(utilitaire);
		joueur = new Joueur(utilitaire);
	}

	public static ModeFactory getInstance() {
		if (ModeFactory.singleton == null) {
			synchronized(ModeFactory.class) {
				if (ModeFactory.singleton == null) {
					ModeFactory.singleton = new ModeFactory();
				}
			}
		}
		return ModeFactory.singleton;
	}

	public IA getIA() {
		return ia;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public IMode creerMode(int type) {
		IMode mode = null;

		if(type == MODE_CHALLENGER) {
			mode = new Challenger(ia);
		} else if(type == MODE_DEFENSEUR) {
			mode = new Defenseur(ia);
		} else if(type == MODE_DUEL) {
			mode = new Duel(ia);
		}
		return mode;
	}
}