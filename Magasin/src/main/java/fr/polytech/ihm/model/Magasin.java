package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Jérémy Lara
 * @version 1.0
 *          Represents one the available shops
 */
public class Magasin {

    private StringProperty nomMagasin;
    private StringProperty adresseMagasin;
    private StringProperty distMagasin;

    public Magasin(String nomMagasin, String adresseMagasin, String distMagasin) {
        this.nomMagasin = new SimpleStringProperty(nomMagasin);
        this.adresseMagasin = new SimpleStringProperty(adresseMagasin);
        this.distMagasin = new SimpleStringProperty(distMagasin);
    }

    public StringProperty getNomMagasin() {
        return nomMagasin;
    }

    public StringProperty getAdresseMagasin() {
        return adresseMagasin;
    }

    public StringProperty getDistMagasin() {
        return distMagasin;
    }

}
