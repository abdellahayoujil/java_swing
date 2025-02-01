package devoir_libre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice extends JFrame implements ActionListener {
    private JTextField display;
    private double num1, num2, result;
    private String operator = "";

    public Calculatrice() {
        setTitle("Calculatrice");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

   
        display = new JTextField("0.0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "<-", "CE", "C", "+/-", "Rac",
            "7", "8", "9", "/", "%",
            "4", "5", "6", "*", "1/x",
            "1", "2", "3", "-", "=",
            "0", ".", "", "+", ""
        };

        for (String text : buttons) {
            if (!text.isEmpty()) {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.BOLD, 16));
                button.addActionListener(this);
                panel.add(button);
            } else {
                panel.add(new JLabel());
            }
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            if (display.getText().equals("0.0") || operator.equals("=")) {
                display.setText(command);
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("+-*/".contains(command)) {
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num2 != 0 ? num1 / num2 : 0; break;
            }
            display.setText(String.valueOf(result));
            operator = "=";
        } else if (command.equals("C")) {
            display.setText("0.0");
            num1 = num2 = result = 0;
            operator = "";
        } else if (command.equals("CE")) {
            display.setText("0.0");
        } else if (command.equals("<-")) {
            String text = display.getText();
            if (!text.isEmpty()) {
                display.setText(text.substring(0, text.length() - 1));
            }
        } else if (command.equals("+/-")) {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(-value));
        } else if (command.equals("Rac")) {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(value)));
        } else if (command.equals("1/x")) {
            double value = Double.parseDouble(display.getText());
            if (value != 0) {
                display.setText(String.valueOf(1 / value));
            } else {
                display.setText("Erreur");
            }
        }
    }

    public static void main(String[] args) {
        new Calculatrice();
    }
}
