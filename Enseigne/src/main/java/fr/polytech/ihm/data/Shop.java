package fr.polytech.ihm.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Enzo on 06/03/2017.
 */
public class Shop {
    private StringProperty name;
    private StringProperty adress;
    private double distance;

    public Shop(String name, String adress, double distance){
        this.name = new SimpleStringProperty(name);
        this.adress = new SimpleStringProperty(adress);
        this.distance = distance;
    }

    public String getName(){
        return name.get();
    }

    public String getAdress(){
        return adress.get();
    }

    public double getDistance(){
        return distance;
    }

    public StringProperty nameProperty(){
        return name;
    }

    public StringProperty adressProperty(){
        return adress;
    }

    public StringProperty distanceProperty(){
        return new SimpleStringProperty(distance + " km");
    }
}
