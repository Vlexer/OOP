import javax.swing.*;
import java.awt.*;

class Demo {
	public static void main (String args[]) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setVisible(true);
		JLabel label = new JLabel("Hi this is a new Swing Application");
		label.setBackground(Color.black);
		label.setForeground(Color.green);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.add(label);
	}
}