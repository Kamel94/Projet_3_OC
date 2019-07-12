package fr.escape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

private static Logger logger = LogManager.getLogger(Log.class);

	public static void main(String[] args) {
		
		
System.out.println("\n Hello world ! \n");
    	
    	logger.info("Ceci est un message d'information ");
    	logger.error("Ceci est un message d'erreur");
    	logger.warn("Ceci est un message d'avertissement");
    	logger.fatal("Ceci est un message fatal ");
    	
    	System.out.println("\n Terminé");

    } 

} 