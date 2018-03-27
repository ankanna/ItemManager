package i18nSupport;

import userInterface.MainMenu;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageChoice {
    private static ResourceBundle labels;
    private static Locale currentLocale;

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static ResourceBundle getLabels() {
        return labels;
    }

    public void setLabels(ResourceBundle labels) {
        this.labels = labels;
    }

    public String setLabelText(String text){
        return labels.getString(text);
    }

    public LanguageChoice(String language){
        currentLocale = new Locale(language);
        labels = ResourceBundle.getBundle("i18nSupport.myDictionary", currentLocale);
    }

    public static String createChoiceFormatter(int numItems) {

        MessageFormat messageForm = new MessageFormat("");
        messageForm.setLocale(LanguageChoice.getCurrentLocale());
        double[] itemsLimits = {0, 1, 2, 3, 4};
        String[] itemsStrings = {
                LanguageChoice.getLabels().getString("noItems"),
                LanguageChoice.getLabels().getString("oneItem"),
                LanguageChoice.getLabels().getString("two-fourItems"),
                LanguageChoice.getLabels().getString("fiveMoreItems"),
                LanguageChoice.getLabels().getString("22-24"),
        };

        ChoiceFormat choiceForm = new ChoiceFormat(itemsLimits, itemsStrings);

        String pattern = LanguageChoice.getLabels().getString("pattern");
        messageForm.applyPattern(pattern);

        Format[] formats = {choiceForm, null, NumberFormat.getInstance()};
        messageForm.setFormats(formats);

        Object[] messageArguments = {null, null};

        int units = numItems % 10;

        if (numItems == 0) {
            messageArguments[0] = new Integer(0);
        }
        if (numItems == 1) {
            messageArguments[0] = new Integer(1);
        }
        if (numItems > 1 && numItems < 5) {
            messageArguments[0] = new Integer(2);
            messageArguments[1] = new Integer(numItems);
        } if (numItems > 4 ) {
            messageArguments[0] = new Integer(3);
            messageArguments[1] = new Integer(numItems);
        }
        if(numItems > 21 && numItems < 25){
            messageArguments[0] = new Integer(4);
            messageArguments[1] = new Integer(numItems);
        }

        String result = messageForm.format(messageArguments);
        System.out.println(result);

        return result;
    }


    static public String displayCurrency(Double price) {

        NumberFormat numberFormatter;
        String quantityOut;

        numberFormatter = NumberFormat.getNumberInstance(currentLocale);
        quantityOut = numberFormatter.format(price);

        return  quantityOut;
    }

}
