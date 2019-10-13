package fr.configuration;

import java.util.ResourceBundle;

public class Configuration {

	ResourceBundle bundle = ResourceBundle.getBundle("config");

	public boolean modeDev() {
		if(bundle.getString("mode.developpeur").equals("true")) {
			return true;
		}
		else {
			return false;
		}
	}

	public int nbEssai() {
		String essai = bundle.getString("essai");
		return Integer.parseInt(essai);
	}

	public int tailleCombi() {
		String nbrChiffre = bundle.getString("nbrChiffre");
		return Integer.parseInt(nbrChiffre);
	}
}
