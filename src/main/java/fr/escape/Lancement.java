package fr.escape;

import fr.escape.Challenger;

public class Lancement extends Menu {

	Challenger challenger = new Challenger();
	Defenseur defenseur = new Defenseur();
	Duel duel = new Duel();
	Ordinateur ordinateur = new Ordinateur();
	Utilitaire utilitaire = new Utilitaire();

	int clef = ordinateur.combinaisonAleatoire();
	public final static int MODE_CHALLENGER = 1;
	public final static int MODE_DEFENSEUR = 2;
	public final static int MODE_DUEL = 3;
	public final static int QUITTER = 4;

	@Override
	public void titre() {
		System.out.println("Bienvenue dans notre jeu Escape Game ONLINE." + "\n" + "Pour commencer, choisissez un mode de jeu parmis les 3 modes suivant.");
	}

	@Override
	public void description() {
		System.out.println("\n1 = Mode Challenger" + "\n2 = Mode Défenseur" + "\n3 = Mode Duel" + "\n4 = Quitter le jeu");
	}

	@Override
	public int choix(int choixMenu) {

		FinDePartie fin = new FinDePartie();
		boolean menuChoisi = false;

		String saisie = ordinateur.lireSaisieUtilisateur(1, menuChoisi);
		choixMenu = 0;
		try {
			choixMenu = Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
		} 

		if(choixMenu == MODE_CHALLENGER) {
			System.out.println("Vous avez choisi le mode : Challenger");
			challenger.partie(clef);
			fin.choix(Lancement.MODE_CHALLENGER);
		} else if(choixMenu == MODE_DEFENSEUR) {
			System.out.println("Vous avez choisi le mode : Défenseur");
			defenseur.partie(clef);
			fin.choix(MODE_DEFENSEUR);
		} else if(choixMenu == MODE_DUEL) {
			System.out.println("Vous avez choisi le mode : Duel");
			duel.partie(clef);
			fin.choix(MODE_DUEL);
		} else if(choixMenu == QUITTER) {
			fin();
		}
		return choixMenu;
	}
}