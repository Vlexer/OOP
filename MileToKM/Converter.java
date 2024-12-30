import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Converter {
	JFrame frame;
	JLabel InputLabel;
	JTextField inputField;
	JButton button;
	JLabel OutputLabel;
	JLabel inMiles;
	Converter () {
		frame = new JFrame();
		frame.setSize(800, 800);
		frame.setLayout(null);
		frame.setOpaque(true);
		frame.setBackground(Color.BLUE);
		InputLabel = new JLabel("Enter KM");
		InputLabel.setBounds(100, 100, 200, 30);
	
		inputField = new JTextField();
		inputField.setBounds(400, 100, 200, 30);
		
		button = new JButton("Convert");
		button.setBounds(100,200, 100,30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double d = Double.parseDouble(inputField.getText());
				double res = d / 1.6;
				String text = Double.toString(res);
				inMiles.setText(text + "km");
			}
 		});	
		
		OutputLabel = new JLabel("Result in KM");
		OutputLabel.setBounds(100, 300, 100, 30);	
		
		inMiles = new JLabel("");
		inMiles.setBounds(300, 300, 200, 30);
		
		frame.add(InputLabel);
		frame.add(button);
		frame.add(inputField);
		frame.add(OutputLabel);
		frame.add(inMiles);
		frame.setVisible(true);
	}
	public static void main(String [] args ) {
		new Converter();
	}
}