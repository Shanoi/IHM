package fr.polytech.ihm.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Enzo on 01/03/2017.
 */
public class Events {

    private int idEvent;
    private int idShop;
    private StringProperty nameEvent;
    private StringProperty dateEvent;
    private StringProperty descEvent;

    public Events(int idEvent, int idShop, String nameEvent, String dateEvent, String descEvent){
        this.idEvent = idEvent;
        this.idShop = idShop;
        this.nameEvent = new SimpleStringProperty(nameEvent);
        this.dateEvent = new SimpleStringProperty(dateEvent);
        this.descEvent = new SimpleStringProperty(descEvent);
    }

    public int getIdEvent() {
        return idEvent;
    }

    public int getIdShop() {
        return idShop;
    }

    public String getNameEvent() {
        return nameEvent.get();
    }

    public StringProperty getDateEvent(){
        return dateEvent;
    }

    public StringProperty getDescEvent(){
        return descEvent;
    }
}
