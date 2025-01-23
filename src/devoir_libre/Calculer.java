package devoir_libre;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculer extends JFrame implements ActionListener{
	
	private JTextField nb;
    private JPanel p;
    private JButton calculer;
    private JLabel mettr, surface, perimetr; 
    
    public Calculer () {
    	nb = new JTextField(10);
    	mettr = new JLabel("métres") ;
    	perimetr = new JLabel("perimetr") ;
    	surface = new JLabel("surface") ;
    	calculer = new JButton("Calculer");
    	
    	this.add(nb);
    	this.add(mettr);
    	this.add(perimetr);
    	this.add(surface);
    	this.add(calculer);
    	
    	
    	this.setLayout(new FlowLayout());
    	calculer.addActionListener(this);
    	
    	this.setBounds(100,50,400,500);
    	this.setVisible(true);

    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		int c = Integer.parseInt(nb.getText());
		
		perimetr.setText("perimetre : "+ c*4);
		surface.setText("surface : "+ c*c);
		
		
	}
	
	   public static void main(String[] args) {
	        new Calculer();
	    }

}
