package main;

import java.io.Serializable;

import enumerations.TypeMoteur;

public class Moteur implements Serializable{
	private static final long serialVersionUID = 597350664058264493L;
	
	protected TypeMoteur type;
	protected String cylindre;
	protected double prix;
	
	public Moteur(String cylindre, double prix){
		this.cylindre = cylindre;
		this.prix = prix;
	}
	
	public String toString(){
		return "Moteur " + type + " " + cylindre + " Chevaux (" + getPrix() + "€)";
	}
	
	public double getPrix(){
		return prix;
	}
	
}
