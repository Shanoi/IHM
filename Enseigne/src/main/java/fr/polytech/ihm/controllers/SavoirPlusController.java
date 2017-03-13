package fr.polytech.ihm.controllers;

/**
 * Created by Enzo on 01/03/2017.
 */

import fr.polytech.ihm.data.Events;
import fr.polytech.ihm.data.JobOffer;
import fr.polytech.ihm.data.Shop;
import fr.polytech.ihm.kernel.EventParser;
import fr.polytech.ihm.kernel.JobOfferParser;
import fr.polytech.ihm.kernel.ShopParser;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;

public class SavoirPlusController {

    private ShopParser shopParser;
    private EventParser eventParser;
    private JobOfferParser jobOfferParser;

    private Point posCustomer = new Point(0,0);

    @FXML
    private TabPane spreadsheet;

    @FXML
    private TableView<Events> eventsSpread;

    @FXML
    private TableColumn<Events, String> dateEvent;

    @FXML
    private TableColumn<Events, String> descEvent;

    @FXML
    private TableView<Shop> shopSpread;

    @FXML
    private TableColumn<Shop, String> nameShop;

    @FXML
    private TableColumn<Shop, String> adressShop;

    @FXML
    private TableColumn<Shop, String> distShop;

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

    SingleSelectionModel<Tab> selectionModel;

    public void initialize(){
        shopParser = new ShopParser();
        eventParser = new EventParser();
        jobOfferParser = new JobOfferParser();
        selectionModel = spreadsheet.getSelectionModel();

        fillEvents();
        fillShop();
        fillJobs();

        selectionModel.selectedIndexProperty().addListener((ov, oldValue, newValue) -> {
            int eventTab = 0;
            int shopTab = 1;
            int joTab = 2;

            if (newValue.intValue() == eventTab){
                fillEvents();
            }

            if (newValue.intValue() == shopTab){
                fillShop();
            }

            if (newValue.intValue() == joTab){
                fillJobs();
            }
        });
    }

    public void setTabView(int index){
        selectionModel.select(index);
    }

    private void fillEvents(){
        ObservableList<Events> events = FXCollections.observableArrayList();

        events.addAll(eventParser.getEvents());

        dateEvent.setCellValueFactory(cellData -> cellData.getValue().getDateEvent());
        descEvent.setCellValueFactory(cellData -> cellData.getValue().getDescEvent());

        eventsSpread.setItems(events);
    }

    private void fillShop(){
        ObservableList<Shop> shops = FXCollections.observableArrayList();

        shops.addAll(shopParser.getShop());

        nameShop.setCellValueFactory(cellData -> cellData.getValue().getNameShop());
        adressShop.setCellValueFactory(cellData -> cellData.getValue().getAdressShop());
        distShop.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().distanceShopForPos(posCustomer) + " km"));

        shopSpread.setItems(shops);
    }

    private void fillJobs(){
        ObservableList<JobOffer> jobs = FXCollections.observableArrayList();

        jobs.addAll(jobOfferParser.getJobOffers());

        nameJobs.setCellValueFactory(cellData -> cellData.getValue().getDescJO());
        functionJobs.setCellValueFactory(cellData -> cellData.getValue().getFunctionJO());
        localisationJobs.setCellValueFactory(cellData -> new SimpleStringProperty("Magasin n°" + cellData.getValue().getIdShop()));
        dateJobs.setCellValueFactory(cellData -> cellData.getValue().getDateJO());

        jobSpread.setItems(jobs);
    }
}
