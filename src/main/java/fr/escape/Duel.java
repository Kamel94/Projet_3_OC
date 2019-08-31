package fr.escape;

import java.util.Scanner;

import fr.configuration.Configuration;
import fr.configuration.Log;

public class Duel extends ModeJeu {
	
	Configuration conf = new Configuration();
	Ordinateur o = new Ordinateur();
	Joueur j = new Joueur();
	
	int nbrEssai = conf.nbEssai();
	int chiffreCombi = conf.chiffreCombi();
	
	
	public String duel() {
		
		String resultat = "";
		
		clef = o.combinaisonAleatoire();
		
		if (dev) {
            Log.logger.info("\nMode développeur activé");
        }
		
		System.out.println("\nBienvenue dans le mode Duel ! \nDans ce mode, vous et l'IA jouez chacun votre tour pour deviner la combinaison de l'autre." + 
				"\nLe premier qui aura trouvé la combinaison de son adversaire aura gagné la partie !!" + 
					"\n" + "Attention !! Vous aurez chacun uniquement " + nbrEssai + " essai(s) pour trouver la bonne combinaison..." + "\n" + 
						"Bonne partie et que le meilleur gagne !!!");
		
		if (dev == true) {
			System.out.println("\nLa combinaison est : " + clef);
		}
		
		resultat = modeDuel(clef);
		
		
		return resultat;
		
	}
	
}
