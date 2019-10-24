package fr.escape;

import fr.configuration.Log;
import fr.configuration.Configuration;

public class Ordinateur {

	Configuration configuration = Configuration.getInstance();
	Utilitaire utilitaire = new Utilitaire();

	int tailleCombi = configuration.tailleCombi();

	public int combinaisonAleatoire() {

		char[] tailleCombiMin = new char [tailleCombi];
		char[] tailleCombiMax = new char [tailleCombi];

		for(int i = 0; i < tailleCombi ; i++) {
			tailleCombiMax[i] = '9';
			tailleCombiMin[i] = '1';
		}

		int max = Integer.parseInt(String.valueOf(tailleCombiMax));
		int min = Integer.parseInt(String.valueOf(tailleCombiMin));
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));

		return nombreAleatoire;
	}

	public int premiereProposition(String valeur1) {

		char[] taille = new char [tailleCombi];

		for(int i = 0; i < tailleCombi ; i++) {
			taille[i] = '5';
		}

		String proposition = String.valueOf(taille);
		int propositionIA = Integer.parseInt(proposition);

		if(valeur1 == null) {
			Log.logger.info("Première proposition IA : " + propositionIA);	
		} else {
			propositionIA = Integer.parseInt(valeur1);
			Log.logger.info("Nouvelle proposition IA : " + propositionIA);
		}
		return propositionIA;
	} // fin méthode premiereProposition

	public String lireSaisieUtilisateur(int tailleSaisie, boolean menuChoisi) {

		String saisie = "";
		String expression = "^[0-9]+$";
		String menu = "";


		int saisieMenu = 0;

		if(menuChoisi == false) {
			System.out.print("\nVeuillez entrer un chiffre parmis les choix proposés. \nEntrez votre choix : ");
			menu = "Menu";

			try {
				saisieMenu = Integer.parseInt(saisie);
			} catch (NumberFormatException e) {
			} 
			saisie = String.valueOf(saisieMenu);
		} else {
			System.out.print("\nProposition joueur : ");
		}

		saisie = utilitaire.clavier();
		saisie.matches(expression);

		if(menu.equals("Menu")) {
			while(Integer.parseInt(saisie) < 1 || Integer.parseInt(saisie) > 4) {
				Log.logger.fatal("\nVous n'avez pas entré le bon chiffre !!");
				saisie = lireSaisieUtilisateur(tailleSaisie, menuChoisi);
			}
		}

		while(saisie.matches(expression) == false) {
			Log.logger.error("\nVeuillez entrer uniquement des chiffres svp !");
			System.out.print("Recommencez : ");
			saisie = utilitaire.clavier();
		}

		if(tailleSaisie == tailleCombi) {
			while(saisie.length() != tailleCombi) {
				Log.logger.fatal("\nVous n'avez pas entré le bon nombre de chiffre !!" + "\nVous devez entrer " + tailleCombi + " chiffres !");
				Log.logger.fatal("\nProposition : " + saisie);
				System.out.print("\nProposition joueur : ");
				saisie = lireSaisieUtilisateur(tailleSaisie, menuChoisi);
			}
		}
		return saisie;
	}
}