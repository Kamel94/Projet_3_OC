package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Duel extends Jeu {

	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();

	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.tailleCombi();
	String victoire = v.victoire();

	@Override
	public void partie(int clef) {

		String resultat = "";
		String reponseIA = "";
		int essai = 0; // Contient le nombre d'essai effectué par l'utilisateur et l'IA.
		int tentative = 0; // La condition de la boucle.
		clef = ordinateur.combinaisonAleatoire();
		String combinaison = "" + clef;
		String egaux = "";
		String reponseJoueur = "";

		System.out.println("\nBienvenue dans le mode Duel ! \nDans ce mode, vous et l'IA jouez chacun votre tour pour deviner la combinaison de l'autre." + "\nLe premier qui aura trouvé la combinaison de son adversaire aura gagné la partie !!" + "\n" + "Attention !! Vous aurez chacun uniquement " + nbrEssai + " essai(s) pour trouver la bonne combinaison..." + "\n" + "Bonne partie et que le meilleur gagne !!!");

		activationModeDev(clef);

		while(tentative < nbrEssai){
			tentative++;
			essai++;
			Log.logger.info("\nEssai n° : " + essai + "\n");

			System.out.print("Proposition joueur : ");
			String proposition = ordinateur.lireSaisieUtilisateur();

			while(proposition.length() != chiffreCombi) {
				Log.logger.fatal("\nVous n'avez pas entré le bon nombre de chiffre !!");
				reponseIA = "Vous devez entrer " + chiffreCombi + " chiffres !";
				Log.logger.fatal("\nProposition : " + proposition + " -> Réponse : " + reponseIA);
				System.out.print("\nProposition joueur : ");
				proposition = ordinateur.lireSaisieUtilisateur();
			}

			reponseIA = comparaison(proposition, combinaison);

			if(v.conditionGagnantPerdantChallenger(proposition, reponseIA, clef, essai).equals("victoire")) {
				resultat = "\nFélicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				egaux = victoire;
				tentative = nbrEssai;
			}

			Log.logger.info("\nEssai n° : " + essai + "\n");

			String propositionIA = String.valueOf(ordinateur.premiereProposition(this.nouvelleProposition));
			System.out.print("Réponse joueur : ");
			reponseJoueur = reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);

			if(v.conditionGagnantPerdantDefenseur(reponseJoueur, propositionIA, essai).equals("perdu")) {
				this.nouvelleProposition = null;
				if(egaux.equals(victoire)) {
					resultat = "\nIl n'y a pas de gagnant..." + "\nVous avez chacun trouvé la bonne combinaison de l'autre en " + essai + " essai(s).";
					tentative = nbrEssai; // Pour ne pas entrer dans la condition du nombre d'essai limite atteint.
				} else {
					resultat = "\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s).";
					tentative = nbrEssai;
					essai = nbrEssai;
				}
			} else if(essai == nbrEssai){
				this.nouvelleProposition = null;
				resultat = "\nIl n'y a pas de gagnant..." + "\nVous avez atteint le nombre d'essai maximum !" + "\nLa combinaison de l'IA était : " + clef;
			}

			if(essai == nbrEssai - 1) {
				System.out.println("\nAttention il vous reste 1 essai !!");
			}
		} //fin while

		Log.logger.info(resultat);

	} // fin méthode partie
}