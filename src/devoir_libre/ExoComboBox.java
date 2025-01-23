package devoir_libre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExoComboBox extends JFrame implements ActionListener {
    JComboBox<String> cmb;
    JLabel label;
    ExoComboBox(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"Uno", "Dos", "Tres", "Cuatro"};
        cmb = new JComboBox<>(animals);
        cmb.addActionListener(this);

        label = new JLabel();        
        label.setOpaque(true);

        this.add(cmb);
        this.add(label);
        this.setBounds(100,100,300,300);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cmb){
            label.setText(""+cmb.getSelectedItem());
        }
    }
	   public static void main(String[] args) {
	        new ExoComboBox();
	    }
}