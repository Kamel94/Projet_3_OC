package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class ModeJeu   {
	
	Configuration conf = new Configuration();
	Ordinateur o = new Ordinateur();
	Joueur j = new Joueur();
	
	int nbrEssai = conf.nbEssai();
	boolean dev = conf.modeDev();
	int chiffreCombi = conf.chiffreCombi();
	int clef = o.combinaisonAleatoire();
	int premiereProposition = o.premiereProposition();
	public String nouvelleProposition;
	public int essai;
	
	public String modeChallenger(int clef) {
		
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String resultat = "";
		String proposition = "";
		int essai = 0;
		
		while(essai != nbrEssai) {
			
			reponse = "";
			
			if(essai != nbrEssai) {
				essai++;
				System.out.println("\nEssai n° : " + essai);
			} 
			
			System.out.print("Proposition joueur : ");
		
			if(String.valueOf(j.rechercheCombi(clef)).equals(j.victoireJoueur())) {
				reponse = "Félicitation vous avez gagné !! \n" + 
								"Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				essai = nbrEssai;
			} else if (essai == nbrEssai){
				reponse = "\nDésolé vous avez atteint le nombre d'essai limité... \nLa combinaison était : " + clef;
				essai = nbrEssai;
			} else if(essai == nbrEssai - 1) {
				System.out.println("\nAttention il vous reste 1 essai !!\n");
			}
		
		} //fin while
	 
		return resultat;
	}
	
	public String modeDefenseur() {
		
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String reponseJoueur = "";
		String proposition = "";
		String victoireJoueur = "";
		int essai = 0;
		int essaiIA = 0;
		String resultat = "";
		int chiffreProposition = 0;
		String propositionIA;
		
		victoireJoueur = j.victoireJoueur();
		
		if(this.nouvelleProposition == null) {
		propositionIA = String.valueOf(premiereProposition);
		} else {
			propositionIA = this.nouvelleProposition;
		}
		
		this.essai++;
		
		System.out.println("\nEssai n° : " + this.essai + "\n");
	if(this.nouvelleProposition == null) {
		System.out.println("Première combinaison IA : " + propositionIA);	
	} else {
		System.out.println("Nouvelle combinaison IA : " + this.nouvelleProposition);
	}
		System.out.print("Réponse joueur : ");
		
		this.nouvelleProposition = "";
		
	reponseJoueur = clavier.nextLine();
	
	String expression = "^[+=-]+$";
	
	reponseJoueur.matches(expression);
	
	if(reponseJoueur.matches(expression) == false) {
		System.out.println("Vous devez entrer que +, -, =");
		System.out.print("Réponse joueur : ");
		reponseJoueur = clavier.nextLine();
	}
	
	if(reponseJoueur.length() != chiffreCombi) {
		System.out.println("\nVous n'avez pas entré le bon nombre de caractère !!");
		reponseJoueur = "Vous devez entrer " + chiffreCombi + " caractères !";
		System.out.println("\nProposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
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
			
			} // fin for
		
		try {
			if (String.valueOf(reponseJoueur).equals(j.victoireJoueur())) {
				System.out.println("Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
				resultat = victoireJoueur;
				this.nouvelleProposition = String.valueOf(premiereProposition);
				this.essai = 0;
				essaiIA = nbrEssai + 1;
				//break;
			} else {
				System.out.println("Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
			}
			
			if(this.essai == nbrEssai) {
				this.nouvelleProposition = String.valueOf(premiereProposition);
				this.essai = 0;
			}
			
			propositionIA = this.nouvelleProposition;
			
			} catch(NumberFormatException e) {
			}
		
		return resultat;
	}
	
	public String modeDuel(int clef) {
			
		String reponseJoueur = "";
		String proposition = "";
		String victoireJoueur = "";
		String resultat = "";
		String victoire = j.victoireJoueur();
		int essai = 0;
		
		
		while(essai < nbrEssai){
			
			if(essai != nbrEssai) {
				essai++;
				System.out.println("\nEssai n° : " + essai);
			} 
			
			System.out.print("Proposition joueur : ");
		
			if(String.valueOf(j.rechercheCombi(clef)).equals(victoire)) {
				resultat = "\nFélicitation vous avez gagné !! \n" + 
							"Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				victoireJoueur = j.victoireJoueur();
				essai = nbrEssai + 1;
			}
		
			if(modeDefenseur().equals(victoire)) {
				resultat = "\nDommage ! L'IA a gagné... \n" + 
					"L'IA a trouvé la bonne combinaison en " + essai + " essai(s)." + "\nLa combinaison de l'IA était : " + clef;
				reponseJoueur = victoire;
				essai = nbrEssai + 1;
			}
		
			if(String.valueOf(victoireJoueur).equals(victoire) && String.valueOf(reponseJoueur).equals(victoire)) {
				resultat ="\nVous avez tous les deux trouvés la bonne combinaison de chacun !" + "\nIl n'y a pas de gagnant...";
			} else if(essai == nbrEssai) {
				resultat = "\nVous avez atteint le nombre d'essai limité !" + "\nIl n'y a pas de gagnant..." + "\nLa combinaison de l'IA était : " + clef;
				essai = nbrEssai + 1;
			}
			
			if(essai >= nbrEssai) {
				this.nouvelleProposition = String.valueOf(premiereProposition);
				this.essai = 0;
			} else if(essai == nbrEssai - 1) {
				System.out.println("\nAttention il vous reste 1 essai !!\n");
			}
		
		} //fin while
		
		return resultat;
	}
}
