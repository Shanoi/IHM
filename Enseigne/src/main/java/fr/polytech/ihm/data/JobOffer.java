package fr.polytech.ihm.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Enzo on 06/03/2017.
 */
public class JobOffer {

    private int idJO;
    private StringProperty functionJO;
    private StringProperty descJO;
    private StringProperty dateJO;
    private int idShop;

    public JobOffer(int idJO, String functionJO, String descJO, String dateJO, int idShop){
        this.idJO = idJO;
        this.functionJO = new SimpleStringProperty(functionJO);
        this.descJO = new SimpleStringProperty(descJO);
        this.dateJO = new SimpleStringProperty(dateJO);
        this.idShop = idShop;
    }

    public int getIdJO(){
        return idJO;
    }

    public StringProperty getFunctionJO(){
        return functionJO;
    }

    public StringProperty getDescJO(){
        return descJO;
    }

    public StringProperty getDateJO(){
        return dateJO;
    }

    public int getIdShop() {
        return idShop;
    }
}
