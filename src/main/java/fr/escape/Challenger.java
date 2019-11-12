package fr.escape;

import fr.configuration.Log;

import static fr.escape.Utilitaire.*;

public class Challenger extends AbstractMode {

	public Challenger(IA ia) {
		super(ia);
	}

	@Override
	public void regleDuMode() {
		Log.logger.info("\nBienvenue dans le mode Challenger." + "\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi + " chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");
	}

	public void partie(int clef) {

		String proposition = "";
		int essai = 0;
		String reponse = "";
		String combinaison = "" + clef;

		activationModeDev(clef);

		while(essai != nbrEssai) {
			essai++;
			Log.logger.info("Essai n° : " + essai);
			proposition = ia.lireSaisieUtilisateur(tailleCombi);
			reponse = comparaison(proposition, combinaison);

			if(conditionGagnantPerdant(reponse, proposition).equals(victoire())) {
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