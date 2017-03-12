package fr.polytech.ihm.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AdminController {

    //Changer données magasin
    @FXML
    private TextField changeAdresse;
    @FXML
    private TextField changeNum;
    @FXML
    private TextField changeSite;
    @FXML
    private Button shopChange;
    @FXML
    private Label applyNotif;

    //Ajouter promo
    @FXML
    private TextField addPromoAmount;
    @FXML
    private ComboBox<?> productListAdd;
    @FXML
    private Button applyAdd;
    @FXML
    private Label addNotif;

    //Supprimer promo
    @FXML
    private ComboBox<?> productListSupp;
    @FXML
    private TextField suppPromoCurrentAmont;
    @FXML
    private Button applySupp;
    @FXML
    private Label suppNotif;

    //Modifier promo
    @FXML
    private TextField modifPromoAmount;
    @FXML
    private TextField modifPromoCurrentAmount;
    @FXML
    private ComboBox<?> productListModif;
    @FXML
    private Button applyModif;

    @FXML
    private Label modifNotif;

    @FXML
    public void initialize() {
        applyNotif.setText(null);
        addNotif.setText(null);
        modifNotif.setText(null);
        suppNotif.setText(null);
    }

    @FXML
    void addPromo(ActionEvent event) {

    }

    @FXML
    void applyChangements(ActionEvent event) throws IOException, ParseException, InterruptedException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src\\main\\resources\\data\\magasins_data.json"));
        JSONObject newData = (JSONObject) obj;
        if(checkEmpty()) {
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(applyNotif.textProperty(), "")));
            timeline.play();
            return;
        }
        if (!changeAdresse.getText().isEmpty()) {
            newData.put("adresse", changeAdresse.getText());
        }
        if (!changeNum.getText().isEmpty()) {
            newData.put("tel", changeNum.getText());
        }
        if (!changeSite.getText().isEmpty()) {
            newData.put("siteweb", changeSite.getText());
        }
        applyNotif.setText("Changements appliqués.");
        writeFile(newData);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(applyNotif.textProperty(), null)));
        timeline.play();
    }

    @FXML
    void modifyPromo(ActionEvent event) {

    }

    @FXML
    void suppPromo(ActionEvent event) {

    }

    public boolean checkEmpty() throws InterruptedException {
        if (changeNum.getText().isEmpty() && changeAdresse.getText().isEmpty() && changeSite.getText().isEmpty()) {
            applyNotif.setText("Aucun changement mentionné.");
            return true;
        }
        return false;
    }

    public void writeFile(JSONObject data) {
        try (FileWriter file = new FileWriter("src\\main\\resources\\data\\magasins_data.json")) {
            file.write(data.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
