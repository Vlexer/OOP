import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Quiz {
	JFrame frame;
	JLabel question;
	String [] Questions = {
		"What is massive", "Which Came first", "Who said She knows", "what is agile framework"
	};
	String [][] Options = {
		{"Minecraft world", "Fortnite chapter6", "Low taper fade", "KSI forehead"},
		{"Quandale Dingle", "Skibidy", "Savesta", "freakbob"},
		{"Kyedae", "Joona", "Shahzam", "Tenz"},
		{"Nobody knows", "Uncle bob may know", "Everybody pretends to know", "ALL THE ABOVE"}
	};
	int [] correct = {2, 0, 1, 3};
	JRadioButton [] options;
	ButtonGroup optionsGroup;
	JButton nextButton;
	int qid = 0;
	int score = 0;
	Quiz () {
		frame = new JFrame();
		frame.setSize(420, 420);
		frame.setLayout(new BorderLayout());

		question = new JLabel("");
		frame.add(question, BorderLayout.NORTH);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(4,1));
		options = new JRadioButton[4];
		optionsGroup = new ButtonGroup();
		for ( int i = 0; i < 4; i++ ){
			options[i] = new JRadioButton();
			optionsGroup.add(options[i]);
			optionsPanel.add(options[i]);
		}
		frame.add(optionsPanel, BorderLayout.CENTER);
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				qid++;
				if (qid < Questions.length) loadQuestion();
				else showScore();
		}
		});	
		frame.add(nextButton, BorderLayout.SOUTH);
		loadQuestion();
		frame.setVisible(true);
	}

	void loadQuestion () {
		question.setText(Questions[qid]);
		for ( int i = 0 ; i < 4; i++ ) {
			options[i].setText(Options[qid][i]);		}
		
		optionsGroup.clearSelection();
	}
	void checkAnswer() {
		for ( int i = 0; i < 4; i++ ) {
			if ( options[i].isSelected() && i == correct[qid] ) {
				score++;
				break;
			}
		}
	}
	void showScore() {
		JOptionPane.showMessageDialog(frame, "Quiz Over ! Your Score is " + score + "/"+ "4");
		frame.dispose();
	}
	public static void main (String [] args) {
		new Quiz();
	} 
}