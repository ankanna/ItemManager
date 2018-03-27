package userInterface;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import i18nSupport.LanguageChoice;
import itemCointainer.Item;
import itemCointainer.Notebook;
import itemCointainer.Pen;
import itemCointainer.Pencil;
import xmlSupport.XMLReader;
import xmlSupport.XMLWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyItemsWindow extends JPanel {

    private JPanel panel1;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel label1;
    private JTable itemTable;
    private JLabel label2;
    private JButton returnButton;
    private JLabel typeLabel;
    private JLabel priceLabel;
    private JLabel nameLabel;
    private JLabel formatterLabel;
    private JLabel imageLabel;
    private JButton saveButton;
    static private int quantityAllItems;
    static public ArrayList<Item> itemList;
    static public ArrayList<Item> keyList;
    private Notebook notebook;
    private Pen pen;
    private Pencil pencil;

    public JPanel getPanel1() {
        return panel1;
    }

    public void addNotebook() {
        notebook = new Notebook();
        keyList.add(notebook);
    }

    public void addPen() {
        pen = new Pen();
        keyList.add(pen);

    }

    public void addPencil() {
        pencil = new Pencil();
        keyList.add(pencil);

    }

    public int getQuantityAllItems(){
        quantityAllItems = 0;
        for(int i = 0; i < keyList.size(); i++){
          quantityAllItems += keyList.get(i).getQuantity();}
          return quantityAllItems;
    }

    MyItemsWindow() {
        panel1 = this;
        MyItemsWindow myItemsWindow = this;
        label1.setText(LanguageChoice.getLabels().getString("name"));
        label2.setText(LanguageChoice.getLabels().getString("quantity"));

        XMLReader reader = new XMLReader();
        createList();


        DefaultTableModel model = new DefaultTableModel() {

            private static final long serialVersionUID = 1L;
            String[] columns = {
                    LanguageChoice.getLabels().getString("name"),
                    LanguageChoice.getLabels().getString("quantity"),
            };

            @Override
            public int getColumnCount() {
                return columns.length;
            }

            @Override
            public String getColumnName(int index) {
                return columns[index];
            }
        };
        setLayout(null);

        itemTable.setModel(model);

        showItems();
        formatterLabel.setText(LanguageChoice.createChoiceFormatter(getQuantityAllItems()));

        String nameLbl = LanguageChoice.getLabels().getString("name");
        nameLabel.setText(nameLbl + ":");
        String priceLbl = LanguageChoice.getLabels().getString("price");
        priceLabel.setText(priceLbl + ":");
        String typeLbl = LanguageChoice.getLabels().getString("type");
        typeLabel.setText(typeLbl + ":");

        ImageIcon icon = new ImageIcon("/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/lab2/pictures/question.png");
        imageLabel.setIcon(icon);


        addButton.setText(LanguageChoice.getLabels().getString("add"));
        returnButton.setText(LanguageChoice.getLabels().getString("return"));
        deleteButton.setText(LanguageChoice.getLabels().getString("delete"));
        saveButton.setText(LanguageChoice.getLabels().getString("save"));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = itemTable.getSelectedRow();
                keyList.get(index).setQuantity(keyList.get(index).getQuantity()+1);
                changeItem(keyList.get(index).getQuantity(), index);
                formatterLabel.setText(LanguageChoice.createChoiceFormatter(getQuantityAllItems()));

            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();

            }
        });
        itemTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = itemTable.getSelectedRow();
                ImageIcon icon = new ImageIcon(itemList.get(i).getURL());
                imageLabel.setIcon(icon);
                nameLabel.setText(nameLbl + ": " + itemList.get(i).getName());
                priceLabel.setText(priceLbl + ": " + LanguageChoice.displayCurrency(itemList.get(i).getPrice()));
                typeLabel.setText(typeLbl + ": " + itemList.get(i).getType());
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = itemTable.getSelectedRow();
                if(keyList.get(index).getQuantity() > 0) {
                    keyList.get(index).setQuantity(keyList.get(index).getQuantity() - 1);
                    changeItem(keyList.get(index).getQuantity(), index);
                    formatterLabel.setText(LanguageChoice.createChoiceFormatter(getQuantityAllItems()));
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XMLWriter writer = new XMLWriter(keyList);

            }
        });
    }

    public void createList(){
        if (keyList == null){
            keyList = new ArrayList<>();
            addNotebook();
            addPen();
            addPencil();}

        notebook = new Notebook();
        pen = new Pen();
        pencil = new Pencil();
        itemList = new ArrayList<>();
        itemList.add(notebook);
        itemList.add(pen);
        itemList.add(pencil);


        for(int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setName(LanguageChoice.getLabels().getString(keyList.get(i).getName()));
            itemList.get(i).setPrice(keyList.get(i).getPrice());
            itemList.get(i).setType(LanguageChoice.getLabels().getString(keyList.get(i).getType()));
            itemList.get(i).setQuantity(keyList.get(i).getQuantity());
        }
    }


    public void changeItem(int quantity, int rowNum) {
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.setValueAt(quantity, rowNum, 1);

    }

    public void showItems() {
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < itemList.size(); i++) {

            row[0] = itemList.get(i).getName();
            row[1] = keyList.get(i).getQuantity();

            model.addRow(row);
        }
    }

};
