package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;

public class Utilitaire {

	public final static int MENU1 = 1;
	public final static int MODE_CHALLENGER = 1;
	public final static int MODE_DEFENSEUR = 2;
	public final static int MODE_DUEL = 3;
	public final static int JEU_FINI = 4;

	public final static int MENU2 = 2;
	public final static int REJOUER = 1;
	public final static int CHANGER_MODE = 2;
	public final static int QUITTER = 3;

	static Configuration configuration = Configuration.getInstance();
	static IA IA = new IA();
	public final static boolean dev = configuration.modeDev(); // Récupère la valeur de la méthode dans la classe configuration pour déterminer l'activation ou non du mode développeur.
	public final static int tailleCombi = configuration.tailleCombi();
	public final static int nbrEssai = configuration.nbEssai();
	public final static int chiffreCombi = configuration.tailleCombi();

	public String clavier() {
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		String saisie = clavier.nextLine();
		return saisie;
	}
}