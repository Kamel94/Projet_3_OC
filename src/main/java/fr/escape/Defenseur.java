package fr.escape;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

import fr.escape.Challenger;

import fr.configuration.*;

public class Defenseur implements EtapeOrdinateur {
	
	Challenger challenger = new Challenger();
	Ordinateur ordinateur = new Ordinateur();
	Joueur joueur = new Joueur();
	Configuration conf = new Configuration();
	
	int nbrEssai = conf.nbEssai();
	int clef = ordinateur.combinaisonAleatoire();
	int premiereProposition = ordinateur.premiereProposition();
	int chiffreCombi = conf.chiffreCombi();
	String victoireJoueur = joueur.victoireJoueur();
	
	public String defenseur() {
		
		String modeDefenseur = etapeOrdinateur();
		
		/*String propositionIA = String.valueOf(premiereProposition);
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String nouvelleProposition = "";
		int chiffreProposition = 0;
		boolean b = true;
		int essai = 0;
		essai++;
		
		System.out.println("\nBienvenue dans le mode Défenseur." +  
				"\nDans ce mode vous devez choisir une combinaison de " + chiffreCombi +
				" chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");
		
		System.out.println("Essai n° : " + essai + "\n");
		System.out.println("Première combinaison IA : " + propositionIA);
		System.out.print("Réponse joueur : ");
		
		reponse = clavier.nextLine();
		
		System.out.println("Proposition : " + propositionIA + " -> Réponse : " + reponse);
		
		if (String.valueOf(reponse).equals(victoireJoueur)) {
			System.out.println("Dommage ! L'IA a gagné... \n" + 
					"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
			b = false;
		}
		
		String expression = "^[+=-]+$";
		
		reponse.matches(expression);
		
		if(reponse.matches(expression) == false) {
			Log.logger.error("Vous devez entrer que +, -, =");
			if(reponse.length() != chiffreCombi) {
				essai++;
				}
			essai = essai - 1;
		} 
		
		if (reponse.length() != chiffreCombi) {
			Log.logger.error("Vous devez entrer " + chiffreCombi + " caractères");
			essai = essai - 1;
		}
		
		while(b) {
			
			nouvelleProposition = "";
		
			char[] r = reponse.toCharArray();
		
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
					} else if(essai == 1) {
						nouvelleProposition += chiffreProposition + 2;
					} else {
						nouvelleProposition += chiffreProposition + 1;
					}
					b = true;
					} else if (String.valueOf(indication).equals("-")) {
						if ((chiffreProposition - 1) < 0) {
							nouvelleProposition += 0;
							Log.logger.error("Impossible de faire - que 0 !!");
						} else if(essai == 1) {
							nouvelleProposition += chiffreProposition - 3;
						} else {
							nouvelleProposition += chiffreProposition - 1;
						}
					}
					i++;
				
				} // fin for

			propositionIA = nouvelleProposition;
			
			/*if(reponse.length() != chiffreCombi) {
				nouvelleProposition = String.valueOf(premiereProposition);
			}//
		
			if(essai != nbrEssai) {
				essai++;
				System.out.println("\nEssai n° : " + essai + "\n");
				System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
				System.out.print("Réponse joueur : ");
			
				try {
					reponse = clavier.nextLine();
					} catch(StringIndexOutOfBoundsException e) {
					}
						
				if(String.valueOf(reponse).equals(victoireJoueur)) {
					System.out.println("Dommage ! L'IA a gagné... \n" + 
						"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
					nouvelleProposition = "";
					b = false;
					break;
				}  
				
				if(reponse.matches(expression) == false) {
					Log.logger.error("Vous devez entrer que +, -, =");
					if(reponse.length() != chiffreCombi) {
					essai++;
					}
					essai = essai - 1;
				}  
				
				if(reponse.length() < chiffreCombi || reponse.length() > chiffreCombi ) {
					Log.logger.error("Vous devez entrer " + chiffreCombi + " caractères");
					essai = essai - 1;
				} else {
				}
				
				System.out.println("Proposition : " + nouvelleProposition + " -> Réponse : " + reponse);
				b = true;
			} else if( essai == nbrEssai && reponse == victoireJoueur) {
				nouvelleProposition = "Dommage ! L'IA a gagné... \n" + 
						"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).";
				b = false;
			} else if (essai == nbrEssai && reponse != victoireJoueur) {
					Log.logger.info("L'IA a atteint le nombre d'essai limité, vous avez donc gagné !!!");
					nouvelleProposition = "La partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.";
					b = false;
			}
		
		} */ // fin while
		
		return modeDefenseur;
	} 

