package fr.configuration;

import java.util.ResourceBundle;

public final class Configuration {

	private static volatile Configuration instance = null;
	private ResourceBundle bundle = ResourceBundle.getBundle("config");
	static {
		instance = new Configuration();
	}

	private Configuration() {}

	public static Configuration getInstance() {
		if (Configuration.instance == null) {
			synchronized(Configuration.class) {
				if (Configuration.instance == null) {
					Configuration.instance = new Configuration();
				}
			}
		}
		return Configuration.instance;
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