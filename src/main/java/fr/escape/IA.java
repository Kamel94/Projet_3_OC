package fr.escape;

import fr.configuration.Log;

import static fr.escape.Utilitaire.*;

public class IA {

	private Utilitaire utilitaire;

	public IA(Utilitaire utilitaire) {
		this.utilitaire = utilitaire;
	}

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

	public int premiereProposition(String nouvelleProposition) {

		char[] taille = new char [tailleCombi];

		for(int i = 0; i < tailleCombi ; i++) {
			taille[i] = '5';
		}

		String proposition = String.valueOf(taille);
		int propositionIA = Integer.parseInt(proposition);

		if(nouvelleProposition == null) {
			Log.logger.info("Première proposition IA : " + propositionIA);	
		} else {
			propositionIA = Integer.parseInt(nouvelleProposition);
			Log.logger.info("Nouvelle proposition IA : " + propositionIA);
		}
		return propositionIA;
	} // fin méthode premiereProposition

	public String verifierSaisieUtilisateur(int menu) {

		String saisie = "";
		String expression = "^[0-9]+$";

		if(menu == tailleCombi) {
			System.out.print("\nProposition joueur : ");
		}

		saisie = utilitaire.lireSaisieUtilisateur();
		saisie.matches(expression);

		try {
			if(menu == MENU1) {

				while(Integer.parseInt(saisie) < 1 || Integer.parseInt(saisie) > 4) {
					Log.logger.fatal("\nVous n'avez pas entré le bon chiffre !!");
					System.out.print("Recommencez : ");
					saisie = verifierSaisieUtilisateur(menu);
				}
			} else if(menu == MENU2) {
				while(Integer.parseInt(saisie) < 1 || Integer.parseInt(saisie) > 3) {
					Log.logger.fatal("\nVous n'avez pas entré le bon chiffre !!");
					System.out.print("Recommencez : ");
					saisie = verifierSaisieUtilisateur(menu);
				}
			} else if(menu == tailleCombi) {
				while(saisie.length() != tailleCombi) {
					Log.logger.fatal("\nVous n'avez pas entré le bon nombre de chiffre !!");
					Log.logger.fatal("\nProposition : " + saisie + " -> Réponse : Vous devez entrer " + tailleCombi + " chiffres !");
					saisie = verifierSaisieUtilisateur(menu);
				}
			} 
		} catch (NumberFormatException e) {
			System.out.println("\n--> Mauvaise saisie... ");
		}
		while(saisie.matches(expression) == false) {
			Log.logger.error("\nVeuillez entrer uniquement des chiffres svp !");
			System.out.print("Recommencez : ");
			saisie = verifierSaisieUtilisateur(menu);
		}
		return saisie;
	}
}