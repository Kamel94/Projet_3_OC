package fr.escape;

import java.util.Scanner;

public class Utilitaire {

	public String clavier() {
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		String saisie = clavier.nextLine();
		return saisie;
	}
}