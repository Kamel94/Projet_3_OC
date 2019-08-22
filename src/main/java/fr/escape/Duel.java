package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Duel implements EtapeOrdinateur, EtapeJoueur {
	
	Configuration conf = new Configuration();
	Ordinateur o = new Ordinateur();
	Joueur j = new Joueur();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	int clef = o.combinaisonAleatoire();
	

	
	@Override
	public String etapeJoueur(int clef) {
		
		
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
		
		int premiereProposition = o.premiereProposition();
		
		String victoire = j.victoireJoueur();
		
		String propositionIA = String.valueOf(premiereProposition);
		
		
		System.out.println("Bienvenue dans le mode Duel ! \nDans ce mode, vous et l'IA jouez chacun votre tour pour deviner la combinaison de l'autre." + 
			"\nLe premier qui aura trouvé la combinaison de son adversaire aura gagné la partie !!" + 
				"\n" + "Attention !! Vous aurez chacun uniquement " + nbrEssai + " essai(s) pour trouver la bonne combinaison..." + "\n" + 
					"Bonne partie et que le meilleur gagne !!!");
		

		while(essai < nbrEssai){
		
			
			reponse = "";
			
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
		
		/*essaiIA++;
		
		System.out.println("Essai n° : " + essaiIA + "\n");
	if(nouvelleProposition == "") {
		System.out.println("Première combinaison IA : " + propositionIA);	
	} else {
		System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
	}
		System.out.print("Réponse joueur : ");
		
		if(String.valueOf(etapeOrdinateur()).equals(victoire)) {
			resultat = "\nDommage ! L'IA a gagné... \n" + 
					"L'IA a trouvé la bonne combinaison en " + essaiIA + " essai(s).";
			essai = nbrEssai + 1;
		}*/
		
		
		essaiIA++;
		
			System.out.println("Essai n° : " + essaiIA + "\n");
		if(nouvelleProposition == "") {
			System.out.println("Première combinaison IA : " + propositionIA);	
		} else {
			System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
		}
			System.out.print("Réponse joueur : ");
			
			
		reponseJoueur = clavier.nextLine();
		
		String expression = "^[+=-]+$";
		
		reponseJoueur.matches(expression);
		
		if(reponseJoueur.matches(expression) == false) {
			System.out.println("Vous devez entrer que +, -, =");
			//propositionIA = propositionIA;
			System.out.print("Réponse joueur : ");
			reponseJoueur = clavier.nextLine();
		}
		 
		
		if (reponseJoueur.length() != chiffreCombi) {
			System.out.println("Vous devez entrer " + chiffreCombi + " caractères");
			//essai = essaiIA - 1;
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
			
			
			try {
			if (String.valueOf(reponseJoueur).equals(victoire)) {
				resultat = "\nDommage ! L'IA a gagné... \n" + 
							"L'IA a trouvé la bonne combinaison en " + essaiIA + " essai(s).";
				essai = nbrEssai + 1;
				essaiIA = nbrEssai + 1;
				//break;
			} else if(String.valueOf(victoireJoueur).equals(victoire)) {
				essaiIA = nbrEssai + 1;
			} else {
				System.out.println("Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
			}
			
			if(essaiIA == nbrEssai || String.valueOf(victoireJoueur).equals(victoire) && String.valueOf(reponseJoueur).equals(victoire)) {
				resultat = "\nVous êtes à égaliter !!";
			}
			
			
			} catch(NumberFormatException e) {
			}
			
			if(reponseJoueur.matches(expression) == true) {
				propositionIA = nouvelleProposition;
			}
			
		
	} //fin while
			
		
		return resultat;
	}

	
	
	
	@Override
	public String etapeOrdinateur() {
		
		/*int premiereProposition = o.premiereProposition();
		
		String victoireJoueur = j.victoireJoueur();
		
		String propositionIA = String.valueOf(premiereProposition);
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String resultat = "";
		String nouvelleProposition = "";
		int chiffreProposition = 0;
		boolean b = true;
		int essai = 0;
		essai++;
		
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
		
		int premiereProposition = o.premiereProposition();
		
		String victoire = j.victoireJoueur();
		
		String propositionIA = String.valueOf(premiereProposition);
		
		essaiIA++;
		
		System.out.println("Essai n° : " + essaiIA + "\n");
	if(nouvelleProposition == "") {
		System.out.println("Première combinaison IA : " + propositionIA);	
	} else {
		System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
	}
		System.out.print("Réponse joueur : ");
		
		
	reponseJoueur = clavier.nextLine();
	
	String expression = "^[+=-]+$";
	
	reponseJoueur.matches(expression);
	
	if(reponseJoueur.matches(expression) == false) {
		System.out.println("Vous devez entrer que +, -, =");
		//propositionIA = propositionIA;
		System.out.print("Réponse joueur : ");
		reponseJoueur = clavier.nextLine();
	}
	 
	
	if (reponseJoueur.length() != chiffreCombi) {
		System.out.println("Vous devez entrer " + chiffreCombi + " caractères");
		//essai = essaiIA - 1;
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
		
		
		try {
		if (String.valueOf(reponseJoueur).equals(victoire)) {
			resultat = victoire;
			essai = nbrEssai + 1;
			essaiIA = nbrEssai + 1;
			//break;
		} else if(String.valueOf(victoireJoueur).equals(victoire)) {
			essaiIA = nbrEssai + 1;
		} else {
			System.out.println("Proposition : " + propositionIA + " -> Réponse : " + reponseJoueur);
		}
		
		if(essaiIA == nbrEssai || String.valueOf(victoireJoueur).equals(victoire) && String.valueOf(reponseJoueur).equals(victoire)) {
			resultat = "\nVous êtes à égaliter !!";
		}
		
		
		} catch(NumberFormatException e) {
		}
		
		if(reponseJoueur.matches(expression) == true) {
			propositionIA = nouvelleProposition;
		}
		
	//	} // fin while*/
		
		return null;
	}

}
