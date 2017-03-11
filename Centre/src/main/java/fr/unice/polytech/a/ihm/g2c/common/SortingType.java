package fr.unice.polytech.a.ihm.g2c.common;

import fr.unice.polytech.a.ihm.g2c.model.Store;

import java.util.Comparator;

/**
 * Created by Jeremy on 11/03/2017.
 */
public enum SortingType {

    A_TO_Z(Comparator.comparing(Store::getName)),
    CATEGORY(Comparator.comparing(Store::getCategory));

    private final Comparator<Store> comparator;

    SortingType(Comparator<Store> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Store> getComparator() {
        return comparator;
    }

}
