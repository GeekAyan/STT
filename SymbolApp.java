import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SymbolApp extends Frame implements ActionListener {
    private Label[] symbolLabels = new Label[99];
    private Button submitButton;
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

        // Adding instruction message
        TextArea instruction = new TextArea(
            "Think of any two digit number. Now reverse it and find the difference of them.\n" +
            "Now find the number you got and remember the symbol from the panel below.\n" +
            "Don't tell me, I'll read your mind! Hit the below button when you are ready to see the magic!",
            5, 60, TextArea.SCROLLBARS_NONE);
        instruction.setEditable(false);
        instruction.setFont(new Font("Arial", Font.PLAIN, 16));
        add(instruction, BorderLayout.NORTH);

        // Panel for symbols
        Panel symbolPanel = new Panel(new GridLayout(11, 9));
        for (int i = 0; i < 99; i++) {
            String symbol = (i % 9 == 0) ? specialSymbol : Character.toString((char) (33 + (i % 94)));
            symbolLabels[i] = new Label(i + ": " + symbol); // Numbering symbols
            symbolLabels[i].setAlignment(Label.CENTER);
            symbolPanel.add(symbolLabels[i]);
        }
        add(symbolPanel, BorderLayout.CENTER);

        // Panel for submit button
        Panel controlPanel = new Panel(new FlowLayout());
        submitButton = new Button("Chin Tapak Dum Dum");
        submitButton.addActionListener(this);
        controlPanel.add(submitButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Setting up the window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Clear the current content and display the selected symbol
        if (ae.getSource() == submitButton) {
            removeAll();
            setLayout(new BorderLayout());
            Label resultLabel = new Label(selectedSymbol, Label.CENTER);
            resultLabel.setFont(new Font("Arial", Font.BOLD, 50));
            add(resultLabel, BorderLayout.CENTER);
            validate();
            repaint();
        }
    }

    public static void main(String[] args) {
        new SymbolApp();
    }
}
