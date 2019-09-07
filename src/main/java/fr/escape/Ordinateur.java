package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Ordinateur {
	
	Configuration conf = new Configuration();
	
	int nEssai = conf.nbEssai();
	boolean dev = conf.modeDev();
	int chiffreCombi = conf.chiffreCombi();
	
	public int combinaisonAleatoire() {
		
		char[] tailleCombiMin = new char [conf.chiffreCombi()];
		char[] tailleCombiMax = new char [conf.chiffreCombi()];
		
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
			tailleCombiMax[i] = '9';
			tailleCombiMin[i] = '1';
		}
		
		int max = Integer.parseInt(String.valueOf(tailleCombiMax));
		int min = Integer.parseInt(String.valueOf(tailleCombiMin));
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		
		return nombreAleatoire;
	}
	
	public int premiereProposition() {
		
		char[] tailleCombi = new char [conf.chiffreCombi()];
		
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
			tailleCombi[i] = '5';
		}
		
		String proposition = String.valueOf(tailleCombi);
		int propositionIA = Integer.parseInt(proposition);
		
		return propositionIA;
	}

}
