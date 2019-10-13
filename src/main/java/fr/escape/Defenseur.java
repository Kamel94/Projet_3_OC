package fr.escape;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

import fr.escape.Challenger;

import fr.configuration.*;

public class Defenseur extends Jeu {

	Configuration conf = new Configuration();

	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.tailleCombi();

	@Override
	public void partie(int essai) {

		String reponseJoueur = "";
		int chiffreProposition = 0;
		essai = 0;

		System.out.println("\nBienvenue dans le mode Défenseur." + "\nDans ce mode vous devez choisir une combinaison de " + chiffreCombi + " chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");

		while(essai < nbrEssai) {

			essai++;
			Log.logger.info("\nEssai n° : " + essai + "\n");
			String propositionIA = String.valueOf(ordinateur.premiereProposition(this.nouvelleProposition));
			System.out.print("Réponse joueur : ");
			reponseJoueur = reponseJoueur();
			this.nouvelleProposition = nouvelleProposition(reponseJoueur, propositionIA, essai);

			if(v.conditionGagnantPerdantDefenseur(reponseJoueur, propositionIA, essai).equals("perdu")) {
				nouvelleProposition = null;
				essai = nbrEssai + 1;
			} else if(essai == nbrEssai){
				nouvelleProposition = null;
			}
		} //fin while
	} // fin méthode partie
}