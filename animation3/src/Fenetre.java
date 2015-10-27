import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();
	private JPanel container = new JPanel();
	private int compteur = 0;
	private boolean animated = true;
	private boolean backX, backY;
	private int x, y;
	private Thread t;

	private JMenuBar menuBar = new JMenuBar();

	private JMenu animation = new JMenu("Animation"),
			forme = new JMenu("Forme"), typeForme = new JMenu("Type de forme"),
			aPropos = new JMenu("À propos");

	private JMenuItem lancer = new JMenuItem("Lancer l'animation"),
			arreter = new JMenuItem("Arrêter l'animation"),
			quitter = new JMenuItem("Quitter"),
			aProposItem = new JMenuItem("?");

	private JCheckBoxMenuItem morph = new JCheckBoxMenuItem("Morphing");
	private JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carré"),
			rond = new JRadioButtonMenuItem("Rond"),
			triangle = new JRadioButtonMenuItem("Triangle"),
			etoile = new JRadioButtonMenuItem("Etoile");

	private ButtonGroup bg = new ButtonGroup();
	private JPopupMenu jpm = new JPopupMenu();
	private JMenu background = new JMenu("Couleur de fond");
	private JMenu couleur = new JMenu("Couleur de la forme");

	private JMenuItem launch = new JMenuItem("Lancer l'animation");
	private JMenuItem stop = new JMenuItem("Arrêter l'animation");
	private JMenuItem rouge = new JMenuItem("Rouge"), bleu = new JMenuItem(
			"Bleu"), vert = new JMenuItem("Vert"), rougeBack = new JMenuItem(
			"Rouge"), bleuBack = new JMenuItem("Bleu"),
			vertBack = new JMenuItem("Vert");

	// On crée des listeners globaux
	private StopAnimationListener stopAnimation = new StopAnimationListener();
	private StartAnimationListener startAnimation = new StartAnimationListener();

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		// On initialise le menu stop
		stop.setEnabled(false);
		// On affecte les écouteurs
		stop.addActionListener(stopAnimation);
		launch.addActionListener(startAnimation);

		// On crée et on passe l'écouteur pour afficher le menu contextuel
		// Création d'une implémentation de MouseAdapter
		// avec redéfinition de la méthode adéquate
		pan.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent event) {
				// Seulement s'il s'agit d'un clic droit
				// if(event.getButton() == MouseEvent.BUTTON3)
				if (event.isPopupTrigger()) {
					background.add(rougeBack);
					background.add(bleuBack);
					background.add(vertBack);

					couleur.add(rouge);
					couleur.add(bleu);
					couleur.add(vert);

					jpm.add(launch);
					jpm.add(stop);
					jpm.add(couleur);
					jpm.add(background);
					// La méthode qui va afficher le menu
					jpm.show(pan, event.getX(), event.getY());
				}
			}
		});

		container.add(pan, BorderLayout.CENTER);

		this.setContentPane(container);
		this.initMenu();
		this.setVisible(true);

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

	public class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
					"Voulez-vous lancer l'animation ?",
					"Lancement de l'animation", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (option == JOptionPane.OK_OPTION) {
				lancer.setEnabled(false);
				arreter.setEnabled(true);
				animated = true;
				t = new Thread(new PlayAnimation());
				t.start();
			}
		}
	}

	class Bouton2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
					"Voulez-vous arrêter l'animation ?",
					"Arrêt de l'animation", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (option != JOptionPane.NO_OPTION
					&& option != JOptionPane.CANCEL_OPTION
					&& option != JOptionPane.CLOSED_OPTION) {
				animated = false;
				// On remplace nos boutons par nos JMenuItem
				lancer.setEnabled(true);
				arreter.setEnabled(false);
			}
		}
	}

	class PlayAnimation implements Runnable {
		public void run() {
			go();
		}
	}

	public class StartAnimationListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
					"Voulez-vous lancer l'animation ?",
					"Lancement de l'animation", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (option == JOptionPane.OK_OPTION) {
				lancer.setEnabled(false);
				arreter.setEnabled(true);

		        //On ajoute l'instruction pour le menu contextuel
		        launch.setEnabled(true);
		        stop.setEnabled(false);

				animated = true;
				t = new Thread(new PlayAnimation());
				t.start();
			}
		}
	}

	class StopAnimationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
					"Voulez-vous arrêter l'animation ?",
					"Arrêt de l'animation", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (option != JOptionPane.NO_OPTION
					&& option != JOptionPane.CANCEL_OPTION
					&& option != JOptionPane.CLOSED_OPTION) {
				animated = false;
				// On remplace nos boutons par nos JMenuItem
				lancer.setEnabled(true);
				arreter.setEnabled(false);

		        //On ajoute l'instruction pour le menu contextuel
		        launch.setEnabled(false);
		        stop.setEnabled(true);
			}
		}
	}

	private void initMenu() {
		// Menu Animation
		// Ajout du listener pour lancer l'animation
		lancer.addActionListener(new StartAnimationListener());
		animation.add(lancer);

		// Ajout du listener pour arrêter l'animation
		arreter.addActionListener(new StopAnimationListener());
		arreter.setEnabled(false);
		animation.add(arreter);

		animation.addSeparator();
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		animation.add(quitter);

		// Menu Forme

		bg.add(carre);
		bg.add(triangle);
		bg.add(rond);
		bg.add(etoile);

		// On crée un nouvel écouteur, inutile de créer 4 instances différentes
		FormeListener fl = new FormeListener();
		carre.addActionListener(fl);
		rond.addActionListener(fl);
		triangle.addActionListener(fl);
		etoile.addActionListener(fl);

		typeForme.add(rond);
		typeForme.add(carre);
		typeForme.add(triangle);
		typeForme.add(etoile);

		rond.setSelected(true);

		forme.add(typeForme);

		// Ajout du listener pour le morphing
		morph.addActionListener(new MorphListener());
		forme.add(morph);

		// Menu À propos

		// Ajout de ce que doit faire le "?"
		aProposItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("images/cysboy.gif");
				String mess = "Merci ! \n J'espère que vous vous amusez bien !\n";
				mess += "Je crois qu'il est temps d'ajouter des accélérateurs et des "
						+ " mnémoniques dans tout ça…\n";
				mess += "\n Allez, GO les ZérOs !";
				jop.showMessageDialog(null, mess, "À propos",
						JOptionPane.INFORMATION_MESSAGE, img);
			}
		});
		aPropos.add(aProposItem);

		// Ajout des menus dans la barre de menus
		menuBar.add(animation);
		menuBar.add(forme);
		menuBar.add(aPropos);

		// Ajout de la barre de menus sur la fenêtre
		this.setJMenuBar(menuBar);
	}

	class FormeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pan.setForme(((JRadioButtonMenuItem) e.getSource()).getText());
		}
	}

	class MorphListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Si la case est cochée, activation du mode morphing
			if (morph.isSelected())
				pan.setMorph(true);
			// Sinon rien !
			else
				pan.setMorph(false);
		}
	}
}