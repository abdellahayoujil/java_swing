package devoir_libre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercice3 extends JFrame implements ActionListener {

    private JTextField nombre1Field, nombre2Field, resultatField;
    private JRadioButton additionButton, multiplicationButton, divisionButton;
    private ButtonGroup buttonGroup;
    private JPanel operationsPanel;
    private JButton quitterButton;
    private JLabel nombre1Label, nombre2Label, resultatLabel; 

    public Exercice3() {
        super("Mini calculateur");
        setBounds(400, 300, 450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.setResizable(false);

        nombre1Label = new JLabel("Nombre 1:");
        nombre1Label.setBounds(20, 30, 60, 20); 
        nombre2Label = new JLabel("Nombre 2:");
        nombre2Label.setBounds(20, 60, 60, 20);
        resultatLabel = new JLabel("Résultat :");
        resultatLabel.setBounds(20, 90, 60, 20);

        nombre1Field = new JTextField(10);
        nombre1Field.setBounds(140, 30, 100, 20);
        nombre2Field = new JTextField(10);
        nombre2Field.setBounds(140, 60, 100, 20);
        resultatField = new JTextField(10);
        resultatField.setBounds(140, 90, 100, 20);
        resultatField.setForeground(Color.RED);
        Font boldFont = new Font("Arial", Font.BOLD, 19);
        resultatField.setFont(boldFont);
        resultatField.setEditable(false);
        quitterButton = new JButton("Quitter");
        quitterButton.setBounds(140, 120, 100, 20);
        quitterButton.addActionListener(this);

        additionButton = new JRadioButton("Addition");
        multiplicationButton = new JRadioButton("Multiplication");
        divisionButton = new JRadioButton("Division");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(additionButton);
        buttonGroup.add(multiplicationButton);
        buttonGroup.add(divisionButton);
        additionButton.setSelected(true);

        operationsPanel = new JPanel();
        operationsPanel.setLayout(new GridLayout(3, 1));
        operationsPanel.setBorder(BorderFactory.createTitledBorder("Opérations"));
        operationsPanel.add(additionButton);
        operationsPanel.add(multiplicationButton);
        operationsPanel.add(divisionButton);
        operationsPanel.setBounds(300, 30, 100, 90);

        add(nombre1Label);
        add(nombre2Label);
        add(resultatLabel);
        add(nombre1Field);
        add(nombre2Field);
        add(resultatField);
        add(quitterButton);
        add(operationsPanel);

        nombre1Field.addActionListener(this);
        nombre2Field.addActionListener(this);
        additionButton.addActionListener(this);
        multiplicationButton.addActionListener(this);
        divisionButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitterButton) {
            System.exit(0);
        } else {
            try {
                double nombre1 = Double.parseDouble(nombre1Field.getText());
                double nombre2 = Double.parseDouble(nombre2Field.getText());
                double resultat = 0;

                if (additionButton.isSelected()) {
                    resultat = nombre1 + nombre2;
                } else if (multiplicationButton.isSelected()) {
                    resultat = nombre1 * nombre2;
                } else if (divisionButton.isSelected()) {
                    if (nombre2 == 0) {
                        throw new ArithmeticException("Division par zéro");
                    }
                    resultat = nombre1 / nombre2;
                }

                resultatField.setText(String.valueOf(resultat));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Division par zéro impossible.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        }
    }

    public static void main(String[] args) {
        new Exercice3();
    }
}