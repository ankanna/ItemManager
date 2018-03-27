package itemCointainer;

import i18nSupport.LanguageChoice;

public abstract class Item {
    protected String name;
    protected Double price;
    protected String type;
    protected int quantity;
    protected int rowNum;
    protected String URL;

    public String getURL() {
        return URL;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getName();


    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
