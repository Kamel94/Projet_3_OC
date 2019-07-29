package fr.escape;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Challenger {
	
	Configuration conf = new Configuration();
	
	int nEssai = conf.nbEssai();
	int nbrCombi = conf.nombreCombi();
	boolean dev = conf.modeDev();
	
	public int combIA() {
		
		int min = 0;
		int max = nbrCombi;
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		String alea = "" + nombreAleatoire;
		int[] combIA = new int[alea.length()];
		
		for(int i = 0; i < alea.length(); i++) {
			combIA[i] = Integer.parseInt("" + alea.charAt(i));
		}
		
		return nombreAleatoire;
	}
	
	
	public String challenger(int clef) {

		System.out.println("Bienvenue dans le mode Challenger." +  
		"\nDans ce mode l'IA choisi une combinaison et vous devez trouver la bonne combinaison en " + nEssai + " essai. \nA vous de jouer !! \n");
		
		String reponse = "";
		String proposition = "";
		String combinaison;
		int taille;
		int essai = 0;
		
		Scanner clavier = new Scanner(System.in);
		
		if (dev == true) {
			System.out.println(clef);
		}
		
		boolean b = true;
		
		while(b && essai < nEssai) {
			
			
			proposition = clavier.nextLine();
			
			
			taille = proposition.length();
			int[] joueur = new int[taille];
			combinaison = "" + clef;
			int[] comb = new int[combinaison.length()];
			
		for (int i = 0; i < taille && i < combinaison.length(); i++) {
		
			try {
				joueur[i] = Integer.parseInt(proposition.charAt(i) + "");
			} catch(NumberFormatException e) {
				System.out.println("Veuillez entrer uniquement des chiffres svp !");
	        	b = true;
			}
			
			
			comb[i] = Integer.parseInt("" + combinaison.charAt(i));
			
			
			if (joueur[i] == comb[i]) {
				reponse += "=";
			} else if (joueur[i] > comb[i]) {
				reponse += "-";
			} else {
				reponse += "+";
			}
			
		} //fin FOR
		
		
		 if(essai != nEssai) {
			essai++;
			System.out.println("Essai n° : " + essai);
		}
			
			switch(reponse) {
				case "====" :
					System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
					reponse = "";
					reponse = "Félicitation vous avez gagné !! \n" + 
					"Vous avez trouvé la bonne combinaison en " + essai + " essai.";
					b = false;
					break;
				case "===" :
					if(clef < 1111) {
						System.out.println("Bravo vous avez gagné !");
						b = false;
						} else {
							System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse);
							reponse = "";
							b = true;
						}
					break;
				case "==" :
					if(clef < 111) {
						System.out.println("Bravo vous avez gagné !");
						b = false;
						} else {
							System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse);
							reponse = "";
							b = true;
						}
					break;
				case "=" :
					if(clef < 11) {
						System.out.println("Bravo vous avez gagné !");
						b = false;
						} else {
							System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse);
							reponse = "";
							b = true;
						}
					break;	
				default :
					System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
					reponse = "";
					b = true;
			}
			
			if(essai == nEssai) {
				System.out.println("Désolé vous avez atteint le nombre d'essai limité...");
				proposition = "";
				reponse = "La combinaison était : " + clef;
			}
		
		} //fin while
		
		return reponse;
	}

}
