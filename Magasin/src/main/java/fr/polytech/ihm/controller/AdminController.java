package fr.polytech.ihm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Thoma on 3/11/2017.
 */
public class AdminController {
    @FXML
    private Button pie_chart_button;

    @FXML
    public void initialize(){

    }

    @FXML
    void show_piechart() throws Exception {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Vue Admin");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Science", 67),
                        new PieChart.Data("Neurologie", 33)
                );
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Benefice par categorie");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
}
