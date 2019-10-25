package fr.escape;

import fr.configuration.Log;

public class Challenger extends Jeu {

	Ordinateur ordinateur = new Ordinateur();

	int nbrEssai = configuration.nbEssai();
	int chiffreCombi = configuration.tailleCombi();
	int clef = ordinateur.combinaisonAleatoire();

	public void partie(int clef) {

		String proposition = "";
		int essai = 0;
		String reponse = "";
		String combinaison = "" + clef;

		Log.logger.info("\nBienvenue dans le mode Challenger." + "\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi + " chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");

		activationModeDev(clef);

		while(essai != nbrEssai) {
			essai++;
			Log.logger.info("Essai n° : " + essai);
			proposition = ordinateur.lireSaisieUtilisateur(tailleCombi);
			reponse = comparaison(proposition, combinaison);

			if(conditionGagnantPerdant(reponse, proposition).equals("victoire")) {
				Log.logger.info("\nFélicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).\n");
				essai = nbrEssai;
			} else if (essai == nbrEssai) {
				Log.logger.info("Désolé vous avez atteint le nombre d'essais maximum... \nLa combinaison était : " + clef + "\n");
			} else if(essai == nbrEssai - 1) {
				System.out.println("C'est le dernier essai !!" + "\n");
			}
		} //fin while
	} // fin méthode partie
}
