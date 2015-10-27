
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pannel extends JPanel {

	Pixel pixels[][];
	byte l;
	byte L;
	
	public Pannel(Pixel pixel[][], byte largeur, byte Longueur){
		pixels = pixel;
		l = largeur;
		L = Longueur;
	}
	
	public void paintComponent(Graphics g) {

		byte x=0, y=0;
		
		for (x=0;x<l;x++){
			for (y=0;y<L;y++){
				if (pixels[x][y].couleur == 0){
					g.fillRect(pixels[x][y].position.x, pixels[x][y].position.y, Chip.DIMPIXEL, Chip.DIMPIXEL);
				}
			}
		}
	}
	
}
