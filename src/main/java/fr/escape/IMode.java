package fr.escape;

public interface IMode {

	public void partie(int clef);
	public void regleDuMode();

	public String comparaison(String proposition, String combinaisonIA);
	public String nouvelleProposition(String reponseJoueur, String propositionIA, int essai);
	public boolean activationModeDev(int clef);
	public String victoire();
	public String conditionGagnantPerdant(String reponse, String proposition);
	public String conditionGagnantPerdantDuel(String proposition, String reponseIA, String reponseJoueur, String propositionIA, int tentative, int essai, int clef);
}