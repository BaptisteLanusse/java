package Moteurs;

import enumerations.TypeMoteur;
import main.Moteur;

public class MoteurDiesel extends Moteur {

	private static final long serialVersionUID = 4958237102419857808L;

	public MoteurDiesel(String cylindre, double prix) {
		super(cylindre, prix);
		this.type = TypeMoteur.DIESEL;
	}

}
