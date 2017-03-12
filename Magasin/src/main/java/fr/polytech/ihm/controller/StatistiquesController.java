package fr.polytech.ihm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

/**
 * Created by Thoma on 3/11/2017.
 */
public class StatistiquesController {

    private static final int sciences = 67;
    private static final int neurologies = 33;

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
        PieChart.Data science = new PieChart.Data("Science", sciences);
        PieChart.Data neurologie = new PieChart.Data("Neurologie", neurologies);

        return FXCollections.observableArrayList(science, neurologie);
    }

    @FXML
    void show_linechart() throws Exception {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Statistiques");
        stage.setResizable(false);


        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mois");
        LineChart<String,Number> chart = new LineChart<>(xAxis,yAxis);
        chart.setTitle("Statistiques mois par mois");

        XYChart.Series data_affaire = create_linechart_data_affaire();
        XYChart.Series data_renvoye = create_linechart_data_renvoye();
        XYChart.Series data_solde = create_linechart_data_solde();
        chart.getData().addAll(data_affaire, data_renvoye, data_solde);

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }


    private XYChart.Series create_linechart_data_affaire() {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new Data("JAN 16", 15));
        series.getData().add(new Data("FEB 16", 18));
        series.getData().add(new Data("MARS 16", 20));
        series.getData().add(new Data("AVR 16", 19));
        series.getData().add(new Data("MAI 16", 19));
        series.getData().add(new Data("JUN 16", 22));
        series.getData().add(new Data("JUL 16", 21));
        series.getData().add(new Data("AOUT 16", 12));
        series.getData().add(new Data("SEP 16", 20));
        series.getData().add(new Data("OCT 16", 18));
        series.getData().add(new Data("NOV 16", 25));
        series.getData().add(new Data("DEC 16", 30));
        series.getData().add(new Data("JAN 17", 16));
        series.getData().add(new Data("FEB 17", 20));

        series.setName("Chiffres daffaires (k€)");

        return series;
    }

    private XYChart.Series create_linechart_data_renvoye() {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new Data("JAN 16", 10));
        series.getData().add(new Data("FEB 16", 1));
        series.getData().add(new Data("MARS 16", 2));
        series.getData().add(new Data("AVR 16", 1));
        series.getData().add(new Data("MAI 16", 1));
        series.getData().add(new Data("JUN 16", 2));
        series.getData().add(new Data("JUL 16", 3));
        series.getData().add(new Data("AOUT 16", 7));
        series.getData().add(new Data("SEP 16", 1));
        series.getData().add(new Data("OCT 16", 1));
        series.getData().add(new Data("NOV 16", 2));
        series.getData().add(new Data("DEC 16", 2));
        series.getData().add(new Data("JAN 17", 9));
        series.getData().add(new Data("FEB 17", 3));

        series.setName("Produits renvoyes (%)");

        return series;
    }

    private XYChart.Series create_linechart_data_solde() {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new Data("JAN 16", 1));
        series.getData().add(new Data("FEB 16", 2));
        series.getData().add(new Data("MARS 16", 3));
        series.getData().add(new Data("AVR 16", 1));
        series.getData().add(new Data("MAI 16", 1));
        series.getData().add(new Data("JUN 16", 5));
        series.getData().add(new Data("JUL 16", 5));
        series.getData().add(new Data("AOUT 16", 2));
        series.getData().add(new Data("SEP 16", 2));
        series.getData().add(new Data("OCT 16", 2));
        series.getData().add(new Data("NOV 16", 5));
        series.getData().add(new Data("DEC 16", 15));
        series.getData().add(new Data("JAN 17", 1));
        series.getData().add(new Data("FEB 17", 2));

        series.setName("Produits soldés (%)");

        return series;
    }
}
