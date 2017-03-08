package fr.unice.polytech.a.ihm.g2c.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08/03/2017.
 */
public class DataStores {

    private static DataStores instance = new DataStores();
    List<Store> storeList = new ArrayList<>();

    private DataStores() {
        if (instance != null)
            throw new IllegalStateException();
    }

    public static DataStores getInstance() {
        return instance;
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void removeScene(Store store) {
        storeList.remove(store);
    }

    public List<Store> getStoreList() {
        return storeList;
    }
}
