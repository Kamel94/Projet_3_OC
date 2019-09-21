package fr.escape;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

import fr.escape.Challenger;

import fr.configuration.*;

public class Defenseur extends ModeJeu {
	
	Configuration conf = new Configuration();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	String victoire = v.victoire();
	
	public void defenseur() {
		
		String resultat = "";
		int essai = 0;

			System.out.println("\nBienvenue dans le mode Défenseur." +  
					"\nDans ce mode vous devez choisir une combinaison de " + chiffreCombi +
					" chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");
		
		while(essai < nbrEssai) {
			essai++;
			
			if (String.valueOf(modeDefenseur()).equals(victoire)) {
				Log.logger.info("\nDommage ! L'IA a gagné... \n" + 
							"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
				essai = nbrEssai + 1;
			} else if (essai == nbrEssai) {
				Log.logger.info("\nL'IA a atteint le nombre d'essais maximum, vous avez donc gagné !!!"
						+ "\nLa partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.");
			}
				
		} //fin while
	}
}
		
