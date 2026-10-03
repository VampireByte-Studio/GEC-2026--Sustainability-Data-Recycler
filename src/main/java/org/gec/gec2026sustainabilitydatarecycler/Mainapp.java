package org.gec.gec2026sustainabilitydatarecycler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mainapp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml")); // references the main fxml
        Parent root = loader.load();       // load once
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MainApp");
        stage.show();
    }

    public static void main(String[] args) {
        launch(); // launch when Mainapp.java is run to start program
    }
}