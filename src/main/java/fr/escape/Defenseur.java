package fr.escape;

import fr.configuration.*;
import fr.factory.ModeFactory;

import static fr.escape.Utilitaire.*;

public class Defenseur extends AbstractMode {

	private ModeFactory modeFactory = ModeFactory.getInstance();
	private IA ia = modeFactory.getIA();
	private Joueur joueur = modeFactory.getJoueur();

	public Defenseur(ModeFactory modeFactory) {
		this.modeFactory = modeFactory;
	}

	public Defenseur(IA ia) {
		this.ia = ia;
	}

	@Override
	public void regleDuMode() {
		Log.logger.info("\nBienvenue dans le mode Défenseur." + "\nDans ce mode vous devez choisir une combinaison de " + tailleCombi + " chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");
	}

	@Override
	public void partie(int essai) {

		String reponseJoueur = "";
		essai = 0;

		while(essai < nbrEssai) {
			essai++;
			Log.logger.info("Essai n° : " + essai + "\n");
			String propositionIA = String.valueOf(ia.premiereProposition(this.nouvelleProposition));
			reponseJoueur = joueur.reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);

			if(conditionGagnantPerdant(reponseJoueur, propositionIA).equals(victoire())) {
				this.nouvelleProposition = null;
				Log.logger.info("\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s).\n");
				essai = nbrEssai + 1;
			} else if(essai == nbrEssai){
				this.nouvelleProposition = null;
				Log.logger.info("L'IA a atteint le nombre d'essais maximum, vous avez donc gagné !!!" + "\nL'IA n'a pas réussi à trouver votre combinaison.\n");
			} else if(essai == nbrEssai - 1) {
				System.out.println("C'est le dernier essai !!" + "\n");
			}
		} //fin while
	}
}