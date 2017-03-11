package fr.polytech.ihm.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Jérémy LARA
 * @version 1.0
 *          Represents the main application controller class. It allows to binds
 *          specifics actions to specifics keys for example.
 */
public class CommonController {

    private Stage primaryStage;
    private Map<KeyCode, Consumer<Void>> mapKeyToActions;

    public CommonController(Stage primaryStage, Scene currentScene) {
        this.primaryStage = primaryStage;
        mapKeyToActions = new HashMap<>();
        initializeKeyMap();
        currentScene.setOnKeyPressed(event -> checkKeyMap(event.getCode()));
    }

    public void initializeKeyMap() {
        mapKeyToActions.put(KeyCode.F1, (x) -> actionF1());
    }

    public void checkKeyMap(KeyCode keyCode) {
        if (mapKeyToActions.containsKey(keyCode)) {
            mapKeyToActions.get(keyCode).accept(null);
        }
    }

    private void actionF1() {
        primaryStage.setFullScreen(true);
    }

}
