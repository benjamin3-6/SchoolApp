/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Matieres;
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
public class CoursController implements Initializable {

private Button Button;
    @FXML
    private Button Button3;
    @FXML
    private TextField Nommatiere;

    @FXML
    private TextField codeMatiere;

    @FXML
    private TextArea description;

    @FXML
    private TextField niveau;
    @FXML
    private Button Button2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       @FXML
    void Ajouter(ActionEvent event) {
  String Nom = Nommatiere.getText();
        if (Nom.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre nommatiere");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
         String code = codeMatiere.getText();
        if (code.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre code");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
         String Description = description.getText();
        if (Description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre description");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        } 
         String Niveau = niveau.getText();
        if (Niveau.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre niveau");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        } 
     
        Matieres matieres=new Matieres(Nom,code,Description,Niveau);
       boolean insertion = matieres.insertion();

        if (insertion) {
            afficherAlert("enregistré du cours  avec succés", Alert.AlertType.INFORMATION);

        } else {
            afficherAlert("echec de l'enregistrement du cours", Alert.AlertType.ERROR);
        }

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
    
    @FXML
    void Modifier(ActionEvent event) {
String Nom = Nommatiere.getText();
    String Code = codeMatiere.getText();
    String Description = description.getText();
    String Niveau = niveau.getText();

    if (Nom.isEmpty() || Code.isEmpty() || Description.isEmpty() || Niveau.isEmpty()) {
        afficherAlert("Tous les champs doivent être remplis pour modifier le cours", Alert.AlertType.WARNING);
        return;
    }

    // On suppose que le codeMatiere est unique
    Matieres matiere = new Matieres(Nom, Code, Description, Niveau);
    boolean modifie = matiere.Modifier(); // à implémenter dans la classe Matieres

    if (modifie) {
        afficherAlert("Cours modifié avec succès", Alert.AlertType.INFORMATION);
    } else {
        afficherAlert("Échec de la modification du cours", Alert.AlertType.ERROR);
    }

    Nommatiere.clear();
    codeMatiere.clear();
    description.clear();
    niveau.clear();
}
    
        @FXML
    void Supprimer(ActionEvent event) {

    String Code = codeMatiere.getText();

    if (Code.isEmpty()) {
        afficherAlert("Veuillez fournir le code du cours à supprimer", Alert.AlertType.WARNING);
        return;
    }

    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
    confirmation.setTitle("Confirmation");
    confirmation.setHeaderText(null);
    confirmation.setContentText("Voulez-vous vraiment supprimer ce cours ?");
    confirmation.showAndWait();

    if (confirmation.getResult().getText().equals("OK")) {
        Matieres matiere = new Matieres();
        matiere.setCodeMatiere(Code);
        boolean supprime = matiere.supprimer();

        if (supprime) {
            afficherAlert("Cours supprimé avec succès", Alert.AlertType.INFORMATION);
        } else {
            afficherAlert("Échec de la suppression", Alert.AlertType.ERROR);
        }

        // 🟢 C'est ici qu'on vide les champs après coup :
        Nommatiere.clear();
        codeMatiere.clear();
        description.clear();
        niveau.clear();
    }
}


    }
