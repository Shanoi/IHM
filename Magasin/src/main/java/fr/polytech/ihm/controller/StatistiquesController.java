package fr.polytech.ihm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Created by Thoma on 3/11/2017.
 */
public class StatistiquesController {

    @FXML
    public void initialize() {

    }

    @FXML
    void show_piechart() throws Exception {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Statistiques");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData = create_piechart_data();

        PieChart chart = new PieChart(pieChartData);
        chart.setStartAngle(90.0);
        chart.setTitle("Benefice par categorie");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<PieChart.Data> create_piechart_data() {
        PieChart.Data science = new PieChart.Data("Science", 67);
        PieChart.Data neurologie = new PieChart.Data("Neurologie", 33);

        return FXCollections.observableArrayList(science, neurologie);
    }

    @FXML
    void show_linechart() throws Exception {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Statistiques");
        stage.setWidth(800);
        stage.setHeight(600);


        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        LineChart<Number,Number> chart = new LineChart<>(xAxis,yAxis);
        chart.setTitle("Statistiques par mois");
        chart.getData().add(create_linechart_data());
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    private XYChart.Series create_linechart_data() {
        XYChart.Series series = new XYChart.Series();
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 15));
        series.getData().add(new XYChart.Data(2, 18));
        series.getData().add(new XYChart.Data(3, 20));
        series.getData().add(new XYChart.Data(4, 19));
        series.getData().add(new XYChart.Data(5, 19));
        series.getData().add(new XYChart.Data(6, 22));
        series.getData().add(new XYChart.Data(7, 21));
        series.getData().add(new XYChart.Data(8, 12));
        series.getData().add(new XYChart.Data(9, 20));
        series.getData().add(new XYChart.Data(10, 18));
        series.getData().add(new XYChart.Data(11, 25));
        series.getData().add(new XYChart.Data(12, 30));

        series.setName("Ventes par mois");

        return series;
    }
}