	@Override
	public String etapeOrdinateur() {
		
		String propositionIA = String.valueOf(premiereProposition);
		Scanner clavier = new Scanner(System.in);
		String reponse = "";
		String nouvelleProposition = "";
		int chiffreProposition = 0;
		boolean b = true;
		int essai = 0;
		essai++;
		
		System.out.println("\nBienvenue dans le mode Défenseur." +  
				"\nDans ce mode vous devez choisir une combinaison de " + chiffreCombi +
				" chiffres et l'IA doit trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !! \n");
		
		System.out.println("Essai n° : " + essai + "\n");
		System.out.println("Première combinaison IA : " + propositionIA);
		System.out.print("Réponse joueur : ");
		
		reponse = clavier.nextLine();
		
		System.out.println("\nProposition : " + propositionIA + " -> Réponse : " + reponse);
		
		if (String.valueOf(reponse).equals(victoireJoueur)) {
			System.out.println("Dommage ! L'IA a gagné... \n" + 
					"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
			b = false;
		}
		
		String expression = "^[+=-]+$";
		
		reponse.matches(expression);
		
		if(reponse.matches(expression) == false) {
			Log.logger.error("Vous devez entrer que +, -, =");
			if(reponse.length() != chiffreCombi) {
				essai++;
				}
			essai = essai - 1;
		} 
		
		if (reponse.length() != chiffreCombi) {
			Log.logger.error("\nVous devez entrer " + chiffreCombi + " caractères");
			nouvelleProposition = propositionIA;
			essai = essai - 1;
		}
		
		while(b) {
			
			if(reponse.matches(expression) == true || reponse.length() == chiffreCombi) {
				nouvelleProposition = "";
			}
			char[] r = reponse.toCharArray();
		
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
					} else if(essai == 1) {
						nouvelleProposition += chiffreProposition + 2;
					} else {
						nouvelleProposition += chiffreProposition + 1;
					}
					b = true;
					} else if (String.valueOf(indication).equals("-")) {
						if ((chiffreProposition - 1) < 0) {
							nouvelleProposition += 0;
							Log.logger.error("Impossible de faire - que 0 !!");
						} else if(essai == 1) {
							nouvelleProposition += chiffreProposition - 3;
						} else {
							nouvelleProposition += chiffreProposition - 1;
						}
					}
					i++;
				
				} // fin for

			if(reponse.length() == chiffreCombi) {
				propositionIA = nouvelleProposition;
			} else {
				nouvelleProposition = propositionIA;
			}
			
			if(essai != nbrEssai) {
				essai++;
				System.out.println("\nEssai n° : " + essai + "\n");
				System.out.println("Nouvelle combinaison IA : " + nouvelleProposition);
				System.out.print("Réponse joueur : ");
			
				try {
					reponse = clavier.nextLine();
					} catch(StringIndexOutOfBoundsException e) {
					}
						
				if(String.valueOf(reponse).equals(victoireJoueur)) {
					System.out.println("\nProposition : " + nouvelleProposition + " -> Réponse : " + reponse);
					Log.logger.info("\nDommage ! L'IA a gagné... \n" + 
						"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).");
					nouvelleProposition = "";
					b = false;
					break;
				}  
				
				if(reponse.matches(expression) == false) {
					Log.logger.error("Vous devez entrer que +, -, =");
					if(reponse.length() != chiffreCombi) {
					essai++;
					}
					essai = essai - 1;
				}  
				
				if(reponse.length() != chiffreCombi ) {
					Log.logger.error("\nVous devez entrer " + chiffreCombi + " caractères");
					essai = essai - 1;
				}
				
				
				System.out.println("\nProposition : " + nouvelleProposition + " -> Réponse : " + reponse);
				b = true;
			/*} else if( essai == nbrEssai && reponse == victoireJoueur) {
				nouvelleProposition = "\nDommage ! L'IA a gagné... \n" + 
						"L'IA a trouvé la bonne combinaison en " + essai + " essai(s).";
				b = false;*/
			} else if (essai == nbrEssai && reponse != victoireJoueur) {
					Log.logger.info("\nL'IA a atteint le nombre d'essai limité, vous avez donc gagné !!!");
					nouvelleProposition = "La partie est finie !" + "\nL'IA n'a pas réussi à trouver votre combinaison.";
					b = false;
			}
		
		} // fin while
		
		return nouvelleProposition;
	}
}
		
