package userInterface;

import i18nSupport.LanguageChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageWindow extends JFrame {

    private JButton startButton;
    private JPanel panel1;
    private JComboBox languageComboBox;
    private LanguageChoice languageChoice;
    private JFrame mainMenu;

    public LanguageChoice getLanguageChoice() {
        return languageChoice;
    }

    public LanguageWindow() {
        panel1.setPreferredSize(new Dimension(300, 250));
        add(panel1);
        languageComboBox.addItem("English");
        languageComboBox.addItem("Polski");
        languageComboBox.addItem("Deutch");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        languageChoice = new LanguageChoice("en");


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   getContentPane().removeAll();
                mainMenu = new MainMenu(languageChoice);
                setVisible(false);
//                panel1.setPreferredSize(new Dimension(300, 250));
//                add(panel1);
//                revalidate();
//                pack();
            }
        });
        languageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = (String) languageComboBox.getSelectedItem();

                switch (language) {//check for a match
                    case "English":


                        break;
                    case "Polski":
                        languageChoice = new LanguageChoice("pl");


                        break;
                    case "Deutch":
                        languageChoice = new LanguageChoice("de");

                        break;
                    default:

                        break;

                }
            }
        });
    }

    public static void main(String[] args) {
        LanguageWindow window = new LanguageWindow();
    }

}
