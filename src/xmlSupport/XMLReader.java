package xmlSupport;

import com.sun.tools.javac.jvm.Items;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import itemCointainer.Item;
import userInterface.MyItemsWindow;

import java.io.File;
import java.util.ArrayList;

public class XMLReader {

    public XMLReader(){
        XStream xstream = new XStream(new StaxDriver());
        try{
            File xmlFile = new File("/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/lab2/files/items.xml");
            MyItemsWindow.keyList = (ArrayList<Item>) xstream.fromXML(xmlFile);
        }catch(Exception e){
            System.err.println("Error in XML Read: " + e.getMessage());
        }

    }
}
