/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Devoirs;
import Model.Matieres;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nsholebenjamin
 */
public class HomeworkController implements Initializable {
@FXML
    private Button Button;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private DatePicker Dateremise;

    @FXML
    private ComboBox<String> comboClasse;

    @FXML
    private ComboBox<Matieres> comboMatiere;

    @FXML
    private ComboBox<String> comboStatut;

    @FXML
    private TextField idDevoir;

    @FXML
    private TextField nomeleve;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Matieres>listMatiere=FXCollections.observableArrayList();
        comboMatiere.setItems(listMatiere);
        
        ObservableList<String> listeStatut = FXCollections.observableArrayList();
        listeStatut.add("En Cours");
        listeStatut.add("Terminé");
        listeStatut.add("Archivé");
        
       comboStatut.setItems(listeStatut);
        
        ObservableList<String> listeClasse = FXCollections.observableArrayList();
        listeClasse.add("1ère Primaire");
         listeClasse.add("2ème Primaire");
         listeClasse.add("3ème Primaire");
         listeClasse.add("4ème Primaire");
         listeClasse.add("5ème Primaire");
         listeClasse.add("6ème Primaire");
         listeClasse.add("1ère Secondaire");
         listeClasse.add("2ème Secondaire");
         listeClasse.add("3ème Secondaire");
         listeClasse.add("4ème Secondaire");
         listeClasse.add("4ème Secondaire");
         listeClasse.add("5ème Secondaire");
         listeClasse.add("6ème Secondaire");
       

        comboClasse.setItems(listeClasse);
        
         ObservableList<Matieres> listMatieres = Devoirs.recupererMatieress();
if (listMatieres == null || listMatieres.isEmpty()) {
    System.err.println("🚨 Aucune matière récupérée depuis la base !");
} else {
    System.out.println("✅ Matières chargées : " + listMatieres.size());
    comboMatiere.setItems(listMatieres);
}

    } 
    

    @FXML
    void Ajouter(ActionEvent event) {
     if (comboClasse.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("classe  vide");
            alert.setContentText("Veuillez selectionner votre classe");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        String classe = comboClasse.getValue();
if (comboStatut.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("statut vide");
            alert.setContentText("Veuillez selectionner votre statut");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        String statut = comboStatut.getValue();
    
   String titreDevoir = idDevoir.getText();
        if (titreDevoir.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votreidDevoir");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
         String description = nomeleve.getText();
        if (description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez saisir votre eleve");
            alert.setHeaderText(null);
            alert.showAndWait();
        }  
        if (Dateremise.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Date remise vide");
            alert.setContentText("Veuillez selectionner la date");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
       Date dateLimite = Date.valueOf(Dateremise.getValue());
    
  
       Matieres matiereSelectionnee = comboMatiere.getValue();
if (matiereSelectionnee == null) {
    afficherAlert("Veuillez sélectionner une matière.", Alert.AlertType.WARNING);
    return;
}

        
   

  Devoirs devoirs = new Devoirs(titreDevoir, statut, description, dateLimite, matiereSelectionnee);

   boolean insertion = devoirs.insertion();
        if (insertion) {
            afficherAlert("enregistré du du devoirs avec succés", Alert.AlertType.INFORMATION);

        } else {
            afficherAlert("echec de l'enregistrement du devoir", Alert.AlertType.ERROR);
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

    String id = idDevoir.getText();
    if (id.isEmpty()) {
        afficherAlert("Veuillez saisir l'ID du devoir à modifier", Alert.AlertType.WARNING);
        return;
    }

    String titre = idDevoir.getText();
    String description = nomeleve.getText();
    String statut = comboStatut.getValue();
    String classe = comboClasse.getValue();
    Date dateRemise = (Dateremise.getValue() != null) ? Date.valueOf(Dateremise.getValue()) : null;
    Matieres matiere = comboMatiere.getValue();

    if (titre.isEmpty() || description.isEmpty() || statut == null || classe == null || dateRemise == null || matiere == null) {
        afficherAlert("Tous les champs doivent être remplis pour modifier le devoir.", Alert.AlertType.WARNING);
        return;
    }

    Devoirs devoir = new Devoirs(titre, statut, description, dateRemise, matiere);
    boolean modifie = devoir.modifier();

    if (modifie) {
        afficherAlert("Devoir modifié avec succès", Alert.AlertType.INFORMATION);
    } else {
        afficherAlert("Échec de la modification du devoir", Alert.AlertType.ERROR);
    }

    idDevoir.clear();
    nomeleve.clear();
    comboClasse.setValue(null);
    comboMatiere.setValue(null);
    comboStatut.setValue(null);
    Dateremise.setValue(null);
}

    

    @FXML
    void Supprimer(ActionEvent event) {

    String id = idDevoir.getText();
    if (id.isEmpty()) {
        afficherAlert("Veuillez fournir l'identifiant du devoir à supprimer.", Alert.AlertType.WARNING);
        return;
    }

    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
    confirmation.setTitle("Confirmation");
    confirmation.setHeaderText(null);
    confirmation.setContentText("Voulez-vous vraiment supprimer ce devoir ?");
    confirmation.showAndWait();

    if (confirmation.getResult().getText().equals("OK")) {
        Devoirs devoir = new Devoirs();
        devoir.setTitre(id); 
        boolean supprime = devoir.supprimer();

        if (supprime) {
            afficherAlert("Devoir supprimé avec succès", Alert.AlertType.INFORMATION);
        } else {
            afficherAlert("Échec de la suppression du devoir", Alert.AlertType.ERROR);
        }

        idDevoir.clear();
        nomeleve.clear();
        comboClasse.setValue(null);
        comboMatiere.setValue(null);
        comboStatut.setValue(null);
        Dateremise.setValue(null);
    }
}

    }



