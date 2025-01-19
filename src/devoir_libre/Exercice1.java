package devoir_libre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Exercice1{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Couleurs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(450, 200, 400, 300);
        JPanel colorPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JRadioButton rougeButton = new JRadioButton("Rouge");
        JRadioButton vertButton = new JRadioButton("Vert");
        JRadioButton bleuButton = new JRadioButton("Bleu");

        ButtonGroup group = new ButtonGroup();
        group.add(rougeButton);
        group.add(vertButton);
        group.add(bleuButton);
        buttonPanel.add(rougeButton);
        buttonPanel.add(vertButton);
        buttonPanel.add(bleuButton);

        ActionListener actionListener = e -> {
            if (rougeButton.isSelected()) {
                colorPanel.setBackground(Color.RED);
            } else if (vertButton.isSelected()) {
                colorPanel.setBackground(Color.GREEN);
            } else if (bleuButton.isSelected()) {
                colorPanel.setBackground(Color.BLUE);
            }
        };

        rougeButton.addActionListener(actionListener);
        vertButton.addActionListener(actionListener);
        bleuButton.addActionListener(actionListener);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(colorPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}




