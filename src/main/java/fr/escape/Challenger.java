package fr.escape;

import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import fr.escape.*;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Challenger implements EtapeJoueur  {
	
	Configuration conf = new Configuration();
	Ordinateur o = new Ordinateur();
	Joueur j = new Joueur();
	
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
			
			reponse = etapeJoueur(clef);
		
		return reponse;
	}

	@Override
	public String etapeJoueur(int clef) {
		
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String resultat = "";
		String proposition = "";
		int essai = 0;
		
		
		/*if (dev) {
            Log.logger.info("Mode développeur activé");
        }
		
		System.out.println("\nBienvenue dans le mode Challenger." +  
		"\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi + 
		" chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");
		
		if (dev == true) {
			System.out.println("La combinaison est : " + clef);
		}*/
		
		boolean b = true;
		
		while(b && essai < nbrEssai) {
		
			reponse = "";
			essai++;
			System.out.println("\nEssai n° : " + essai);
			System.out.print("Proposition joueur : ");
		
		proposition = j.propositionJoueur();
		int taille = proposition.length();
		
		int[] joueur = new int[taille];
		String combinaison = "" + clef;
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
			
		}  //fin FOR
		
	 
		String expression = "^[0-9]+$";
		
		proposition.matches(expression);
		
		if(proposition.matches(expression) == false) {
			Log.logger.error("\nVeuillez entrer uniquement des chiffres svp !");
			if(taille != chiffreCombi) {
				essai++;
			}
			essai = essai - 1;
		}
		
		if(taille != chiffreCombi) {
			Log.logger.error("\nVous n'avez pas entré le bon nombre de chiffre !!");
			reponse = "Vous devez entrer " + chiffreCombi + " chiffres !";
			essai = essai - 1;
			b = true;
		}
	 
		try {
			if(clef == Integer.parseInt(proposition)) {
				Log.logger.info("\nProposition : " + proposition + " -> Réponse : " + reponse + "\n" +
						"\nFélicitation vous avez gagné !! \n" + 
						"Vous avez trouvé la bonne combinaison en " + essai + " essai(s).");
				reponse = "";
				b = false;
			} else {
				Log.logger.info("\nProposition : " + proposition + " -> Réponse : " + reponse);
				reponse = "";
				b = true;
			}
		
			if(essai == nbrEssai && clef != Integer.parseInt(proposition)) {
				proposition = "";
				Log.logger.info("\nDésolé vous avez atteint le nombre d'essai limité... \nLa combinaison était : " + clef);
			} else if(essai == nbrEssai - 1 && clef != Integer.parseInt(proposition)) {
				Log.logger.warn("\nAttention il vous reste 1 essai !!");
			}
		
		} catch(NumberFormatException e) {
		 
		} 
	
	} //fin while
		
		return reponse;
	}

}
