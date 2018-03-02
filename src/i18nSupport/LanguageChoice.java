package i18nSupport;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageChoice {
    private ResourceBundle labels;

    public ResourceBundle getLabels() {
        return labels;
    }

    public void setLabels(ResourceBundle labels) {
        this.labels = labels;
    }

    public String setLabelText(String text){
        return labels.getString(text);
    }

    public LanguageChoice(String language){
        Locale currentLocale = new Locale(language);
        labels = ResourceBundle.getBundle("i18nSupport.myDictionary", currentLocale);
    }
}
