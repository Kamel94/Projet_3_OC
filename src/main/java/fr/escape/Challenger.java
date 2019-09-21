package fr.escape;

import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import fr.escape.*;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Challenger extends ModeJeu {
	
	Configuration conf = new Configuration();
	Ordinateur ordinateur = new Ordinateur();
	
	int nbrEssai = conf.nbEssai();
	boolean dev = conf.modeDev(); // Récupère la valeur de la méthode dans la classe configuration pour déterminer l'activation ou non du mode développeur.
	int chiffreCombi = conf.chiffreCombi();
	int clef = ordinateur.combinaisonAleatoire();
	
	public void challenger(int clef) {
		
		String choix;
		int code;
		
		Scanner clavier = new Scanner(System.in);
		String proposition = "";
		int essai = 0;
		
		if (dev) {
            Log.logger.info("Mode développeur activé");
        }
		
		System.out.println("\nBienvenue dans le mode Challenger." +  
		"\nDans ce mode l'IA choisi une combinaison de " + chiffreCombi + 
		" chiffres et vous devez trouver la bonne combinaison en " + nbrEssai + " essais. \nBonne partie !!");
		
		if (dev == true) {
			Log.logger.info("\nLa combinaison est : " + clef);
		}
		
		while(essai != nbrEssai) {
			
			if(essai != nbrEssai) {
				essai++;
				Log.logger.info("\nEssai n° : " + essai);
			} 
			
			System.out.print("\nProposition joueur : ");
		
			if(String.valueOf(modeChallenger(clef)).equals(v.victoire())) {
				Log.logger.info("Félicitation vous avez gagné !! \n" + 
								"Vous avez trouvé la bonne combinaison en " + essai + " essai(s).");
				essai = nbrEssai;
			} else if (essai == nbrEssai){
				Log.logger.info("\nDésolé vous avez atteint le nombre d'essais maximum... \nLa combinaison était : " + clef);
				essai = nbrEssai;
			} else if(essai == nbrEssai - 1) {
				System.out.println("\nAttention il vous reste 1 essai !!");
			}
		
		} //fin while
		
	}

}
