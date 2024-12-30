import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApplication {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Questions, options, and correct answers
    private String[] questions = {
        "What is the capital of France?",
        "Who is the author of 'Harry Potter'?",
        "What is 5 + 7?",
        "Which planet is known as the Red Planet?"
    };
    
    private String[][] optionsData = {
        {"Berlin", "Madrid", "Paris", "Rome"},
        {"J.R.R. Tolkien", "J.K. Rowling", "George Orwell", "Mark Twain"},
        {"10", "12", "14", "15"},
        {"Earth", "Mars", "Jupiter", "Saturn"}
    };
    
    private int[] correctAnswers = {2, 1, 1, 1}; // Indices of correct options

    public QuizApplication() {
        // Frame setup
        frame = new JFrame("Quiz Application");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Question panel
        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionLabel, BorderLayout.NORTH);

        // Options panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        frame.add(optionsPanel, BorderLayout.CENTER);

        // Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    showScore();
                }
            }
        });
        frame.add(nextButton, BorderLayout.SOUTH);

        // Load the first question
        loadQuestion();

        // Make the frame visible
        frame.setVisible(true);
    }

    private void loadQuestion() {
        // Set question text
        questionLabel.setText(questions[currentQuestionIndex]);

        // Set options text
        for (int i = 0; i < 4; i++) {
            options[i].setText(optionsData[currentQuestionIndex][i]);
        }

        // Clear previous selection
        optionsGroup.clearSelection();
    }

    private void checkAnswer() {
        // Check if the selected option is correct
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == correctAnswers[currentQuestionIndex]) {
                score++;
                break;
            }
        }
    }

    private void showScore() {
        // Show the final score
        JOptionPane.showMessageDialog(frame, "Quiz Over! Your score: " + score + "/" + questions.length);
        frame.dispose();
    }

    public static void main(String[] args) {
        new QuizApplication();
    }
}
