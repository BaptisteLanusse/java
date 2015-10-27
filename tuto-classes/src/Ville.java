
public class Ville {
	public static int nbreInstances = 0;
	
	private static int nbreInstanceBis = 0;
	
	private String nomVille;
	private String nomPays;
	private int nbreHabitants;
	private char categorie;
	
	public Ville(){
		nbreInstances++;
		nbreInstanceBis++;
		System.out.println("Création d'une ville !");
		nomVille = "Inconnu";
		nomPays = "Inconnu";
		nbreHabitants = 0;
		this.setCategorie();
	}
	
	public Ville(String pNom, int pNbre, String pPays){
		nbreInstances++;
		nbreInstanceBis++;
		System.out.println("Création d'une ville avec des paramètres !");
		nomVille = pNom;
		nomPays = pPays;
		nbreHabitants = pNbre;
		this.setCategorie();
	}
	
	public static int getNombreInstancesBis()
	{
		return nbreInstanceBis;
	}
	
	public String getNom() {
		return nomVille;
	}

	public void setNom(String pNom) {
		nomVille = pNom;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String pPays) {
		nomPays = pPays;
	}

	public int getNombreHabitants() {
		return nbreHabitants;
	}

	public void setNombreHabitants(int nbre) {
		nbreHabitants = nbre;
	}
	
	private void setCategorie() {
		int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
		char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		
		int i = 0;
		while (i < bornesSuperieures.length && this.nbreHabitants > bornesSuperieures[i])
			i++;
		
		this.categorie = categories[i];
	}
	
	public String decrisToi() {
		return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc de catégorie : "+this.categorie;
	}
	
	public String comparer(Ville v1){
	    String str = new String();

	    if (v1.getNombreHabitants() > this.nbreHabitants)
	      str = v1.getNom()+" est une ville plus peuplée que "+this.nomVille;
	     
	    else
	      str = this.nomVille+" est une ville plus peuplée que "+v1.getNom();
	     
	    return str;
	  }
	
}
