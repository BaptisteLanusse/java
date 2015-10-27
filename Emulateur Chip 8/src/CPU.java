
public class CPU {
	static final int tailleMemoire = 4096;
	static final int adresseDebut = 512;
	
	byte memoire[] = new byte[tailleMemoire];	//La mémoire de l'émulateur
	byte V[] = new byte[16];					//Le registre
	int I;										//Stocke une adresse mémoire ou dessinateur
	int saut[] = new int[16];					//Gère les sauts dans mémoire, 16 au maximum
	byte nbrSaut;								//Compte le nombre de sauts pour ne pas dépasser
	byte compteurJeu;							//Compteur de synchronisation
	byte compteurSon;							//Compteur pour le son
	int pc;										//Pour parcourir le tableau mémoire
	
	public void initialiserCpu() {
		int i = 0;
		
		for (i = 0; i < tailleMemoire; i++){
			this.memoire[i]=0;
		}
		
		for (i = 0; i < 16; i++){
			this.V[i] = 0;
			this.saut[i] = 0;
		}
		
		this.pc = adresseDebut;
		this.nbrSaut = 0;
		this.compteurJeu = 0;
		this.compteurSon = 0;
		this.I = 0;
	}
	
	public void decompter() {
		if (this.compteurJeu>0)
			this.compteurJeu--;
		
		if (this.compteurSon>0)
			this.compteurSon--;
	}
	
}
