package fr.unice.polytech.a.ihm.g2c.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 08/03/2017.
 */
public class DataModel {

    private static DataModel instance = new DataModel();

    private List<Store> storeList = new ArrayList<>();
    private String highlight;

    private DataModel() {
        if (instance != null)
            throw new IllegalStateException();
    }

    public static DataModel getInstance() {
        return instance;
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void removeStore(Store store) {
        storeList.remove(store);
    }

    public List<Store> getStoreList() {
        return new LinkedList<>(storeList);
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}
