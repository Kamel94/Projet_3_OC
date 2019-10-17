package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Singleton;

public class Ordinateur {

	//Configuration conf = new Configuration();
	Utilitaire utilitaire = new Utilitaire();

	int tailleCombi = Singleton.getInstance().tailleCombi();

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

	public String lireSaisieUtilisateur(int tailleSaisie) {

		String saisie = "";
		String expression = "^[0-9]+$";
		saisie = utilitaire.clavier();
		saisie.matches(expression);

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
				saisie = lireSaisieUtilisateur(tailleSaisie);
			}
		}
		return saisie;
	}
}