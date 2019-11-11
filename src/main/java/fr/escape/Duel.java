package fr.escape;

import fr.configuration.Log;

import static fr.escape.Utilitaire.*;

public class Duel extends AbstractMode {

	String victoire = victoire();

	@Override
	public void regleDuMode() {
		Log.logger.info("\nBienvenue dans le mode Duel ! \nDans ce mode, vous et l'IA jouez chacun votre tour pour deviner la combinaison de l'autre." + "\nLe premier qui aura trouvé la combinaison de son adversaire aura gagné la partie !!" + "\n" + "Attention !! Vous aurez chacun uniquement " + nbrEssai + " essai(s) pour trouver la bonne combinaison..." + "\n" + "Bonne partie et que le meilleur gagne !!!");
	}

	@Override
	public void partie(int clef) {

		String resultat = "";
		String reponseIA = "";
		int essai = 0; // Contient le nombre d'essai effectué par l'utilisateur et l'IA.
		int tentative = 0; // La condition de la boucle.
		String combinaison = "" + clef;
		String reponseJoueur = "";
		activationModeDev(clef);

		while(tentative < nbrEssai){
			tentative++;
			essai++;
			Log.logger.info("Essai n° : " + essai);
			String proposition = ia.lireSaisieUtilisateur(tailleCombi);
			System.out.println("");
			reponseIA = comparaison(proposition, combinaison);
			String propositionIA = String.valueOf(ia.premiereProposition(this.nouvelleProposition));
			reponseJoueur = joueur.reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);
			System.out.println("");
			if(conditionGagnantPerdantDuel(proposition, reponseIA, reponseJoueur, propositionIA, tentative, essai, clef).equals(victoire())) {
				tentative = nbrEssai;
				nouvelleProposition = null;
			} else if(essai == nbrEssai){
				nouvelleProposition = null;
			}
		} //fin while

		Log.logger.info(resultat);

	} // fin méthode partie
}