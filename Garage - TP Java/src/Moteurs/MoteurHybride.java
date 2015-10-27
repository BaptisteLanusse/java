package Moteurs;

import enumerations.TypeMoteur;
import main.Moteur;

public class MoteurHybride extends Moteur {

	private static final long serialVersionUID = -1013815646326520735L;

	public MoteurHybride(String cylindre, double prix) {
		super(cylindre, prix);
		this.type = TypeMoteur.HYBRIDE;
	}

}
