package fr.polytech.ihm.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Enzo on 06/03/2017.
 */
public class JobOffer {

    private StringProperty name;
    private StringProperty function;
    private StringProperty localisation;
    private StringProperty date;

    public JobOffer(String name, String function, String localisation, String date){
        this.name = new SimpleStringProperty(name);
        this.function = new SimpleStringProperty(function);
        this.localisation = new SimpleStringProperty(localisation);
        this.date = new SimpleStringProperty(date);
    }
    public String getName(){
        return name.get();
    }

    public String getFunction(){
        return function.get();
    }

    public String getLocalisation(){
        return localisation.get();
    }

    public String getDate(){
        return date.get();
    }

    public StringProperty nameProperty(){
        return name;
    }

    public StringProperty functionProperty(){
        return function;
    }

    public StringProperty localisationProperty(){
        return localisation;
    }

    public StringProperty dateProperty(){
        return date;
    }

}
