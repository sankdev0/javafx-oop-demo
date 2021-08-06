package com.sankdev;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

  private static ResourceBundle theGuiResourceBundle = ResourceBundle.getBundle(
      "com.sankdev.locale.GuiResourceBundle", Locale.getDefault());

  private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("primary"), 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"),
        theGuiResourceBundle);
    return fxmlLoader.load();
  }

  public static void main(String[] args) {
    launch();
  }

}