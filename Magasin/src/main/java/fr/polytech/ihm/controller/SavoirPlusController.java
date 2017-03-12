package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Magasin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Kovox on 12/03/2017.
 */
public class SavoirPlusController {

    @FXML
    private TableView<Magasin> magasinTableView;

    @FXML
    private TableColumn<Magasin, String> nomMagasin;

    @FXML
    private TableColumn<Magasin, String> adresseMagasin;

    @FXML
    private TableColumn<Magasin, String> distMagasin;

    @FXML
    public void initialize() {
        fillShop();
    }

    private void fillShop() {
        ObservableList<Magasin> shops = FXCollections.observableArrayList();
        shops.add(new Magasin("Nom 1 (Ville)", "Adresse1", "65.604km"));
        shops.add(new Magasin("Nom 2 (Ville)", "Adresse2", "59.808km"));
        shops.add(new Magasin("Nom 3 (Ville)", "Adresse3", "85.796km"));
        shops.add(new Magasin("Nom 4 (Ville)", "Adresse4", "106.301km"));
        shops.add(new Magasin("Nom 5 (Ville)", "Adresse5", "110.276km"));

        nomMagasin.setCellValueFactory(cellData -> cellData.getValue().getNomMagasin());
        adresseMagasin.setCellValueFactory(cellData -> cellData.getValue().getAdresseMagasin());
        distMagasin.setCellValueFactory(cellData -> cellData.getValue().getDistMagasin());

        magasinTableView.setItems(shops);
    }

}
