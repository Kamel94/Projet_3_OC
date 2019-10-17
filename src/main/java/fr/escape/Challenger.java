package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Singleton;

public class Challenger extends Jeu {

	//Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();

	int nbrEssai = Singleton.getInstance().nbEssai();
	int chiffreCombi = Singleton.getInstance().tailleCombi();
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
}
