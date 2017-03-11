package fr.polytech.ihm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * Created by Thoma on 3/11/2017.
 */
public class AdminController {

    @FXML
    public void initialize() {

    }

    @FXML
    void show_piechart() throws Exception {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Vue Admin");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData = create_data();

        PieChart chart = new PieChart(pieChartData);
        chart.setStartAngle(90.0);
        chart.setTitle("Benefice par categorie");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<PieChart.Data> create_data() {
        PieChart.Data science = new PieChart.Data("Science", 67);
        PieChart.Data neurologie = new PieChart.Data("Neurologie", 33);

        return FXCollections.observableArrayList(science, neurologie);
    }
}
