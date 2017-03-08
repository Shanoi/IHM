package fr.polytech.ihm.controllers;

/**
 * Created by Enzo on 01/03/2017.
 */

import fr.polytech.ihm.data.Events;
import fr.polytech.ihm.data.JobOffer;
import fr.polytech.ihm.data.Shop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavoirPlusController {
    private static final Logger log = LoggerFactory.getLogger(SavoirPlusController.class);

    @FXML
    private TextArea testHeader;

    @FXML
    private TabPane spreadsheet;

    @FXML
    private Tab event;

    @FXML
    private TableView<Events> eventsSpread;

    @FXML
    private TableColumn<Events, String> dateEvent;

    @FXML
    private TableColumn<Events, String> descEvent;

    @FXML
    private Tab shops;

    @FXML
    private TableView<Shop> shopSpread;

    @FXML
    private TableColumn<Shop, String> nameShop;

    @FXML
    private TableColumn<Shop, String> adressShop;

    @FXML
    private TableColumn<Shop, String> distShop;

    @FXML
    private Tab jobs;

    @FXML
    private TableView<JobOffer> jobSpread;

    @FXML
    private TableColumn<JobOffer, String> nameJobs;

    @FXML
    private TableColumn<JobOffer, String> functionJobs;

    @FXML
    private TableColumn<JobOffer, String> localisationJobs;

    @FXML
    private TableColumn<JobOffer, String> dateJobs;

    @FXML
    private TextArea adress;

    @FXML
    private TextArea website;

    @FXML
    private TextArea support;

    SingleSelectionModel<Tab> selectionModel;

    @FXML
    public void initialize(){
        initEvents();
        initShops();
        initJobs();
        selectionModel = spreadsheet.getSelectionModel();
    }

    public void setTabView(int index){
        selectionModel.select(index);
    }

    private void initEvents(){
        ObservableList<Events> events = FXCollections.observableArrayList();
        events.add(new Events("01/01/2017", "This event is the first item in the spreadsheet !"));
        events.add(new Events("02/02/2017", "And this is the second one"));

        dateEvent.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        descEvent.setCellValueFactory(cellData -> cellData.getValue().descProperty());

        eventsSpread.setItems(events);
    }

    private void initShops(){
        ObservableList<Shop> shops = FXCollections.observableArrayList();

        shops.add(new Shop("Magasin 1", "123 rue de la paix", 50.9));
        shops.add(new Shop("Magasin 2", "456 route de Napoléon", 26.0));
        shops.add(new Shop("Magasin 3", "789 avenue Martin", 146.4));

        nameShop.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        adressShop.setCellValueFactory(cellData -> cellData.getValue().adressProperty());
        distShop.setCellValueFactory(cellData -> cellData.getValue().distanceProperty());

        shopSpread.setItems(shops);
    }

    private void initJobs(){
        ObservableList<JobOffer> jobs = FXCollections.observableArrayList();

        jobs.add(new JobOffer("Hôte(sse) de caisse", "Vente", "Variées","01/01/2017"));
        jobs.add(new JobOffer("Directeur de magasin", "Vente", "Nice","02/02/2017"));
        jobs.add(new JobOffer("Analyste financier", "Marketing", "Paris","03/03/2017"));

        nameJobs.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        functionJobs.setCellValueFactory(cellData -> cellData.getValue().functionProperty());
        localisationJobs.setCellValueFactory(cellData -> cellData.getValue().localisationProperty());
        dateJobs.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        jobSpread.setItems(jobs);
    }
}
