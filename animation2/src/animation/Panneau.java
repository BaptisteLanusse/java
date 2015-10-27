package animation;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
  private int posX = 0;
  private int posY = 0;
  
  private int diameter = 50;

  public void paintComponent(Graphics g){
    g.setColor(Color.red);
    g.fillOval(posX, posY, diameter, diameter);
    g.setColor(Color.cyan);
    g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
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
  
  public int getDiameter() {
	  return diameter;
  }
}