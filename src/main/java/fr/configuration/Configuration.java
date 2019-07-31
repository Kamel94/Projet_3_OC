package fr.configuration;

import java.util.ResourceBundle;

public class Configuration {
	
	ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public int nombreCombi() {
		String nombre = bundle.getString("nb.chif.combi");
		return Integer.parseInt(nombre);
	}
	
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
	
}
