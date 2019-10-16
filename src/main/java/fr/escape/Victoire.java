package fr.escape;

import fr.configuration.Configuration;
import fr.configuration.Log;

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

	public String conditionGagnantPerdantChallenger(String valeur1, String valeur2, int clef) {

		String reponse = "";

		try {
			if(clef == Integer.parseInt(valeur1)) {
				System.out.println("Proposition : " + valeur1 + " -> Réponse : " + valeur2 + "\n");
				reponse = "victoire";
			} else {
				System.out.println("Proposition : " + valeur1 + " -> Réponse : " + valeur2 + "\n");
			}
		} catch (NumberFormatException e) {
		}
		return reponse;
	} // fin méthode conditionGagnantPerdantChallenger

	public String conditionGagnantPerdantDefenseur(String valeur1, String valeur2, int essai) {

		String resultat = "";

		if (String.valueOf(valeur1).equals(victoire())) {
			Log.logger.info("Proposition IA : " + valeur2 + " -> Réponse : " + valeur1);
			resultat = "perdu";
		} else {
			Log.logger.info("Proposition IA : " + valeur2 + " -> Réponse : " + valeur1);
		} 
		return resultat;
	} // fin méthode conditionGagnantPerdantDefenseur

	public String conditionGagnantPerdantDuel(String proposition, String reponseIA, String reponseJoueur, String propositionIA, int tentative, int essai, int clef) {
		String resultat = "";
		String reponse = "";
		String egaux = "";

		if(conditionGagnantPerdantChallenger(proposition, reponseIA, clef).equals("victoire")) {
			reponse = "\nFélicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
			essai = nbrEssai + 1;// Pour ne pas entrer dans la condition du nombre d'essai limite atteint.
			resultat = "victoire";
			egaux = "victoire"; // Pour déterminer si l'utilisateur et l'IA ont trouvé la bonne combinaison en même temps.
		}
		if(conditionGagnantPerdantDefenseur(reponseJoueur, propositionIA, essai).equals("perdu")) {
			resultat = "victoire";
			if(egaux.equals("victoire")) {
				reponse = "\nIl n'y a pas de gagnant..." + "\nVous avez chacun trouvé la bonne combinaison de l'autre en " + tentative + " essai(s).";
				tentative = nbrEssai; 
			} else {
				reponse = "\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s)." + "\nLa combinaison de l'IA était : " + clef;
				tentative = nbrEssai;
			}
		} else if(essai == nbrEssai){
			reponse = "\nIl n'y a pas de gagnant..." + "\nVous avez atteint le nombre d'essai maximum !" + "\nLa combinaison de l'IA était : " + clef;
		}
		Log.logger.info(reponse);
		return resultat;
	}
}