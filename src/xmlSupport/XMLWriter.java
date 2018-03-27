package xmlSupport;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import itemCointainer.Item;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLWriter {

    public XMLWriter(ArrayList<Item> itemList){
    FileOutputStream fos = null;
    XStream xstream = new XStream(new StaxDriver());
                try{
        String xml = xstream.toXML(itemList);
        fos = new FileOutputStream("/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/lab2/files/items.xml");
//        fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
        byte[] bytes = xml.getBytes("UTF-8");
        fos.write(bytes);

    }catch (Exception ex){
        System.err.println("Error in XML Write: " + ex.getMessage());
    }
                finally{
        if(fos != null){
            try{
                fos.close();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    }
}
