package main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Garage {
	protected List<Vehicule> voitures;
	
	public Garage(){
		voitures = new ArrayList<Vehicule>();
		try {
			File file = new File("garage.txt");
			
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			while (true) {
				try {
					Vehicule resultat = (Vehicule)ois.readObject();
					voitures.add(resultat);
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			ois.close();
			
		} catch (EOFException e) {
			System.err.println("Aucune voiture sauvegardée !");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString(){
		String resultat = "";
		resultat += "****************************\n";
		resultat += "*  Garage OpenClassrooms   *\n";
		resultat += "****************************\n";
		for (int i = 0; i < voitures.size(); i++){
			resultat += voitures.get(i).toString() + "\n";
		}
		return resultat;
	}
	
	public void addVoiture(Vehicule voit){
		this.voitures.add(voit);
		try {
			File file = new File("garage.txt");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			for (int i = 0; i < voitures.size(); i++){
				oos.writeObject(voitures.get(i));
			}
			
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}