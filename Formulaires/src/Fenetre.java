import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	
	private Panneau pan = new Panneau();
	private JPanel container = new JPanel();
	private String[] tab = {"ROND", "CARRE", "TRIANGLE"};
	private JComboBox combo = new JComboBox(tab);
	private JLabel label = new JLabel("Choix de la forme");
	private JCheckBox morph = new JCheckBox("Morphing");
	private JButton bouton = new JButton("Go");
	private JButton bouton2 = new JButton("Stop");
	private boolean animated = true;
	private boolean backX, backY;
	private int x, y;
	private Thread t;
	
	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		
		container.add(pan, BorderLayout.CENTER);
		
		combo.setPreferredSize(new Dimension(150, 20));
		
		combo.addItem("ETOILE");
		
		combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		combo.setForeground(Color.blue);
		
		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		top.add(morph);
		morph.addActionListener(new MorphListener());
		container.add(top, BorderLayout.NORTH);
		
		bouton.addActionListener(new BoutonListener());
		bouton.setEnabled(false);
		bouton2.addActionListener(new Bouton2Listener());

		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);
		container.add(south, BorderLayout.SOUTH);
		
		this.setContentPane(container);
		this.setVisible(true);
		go();
	}

	private void go() {
		// Les coordonnées de départ de notre rond
		x = pan.getPosX();
		y = pan.getPosY();
		// Dans cet exemple, j'utilise une boucle while
		// Vous verrez qu'elle fonctionne très bien
		while (this.animated) {
			if (x < 1)
				backX = false;
			if (x > pan.getWidth() - pan.getDrawSize())
				backX = true;
			if (y < 1)
				backY = false;
			if (y > pan.getHeight() - pan.getDrawSize())
				backY = true;
			if (!backX)
				pan.setPosX(++x);
			else
				pan.setPosX(--x);
			if (!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);
			
			pan.repaint();

			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ItemState implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			System.out.println("évènement déclenché sur : " + event.getItem());
		}
	}
	
	class ItemAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pan.setForme((String)combo.getSelectedItem());
		}
	}
	
	class MorphListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pan.setMorph(morph.isSelected());
		}
	}

	class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			animated = true;
			t = new Thread(new PlayAnimation());
			t.start();
			bouton.setEnabled(false);
			bouton2.setEnabled(true);
		}
	}

	class Bouton2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			animated = false;
			bouton.setEnabled(true);
			bouton2.setEnabled(false);
		}
	}
	
	class PlayAnimation implements Runnable{
		public void run(){
			go();
		}
	}
}
