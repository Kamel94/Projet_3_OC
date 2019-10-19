package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Singleton;

public abstract class Jeu   {

	//Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	Victoire v = new Victoire();
	Utilitaire utilitaire = new Utilitaire();
	Joueur joueur = new Joueur();

	boolean dev = Singleton.getInstance().modeDev(); // Récupère la valeur de la méthode dans la classe configuration pour déterminer l'activation ou non du mode développeur.
	int tailleCombi = Singleton.getInstance().tailleCombi();
	public String nouvelleProposition;

	public abstract void partie(int clef);

	public String comparaison(String valeur1, String valeur2) {

		String reponse = "";

		try {
			for (int i = 0; i < tailleCombi; i++) {
				if (valeur1.charAt(i) > valeur2.charAt(i)) {
					reponse += "-";
				} else if (valeur1.charAt(i) < valeur2.charAt(i)) {
					reponse += "+";
				} else {
					reponse += "=";
				}
			} // fin for
		} catch (StringIndexOutOfBoundsException e) {
		}
		return reponse;
	}

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
		} // fin for
		return val;
	}

	public boolean activationModeDev(int clef) {
		if (dev) {
			Log.logger.info("\nMode développeur activé");
			Log.logger.info("\nLa combinaison est : " + clef + "\n");
		}
		return true;
	}
}