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
	
	public int chiffreCombi() {
		String nbrChiffre = bundle.getString("nbrChiffre");
		return Integer.parseInt(nbrChiffre);
	}
	
	
	
	
	
	/*public int nombreCombi() {
		String nombre = bundle.getString("nb.chif.combi");
		return Integer.parseInt(nombre);
	}
	
	public int min() {
		String combiMin = bundle.getString("combiMin");
		return Integer.parseInt(combiMin);
	}
	
	public int chiffreProposition() {
		String chiffreProp = bundle.getString("chiffreProposition");
		return Integer.parseInt(chiffreProp);
	}
	
	public String reponseJoueur() {
		String reponseJ = bundle.getString("reponseJoueur");
		return reponseJ;
	}*/
}
