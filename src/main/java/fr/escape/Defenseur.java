package fr.escape;

import fr.configuration.*;

public class Defenseur extends Jeu {

	//Configuration conf = new Configuration();

	int nbrEssai = Singleton.getInstance().nbEssai();
	int tailleCombi = Singleton.getInstance().tailleCombi();

	@Override
	public void partie(int essai) {

		String reponseJoueur = "";
		essai = 0;

		System.out.println("\nBienvenue dans le mode Défenseur." + "\nDans ce mode vous devez choisir une combinaison de " + tailleCombi + " chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");

		while(essai < nbrEssai) {
			essai++;
			Log.logger.info("Essai n° : " + essai + "\n");
			String propositionIA = String.valueOf(ordinateur.premiereProposition(this.nouvelleProposition));
			System.out.print("Réponse joueur : ");
			reponseJoueur = joueur.reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);

			if(v.conditionGagnantPerdant(reponseJoueur, propositionIA, 0, essai).equals("victoire")) {
				nouvelleProposition = null;
				Log.logger.info("\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
				essai = nbrEssai + 1;
			} else if(essai == nbrEssai){
				nouvelleProposition = null;
				Log.logger.info("L'IA a atteint le nombre d'essais maximum, vous avez donc gagné !!!" + "\nLa partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.");
			} else if(essai == nbrEssai - 1) {
				System.out.println("C'est le dernier essai !!" + "\n");
			}
		} //fin while
	}
}