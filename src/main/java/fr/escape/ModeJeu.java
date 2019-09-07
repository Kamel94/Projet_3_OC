package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class ModeJeu   {
	
	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	Victoire v = new Victoire();
	
	int nbrEssai = conf.nbEssai();
	boolean dev = conf.modeDev();
	int chiffreCombi = conf.chiffreCombi();
	int clef = ordinateur.combinaisonAleatoire();
	int premiereProposition = ordinateur.premiereProposition();
	public String nouvelleProposition;
	public int essai;
	
	protected String modeChallenger(int clef) {
		
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String proposition = "";
		String resultat = "";
		String victoireJoueur = v.victoire();
		String expression = "^[0-9]+$";
		
		proposition = clavier.nextLine();
			
		proposition.matches(expression);
			
		while(proposition.matches(expression) == false) {
			Log.logger.error("\nVeuillez entrer uniquement des chiffres svp !");
			System.out.print("Proposition joueur : ");
			proposition = clavier.nextLine();
		}
		
		while(proposition.length() != chiffreCombi) {
			Log.logger.fatal("\nVous n'avez pas entré le bon nombre de chiffre !!");
			reponse = "Vous devez entrer " + chiffreCombi + " chiffres !";
			Log.logger.fatal("\nProposition : " + proposition + " -> Réponse : " + reponse);
			reponse = "";
			System.out.print("\nProposition joueur : ");
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
			}
			
			comb[i] = Integer.parseInt("" + combinaison.charAt(i));
			
			if (joueur[i] == comb[i]) {
				reponse += "=";
			} else if (joueur[i] > comb[i]) {
				reponse += "-";
			} else {
				reponse += "+";
			}
			
		} // Fin for

		try {
			if(clef == Integer.parseInt(proposition)) {
				Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse + "\n");
				reponse = "";
				resultat = v.victoire();
			} else {
				Log.logger.info("Proposition : " + proposition + " -> Réponse : " + reponse);
				reponse = "";
			}
		} catch (NumberFormatException e) {
		}
		return resultat;
	}
	
	public String modeDefenseur() {
		
		Scanner clavier = new Scanner(System.in);
		String reponseJoueur = "";
		String victoireJoueur = "";
		String resultat = "";
		int chiffreProposition = 0;
		String propositionIA;
		
		victoireJoueur = v.victoire();
		
		if(this.nouvelleProposition == null) {
			propositionIA = String.valueOf(premiereProposition);
		} else {
			propositionIA = this.nouvelleProposition;
		}
		
		this.essai++;
		
		Log.logger.info("\nEssai n° : " + this.essai + "\n");
		
		if(this.nouvelleProposition == null) {
			Log.logger.info("Première combinaison IA : " + propositionIA);	
		} else {
			Log.logger.info("Nouvelle combinaison IA : " + this.nouvelleProposition);
		}
		
		System.out.print("Réponse joueur : ");
		
		reponseJoueur = clavier.nextLine();
	
		String expression = "^[+=-]+$";
		reponseJoueur.matches(expression);
		
		while(reponseJoueur.matches(expression) == false) {
			Log.logger.error("Vous devez entrer que +, -, =");
			System.out.print("Réponse joueur : ");
			reponseJoueur = clavier.nextLine();
		}
		
		while(reponseJoueur.length() != chiffreCombi) {
			Log.logger.fatal("\nVous n'avez pas entré le bon nombre de caractère !!");
			reponseJoueur = "Vous devez entrer " + chiffreCombi + " caractères !";
			Log.logger.fatal("\nProposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
			System.out.print("\nProposition joueur : ");
			reponseJoueur = clavier.nextLine();
		}
	
		if(reponseJoueur.matches(expression) == true) {
			nouvelleProposition = "";
		}
		
		char[] r = reponseJoueur.toCharArray();
	
		int i = 0;
		for (char indication : r) {
		
			try {
				chiffreProposition = Integer.parseInt(String.valueOf(propositionIA.charAt(i)));
			} catch (StringIndexOutOfBoundsException e) {
			}
			
			if(String.valueOf(indication).equals("=")) {
				this.nouvelleProposition += chiffreProposition ;
			} else if (String.valueOf(indication).equals("+")) {
				if ((chiffreProposition + 1) > 9) {
					this.nouvelleProposition += 9;
					Log.logger.error("Impossible de faire + que 9 !!");
				} else if(this.essai == 1) {
					this.nouvelleProposition += chiffreProposition + 2;
				} else if(this.essai > 1) {
					this.nouvelleProposition += chiffreProposition + 1;
				}
				
			} else if (String.valueOf(indication).equals("-")) {
				if ((chiffreProposition - 1) < 0) {
					this.nouvelleProposition += 0;
					Log.logger.error("Impossible de faire - que 0 !!");
				} else if(this.essai == 1) {
					this.nouvelleProposition += chiffreProposition - 3;
				} else if(this.essai > 1){
					this.nouvelleProposition += chiffreProposition - 1;
				}
			}
			
			i++;
			
		} // Fin for
		
			if (String.valueOf(reponseJoueur).equals(v.victoire())) {
				Log.logger.info("Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
				resultat = victoireJoueur;
				this.nouvelleProposition = String.valueOf(premiereProposition);
				this.essai = 0;
			} else {
				Log.logger.info("Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
			}
			
			if(this.essai == nbrEssai) {
				this.nouvelleProposition = String.valueOf(premiereProposition);
				this.essai = 0;
			}
			
		return resultat;
	}
}
