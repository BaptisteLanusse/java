package main;

import java.io.Serializable;
import java.util.List;

import enumerations.Marque;

public class Vehicule implements Serializable{
	private static final long serialVersionUID = 7896237835039404316L;
	
	protected double prix;
	protected String nom;
	protected List<Option> options;
	protected Marque nomMarque;
	protected Moteur moteur;

	public String toString(){
		String resultat = "+ Voiture " + nomMarque + " : " + nom + " " + moteur.toString() + " [";
		for (int i = 0; i < options.size(); i++){
			resultat += options.get(i).toString();
			if (i != (options.size() - 1)){
				resultat += ", ";
			}
		}
		resultat += "] d'une valeur totale de " + getPrix() + " €";
		return resultat;
	}
	
	public void addOption(Option opt){
		options.add(opt);
	}
	
	public Marque getMarque(){
		return nomMarque;
	}
	
	public List<Option> getOptions(){
		return options;
	}
	
	public double getPrix(){
		double resultat = prix;
		for (int i = 0; i < options.size(); i++){
			resultat += options.get(i).GetPrix();
		}
		return resultat;
	}
	
	public void setMoteur(Moteur moteur){
		this.moteur = moteur;
	}
	
}
