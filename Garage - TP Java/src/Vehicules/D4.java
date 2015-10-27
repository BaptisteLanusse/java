package Vehicules;

import java.util.ArrayList;

import main.Option;
import main.Vehicule;
import enumerations.Marque;

public class D4 extends Vehicule {
	
	private static final long serialVersionUID = -2034060828498491793L;

	public D4(){
		this.nom = "D4";
		this.prix = 25147.0;
		this.options = new ArrayList<Option>();
		this.nomMarque = Marque.TROEN;
	}
}
