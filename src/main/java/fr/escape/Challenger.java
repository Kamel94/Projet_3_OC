package fr.escape;

import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Challenger {
	
	Configuration conf = new Configuration();
	
	int nbrEssai = conf.nbEssai();
	boolean dev = conf.modeDev();
	int chiffreCombi = conf.chiffreCombi();
	
	
	public String challenger(int clef) {
		
		if (dev) {
            Log.logger.info("Mode développeur activé");
        }
		
		System.out.println("\nBienvenue dans le mode Challenger." +  
		"\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi +  " chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essai. \nA vous de jouer !! \n");
		
		String reponse = "";
		String proposition = "";
		String combinaison;
		int taille;
		int essai = 0;
		
		Scanner clavier = new Scanner(System.in);
		
		if (dev == true) {
			System.out.println(clef);
		}
		
		boolean b = true;
		
		while(b && essai < nbrEssai) {
			
			reponse = "";
			proposition = clavier.nextLine();
			taille = proposition.length();
			
			
			int[] joueur = new int[taille];
			combinaison = "" + clef;
			int[] comb = new int[combinaison.length()];
			
			for (int i = 0; i < taille && i < combinaison.length(); i++) {
				
				try {
					joueur[i] = Integer.parseInt(proposition.charAt(i) + "");
				} catch(NumberFormatException e) {
					b = true;
				}
				
				comb[i] = Integer.parseInt("" + combinaison.charAt(i));
				
				
				if (joueur[i] == comb[i]) {
					reponse += "=";
				} else if (joueur[i] > comb[i]) {
					reponse += "-";
				} else {
					reponse += "+";
				}
				
			} //fin FOR
			
			
		 if(essai != nbrEssai) {
			essai++;
			Log.logger.info("\nEssai n° : " + essai);
		} 
		 
		 String expression = "^[0-9]+$";
			
			proposition.matches(expression);
			
			if(proposition.matches(expression) == false) {
				Log.logger.error("Veuillez entrer uniquement des chiffres svp !");
				if(taille != chiffreCombi) {
					essai++;
				}
				essai = essai - 1;
			} else {
				//System.out.println("Ok");
			}
			
			
			if(taille != chiffreCombi) {
				Log.logger.error("Vous n'avez pas entré le bon nombre de chiffre !! \nVous devez entrer " + chiffreCombi + " chiffres !\n");
				essai = essai - 1;
				b = true;
			}
		 
		 try {
		 if(clef == Integer.parseInt(proposition)) {
			 System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
				reponse = "";
				reponse = "\nFélicitation vous avez gagné !! \n" + 
				"Vous avez trouvé la bonne combinaison en " + essai + " essai.";
				b = false;
		 } else {
			 Log.logger.info("\nProposition : " + proposition + " -> Réponse : " + reponse + "\n");
				reponse = "";
				b = true;
		 }
			
			if(essai == nbrEssai && clef != Integer.parseInt(proposition)) {
				Log.logger.info("Désolé vous avez atteint le nombre d'essai limité...");
				proposition = "";
				reponse = "La combinaison était : " + clef;
			} else if(essai == nbrEssai - 1) {
				Log.logger.warn("Attention il vous reste 1 essai !!\n");
			}
			
			
			
		 } catch(NumberFormatException e) {
			 
		 }
		
		} //fin while
		
		return reponse;
	}

}
