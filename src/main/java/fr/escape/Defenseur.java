package fr.escape;

import fr.configuration.*;

public class Defenseur extends Jeu {

	Configuration conf = new Configuration();

	int nbrEssai = conf.nbEssai();
	int tailleCombi = conf.tailleCombi();

	@Override
	public void partie(int essai) {

		String reponseJoueur = "";
		essai = 0;

		System.out.println("\nBienvenue dans le mode Défenseur." + "\nDans ce mode vous devez choisir une combinaison de " + tailleCombi + " chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");

		while(essai < nbrEssai) {
			essai++;
			Log.logger.info("\nEssai n° : " + essai + "\n");
			String propositionIA = String.valueOf(ordinateur.premiereProposition(this.nouvelleProposition));
			System.out.print("Réponse joueur : ");
			reponseJoueur = joueur.reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);

			if(v.conditionGagnantPerdantDefenseur(reponseJoueur, propositionIA, essai).equals("perdu")) {
				nouvelleProposition = null;
				Log.logger.info("\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
				essai = nbrEssai + 1;
			} else if(essai == nbrEssai){
				nouvelleProposition = null;
				Log.logger.info("\nL'IA a atteint le nombre d'essais maximum, vous avez donc gagné !!!" + "\nLa partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.");
			} else if(essai == nbrEssai - 1) {
				System.out.println("\nC'est le dernier essai !!");
			}
		} //fin while
	}
}