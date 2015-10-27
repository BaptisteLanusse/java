import javax.swing.JFrame;

public class Fenetre extends JFrame {
	public Fenetre(){
		this.setTitle("Ma fenêtre Java");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setAlwaysOnTop(true);
		//this.setResizable(false);
		//this.setUndecorated(true);
		
		this.setContentPane(new Panneau());
		
		this.setVisible(true);
	}
}
