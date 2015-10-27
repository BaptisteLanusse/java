package Moteurs;

import enumerations.TypeMoteur;
import main.Moteur;

public class MoteurEssence extends Moteur {

	private static final long serialVersionUID = 6641268206208843659L;

	public MoteurEssence(String cylindre, double prix) {
		super(cylindre, prix);
		this.type = TypeMoteur.ESSENCE;
	}

}
