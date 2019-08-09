package fr.escape;

import fr.configuration.Configuration;

public class Joueur {
	
	Configuration conf = new Configuration();
	
	public String victoireJoueur() {
		
		char[] tailleReponse = new char [conf.chiffreCombi()];
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
			tailleReponse[i] = '=';
		}
		String victoireJoueur = String.valueOf(tailleReponse);
		
		return victoireJoueur;
	
	}
	
}
