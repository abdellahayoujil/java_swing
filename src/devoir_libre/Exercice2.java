package devoir_libre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Exercice2 {
	
    private static Timer timer; 

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Couleurs aléatoires");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 450, 400);
        frame.setLayout(new BorderLayout());
        JPanel colorPanel = new JPanel();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton playButton = new JButton("PLAY");
        JButton stopButton = new JButton("STOP");

        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);

        frame.add(colorPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        playButton.addActionListener(e -> {
            if (timer != null) {
                timer.cancel(); 
            }
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Random rand = new Random();
                    int r = rand.nextInt(256);
                    int g = rand.nextInt(256);
                    int b = rand.nextInt(256);
                    colorPanel.setBackground(new Color(r, g, b));
                }
            }, 0, 1000); 
        });

        stopButton.addActionListener(e -> {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
        });

        frame.setVisible(true);
    }

}
