package fr.escape;

import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import fr.escape.*;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Challenger extends ModeJeu {
	
	Configuration conf = new Configuration();
	Ordinateur o = new Ordinateur();
	
	int nbrEssai = conf.nbEssai();
	boolean dev = conf.modeDev();
	int chiffreCombi = conf.chiffreCombi();
	int clef = o.combinaisonAleatoire();
	
	public String challenger(int clef) {
		
		if (dev) {
            Log.logger.info("Mode développeur activé");
        }
		
		System.out.println("\nBienvenue dans le mode Challenger." +  
		"\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi + 
		" chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");
		
		String reponse = "";
		
		if (dev == true) {
			System.out.println("La combinaison est : " + clef);
		}
		
			reponse = modeChallenger(clef);
		
		return reponse;
	}

}
