package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Ordinateur {
	
	Configuration conf = new Configuration();
	
	int nEssai = conf.nbEssai();
	boolean dev = conf.modeDev();
	int chiffreCombi = conf.chiffreCombi();
	
	public int combinaisonAleatoire() {
		
		char[] tailleCombiMin = new char [conf.chiffreCombi()];
		char[] tailleCombiMax = new char [conf.chiffreCombi()];
		
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
		tailleCombiMax[i] = '9';
		tailleCombiMin[i] = '1';
		}
		
		int max = Integer.parseInt(String.valueOf(tailleCombiMax));
		int min = Integer.parseInt(String.valueOf(tailleCombiMin));
		
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		
		return nombreAleatoire;
	}
	
	public int premiereProposition() {
		
		char[] tailleCombi = new char [conf.chiffreCombi()];
		
		for(int i = 0; i < conf.chiffreCombi() ; i++) {
		tailleCombi[i] = '5';
		}
		
		String proposition = String.valueOf(tailleCombi);
		int propositionIA = Integer.parseInt(proposition);
		
		return propositionIA;
	}
	
	
	public String propositionIA() {
		
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String reponseJoueur = "";
		String proposition = "";
		String victoireJoueur = "";
		int essai = 0;
		int essaiIA = 0;
		String resultat = "";
		String nouvelleProposition = "";
		int chiffreProposition = 0;
		
		int premiereProposition = premiereProposition();
		
		String victoire = "=====";
		
		String propositionIA = String.valueOf(premiereProposition);
		
		/*essaiIA++;
		
		System.out.println("Essai n° : " + essaiIA + "\n");
	if(nouvelleProposition == "") {
		System.out.println("Première combinaison IA : " + propositionIA);	
	} else {
		System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
	}
		System.out.print("Réponse joueur : ");*/
	
	
	reponseJoueur = clavier.nextLine();
	//resultat = "Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur;
	
	// faire une condition pour les expressions régulières (uniquement les +,=,-)
	
	/*expression = "^[+=-]+$";
	
	reponse.matches(expression);
	
	if(reponse.matches(expression) == false) {
		Log.logger.error("Vous devez entrer que +, -, =");
		if(reponse.length() != chiffreCombi) {
			essai++;
			}
		essai = essai - 1;
	} */
	
	if (reponseJoueur.length() != chiffreCombi) {
		System.out.println("Vous devez entrer " + chiffreCombi + " caractères");
		essai = essaiIA - 1;
	}
	
	boolean b = true;
	while(b) {
		
		essaiIA++;
		
		nouvelleProposition = "";
	
		char[] r = reponseJoueur.toCharArray();
	
		int i = 0;
		for (char indication : r) {
		
			try {
				chiffreProposition = Integer.parseInt(String.valueOf(propositionIA.charAt(i)));
			} catch (StringIndexOutOfBoundsException e) {
			}
		
			if(String.valueOf(indication).equals("=")) {
				nouvelleProposition += chiffreProposition ;
			} else if (String.valueOf(indication).equals("+")) {
				if ((chiffreProposition + 1) > 9) {
					nouvelleProposition += 9;
					Log.logger.error("Impossible de faire + que 9 !!");
				} else if(essaiIA == 1) {
					nouvelleProposition += chiffreProposition + 2;
				} else if(essaiIA > 1){
					nouvelleProposition += chiffreProposition + 1;
				}
				//b = true;
				} else if (String.valueOf(indication).equals("-")) {
					if ((chiffreProposition - 1) < 0) {
						nouvelleProposition += 0;
						Log.logger.error("Impossible de faire - que 0 !!");
					} else if(essaiIA == 1) {
						nouvelleProposition += chiffreProposition - 3;
					} else if(essaiIA > 1){
						nouvelleProposition += chiffreProposition - 1;
					}
				}
				i++;
			
			} // fin for
		
		propositionIA = nouvelleProposition;
		
		System.out.println(propositionIA);
		
		/*if(essaiIA > 1) {
			System.out.println("\nEssai n° : " + essaiIA + "\n");
			System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
			System.out.print("Réponse joueur : ");
			//reponseJoueur = clavier.nextLine();
		}*/
		try {
		if (String.valueOf(reponseJoueur).equals(victoire)) {
			//System.out.println("Dommage ! L'IA a gagné... \n" + 
			//		"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
			//resultat = "Dommage ! L'IA a gagné... \n" + 
			//			"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).";
			resultat = victoire;
			essai = nEssai;
			b = false;
		} else {
			System.out.println("Proposition : " + nouvelleProposition + " -> Réponse : " + reponseJoueur);
			break;
		}
		
		
		if(String.valueOf(reponseJoueur).equals(victoire) && String.valueOf(victoireJoueur).equals(victoire)) {
			resultat = "\nVous êtes à égaliter !!";
		}
		} catch(NumberFormatException e) {
		}
	}	
		return resultat;
	}

}
