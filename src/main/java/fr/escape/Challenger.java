package fr.escape;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Challenger extends Jeu {

	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();

	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.tailleCombi();
	int clef = ordinateur.combinaisonAleatoire();

	public void partie(int clef) {

		String proposition = "";
		int essai = 0;
		String reponse = "";
		String combinaison = "" + clef;

		System.out.println("\nBienvenue dans le mode Challenger." + "\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi + " chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");

		activationModeDev(clef);

		while(essai != nbrEssai) {

			essai++;
			Log.logger.info("\nEssai n° : " + essai);
			System.out.print("\nProposition joueur : ");
			proposition = ordinateur.lireSaisieUtilisateur(tailleCombi);
			reponse = comparaison(proposition, combinaison);

			if(v.conditionGagnantPerdantChallenger(proposition, reponse, clef).equals("victoire")) {
				Log.logger.info("Félicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).");
				essai = nbrEssai;
			} else if (essai == nbrEssai) {
				Log.logger.info("\nDésolé vous avez atteint le nombre d'essais maximum... \nLa combinaison était : " + clef);
			} else if(essai == nbrEssai - 1) {
				System.out.println("\nAttention il vous reste 1 essai !!");
			}
		} //fin while
	} // fin méthode partie

	public String conditionGagnantPerdant(String valeur1, String valeur2, int clef, int essai) {

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

		if(valeur2.equals(v.victoire())) {
			System.out.println("Félicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).");
		} else if (essai == nbrEssai) {
			System.out.println("\nDésolé vous avez atteint le nombre d'essais maximum... \nLa combinaison était : " + clef);
		}

		if(essai == nbrEssai - 1) {
			System.out.println("\nAttention il vous reste 1 essai !!");
		}
		return reponse;
	} // fin méthode conditionGagnantPerdant
}
