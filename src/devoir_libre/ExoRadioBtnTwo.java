package devoir_libre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExoRadioBtnTwo extends JFrame implements ActionListener {
    JLabel txt1, txt2;
    JTextField tf1, tf2;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup group;
    JPanel pan;

    public ExoRadioBtnTwo() {
        super("ExoRadioBtnTwo"); 

        pan = new JPanel(new GridLayout(3, 2, 5, 5));  

        txt1 = new JLabel("Texte 1 : ");
        txt2 = new JLabel("Texte 2 : ");

        tf1 = new JTextField(15);
        tf2 = new JTextField(15);
        tf2.setEditable(false);  

        rbtn1 = new JRadioButton("Copy");
        rbtn2 = new JRadioButton("Remove");

        group = new ButtonGroup();
        group.add(rbtn1);
        group.add(rbtn2);

        rbtn1.addActionListener(this);
        rbtn2.addActionListener(this);

        pan.add(txt1);
        pan.add(tf1);
        pan.add(txt2);
        pan.add(tf2);
        pan.add(rbtn1);
        pan.add(rbtn2);

        this.getContentPane().setLayout(new FlowLayout());
        this.add(pan);

        this.setBounds(100, 100, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (rbtn1.isSelected()) { 
            tf2.setText(tf1.getText());
        } else if (rbtn2.isSelected()) {
            tf1.setText("");  
            tf2.setText("");
            tf1.requestFocus(); 
        }
    }

    public static void main(String[] args) {
        new ExoRadioBtnTwo();
    }
}
