package fr.escape;

import fr.factory.IModeFactory;
import fr.factory.ModeFactory;

public class LancementDuMode {

	private IModeFactory modeFactory;

	public LancementDuMode(IModeFactory modeFactory) {
		this.modeFactory = modeFactory;
	}

	public IMode choisirMode(int type) {
		IMode mode = modeFactory.creerMode(type);
		
		mode.regleDuMode();
		mode.partie(ModeFactory.clef);
		return mode;
	}
}