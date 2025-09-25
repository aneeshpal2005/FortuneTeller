import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends javax.swing.JFrame {

    JPanel mainPanel;
    JPanel iconPanel;
    JPanel displayPanel;
    JPanel controlPanel;

    JLabel iconLabel;
    ImageIcon tellerIcon;

    JScrollPane scrollPane;
    JTextArea fortuneDisplay;

    JButton fortuneButton;
    JButton quitButton;

    int curDex = -1;

    java.util.Random rnd = new java.util.Random();

    String[] fortunes = {"You will have a great day!",
                        "You will have a great week!",
                        "You will have a great month!",
                        "You will have a great year!",
            "You will have a good day!",
            "You will have a good week!",
            "You will have a good month!",
            "You will have a good year!",
            "You will have an awesome day!",
            "You will have an awesome week!"};



    public FortuneTellerFrame() {
        super("Fortune Teller");

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);
        createIconPanel();
        createDisplayPanel();
        createControlPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);


    }

    private void createControlPanel() {
        controlPanel = new JPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        controlPanel.setLayout(new GridLayout(1, 2));
        fortuneButton = new JButton("Give me a Fortune");
        quitButton = new JButton("Quit");
        controlPanel.add(fortuneButton);
        controlPanel.add(quitButton);

        fortuneButton.addActionListener(e -> {
                int newDex = -1;
                do {
                    newDex = rnd.nextInt(fortunes.length);
                } while (newDex == curDex);
                fortuneDisplay.append(fortunes[newDex] + "\n");
                curDex = newDex;
        });
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void createDisplayPanel() {
        displayPanel = new JPanel();
        fortuneDisplay = new JTextArea(10,30);
        fortuneDisplay.setEditable(false);
        fortuneDisplay.setLineWrap(true);
        scrollPane = new JScrollPane(fortuneDisplay);

        displayPanel.add(scrollPane);

        mainPanel.add(displayPanel, BorderLayout.CENTER);


    }

    private void createIconPanel() {
        iconPanel = new JPanel();
        tellerIcon = new ImageIcon("tellerIcon.jpg");
        iconLabel = new JLabel(tellerIcon);

        iconLabel.setVerticalTextPosition(JLabel.BOTTOM);
        iconLabel.setHorizontalTextPosition(JLabel.CENTER);

        iconPanel.add(iconLabel);
        mainPanel.add(iconPanel, BorderLayout.NORTH);
    }


}
