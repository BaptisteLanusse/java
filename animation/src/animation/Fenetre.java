package animation;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private Panneau pan = new Panneau();

	public Fenetre(){        
		this.setTitle("Animation");
		this.setSize(450, 375);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(0,25);
		this.setAlwaysOnTop(true);
		this.setContentPane(pan);
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
		go();
	}

	private void go(){
		int x = pan.getPosX(), y = pan.getPosY();

		boolean backX = false, backY = false;

		while(true) {
			if (x <= 0){
				backX = false;
			}
			
			if (x >= (pan.getWidth() - pan.getDiameter())){
				backX = true;
			}
			
			if (y <= 0){
				backY = false;
			}
			
			if (y >= (pan.getHeight() - pan.getDiameter())){
				backY = true;
			}
			
			if (!backX){
				pan.setPosX(++x);
			} else {
				pan.setPosX(--x);
			}
			
			if (!backY){
				pan.setPosY(++y);
			} else {
				pan.setPosY(--y);
			}
			
			pan.repaint();
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}