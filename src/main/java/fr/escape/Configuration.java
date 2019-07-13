package fr.escape;

import java.util.ResourceBundle;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Configuration {
	
	static ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public static void main(final String[] args) {
		
		System.out.println("Nombre par défaut est : " + bundle.getString("nb.chif.combi"));
		System.out.println("Le nombre d'essai maximum est de : " + getNbEssai());
		System.out.println("Mode développeur : " + modeDev());
		
	}
	
	public static boolean modeDev() {
		if(bundle.getString("mode.developpeur").equals("oui")) {
            return true;
        }
        else {
            return false;
        }
	}
	
	public static int getNbEssai() {
		String nbEssai = bundle.getString("essai");
		return Integer.parseInt(nbEssai);
	}
	
}
