/*
 *  Copyright (c) 2021. San K (sankdev0@gmail.com) as alias to A.K.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.sankdev;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// Table with the Text Fields to Enter New Items.
public class TableViewDemoOne extends Application {

  private TableView<Person> table = new TableView<Person>();
  private final ObservableList<Person> data =
      FXCollections.observableArrayList(
          new Person("Jacob", "Smith", "jacob.smith@example.com"),
          new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
          new Person("Ethan", "Williams", "ethan.williams@example.com"),
          new Person("Emma", "Jones", "emma.jones@example.com"),
          new Person("Michael", "Brown", "michael.brown@example.com"));
  final HBox hb = new HBox();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Scene scene = new Scene(new Group());
    stage.setTitle("Table View Sample");
    stage.setWidth(450);
    stage.setHeight(550);

    final Label label = new Label("Address Book");
    label.setFont(new Font("Arial", 20));

    table.setEditable(true);

    TableColumn firstNameCol = new TableColumn("First Name");
    firstNameCol.setMinWidth(100);
    firstNameCol.setCellValueFactory(
        new PropertyValueFactory<Person, String>("firstName"));

    TableColumn lastNameCol = new TableColumn("Last Name");
    lastNameCol.setMinWidth(100);
    lastNameCol.setCellValueFactory(
        new PropertyValueFactory<Person, String>("lastName"));

    TableColumn emailCol = new TableColumn("Email");
    emailCol.setMinWidth(200);
    emailCol.setCellValueFactory(
        new PropertyValueFactory<Person, String>("email"));

    table.setItems(data);
    table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

    final TextField addFirstName = new TextField();
    addFirstName.setPromptText("First Name");
    addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
    final TextField addLastName = new TextField();
    addLastName.setMaxWidth(lastNameCol.getPrefWidth());
    addLastName.setPromptText("Last Name");
    final TextField addEmail = new TextField();
    addEmail.setMaxWidth(emailCol.getPrefWidth());
    addEmail.setPromptText("Email");

    final Button addButton = new Button("Add");
    addButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        data.add(new Person(
            addFirstName.getText(),
            addLastName.getText(),
            addEmail.getText()));
        addFirstName.clear();
        addLastName.clear();
        addEmail.clear();
      }
    });

    hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
    hb.setSpacing(3);

    final VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table, hb);

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }

  // When you create a table in a JavaFX application, it is a best practice to implement a class
  // that defines the data model and provides methods and fields to further work with the table.
  // Example 12-3 creates the Person class to define data in an address book.
  public static class Person {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;

    private Person(String fName, String lName, String email) {
      this.firstName = new SimpleStringProperty(fName);
      this.lastName = new SimpleStringProperty(lName);
      this.email = new SimpleStringProperty(email);
    }

    public String getFirstName() {
      return firstName.get();
    }

    public void setFirstName(String fName) {
      firstName.set(fName);
    }

    public String getLastName() {
      return lastName.get();
    }

    public void setLastName(String fName) {
      lastName.set(fName);
    }

    public String getEmail() {
      return email.get();
    }

    public void setEmail(String fName) {
      email.set(fName);
    }
  }
}
