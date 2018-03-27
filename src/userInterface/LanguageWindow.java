package userInterface;

import i18nSupport.LanguageChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.Locale;

public class LanguageWindow extends JFrame {

    private JButton startButton;
    private JPanel panel1;
    private JComboBox languageComboBox;
    private JLabel chooseLngLabel;
    private LanguageChoice languageChoice;
    private JFrame mainMenu;
    private String language;

    public String getLanguage() {

        return language;
    }

    public LanguageChoice getLanguageChoice() {
        return languageChoice;
    }

    public LanguageWindow(String language) {

        this.setTitle("Item Manager");

        languageChoice = new LanguageChoice(language);
        chooseLngLabel.setText(languageChoice.setLabelText("chooseLng"));

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension.width/3, dimension.height/3);
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height);

        panel1.setPreferredSize(new Dimension(dimension.width/3, dimension.height/3));
        add(panel1);
        languageComboBox.addItem("English");
        languageComboBox.addItem("Polski");
        languageComboBox.addItem("Deutch");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu = new MainMenu();
                setVisible(false);
            }
        });
        languageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = (String) languageComboBox.getSelectedItem();

                switch (language) {//check for a match
                    case "English":
                        language = "en";
                        languageChoice = new LanguageChoice(language);
                        break;

                    case "Polski":
                        language = "pl";
                        languageChoice = new LanguageChoice(language);

                        break;
                    case "Deutch":
                        language = "de";
                        languageChoice = new LanguageChoice(language);

                        break;
                    default:
                        language = "en";
                        languageChoice = new LanguageChoice(language);

                        break;

                }
                MainMenu.setLanguage(language);
            }
        });
        languageComboBox.addFocusListener(new FocusAdapter() {
        });
    }

    public static void main(String[] args) {
        LanguageWindow window = new LanguageWindow("en");
    }

}
