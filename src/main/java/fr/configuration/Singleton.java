package fr.configuration;

import java.util.ResourceBundle;

public final class Singleton {

	private static volatile Singleton instance = null;
	private ResourceBundle bundle = ResourceBundle.getBundle("config");
	static {
		instance = new Singleton();
	}

	private Singleton() {}

	public static Singleton getInstance() {
		//Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet 
		//d'éviter un appel coûteux à synchronized, 
		//une fois que l'instanciation est faite.
		if (Singleton.instance == null) {
			// Le mot-clé synchronized sur ce bloc empêche toute instanciation
			// multiple même par différents "threads".
			// Il est TRES important.
			synchronized(Singleton.class) {
				if (Singleton.instance == null) {
					Singleton.instance = new Singleton();
				}
			}
		}
		return Singleton.instance;
	}

	public int nbEssai() {
		String essai = bundle.getString("essai");
		return Integer.parseInt(essai);
	}

	public int tailleCombi() {
		String nbrChiffre = bundle.getString("nbrChiffre");
		return Integer.parseInt(nbrChiffre);
	}

	public boolean modeDev() {
		if(bundle.getString("mode.developpeur").equals("true")) {
			return true;
		}
		else {
			return false;
		}
	}

}
