package fr.escape;

import fr.configuration.Log;
import static fr.escape.Utilitaire.*;

public class Joueur {

	Utilitaire utilitaire;

	public Joueur(Utilitaire utilitaire) {
		this.utilitaire = utilitaire;
	}

	public String reponseJoueur() {
		String reponseJoueur = "";
		System.out.print("Réponse joueur : ");
		reponseJoueur = utilitaire.lireSaisieUtilisateur();
		String expression = "^[+=-]+$";
		reponseJoueur.matches(expression);

		while(reponseJoueur.matches(expression) == false) {
			Log.logger.error("Vous devez entrer que +, -, =");
			System.out.print("Réponse joueur : ");
			reponseJoueur = utilitaire.lireSaisieUtilisateur();
		}

		while(reponseJoueur.length() != tailleCombi) {
			Log.logger.fatal("\nVous n'avez pas entré le bon nombre de caractère !!" + "\nVous devez entrer " + tailleCombi + " caractères !");
			Log.logger.fatal("\n -> Réponse : " + reponseJoueur);
			System.out.print("\nRéponse joueur : ");
			reponseJoueur = utilitaire.lireSaisieUtilisateur();
		}
		return reponseJoueur;
	} // fin méthode reponseJoueur
}