package org.afpa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.afpa.model.Client;

import java.net.URL;
import java.util.ResourceBundle;

public class TableviewController {
    public TableView<Client> tableClient;
    public TableColumn<Client, String> nomCol;
    public TableColumn<Client, String> prenomCol;
    public TextField nomfield;
    public TextField prenomField;
    public TextField villeField;
    public Button btnAjouter;
    public Button btnSupp;

    ObservableList<Client> model = FXCollections.observableArrayList();


    public void addClient(ActionEvent actionEvent) {
        Client cli = new Client(nomfield.getText(),prenomField.getText(),villeField.getText());
        model.add(cli);
    }

    @FXML
    public void initialize() {
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        tableClient.setItems(model);
    }

    public void remClient(ActionEvent actionEvent) {
        model.remove(tableClient.getSelectionModel().getSelectedItem());
    }

    public void getDetails(MouseEvent mouseEvent) {
        Client cli = tableClient.getSelectionModel().getSelectedItem();
        prenomField.setText(cli.getPrenom());
        nomfield.setText(cli.getNom());
        villeField.setText(cli.getVille());
    }
}
