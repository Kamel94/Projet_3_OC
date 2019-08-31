package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;
import fr.escape.*;

public class Joueur {
	
	Configuration conf = new Configuration();
	Ordinateur o = new Ordinateur();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	int premiereProposition = o.premiereProposition();
	
	Scanner clavier = new Scanner(System.in);
	
	public String victoireJoueur() {
		
		char[] tailleReponse = new char [conf.chiffreCombi()];
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
			tailleReponse[i] = '=';
		}
		String victoireJoueur = String.valueOf(tailleReponse);
		
		return victoireJoueur;
	
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
		
		String victoireJoueur = victoireJoueur();
		
		String expression = "^[0-9]+$";
		proposition = clavier.nextLine();
		
		boolean b = true;
		while(proposition.length() == chiffreCombi || proposition.length() != chiffreCombi) {
		
			essai++;
			
			proposition.matches(expression);
			
			if(proposition.matches(expression) == false) {
				System.out.println("\nVeuillez entrer uniquement des chiffres svp !");
				System.out.print("Proposition joueur : ");
				proposition = clavier.nextLine();
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
				proposition = clavier.nextLine();
				
				taille = proposition.length();
				
				joueur = new int[taille];
				combinaison = "" + clef;
				comb = new int[combinaison.length()];
			} else if(clef != Integer.parseInt(proposition) && taille == chiffreCombi ) {
				System.out.println("\nProposition : " + proposition + " -> Réponse : " + reponse);
				reponse = "";
				b = false;
				break;
			}
		
		} catch(NumberFormatException e) {
		 
		}
	
	} //fin while
		
		return resultat;
	}
	
}
