import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


class Quiz  {

        JFrame frame;
        JButton button;
        JRadioButton [] options;
        ButtonGroup optionGroup;
        JLabel label;
        int qid = 0;
        int score = 0;
        String [] Questions = {"What is Massive", "Who said she knows"};
        String [][] AnswerOptions = {{"Low taper Fade", "Chapter 5"}, {"Joona", "Kyedae"}};
        int correct[] = {0,0};
        Quiz () {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new BorderLayout());
            button = new JButton("Submit");
            frame.add(button, BorderLayout.SOUTH);

            label = new JLabel("");
            frame.add(label, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            options = new JRadioButton[2];
            optionGroup = new ButtonGroup();

            for ( int i = 0; i < 2; i++ ) {
                options[i] = new JRadioButton();
                optionGroup.add(options[i]);
                panel.add(options[i]);
            } 
            button.addActionListener(new ActionListener() {
                public void actionPerformed ( ActionEvent e ) {
                    checkAnswer();
                    qid++;
                    if ( qid < Questions.length ) loadQuestion();
                    else showScore();
                 }
            });
            loadQuestion();
            frame.add(panel, BorderLayout.CENTER);
            
            frame.setVisible(true);
        }
        void checkAnswer() {
            for ( int i = 0; i < 2; i++ ) {
                if (options[i].isSelected() && i == correct[i]) {
                    score++;break;
                }
            }
        }
        void loadQuestion () {
            label.setText(Questions[qid]);
            for ( int i = 0; i < 2; i++ ) {
                options[i].setText(AnswerOptions[qid][i]);
            }
            optionGroup.clearSelection();
        }
        void showScore () {
            frame.dispose();
            JOptionPane.showMessageDialog(frame, "You scored " + score + "/2");
        }
        public static void main(String[] args) {
            new Quiz();
        }
}