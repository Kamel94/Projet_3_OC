package fr.factory;

import static fr.escape.Utilitaire.*;
import fr.escape.*;

public final class ModeFactory implements IModeFactory {

	private Utilitaire utilitaire;
	private IA iA;
	private Joueur joueur;

	private static  ModeFactory singleton = null;

	private ModeFactory() {
		utilitaire = new Utilitaire();
		iA = new IA(utilitaire);
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
		return iA;
	}

	public Utilitaire getUtilitaire() {
		return utilitaire;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public IMode creerMode(int type) {
		IMode mode = null;

		if(type == MODE_CHALLENGER) {
			mode = new Challenger(iA);
		} else if(type == MODE_DEFENSEUR) {
			mode = new Defenseur(iA);
		} else if(type == MODE_DUEL) {
			mode = new Duel(iA);
		}
		return mode;
	}
}