/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Eleves;
import Model.Frais;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author nsholebenjamin
 */
public class FraisController implements Initializable {

   
    @FXML
    private Button Button;

    @FXML
    private TableColumn<Frais, String> Coleleve;

    @FXML
    private TableColumn<Frais, String> Colobservation;

    @FXML
    private TableColumn<Frais, Date> colDate;

    @FXML
    private TableColumn<Frais, String> colMode;

    @FXML
    private TableColumn<Frais, String> colMontant;

    @FXML
    private TableColumn<Frais, String> coltypeFrais;

    @FXML
    private ComboBox<Eleves> comboeleve;

    @FXML
    private DatePicker datePaiment;

    @FXML
    private TextField montant;
 
    @FXML
    private ComboBox<String> combomodePaiement;

    @FXML
    private TextField observations;

    @FXML
    private TableView<Frais> tablePaiements;
    @FXML
    private ComboBox<String> comboFrais;

    /**
     * Initializes the controller class.
     * @param url
    ActionEvent event) { * @param rb
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String>listtypeFrais=FXCollections.observableArrayList();
      
    listtypeFrais.add("Scolarité");
    listtypeFrais.add("Transport");
    listtypeFrais.add("cantine");
    comboFrais.setItems(listtypeFrais);

          ObservableList<String> listModes = FXCollections.observableArrayList("Espèces", "Mobile Money", "Virement");
        combomodePaiement.setItems(listModes);
    ObservableList<Eleves> listeleve = Eleves.recupererEleves();
    comboeleve.setItems(listeleve);

   
        coltypeFrais.setCellValueFactory(new PropertyValueFactory<>("typeFrais"));
        colMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
       colMode.setCellValueFactory(new PropertyValueFactory<>("modePaiement"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("datePaiement"));
     Colobservation.setCellValueFactory(new PropertyValueFactory<>("observations"));
        Coleleve.setCellValueFactory(new PropertyValueFactory<>("eleveNom")); 


afficherPaiements();
tablePaiements.refresh();

    }        



private void afficherPaiements() {
    List<Frais> paiements = Frais.recupererPaiements();
    tablePaiements.setItems(FXCollections.observableArrayList(paiements));
System.out.println("📋 Paiements récupérés : " + paiements.size());

}

      @FXML
    void Payer(ActionEvent event) {
String  Observations=observations.getText();
if (Observations.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre observation");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        } if (comboFrais.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("District vide");
            alert.setContentText("Veuillez selectionner votre typefrais");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
      
        String typefrais = comboFrais.getValue();
        
            String mode = combomodePaiement.getValue();
   if (combomodePaiement.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("District vide");
            alert.setContentText("Veuillez selectionner votre typefrais");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }


        String Textmontant = montant.getText();
        if (Textmontant.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre montant");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        float montants = Float.parseFloat(Textmontant);
        
         if (datePaiment.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Date naissance vide");
            alert.setContentText("Veuillez selectionner la date");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        LocalDate localDate = datePaiment.getValue();
        Date dob = Date.valueOf(localDate.toString());
        
Frais frais = new Frais(typefrais, montants, Observations, mode, dob);

   Eleves eleves = comboeleve.getValue();
if (eleves == null) {
    afficherAlert("Veuillez sélectionner un élève", Alert.AlertType.WARNING);
    return;
}



        frais.setEleves(eleves);

     boolean insertion=frais.insertion();
   if (insertion) {
            afficherAlert("enregistré du Frais avec succés", Alert.AlertType.INFORMATION);

        } else {
            afficherAlert("echec de l'enregistrement du Frais", Alert.AlertType.ERROR);
        }
 observations.setText("");
     datePaiment.setValue(null);
     montant.setText("");
     comboFrais.setValue(null);
     combomodePaiement.setValue(null);
     comboeleve.setValue(null);
    }

    private void afficherAlert(String message) {
        afficherAlert(message, Alert.AlertType.WARNING);
    }

    private void afficherAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
