package me.manstein.moneyconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CurrencyConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/me/manstein/moneyconverter/moeda.png")));
        Parent root = FXMLLoader.load(getClass().getResource("CurrencyConverterUI.fxml"));
        primaryStage.setTitle("Conversor de Moedas");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
