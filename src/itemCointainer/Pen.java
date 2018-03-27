package itemCointainer;

import i18nSupport.LanguageChoice;

public class Pen extends Item{

//    public Pen() {
//        this.name = LanguageChoice.getLabels().getString("pen");
//        this.price = new Double(3.2);
//        this.type = LanguageChoice.getLabels().getString("color");
//        this.quantity = 1;
//    }
        public Pen() {
        this.name = "pen";
        this.price = new Double(3.2);
        this.type = "color";
        this.quantity = 0;
        this.URL = "/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/lab2/pictures/pen.jpg";
    }


    public String getName() {
        return name;
    }
}
