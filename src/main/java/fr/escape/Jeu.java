package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Configuration;

public abstract class Jeu   {

	Configuration configuration = Configuration.getInstance();
	//Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	Utilitaire utilitaire = new Utilitaire();
	Joueur joueur = new Joueur();

	boolean dev = configuration.modeDev(); // Récupère la valeur de la méthode dans la classe configuration pour déterminer l'activation ou non du mode développeur.
	int tailleCombi = configuration.tailleCombi();
	public String nouvelleProposition;

	public abstract void partie(int clef);

	public String comparaison(String valeur1, String valeur2) {

		String reponse = "";

		try {
			for (int i = 0; i < tailleCombi; i++) {
				if (valeur1.charAt(i) > valeur2.charAt(i)) {
					reponse += "-";
				} else if (valeur1.charAt(i) < valeur2.charAt(i)) {
					reponse += "+";
				} else {
					reponse += "=";
				}
			} // fin for
		} catch (StringIndexOutOfBoundsException e) {
		}
		return reponse;
	}

	public String nouvelleProposition(String valeur1, String valeur2, int essai) {

		int i = 0;
		int val2 = 0;
		String val = "";
		char[] r = valeur1.toCharArray();

		for (char val1 : r) {
			try {
				val2 = Integer.parseInt(String.valueOf(valeur2.charAt(i)));
			} catch (StringIndexOutOfBoundsException e) {
			}

			if (String.valueOf(val1).equals("=")) {
				val += val2;
			} else if (String.valueOf(val1).equals("+")) {
				if ((val2 + 1) > 9) {
					val += 9;
					Log.logger.error("Impossible de faire + que 9 !!");
				} else if(essai == 1) {
					val += val2 + 2;
				} else if(essai > 1) {
					val += val2 + 1;
				}
			} else if (String.valueOf(val1).equals("-")) {
				if ((val2 - 1) < 0) {
					val += 0;
					Log.logger.error("Impossible de faire - que 0 !!");
				} else if(essai == 1) {
					val += val2 - 3;
				} else if(essai > 1){
					val += val2 - 1;
				}
			}
			i++;
		} // fin for
		return val;
	}

	public boolean activationModeDev(int clef) {
		if (dev) {
			Log.logger.info("\nMode développeur activé");
			Log.logger.info("\nLa combinaison est : " + clef + "\n");
		}
		return true;
	}

	public String victoire() {
		int chiffreCombi = configuration.tailleCombi();
		char[] tailleReponse = new char [chiffreCombi];
		for(int i = 0; i < chiffreCombi ; i++) {
			tailleReponse[i] = '=';
		}
		String victoire = String.valueOf(tailleReponse);

		return victoire;
	}

	public String conditionGagnantPerdant(String reponse, String proposition, int clef, int essai) {

		String resultat = "";
		if (String.valueOf(reponse).equals(victoire())) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse);
			resultat = "victoire";
		} else {
			Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
		}
		return resultat;
	} // fin méthode conditionGagnantPerdantDefenseur

	public String conditionGagnantPerdant(String proposition, String reponseIA, String reponseJoueur, String propositionIA, int tentative, int essai, int clef) {
		String resultat = "";
		String reponse = "";
		String egaux = "";
		int nbrEssai = configuration.nbEssai();

		if(conditionGagnantPerdant(reponseJoueur, propositionIA, clef, essai).equals("victoire")) {
			resultat = "victoire";
			egaux = "égalité"; // Pour déterminer si l'utilisateur et l'IA ont trouvé la bonne combinaison en même temps.
			reponse = "\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s)." + "\nLa combinaison de l'IA était : " + clef;
			essai = nbrEssai + 1;// Pour ne pas entrer dans la condition du nombre d'essai limite atteint.
		}
		
		if(clef == Integer.parseInt(proposition)) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA);
			if(egaux.equals("égalité")) {
				reponse = "Il n'y a pas de gagnant..." + "\nVous avez chacun trouvé la bonne combinaison de l'autre en " + tentative + " essai(s).";
				tentative = nbrEssai; 
			} else {
				reponse = "\nFélicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				resultat = "victoire";
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