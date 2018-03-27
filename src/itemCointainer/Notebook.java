package itemCointainer;

import i18nSupport.LanguageChoice;

public class Notebook extends Item{


    public Notebook() {
        this.name = "notebook";
        this.price = new Double(5344534666.5);
        this.type = "notebookType";
        this.quantity = 0;
        this.URL = "/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/lab2/pictures/notebook.jpg";

    }
//    public Notebook() {
//        this.name = LanguageChoice.getLabels().getString("notebook");
//        this.price = new Double(5344534666.5);
//        this.type = LanguageChoice.getLabels().getString("notebookType");
//        this.quantity = 1;
//    }
    @Override
    public String getName() {
        return name;
    }
}