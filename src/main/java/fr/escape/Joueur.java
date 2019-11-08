package fr.escape;

import fr.configuration.Log;
import fr.factory.ModeFactory;

import static fr.escape.Utilitaire.*;

public class Joueur {

	Utilitaire utilitaire = ModeFactory.utilitaire;

	public String reponseJoueur() {
		String reponseJoueur = "";
		System.out.print("Réponse joueur : ");
		reponseJoueur = utilitaire.clavier();
		String expression = "^[+=-]+$";
		reponseJoueur.matches(expression);

		while(reponseJoueur.matches(expression) == false) {
			Log.logger.error("Vous devez entrer que +, -, =");
			System.out.print("Réponse joueur : ");
			reponseJoueur = utilitaire.clavier();
		}

		while(reponseJoueur.length() != tailleCombi) {
			Log.logger.fatal("\nVous n'avez pas entré le bon nombre de caractère !!" + "\nVous devez entrer " + tailleCombi + " caractères !");
			Log.logger.fatal("\n -> Réponse : " + reponseJoueur);
			System.out.print("\nRéponse joueur : ");
			reponseJoueur = utilitaire.clavier();
		}
		return reponseJoueur;
	} // fin méthode reponseJoueur
}