import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int posX = 0;
	private int posY = 0;

	private int drawSize = 50;

	private String forme = "ROND";
	
	private boolean morph = false, reduce = false;
	
	private int increment = 0;
	
	private Color couleurForme = Color.red;
	
	private Color couleurFond = Color.white;

	public void paintComponent(Graphics g) {
		g.setColor(couleurFond);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(couleurForme);
		if (this.morph){
			drawMorph(g);
		}
		else{
			draw(g);
		}
	}

	private void draw(Graphics g) {
		switch (forme) {
		case "CARRE":
		case "CARRÉ":
			g.fillRect(posX, posY, drawSize, drawSize);
			break;
		case "TRIANGLE":
			int posX1 = posX + (drawSize / 2);
			int posY1 = posY;
			
			int posX2 = posX;
			int posY2 = posY + drawSize;
			
			int posX3 = posX + drawSize;
			int posY3 = posY + drawSize;
			
			int[] tabX = {posX1, posX2, posX3};
			int[] tabY = {posY1, posY2, posY3};
			
			g.fillPolygon(tabX, tabY, 3);
			
			break;
		case "ETOILE":
		case "ÉTOILE":
			
			int pX1 = posX + (int)(drawSize / 2);
			int pY1 = posY;
			
			int pX2 = posX + (int)(0.8 * drawSize);
			int pY2 = posY + drawSize;
			
			g.drawLine(pX1, pY1, pX2, pY2);
			
			int pX3 = posX;
			int pY3 = posY + (int)(0.4 * drawSize);
			
			g.drawLine(pX2, pY2, pX3, pY3);
			
			int pX4 = posX + drawSize;
			int pY4 = posY + (int)(0.4 * drawSize);
			
			g.drawLine(pX3, pY3, pX4, pY4);
			
			int pX5 = posX + (int)(0.2 * drawSize);
			int pY5 = posY + drawSize;
			
			g.drawLine(pX4, pY4, pX5, pY5);
			g.drawLine(pX5, pY5, pX1, pY1);
			
			break;
		default:
			g.fillOval(posX, posY, drawSize, drawSize);
			break;
		}
	}
	
	private void drawMorph(Graphics g){
		increment++;
		
		if (drawSize >= 50) reduce = true;
		if (drawSize <= 10) reduce = false;
		if (reduce) {
			drawSize = drawSize - getUsedSize();
		} else {
			drawSize = drawSize + getUsedSize();
		}
		
		switch (forme) {
			case "CARRE":
				g.fillRect(posX, posY, drawSize, drawSize);
				break;
			case "TRIANGLE":
				int posX1 = posX + (drawSize / 2);
				int posY1 = posY;
				
				int posX2 = posX;
				int posY2 = posY + drawSize;
				
				int posX3 = posX + drawSize;
				int posY3 = posY + drawSize;
				
				int[] tabX = {posX1, posX2, posX3};
				int[] tabY = {posY1, posY2, posY3};
				
				g.fillPolygon(tabX, tabY, 3);
				
				break;
			case "ETOILE":
				int pX1 = posX + (int)(drawSize / 2);
				int pY1 = posY;
				
				int pX2 = posX + (int)(0.8 * drawSize);
				int pY2 = posY + drawSize;
				
				g.drawLine(pX1, pY1, pX2, pY2);
				
				int pX3 = posX;
				int pY3 = posY + (int)(0.4 * drawSize);
				
				g.drawLine(pX2, pY2, pX3, pY3);
				
				int pX4 = posX + drawSize;
				int pY4 = posY + (int)(0.4 * drawSize);
				
				g.drawLine(pX3, pY3, pX4, pY4);
				
				int pX5 = posX + (int)(0.2 * drawSize);
				int pY5 = posY + drawSize;
				
				g.drawLine(pX4, pY4, pX5, pY5);
				g.drawLine(pX5, pY5, pX1, pY1);
				
				break;
			default:
				g.fillOval(posX, posY, drawSize, drawSize);
				break;
		}
	}

	private int getUsedSize() {
		int res = 0;
		
		if (increment / 10 == 1) {
			increment = 0;
			res = 1;
		}
		
		return res;
	}
	
	public int getDrawSize(){
		return drawSize;
	}
	
	public boolean isMorph(){
		return morph;
	}
	
	public void setMorph(boolean bool){
		this.morph = bool;
		drawSize = 50;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setForme(String form) {
		this.forme = form.toUpperCase();
	}

}