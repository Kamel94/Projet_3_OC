package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.escape.*;

public class Victoire {
	
	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	int premiereProposition = ordinateur.premiereProposition();
	
	Scanner clavier = new Scanner(System.in);
	
	public String victoire() {
		
		char[] tailleReponse = new char [conf.chiffreCombi()];
		
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
			tailleReponse[i] = '=';
		}
		
		String victoire = String.valueOf(tailleReponse);
		
		return victoire;
	}
}
