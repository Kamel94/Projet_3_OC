package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.escape.*;

public class Victoire {

	Configuration conf = new Configuration();

	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.tailleCombi();

	public String victoire() {

		char[] tailleReponse = new char [chiffreCombi];
		for(int i = 0; i < chiffreCombi ; i++) {
			tailleReponse[i] = '=';
		}

		String victoire = String.valueOf(tailleReponse);

		return victoire;
	}

	public String conditionGagnantPerdantChallenger(String valeur1, String valeur2, int clef, int essai) {

		String reponse = "";

		try {
			if(clef == Integer.parseInt(valeur1)) {
				System.out.println("Proposition : " + valeur1 + " -> Réponse : " + valeur2 + "\n");
				reponse = "victoire";
			} else {
				System.out.println("Proposition : " + valeur1 + " -> Réponse : " + valeur2);
			}
		} catch (NumberFormatException e) {
		}
		return reponse;
	} // fin méthode conditionGagnantPerdantChallenger

	public String conditionGagnantPerdantDefenseur(String valeur1, String valeur2, int essai) {

		String resultat = "";

		if (String.valueOf(valeur1).equals(victoire())) {
			Log.logger.info("Proposition : " + valeur2 + " -> Réponse : " + valeur1);
			Log.logger.info("\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
			resultat = "perdu";
		} else if(essai == nbrEssai){
			Log.logger.info("\nL'IA a atteint le nombre d'essais maximum, vous avez donc gagné !!!" + "\nLa partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.");
		} else {
			Log.logger.info("Proposition : " + valeur2 + " -> Réponse : " + valeur1);
		}
		return resultat;
	} // fin méthode conditionGagnantPerdantDefenseur
}