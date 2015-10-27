package Vehicules;

import java.util.ArrayList;

import enumerations.Marque;
import main.Option;
import main.Vehicule;

public class Lagouna extends Vehicule {
	
	private static final long serialVersionUID = -2969926630575114456L;

	public Lagouna(){
		this.nom = "Lagouna";
		this.prix = 23123.0;
		this.options = new ArrayList<Option>();
		this.nomMarque = Marque.RENO;
	}
}
