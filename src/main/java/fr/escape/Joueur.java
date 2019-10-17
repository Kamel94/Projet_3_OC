package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Singleton;

public class Joueur {

	Utilitaire utilitaire = new Utilitaire();
	//Configuration conf = new Configuration();
	
	public String reponseJoueur() {
		int tailleCombi = Singleton.getInstance().tailleCombi();
		String reponseJoueur = "";
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
			System.out.print("\nProposition joueur : ");
			reponseJoueur = utilitaire.clavier();
		}
		return reponseJoueur;
	} // fin méthode reponseJoueur

}
