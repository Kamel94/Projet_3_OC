package fr.escape;

//import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.configuration.Singleton;

public class Victoire {

	//Configuration conf = new Configuration();

	int nbrEssai = Singleton.getInstance().nbEssai();
	int chiffreCombi = Singleton.getInstance().tailleCombi();

	public String victoire() {

		char[] tailleReponse = new char [chiffreCombi];
		for(int i = 0; i < chiffreCombi ; i++) {
			tailleReponse[i] = '=';
		}

		String victoire = String.valueOf(tailleReponse);

		return victoire;
	}

	public String conditionGagnantPerdant(String reponse, String proposition, int clef, int essai) {

		String resultat = "";
		if (String.valueOf(reponse).equals(victoire())) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse);
			resultat = "victoire";
		} else {
			Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
		}
		return resultat;
	} // fin méthode conditionGagnantPerdantDefenseur

	public String conditionGagnantPerdant(String proposition, String reponseIA, String reponseJoueur, String propositionIA, int tentative, int essai, int clef) {
		String resultat = "";
		String reponse = "";
		String egaux = "";

		if(conditionGagnantPerdant(reponseJoueur, propositionIA, clef, essai).equals("victoire")) {
			resultat = "victoire";
			egaux = "égalité"; // Pour déterminer si l'utilisateur et l'IA ont trouvé la bonne combinaison en même temps.
			reponse = "\nDommage ! L'IA a gagné... \n" + "L'IA a trouvé la bonne combinaison en " + essai + " essai(s)." + "\nLa combinaison de l'IA était : " + clef;
			essai = nbrEssai + 1;// Pour ne pas entrer dans la condition du nombre d'essai limite atteint.

		} 
		if(clef == Integer.parseInt(proposition)) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA);
			if(egaux.equals("égalité")) {
				reponse = "Il n'y a pas de gagnant..." + "\nVous avez chacun trouvé la bonne combinaison de l'autre en " + tentative + " essai(s).";
				tentative = nbrEssai; 
			} else {
				reponse = "\nFélicitation vous avez gagné !! \n" + "Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				resultat = "victoire";
				tentative = nbrEssai;
			}
		} else if(essai == nbrEssai){
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA + "\n");
			reponse = "Il n'y a pas de gagnant..." + "\nVous avez atteint le nombre d'essai maximum !" + "\nLa combinaison de l'IA était : " + clef;
		} else if(essai == nbrEssai - 1) {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA + "\n");
			System.out.println("C'est le dernier essai !!");
		} else {
			Log.logger.info("Proposition : " + proposition + " -> Réponse IA : " + reponseIA);
		}
		Log.logger.info(reponse);
		return resultat;
	}
}