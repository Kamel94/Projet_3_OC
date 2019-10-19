package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Singleton;

public class Duel extends Jeu {

	//Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();

	int nbrEssai = Singleton.getInstance().nbEssai();
	int tailleCombi = Singleton.getInstance().tailleCombi();
	String victoire = v.victoire();

	@Override
	public void partie(int clef) {

		String resultat = "";
		String reponseIA = "";
		int essai = 0; // Contient le nombre d'essai effectué par l'utilisateur et l'IA.
		int tentative = 0; // La condition de la boucle.
		clef = ordinateur.combinaisonAleatoire();
		String combinaison = "" + clef;
		String reponseJoueur = "";

		System.out.println("\nBienvenue dans le mode Duel ! \nDans ce mode, vous et l'IA jouez chacun votre tour pour deviner la combinaison de l'autre." + "\nLe premier qui aura trouvé la combinaison de son adversaire aura gagné la partie !!" + "\n" + "Attention !! Vous aurez chacun uniquement " + nbrEssai + " essai(s) pour trouver la bonne combinaison..." + "\n" + "Bonne partie et que le meilleur gagne !!!");

		activationModeDev(clef);

		while(tentative < nbrEssai){
			tentative++;
			essai++;
			Log.logger.info("Essai n° : " + essai + "\n");

			System.out.print("Proposition joueur : ");
			String proposition = ordinateur.lireSaisieUtilisateur(tailleCombi);
			System.out.println("");
			reponseIA = comparaison(proposition, combinaison);
			String propositionIA = String.valueOf(ordinateur.premiereProposition(this.nouvelleProposition));
			System.out.print("Réponse joueur : ");
			reponseJoueur = joueur.reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);
			System.out.println("");

			if(v.conditionGagnantPerdant(proposition, reponseIA, reponseJoueur, propositionIA, tentative, essai, clef).equals("victoire")) {
				tentative = nbrEssai;
				nouvelleProposition = null;
			} else if(essai == nbrEssai){
				nouvelleProposition = null;
			}
		} //fin while

		Log.logger.info(resultat);

	} // fin méthode partie
}