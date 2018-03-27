package itemCointainer;

import i18nSupport.LanguageChoice;

public class Pencil extends Item{
//
//    public Pencil() {
//        this.name = LanguageChoice.getLabels().getString("pencil");
//        this.price = new Double(2.5);
//        this.type = LanguageChoice.getLabels().getString("pencilType");
//        this.quantity = 1;
//    }

    public Pencil() {
        this.name = "pencil";
        this.price = new Double(2000000.50);
        this.type = "pencilType";
        this.quantity = 0;
        this.URL = "/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/lab2/pictures/pencil.jpg";
    }
    @Override
    public String getName() {
        return name;
    }
}
