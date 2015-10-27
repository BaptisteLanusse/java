import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	/*int nbLignes = 3;
	int nbColonnes = 2;*/
	
	/*CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
	int indice = 0;*/
	
	  public Fenetre(){
	    this.setTitle("CardLayout");
	    this.setSize(240, 142);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    /*this.setLayout(new BorderLayout());

	    this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
	    
	    this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
	    
	    this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
	    
	    this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
	    
	    this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
	    
	    this.setVisible(true);*/
	    
	    /*GridLayout gl = new GridLayout(nbLignes, nbColonnes);
	    
	    gl.setColumns(nbColonnes);
	    gl.setRows(nbLignes);
	    
	    gl.setHgap(5);					//Espacement Horizontal -> Horizontal Gap
	    gl.setVgap(5);					//Espacement Vertical -> Vertical Gap
	    
	    this.setLayout(gl);
	    
	    this.getContentPane().add(new JButton("1"));
	    this.getContentPane().add(new JButton("2"));
	    this.getContentPane().add(new JButton("3"));
	    this.getContentPane().add(new JButton("4"));
	    this.getContentPane().add(new JButton("5"));
	    
	    this.setVisible(true);*/
	    
	    /*JPanel b1 = new JPanel();
	    
	    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    b1.add(new JButton("Bouton 1"));
	    
	    JPanel b2 = new JPanel();
	    
	    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	    b2.add(new JButton("Bouton 2"));
	    b2.add(new JButton("Bouton 3"));
	    
	    JPanel b3 = new JPanel();
	    
	    b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
	    b3.add(new JButton("Bouton 4"));
	    b3.add(new JButton("Bouton 5"));
	    b3.add(new JButton("Bouton 6"));
	    
	    JPanel b4 = new JPanel();
	    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);
	    
	    this.getContentPane().add(b4);
	    
	    this.setVisible(true);*/
	    
	    /*Box b1 = Box.createHorizontalBox();
	    b1.add(new JButton("Bouton 1"));
	    //Idem
	    Box b2 = Box.createHorizontalBox();
	    b2.add(new JButton("Bouton 2"));
	    b2.add(new JButton("Bouton 3"));
	    //Idem
	    Box b3 = Box.createHorizontalBox();
	    b3.add(new JButton("Bouton 4"));
	    b3.add(new JButton("Bouton 5"));
	    b3.add(new JButton("Bouton 6"));
	    //On crée un conteneur avec gestion verticale
	    Box b4 = Box.createVerticalBox();
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);

	    this.getContentPane().add(b4);
	    this.setVisible(true);*/
	    
	    /*JPanel card1 = new JPanel();
	    card1.setBackground(Color.blue);
	    JPanel card2 = new JPanel();
	    card2.setBackground(Color.red);
	    JPanel card3 = new JPanel();
	    card3.setBackground(Color.green);
	    
	    JPanel boutonPane = new JPanel();
	    JButton bouton = new JButton("Contenu suivant");
	    
	    bouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		cl.next(content);
	    	}
	    });
	    
	    JButton bouton2 = new JButton("Contenu par indice");
	    
	    bouton2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		if(++indice > listContent.length - 1)
	    			indice = 0;
	    		
	    		cl.show(content, listContent[indice]);
	    	}
	    });
	    
	    boutonPane.add(bouton);
	    boutonPane.add(bouton2);
	    
	    content.setLayout(cl);
	    
	    content.add(card1, listContent[0]);
	    content.add(card2, listContent[1]);
	    content.add(card3, listContent[2]);
	    
	    this.getContentPane().add(boutonPane, BorderLayout.NORTH);
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.setVisible(true);*/
	    
	    JPanel cell1 = new JPanel();
	    cell1.setBackground(Color.YELLOW);
	    cell1.setPreferredSize(new Dimension(60,40));
	    
	    JPanel cell2 = new JPanel();
	    cell2.setBackground(Color.red);
	    cell2.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel cell3 = new JPanel();
	    cell3.setBackground(Color.green);
	    cell3.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel cell4 = new JPanel();
	    cell4.setBackground(Color.black);
	    cell4.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel cell5 = new JPanel();
	    cell5.setBackground(Color.cyan);
	    cell5.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel cell6 = new JPanel();
	    cell6.setBackground(Color.BLUE);
	    cell6.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel cell7 = new JPanel();
	    cell7.setBackground(Color.orange);
	    cell7.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel cell8 = new JPanel();
	    cell8.setBackground(Color.DARK_GRAY);
	    cell8.setPreferredSize(new Dimension(60, 40));
	    
	    JPanel content = new JPanel();
	    content.setPreferredSize(new Dimension(240, 120));
	    content.setBackground(Color.WHITE);
	    
	    content.setLayout(new GridBagLayout());
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    //Position de la première case
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    //Taille en hauteur et en largeur
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    content.add(cell1, gbc);
	    
	    gbc.gridx = 1;
	    content.add(cell2, gbc);
	    
	    gbc.gridx = 2;
	    content.add(cell3, gbc);
	    
	    //Indication de fin de ligne
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.gridx = 3;
	    content.add(cell4, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 2;
	    
	    //Indique que la cellule se répète de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    content.add(cell5, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell6, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.gridwidth = 2;
	    content.add(cell7, gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell8, gbc);
	    
	    this.setContentPane(content);
	    this.setVisible(true);
	    
	  } 
}
