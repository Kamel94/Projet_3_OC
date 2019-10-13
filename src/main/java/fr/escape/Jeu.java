package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public abstract class Jeu   {

	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	Victoire v = new Victoire();

	boolean dev = conf.modeDev(); // Récupère la valeur de la méthode dans la classe configuration pour déterminer l'activation ou non du mode développeur.
	int chiffreCombi = conf.tailleCombi();
	public String nouvelleProposition;

	public abstract void partie(int clef);

	public String comparaison(String valeur1, String valeur2) {

		String reponse = "";

		for (int i = 0; i < chiffreCombi; i++) {
			if (valeur1.charAt(i) > valeur2.charAt(i)) {
				reponse += "-";
			} else if (valeur1.charAt(i) < valeur2.charAt(i)) {
				reponse += "+";
			} else {
				reponse += "=";
			}
		}
		return reponse;
	}

	public String reponseJoueur() {

		Scanner clavier = new Scanner(System.in);
		String reponseJoueur = "";

		reponseJoueur = clavier.nextLine();
		String expression = "^[+=-]+$";
		reponseJoueur.matches(expression);

		while(reponseJoueur.matches(expression) == false) {
			Log.logger.error("Vous devez entrer que +, -, =");
			System.out.print("Réponse joueur : ");
			reponseJoueur = clavier.nextLine();
		}

		while(reponseJoueur.length() != chiffreCombi) {
			Log.logger.fatal("\nVous n'avez pas entré le bon nombre de caractère !!");
			reponseJoueur = "Vous devez entrer " + chiffreCombi + " caractères !";
			Log.logger.fatal("\n -> Réponse : " + reponseJoueur);
			System.out.print("\nProposition joueur : ");
			reponseJoueur = clavier.nextLine();
		}

		if(reponseJoueur.matches(expression) == true) {
			nouvelleProposition = "";
		}
		return reponseJoueur;
	} // fin méthode reponseJoueur

	public String nouvelleProposition(String valeur1, String valeur2, int essai) {

		int i = 0;
		int val2 = 0;
		String val = "";
		char[] r = valeur1.toCharArray();

		for (char val1 : r) {
			try {
				val2 = Integer.parseInt(String.valueOf(valeur2.charAt(i)));
			} catch (StringIndexOutOfBoundsException e) {
			}

			if (String.valueOf(val1).equals("=")) {
				val += val2;
			} else if (String.valueOf(val1).equals("+")) {
				if ((val2 + 1) > 9) {
					val += 9;
					Log.logger.error("Impossible de faire + que 9 !!");
				} else if(essai == 1) {
					val += val2 + 2;
				} else if(essai > 1) {
					val += val2 + 1;
				}
			} else if (String.valueOf(val1).equals("-")) {
				if ((val2 - 1) < 0) {
					val += 0;
					Log.logger.error("Impossible de faire - que 0 !!");
				} else if(essai == 1) {
					val += val2 - 3;
				} else if(essai > 1){
					val += val2 - 1;
				}
			}
			i++;
		}
		return val;
	}

	public boolean activationModeDev(int clef) {
		if (dev) {
			Log.logger.info("\nMode développeur activé");
			Log.logger.info("\nLa combinaison est : " + clef);
		}
		return true;
	}
}
