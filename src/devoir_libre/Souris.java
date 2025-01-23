package devoir_libre;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Souris extends MouseAdapter{

	private JFrame f;
	private JLabel xy;
	public Souris() {
			f = new JFrame("test souris");
			JPanel p = new JPanel();
			xy = new JLabel("x est y");
			f.add(p);
			f.add(xy);
			xy.addMouseListener(this);
			p.addMouseListener(this);
			f.setBounds(400, 200, 450, 400);
			f.setVisible(true);
	}
	
	public void mousePressed(MouseEvent e) {
		xy.setText(e.getX()+ " ," + e.getY());
	}

	
    public static void main(String[] args) {
        new Souris();
    }
}
