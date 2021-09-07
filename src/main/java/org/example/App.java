package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.view.Calculatrice;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Calculatrice calculatrice = new Calculatrice();
        stage.setScene(new Scene(calculatrice.getRoot()));
        stage.show();
    }
}
