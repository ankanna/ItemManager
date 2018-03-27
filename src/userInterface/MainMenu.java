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
    private JLabel titleLabel;
    private LanguageWindow lngWindow;
    public static String language = "en";

    public JPanel getPanel1() {
        return panel1;
    }

    public static void setLanguage(String language) {
        MainMenu.language = language;
    }

    public MainMenu() {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension.width/3, dimension.height/3);
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height);

        panel1.setPreferredSize(new Dimension(dimension.width/3 , dimension.height/3));
        add(panel1);

        titleLabel.setText("Item Manager");
        menuLabel.setText(LanguageChoice.getLabels().getString("menu"));
        myItemsButton.setText(LanguageChoice.getLabels().getString("myItems"));
        changeLngButton.setText(LanguageChoice.getLabels().getString("changeLng"));

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //changing language
        changeLngButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lngWindow = new LanguageWindow(language);
                setVisible(false);
            }
        });

        //opening panel with items
        myItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                panel1 = new MyItemsWindow().getPanel1();
                panel1.setLocation(dimension.width / 2 - panel1.getSize().width / 2, dimension.height / 2 - panel1.getSize().height / 2);
                add(panel1);
                pack();
                revalidate();
                repaint();
            }
        });
    }

}
