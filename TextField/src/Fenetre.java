import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	private JPanel container = new JPanel();
	private JTextField jtf = new JTextField("Valeur par défaut");
	private JLabel label = new JLabel("Un JTextField");
	
	private JPanel centerContainer = new JPanel();
	private JFormattedTextField jtf1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField jtf2 = new JFormattedTextField(NumberFormat.getPercentInstance());
	private JLabel centerLabel = new JLabel("Des JFormattedTextFields");
	private JButton b = new JButton("OK");
	
	public Fenetre(){
		this.setTitle("Text Field");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150,30));
		jtf.setForeground(Color.BLUE);
		
		top.add(label);
		top.add(jtf);
		
		container.add(top, BorderLayout.NORTH);
		
		centerContainer.setBackground(Color.white);
		centerContainer.setLayout(new BorderLayout());
		JPanel centerTop = new JPanel();
		jtf1.setFont(police);
		jtf1.setPreferredSize(new Dimension(150, 30));
		jtf1.setForeground(Color.BLUE);
		jtf2.setPreferredSize(new Dimension(150, 30));
		b.addActionListener(new BoutonListener());
		
		centerTop.add(centerLabel);
		centerTop.add(jtf1);
		centerTop.add(jtf2);
		centerTop.add(b);
		
		container.add(centerTop, BorderLayout.CENTER);
		
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("TEXT : jtf1 " + jtf1.getText());
			System.out.println("TEXT : jtf2 " + jtf2.getText());
		}
	}
	
}
