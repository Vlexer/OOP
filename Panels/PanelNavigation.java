import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PanelNavigation {
	JFrame frame;
	JPanel container;
	CardLayout cardLayout;
	PanelNavigation () {
		frame = new JFrame();
		frame.setSize(400, 400);
		

		cardLayout = new CardLayout();
		container = new JPanel (cardLayout);

		container.add(createPanel1(), "Panel1");
		container.add(createPanel2(), "Panel2");
		
		frame.add(container);
		frame.setVisible(true);

	}

	JPanel createPanel1 () {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("THIS IS PANEL1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);

		JButton button = new JButton ("Navigate to different pane");
		button.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(container, "Panel2");
			}
		});
		panel.add(button, BorderLayout.SOUTH);	
		return panel;
	}
	JPanel createPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("THIS IS PANEL 2");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);
		
		JButton button = new JButton ("Press to navigate to panel 1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(container, "Panel1");
			}
		});	
		panel.add(button, BorderLayout.SOUTH);
		return panel;

	}
	public static void main ( String [] args ) {
		new PanelNavigation();
	}
}