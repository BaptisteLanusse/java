import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	public void paintComponent(Graphics g){
		/*try{
			Image img = ImageIO.read(new File("Java_620X0.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img, 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int widthComp = 80, heightComp = 80;
		int x1 = this.getWidth()/2 - widthComp/2;
		int y1 = this.getHeight()/2 - heightComp/2;
		g.fillOval(x1, y1, widthComp, heightComp);
		
		int x2 = this.getWidth()/4;
		int y2 = this.getHeight()/4;
		g.drawOval(x2, y2, widthComp, heightComp);

		int x3 = 10;
		int y3 = 10;
		g.drawRect(x3, y3, 50, 60);
		
		int x4 = 65;
		int y4 = 65;
		g.fillRect(x4, y4, 30, 40);
		
		int x5 = 150;
		int y5 = 10;
		g.drawRoundRect(x5, y5, 30, 50, 10, 10);
		
		int x6 = 10;
		int y6 = 150;
		g.drawRoundRect(x6, y6, 55, 30, 5, 5);
		
		g.drawLine(0,0,this.getWidth(),this.getHeight());
		g.drawLine(0,this.getHeight(),this.getWidth(),0);
		
		int tabx[] = {120, 130, 150, 160, 160, 150, 130, 120};
		int taby[] = {230, 220, 220, 230, 250, 260, 260, 250};
		g.drawPolygon(tabx, taby, 8);
		
		int tabx2[] = {350, 360, 380, 390, 390, 380, 360, 350};
		int taby2[] = {360, 350, 350, 360, 380, 390, 390, 380};
		g.fillPolygon(tabx2, taby2, 8);
		
		Font font = new Font("Courrier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Tiens ! Le Site du Zéro !", 10, 300);*/
		
		/*Graphics2D g2d = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());*/
		
		Graphics2D g2d = (Graphics2D)g;
	    GradientPaint gp, gp2, gp3, gp4, gp5, gp6; 
	    gp = new GradientPaint(0, 0, Color.RED, this.getWidth()/6, 0, Color.magenta, true);
	    gp2 = new GradientPaint(this.getWidth()/6, 0, Color.magenta, 2 * this.getWidth()/6, 0, Color.blue, true);
	    gp3 = new GradientPaint(2 * this.getWidth()/6, 0, Color.blue, 3 * this.getWidth()/6, 0, Color.green, true);
	    gp4 = new GradientPaint(3 * this.getWidth()/6, 0, Color.green, 4 * this.getWidth()/6, 0, Color.yellow, true);
	    gp5 = new GradientPaint(4 * this.getWidth()/6, 0, Color.yellow, 5 * this.getWidth()/6, 0, Color.orange, true);
	    gp6 = new GradientPaint(5 * this.getWidth()/6, 0, Color.orange, this.getWidth(), 0, Color.red, true);

	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, this.getWidth()/6, this.getHeight());               
	    g2d.setPaint(gp2);
	    g2d.fillRect(this.getWidth()/6 - 5, 0, this.getWidth()/6 + 10, this.getHeight());
	    g2d.setPaint(gp3);
	    g2d.fillRect(2 * this.getWidth()/6 - 5, 0, this.getWidth()/6 + 10, this.getHeight());
	    g2d.setPaint(gp4);
	    g2d.fillRect(3 * this.getWidth()/6 - 5, 0, this.getWidth()/6 + 10, this.getHeight());
	    g2d.setPaint(gp5);
	    g2d.fillRect(4 * this.getWidth()/6 - 5, 0, this.getWidth()/6 + 10, this.getHeight());
	    g2d.setPaint(gp6);
	    g2d.fillRect(5 * this.getWidth()/6 - 5, 0, this.getWidth()/6 + 10, this.getHeight());
	}
}
