package fr.escape;

import java.util.Scanner;

public class Challenger  {
	
	public static int combIA() {
		
		int min = 0000;
		int max = 9999;
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		String alea = "" + nombreAleatoire;
		int[] combIA = new int[alea.length()];
		
		for(int i = 0; i < alea.length(); i++) {
			combIA[i] = Integer.parseInt("" + alea.charAt(i));
		}
		
		return nombreAleatoire;
	}
	
	
	static String challenger(int clef) {

		System.out.println("Bienvenue dans le mode Challenger." +  
		"\nDans ce mode l'IA choisi une combinaison et vous devez trouver la bonne combinaison en un nombre d'essai limité. A vous de jouer !! ");
		
		String reponse = "";
		String proposition = "";
		String combinaison;
		int taille;
		Scanner clavier = new Scanner(System.in);
		
      	//System.out.println(clef);
		
		boolean r = true;
		
		while(r) {
			
			proposition = clavier.nextLine();
			taille = proposition.length();
			int[] joueur = new int[taille];
			combinaison = "" + clef;
			int[] comb = new int[combinaison.length()];
			
		for (int i = 0; i < taille && i < combinaison.length(); i++) {
		
			joueur[i] = Integer.parseInt(proposition.charAt(i) + "");
			
			comb[i] = Integer.parseInt("" + combinaison.charAt(i));
			
			
			
			if (joueur[i] == comb[i]) {
				reponse += "=";
			} else if (joueur[i] > comb[i]) {
				reponse += "-";
			} else {
				reponse += "+";
			}
			
		} //fin FOR
		
			
			switch(reponse) {
				case "====" :
					System.out.println("Bravo vous avez gagné !");
					r = false;
					break;
				case "===" :
					System.out.println("Bravo vous avez gagné !");
					r = false;
					break;
				case "==" :
					System.out.println("Bravo vous avez gagné !");
					r = false;
					break;
				case "=" :
					System.out.println("Bravo vous avez gagné !");
					r = false;
					break;	
				default :
					System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse);
					reponse = "";
					r = true;
			}
		
		} //fin while
		
		return "Proposition : " + proposition + " -> Réponse : " + reponse;
	}

}
