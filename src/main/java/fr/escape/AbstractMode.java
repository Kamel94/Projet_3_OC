package fr.escape;

import fr.configuration.Log;
import fr.factory.ModeFactory;

import static fr.escape.Utilitaire.*;

public abstract class AbstractMode implements IMode {

	protected ModeFactory modeFactory = ModeFactory.getInstance();
	protected IA ia = modeFactory.getIA();
	protected Joueur joueur = modeFactory.getJoueur();

	public String nouvelleProposition;

	public String comparaison(String proposition, String combinaisonIA) {

		String reponse = "";

		for (int i = 0; i < tailleCombi; i++) {
			if (proposition.charAt(i) > combinaisonIA.charAt(i)) {
				reponse += "-";
			} else if (proposition.charAt(i) < combinaisonIA.charAt(i)) {
				reponse += "+";
			} else {
				reponse += "=";
			}
		} // fin for
		return reponse;
	}

	public String nouvelleProposition(String reponseJoueur, String propositionIA, int essai) {

		int i = 0;
		int proposition = 0;
		String nouvelleProposition = "";
		char[] r = reponseJoueur.toCharArray();

		for (char reponse : r) {
			proposition = Integer.parseInt(String.valueOf(propositionIA.charAt(i)));

			if (String.valueOf(reponse).equals("=")) {
				nouvelleProposition += proposition;
			} else if (String.valueOf(reponse).equals("+")) {
				if ((proposition + 1) > 9) {
					nouvelleProposition += 9;
					Log.logger.error("Impossible de faire + que 9 !!");
				} else if(essai == 1) {
					nouvelleProposition += proposition + 2;
				} else if(essai > 1) {
					nouvelleProposition += proposition + 1;
				}
			} else if (String.valueOf(reponse).equals("-")) {
				if ((proposition - 1) < 0) {
					nouvelleProposition += 0;
					Log.logger.error("Impossible de faire - que 0 !!");
				} else if(essai == 1) {
					nouvelleProposition += proposition - 3;
				} else if(essai > 1){
					nouvelleProposition += proposition - 1;
				}
			}
			i++;
		} // fin for
		return nouvelleProposition;
	}

	public boolean activationModeDev(int clef) {
		if (dev) {
			Log.logger.info("\nMode développeur activé");
			Log.logger.info("\nLa combinaison est : " + clef + "\n");
		}
		return true;
	}

	public String victoire() {
		int chiffreCombi = tailleCombi;
		char[] tailleReponse = new char [chiffreCombi];
		for(int i = 0; i < chiffreCombi ; i++) {
			tailleReponse[i] = '=';
		}
		String victoire = String.valueOf(tailleReponse);

		return victoire;
	}

	public String conditionGagnantPerdant(String reponse, String proposition) {

		String resultat = "";
		if (String.valueOf(reponse).equals(victoire())) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse);
			resultat = victoire();
		} else {
			Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
		}
		return resultat;
	} // fin méthode conditionGagnantPerdantDefenseur

	public String conditionGagnantPerdantDuel(String proposition, String reponseIA, String reponseJoueur, String propositionIA, int tentative, int essai, int clef) {
		String resultat = "";
		String reponse = "";
		String egaux = "";

		if(conditionGagnantPerdant(reponseJoueur, propositionIA).equals(victoire())) {
			resultat = victoire();
			egaux = "EGAUX"; // Pour déterminer si l'utilisateur et l'IA ont trouvé la bonne combinaison en même temps.
			reponse = "\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s)." + "\nLa combinaison de l'IA était : " + clef;
			essai = nbrEssai + 1;// Pour ne pas entrer dans la condition du nombre d'essai limite atteint.
		}

		if(clef == Integer.parseInt(proposition)) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA);
			if(egaux.equals("EGAUX")) {
				reponse = "\nIl n'y a pas de gagnant..." + "\nVous avez chacun trouvé la bonne combinaison de l'autre en " + tentative + " essai(s).";
				tentative = nbrEssai; 
			} else {
				reponse = "\nFélicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				resultat = victoire();
				tentative = nbrEssai;
			}
		} else if(essai == nbrEssai){
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA + "\n");
			reponse = "Il n'y a pas de gagnant..." + "\nVous avez atteint le nombre d'essai maximum !" + "\nLa combinaison de l'IA était : " + clef;
		} else if(essai == nbrEssai - 1) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA + "\n");
			System.out.println("C'est le dernier essai !!");
		} else {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA);
		}
		Log.logger.info(reponse);
		return resultat;
	}
}