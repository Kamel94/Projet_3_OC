package fr.escape;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

import fr.escape.Challenger;

import fr.configuration.*;

public class Defenseur extends ModeJeu {
	
	Joueur joueur = new Joueur();
	Configuration conf = new Configuration();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	String victoireJoueur = joueur.victoireJoueur();
	
	public String defenseur() {
		
		String resultat = "";
		int essai = 0;

			System.out.println("\nBienvenue dans le mode Défenseur." +  
					"\nDans ce mode vous devez choisir une combinaison de " + chiffreCombi +
					" chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");
		
		while(essai < nbrEssai) {
			essai++;
			
			if (String.valueOf(modeDefenseur()).equals(victoireJoueur)) {
				resultat = "\nDommage ! L'IA a gagné... \n" + 
							"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).";
				essai = nbrEssai + 1;
			} else if (essai == nbrEssai) {
				resultat = "\nL'IA a atteint le nombre d'essai limité, vous avez donc gagné !!!"
						+ "\nLa partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.";
			}
				
		} //fin while
			
		return resultat;
	}
}
		
