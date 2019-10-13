package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Ordinateur {

	Configuration conf = new Configuration();

	int tailleCombi = conf.tailleCombi();

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

		String proposition = String.valueOf(tailleCombi);
		int propositionIA = Integer.parseInt(proposition);

		if(valeur1 == null) {
			Log.logger.info("Première proposition IA : " + propositionIA);	
		} else {
			propositionIA = Integer.parseInt(valeur1);
			Log.logger.info("Nouvelle proposition IA : " + propositionIA);
		}
		return propositionIA;
	} // fin méthode premiereProposition

	public String lireSaisieUtilisateur() {

		Scanner clavier = new Scanner(System.in);
		String saisie = "";
		String expression = "^[0-9]+$";
		saisie = clavier.nextLine();
		saisie.matches(expression);

		while(saisie.matches(expression) == false) {
			Log.logger.error("\nVeuillez entrer uniquement des chiffres svp !");
			System.out.print("Recommencez : ");
			saisie = clavier.nextLine();
		}
		return saisie;
	}
}