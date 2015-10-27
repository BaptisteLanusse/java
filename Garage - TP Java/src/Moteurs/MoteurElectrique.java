package Moteurs;

import enumerations.TypeMoteur;
import main.Moteur;

public class MoteurElectrique extends Moteur {

	private static final long serialVersionUID = 1649035272219076089L;

	public MoteurElectrique(String cylindre, double prix) {
		super(cylindre, prix);
		this.type = TypeMoteur.ELECTRIQUE;
	}

}
