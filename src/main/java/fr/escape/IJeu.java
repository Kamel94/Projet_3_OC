package fr.escape;

import fr.configuration.Configuration;

public interface IJeu {

	Configuration configuration = Configuration.getInstance();
	Ordinateur ordinateur = new Ordinateur();
	Utilitaire utilitaire = new Utilitaire();
	Joueur joueur = new Joueur();

	public IJeu creationDuMode(int type);

	public abstract void partie(int clef);
	public abstract void regleDuMode();

	public String comparaison(String proposition, String combinaisonIA);
	public String nouvelleProposition(String reponseJoueur, String propositionIA, int essai);
	public boolean activationModeDev(int clef);
	public String victoire();
	public String conditionGagnantPerdant(String reponse, String proposition);
	public String conditionGagnantPerdantDuel(String proposition, String reponseIA, String reponseJoueur, String propositionIA, int tentative, int essai, int clef);

	public int clef = ordinateur.combinaisonAleatoire();
}