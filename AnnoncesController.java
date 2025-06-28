/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nsholebenjamin
 */
public class AnnoncesController implements Initializable {
    @FXML
    private TextArea Description;

    @FXML
    private Button publier;

    @FXML
    private TextField titre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void Publier(ActionEvent event) {
   String description = Description.getText();
        if (description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre Description");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        String Titre = titre.getText();
        if (Titre.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre titre");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }
}
