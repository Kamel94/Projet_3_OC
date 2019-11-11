package fr.factory;

import static fr.escape.Utilitaire.*;
import fr.escape.*;

public final class ModeFactory implements IModeFactory {

	private static volatile ModeFactory singleton = null;
	static {
		singleton = new ModeFactory();
	}

	private ModeFactory() {}

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
	private Utilitaire utilitaire = new Utilitaire();
	private IA IA = new IA(utilitaire);
	private Joueur joueur = new Joueur(utilitaire);

	public IA getIA() {
		return IA;
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
			mode = new Challenger();
		} else if(type == MODE_DEFENSEUR) {
			mode = new Defenseur();
		} else if(type == MODE_DUEL) {
			mode = new Duel();
		}
		return mode;
	}
}