package devoir_libre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExoCheckBox extends JFrame implements ActionListener {
	
	JLabel txt1, txt2;
    JTextField tf1, tf2;
    JCheckBox chkb1, chkb2;
    ButtonGroup group;

    public ExoCheckBox(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        txt1 = new JLabel("Texte 1 : ");
        txt2 = new JLabel("Texte 2 : ");

        tf1 = new JTextField(15);
        tf2 = new JTextField(15);

        chkb1 = new JCheckBox("Copy");
        chkb2 = new JCheckBox("Remove");

        group = new ButtonGroup();
        group.add(chkb1);
        group.add(chkb2);

        chkb1.addActionListener(this);
        this.add(txt1);
        this.add(tf1);
        this.add(txt2);
        this.add(tf2);
        this.add(chkb1);
        this.add(chkb2);

        this.setBounds(100,100,275,300);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean checked = chkb1.isSelected();
        boolean checked2 = chkb2.isSelected();
        String str = tf1.getText();
        if(checked){
            tf2.setText(str);
        }
        if(checked2){
            tf1.setText("");
            tf2.setText("");
        }
    }

    public static void main(String[] args){
        new ExoCheckBox();}
}
