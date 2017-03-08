package fr.polytech.ihm.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Enzo on 01/03/2017.
 */
public class Events {

    private StringProperty date;
    private StringProperty desc;

    public Events(String date, String desc){
        this.date = new SimpleStringProperty(date);
        this.desc = new SimpleStringProperty(desc);
    }

    public String getName(){
        return date.get();
    }

    public String getDesc(){
        return desc.get();
    }

    public StringProperty dateProperty(){
        return date;
    }

    public StringProperty descProperty(){
        return desc;
    }
}
