package fr.unice.polytech.a.ihm.g2c.common;

import fr.unice.polytech.a.ihm.g2c.model.DataModel;

/**
 * Created by user on 08/03/2017.
 */
public enum Category {

    // Waning: needs to be in alphabetical order !

    COSMETIC,
    FASHION_MAN,
    FASHION_WOMAN,
    HIGH_TECH,
    TELECOM;

    @Override
    public String toString() {
       return DataModel.getInstance().getLangBundle().getString(super.toString().toLowerCase().replace("_", "."));
    }

}
