package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Duel extends ModeJeu {
	
	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	String victoire = v.victoire();
	
	public void duel() {
		
		String victoireJoueur = "";
		String victoireIA = "";
		String resultat = "";
		int essai = 0; // Contient le nombre d'essai effectué par l'utilisateur et l'IA.
		int tentative = 0; // La condition de la boucle.
		this.essai = 0; // Pour réinitialiser le nombre d'essai du mode Defenseur à chaque début de partie.
		clef = ordinateur.combinaisonAleatoire();
		
		if (dev) {
            Log.logger.info("\nMode développeur activé");
        }
		
		System.out.println("\nBienvenue dans le mode Duel ! \nDans ce mode, vous et l'IA jouez chacun votre tour pour deviner la combinaison de l'autre." + 
				"\nLe premier qui aura trouvé la combinaison de son adversaire aura gagné la partie !!" + 
					"\n" + "Attention !! Vous aurez chacun uniquement " + nbrEssai + " essai(s) pour trouver la bonne combinaison..." + "\n" + 
						"Bonne partie et que le meilleur gagne !!!");
		
		if (dev == true) {
			Log.logger.info("\nLa combinaison est : " + clef);
		}
		
		
		while(tentative < nbrEssai){
			
			tentative++;
			
			if(essai != nbrEssai) {
				essai++;
				Log.logger.info("\nEssai n° : " + essai + "\n");
			} 
			
			System.out.print("Proposition joueur : ");
		
			if(modeChallenger(clef).equals(victoire)) {
				resultat = "\nFélicitation vous avez gagné !! \n" + 
							"Vous avez trouvé la bonne combinaison en " + essai + " essai(s).";
				victoireJoueur = victoire;
				tentative = nbrEssai + 1; // Pour sortir de la boucle
			}
		
			if(modeDefenseur().equals(victoire)) {
				resultat = "\nDommage ! L'IA a gagné... \n" + 
					"L'IA a trouvé la bonne combinaison en " + essai + " essai(s)." + "\nLa combinaison de l'IA était : " + clef;
				victoireIA = victoire;
				tentative = nbrEssai + 1;
			}
		
			if(String.valueOf(victoireJoueur).equals(victoire) && String.valueOf(victoireIA).equals(victoire)) {
				resultat = "\nIl n'y a pas de gagnant..." + "\nVous avez chacun trouvé la bonne combinaison de l'autre en " + essai + " essai(s).";
				tentative = nbrEssai + 1; // Pour ne pas entrer dans la condition du nombre d'essai limite atteint.
			}  if(tentative == nbrEssai) {
				resultat = "\nIl n'y a pas de gagnant..." + "\nVous avez atteint le nombre d'essai maximum !" + "\nLa combinaison de l'IA était : " + clef;
				tentative = nbrEssai + 1;
			}
			
			if(tentative > nbrEssai) {
				this.nouvelleProposition = String.valueOf(premiereProposition);
			} else if(essai == nbrEssai - 1) {
				System.out.println("\nAttention il vous reste 1 essai !!");
			}
		} //fin while
		
		victoireIA = "";
		victoireJoueur = "";
		
		Log.logger.info(resultat);
		
	}
	
}
