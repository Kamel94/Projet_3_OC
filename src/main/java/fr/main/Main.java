package fr.main;

import java.lang.String;

import fr.escape.Demarrer;
import fr.escape.Lancement;

public class Main {

	public static void main(String[] args) {

		Demarrer m = new Demarrer(new Lancement());
		m.choisirMenu("Début");
	}
}