package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.escape.*;

public class Joueur {
	
	Configuration conf = new Configuration();
	//Challenger c = new Challenger();
	Ordinateur o = new Ordinateur();
	//boolean b;
	
	int nbrEssai = conf.nbEssai();
	
	int chiffreCombi = conf.chiffreCombi();
	
	public String victoireJoueur() {
		
		char[] tailleReponse = new char [conf.chiffreCombi()];
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
			tailleReponse[i] = '=';
		}
		String victoireJoueur = String.valueOf(tailleReponse);
		
		return victoireJoueur;
	
	}
	
	
	public String propositionJoueur() {
		
		Scanner clavier = new Scanner(System.in);
		
		String proposition = clavier.nextLine();
		
		String propositionJ = proposition; 
		
		return propositionJ;
	}
	
	public String rechercheCombi(int clef) {
		
		
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String reponseJoueur = "";
		String proposition = "";
		int essai = 0;
		int essaiIA = 0;
		String resultat = "";
		String nouvelleProposition = "";
		int chiffreProposition = 0;
		
		int premiereProposition = o.premiereProposition();
		
		String victoireJoueur = victoireJoueur();
		
		String propositionIA = String.valueOf(premiereProposition);
		
		String expression = "^[0-9]+$";
		proposition = propositionJoueur();
		
		System.out.println(clef);
		
		boolean b = true;
		while(proposition.length() == chiffreCombi || proposition.length() != chiffreCombi) {
		
			//reponse = "";
			essai++;
			/*if(proposition.matches(expression) == false && proposition != "") {
				
				//System.out.println("\nEssai n° : " + essai);
				
			} */
			
			
			proposition.matches(expression);
			
			if(proposition.matches(expression) == false) {
				System.out.println("\nVeuillez entrer uniquement des chiffres svp !");
				System.out.print("Proposition joueur : ");
				proposition = propositionJoueur();
			}
		
		int taille = proposition.length();
		
		int[] joueur = new int[taille];
		String combinaison = "" + clef;
		int[] comb = new int[combinaison.length()];
		
		
		
		for (int i = 0; i < taille && i < combinaison.length(); i++) {
			
			try {
				joueur[i] = Integer.parseInt(proposition.charAt(i) + "");
			} catch(NumberFormatException e) {
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
		
		
		// faire une condition pour les expressions régulières (uniquement les chiffres)
	 
		
	 
		try {
			if(clef == Integer.parseInt(proposition)) {
				System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
				reponse = "";
				resultat = victoireJoueur();
				break;
			}  else if(taille != chiffreCombi) {
				System.out.println("\nVous n'avez pas entré le bon nombre de chiffre !!");
				reponse = "Vous devez entrer " + chiffreCombi + " chiffres !";
				System.out.println("\nProposition : " + proposition + " -> Réponse : " + reponse);
				reponse = "";
				System.out.print("\nProposition joueur : ");
				proposition = propositionJoueur();
				
				taille = proposition.length();
				
				joueur = new int[taille];
				combinaison = "" + clef;
				comb = new int[combinaison.length()];
				
				/*for (int i = 0; i < taille && i < combinaison.length(); i++) {
					
					try {
						joueur[i] = Integer.parseInt(proposition.charAt(i) + "");
					} catch(NumberFormatException e) {
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
					
				}*/ //fin FOR
			} else if(clef != Integer.parseInt(proposition) && taille == chiffreCombi ) {
				System.out.println("\nProposition : " + proposition + " -> Réponse : " + reponse);
				reponse = "";
				b = false;
				break;
			}
		
			if(essai == nbrEssai && clef != Integer.parseInt(proposition)) {
				System.out.println("Désolé vous avez atteint le nombre d'essai limité...");
				proposition = "";
				reponse = "La combinaison était : " + clef;
			} else if(essai == nbrEssai - 1) {
				System.out.println("Attention il vous reste 1 essai !!\n");
			}
		
		} catch(NumberFormatException e) {
		 
		}
		
		
		
		
		
		/*Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String proposition = "";
		int essai = 0;
		
		
		boolean b = true;
		
		while(b && essai < nbrEssai) {
		
			reponse = "";
			if(proposition == "") {
			System.out.print("Proposition joueur : ");
			}
		
		proposition = propositionJoueur();
		int taille = proposition.length();
		
		int[] joueur = new int[taille];
		String combinaison = "" + clef;
		int[] comb = new int[combinaison.length()];
		
		System.out.println(clef);
		
		for (int i = 0; i < taille && i < combinaison.length(); i++) {
			
			try {
				joueur[i] = Integer.parseInt(proposition.charAt(i) + "");
			} catch(NumberFormatException e) {
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
		
		if(essai != nbrEssai) {
			essai++;
			Log.logger.info("\nEssai n° : " + essai);
		} 	
	 
		String expression = "^[0-9]+$";
		
		proposition.matches(expression);
		
		if(proposition.matches(expression) == false) {
			Log.logger.error("\nVeuillez entrer uniquement des chiffres svp !");
			if(taille != chiffreCombi) {
				essai++;
			}
			essai = essai - 1;
		} else {
			//System.out.println("Ok");
		}
		
		if(taille != chiffreCombi) {
			Log.logger.error("\nVous n'avez pas entré le bon nombre de chiffre !! \nVous devez entrer " + chiffreCombi + " chiffres !\n");
			essai = essai - 1;
			b = true;
		}
	 
		try {
			if(clef == Integer.parseInt(proposition)) {
				Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
				reponse = "";
				reponse = "\nFélicitation vous avez gagné !! \n" + 
						"Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				b = false;
			} else {
				Log.logger.info("\nProposition : " + proposition + " -> Réponse : " + reponse + "\n" + "Proposition joueur : ");
				reponse = "";
				b = true;
			}
		
			if(essai == nbrEssai && clef != Integer.parseInt(proposition)) {
				Log.logger.info("Désolé vous avez atteint le nombre d'essai limité...");
				proposition = "";
				reponse = "La combinaison était : " + clef;
			} else if(essai == nbrEssai - 1) {
				Log.logger.warn("Attention il vous reste 1 essai !!\n");
			}
		
		} catch(NumberFormatException e) {
		 
		} */
	
	} //fin while
		
		
		
		return resultat;
	}
	
}
