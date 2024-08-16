
\import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SymbolApp extends JFrame implements ActionListener {
    private JLabel[] symbolLabels = new JLabel[99];
    private JButton submitButton;
    private String specialSymbol;
    private String selectedSymbol;

    public SymbolApp() {
        // Generate a random special symbol
        Random rand = new Random();
        specialSymbol = Character.toString((char) (rand.nextInt(94) + 33)); // Random ASCII character from 33 to 126
        selectedSymbol = specialSymbol;

        // Setting up the main frame
        setLayout(new BorderLayout());
        setSize(800, 700);
        setTitle("Symbol App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding instruction message
        JTextArea instruction = new JTextArea(
            "Think of any two digit number. Now reverse it and find the difference of them.\n" +
            "Now find the number you got and remember the symbol from the panel below.\n" +
            "Don't tell me, I'll read your mind! Hit the below button when you are ready to see the magic!");
        instruction.setEditable(false);
        instruction.setFont(new Font("Arial", Font.PLAIN, 16));
        instruction.setLineWrap(true);
        instruction.setWrapStyleWord(true);
        add(new JScrollPane(instruction), BorderLayout.NORTH);

        // Panel for symbols
        JPanel symbolPanel = new JPanel(new GridLayout(11, 9));
        for (int i = 0; i < 99; i++) {
            String symbol = (i % 9 == 0) ? specialSymbol : Character.toString((char) (33 + (i % 94)));
            symbolLabels[i] = new JLabel(i + ": " + symbol, SwingConstants.CENTER);
            symbolPanel.add(symbolLabels[i]);
        }
        add(symbolPanel, BorderLayout.CENTER);

        // Panel for submit button
        JPanel controlPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Chin Tapak Dum Dum");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set font size
        submitButton.setBackground(Color.YELLOW); // Set background color
        submitButton.setForeground(Color.BLACK); // Set text color
        submitButton.setPreferredSize(new Dimension(250, 50)); // Set button size
        submitButton.addActionListener(this);
        controlPanel.add(submitButton);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Clear the current content and display the selected symbol
        if (ae.getSource() == submitButton) {
            getContentPane().removeAll();
            setLayout(new BorderLayout());
            JLabel resultLabel = new JLabel(selectedSymbol, SwingConstants.CENTER);
            resultLabel.setFont(new Font("Arial", Font.BOLD, 50));
            add(resultLabel, BorderLayout.CENTER);
            validate();
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SymbolApp::new);
    }
}