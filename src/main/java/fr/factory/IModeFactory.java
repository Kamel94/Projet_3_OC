package fr.factory;

import fr.configuration.Configuration;
import fr.escape.*;
// TODO changer le nom de IJeuFactory, par modeFactory
public interface IModeFactory {

	Configuration configuration = Configuration.getInstance();
	IA IA = new IA();
	Utilitaire utilitaire = new Utilitaire();
	Joueur joueur = new Joueur();
	
	public IMode creerMode(int type);

}