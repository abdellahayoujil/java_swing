package devoir_libre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExoCheckBox extends JFrame implements ActionListener {
	
    JLabel txt1, txt2;
    JTextField tf1, tf2;
    JCheckBox chkb1, chkb2;

    public ExoCheckBox() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        txt1 = new JLabel("Texte 1 : ");
        txt2 = new JLabel("Texte 2 : ");

        tf1 = new JTextField(15);
        tf2 = new JTextField(15);

        chkb1 = new JCheckBox("Copy");
        chkb2 = new JCheckBox("Remove");

        // Ajouter des ActionListeners aux deux cases à cocher
        chkb1.addActionListener(this);
        chkb2.addActionListener(this);

        // Ajouter les composants à la fenêtre
        this.add(txt1);
        this.add(tf1);
        this.add(txt2);
        this.add(tf2);
        this.add(chkb1);
        this.add(chkb2);

        this.setBounds(100, 100, 275, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chkb1) {  // Si "Copy" est sélectionné
            if (chkb1.isSelected()) {
                tf2.setText(tf1.getText());
            } else {
                tf2.setText("");  // Optionnel : Réinitialiser si on décoche
            }
        }

        if (e.getSource() == chkb2) {  // Si "Remove" est sélectionné
            if (chkb2.isSelected()) {
                tf1.setText("");
                tf2.setText("");
                chkb1.setSelected(false); // Désactiver "Copy" si "Remove" est sélectionné
            }
        }
    }

    public static void main(String[] args) {
        new ExoCheckBox();
    }
}
