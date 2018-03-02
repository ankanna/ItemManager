package userInterface;

import i18nSupport.LanguageChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton myItemsButton;
    private JButton changeLngButton;
    private JLabel menuLabel;
    private JPanel panel1;
    private LanguageWindow lngWindow;

    public MainMenu(LanguageChoice languageChoice) {
        panel1.setPreferredSize(new Dimension(300, 250));
        add(panel1);
        menuLabel.setText(languageChoice.setLabelText("menu"));
        myItemsButton.setText(languageChoice.setLabelText("myItems"));
        changeLngButton.setText(languageChoice.setLabelText("changeLng"));

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        changeLngButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lngWindow = new LanguageWindow();
              //  setVisible(false);
            }
        });
    }

}
