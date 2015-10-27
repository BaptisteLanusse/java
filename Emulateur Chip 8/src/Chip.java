
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chip {
	
	static final byte NOIR = 0;
	static final byte BLANC = 1;
	static final byte l = 64;				//nombre de pixels en largeur
	static final byte L = 32;				//nombre de pixels en longueur
	static final byte DIMPIXEL = 8;			//taille du pixel
	static final int width = l * DIMPIXEL;	//largeur de l'écran
	static final int height = L * DIMPIXEL;	//Longueur de l'écran
	
	Pixel pixel[][] = new Pixel[l][L];
	
	JFrame mainFrame;
	
	public void init() {
		// TODO Auto-generated method stub
		mainFrame = new JFrame();
		
		initialiserPixel();
		
		mainFrame.setTitle("Emulateur Console - Chip 8");
		
		mainFrame.setSize(width, height);
		
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		updateEcran();
		
		mainFrame.setVisible(true);
		
		byte continuer = 1;
		
		do {
			//Opérations à effectuer
			
			updateEcran();
			
			try {
				wait(16);						//Pause de 16 ms
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			
		}while(continuer == 1);
		
		pause();
	}

	private void initialiserPixel() {
		byte x=0, y=0;
		
		for (x=0;x<l;x++){
			for (y=0;y<L;y++){
				pixel[x][y] = new Pixel();
				
				pixel[x][y].position.x = x*DIMPIXEL;
				pixel[x][y].position.y = y*DIMPIXEL;

				pixel[x][y].couleur = NOIR;
			}
		}
	}
	
	private void effacerEcran(){
		mainFrame.setContentPane(new JPanel());
	}
	
	private void pause(){
		byte continuer = 1;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			
		}while (continuer == 1);
	}
	
	private void updateEcran(){
		mainFrame.setContentPane(new Pannel(pixel, l, L));
	}
	
}
