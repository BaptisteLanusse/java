package Vehicules;

import java.util.ArrayList;
import main.Option;
import main.Vehicule;
import enumerations.Marque;

public class A300B extends Vehicule {
	
	private static final long serialVersionUID = -7674016247043258094L;

	public A300B(){
		this.nom = "A330B";
		this.prix = 28457.0;
		this.options = new ArrayList<Option>();
		this.nomMarque = Marque.PIGEOT;
	}
}
