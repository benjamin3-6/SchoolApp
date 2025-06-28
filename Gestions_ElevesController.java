/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Eleves;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nsholebenjamin
 */
public class Gestions_ElevesController implements Initializable {

 
    @FXML
    private Button Button;

    @FXML
    private TextField adresseEleve;

    @FXML
    private TextField classeEleve;

    @FXML
    private TextField dateNaissance;

    @FXML
    private TextField nomEleve;

    @FXML
    private TextField nomParent;

    @FXML
    private TextField prenomEleve;

    @FXML
    private TextField sexe;

    @FXML
    private TextField telephoneParent;
@FXML
private TextField idEleve;

 
    @FXML
    private TextField telephoneEleve;
        @FXML
    private Button Button2;

    @FXML
    private Button Button3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    void Valider(ActionEvent event) {
        

     System.out.println("Début de l'enregistrement...");

    String NomEleve = nomEleve.getText();
        if (NomEleve.isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs nom vide");
            alert.setContentText("Veuillez entrer votre nom complet");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
       
        String AdresseEleve = adresseEleve.getText();
        
        if (AdresseEleve.isEmpty()) {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Champs adresse  vide");
          alert.setContentText("Veuillez remplir ce champ");
          alert.setHeaderText(null);
          alert.showAndWait();
          return;
        }

         System.out.println("Date brute tapée : '" + dateNaissance.getText() + "'");
        
        String DateNaissance = dateNaissance.getText();
        
        if (DateNaissance == null || DateNaissance.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Date de naissance vide");
            alert.setContentText("Veuillez entrer la date au format AAAA-MM-JJ (ex : 2005-09-14)");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
       
     try {
    LocalDate localDate = LocalDate.parse(DateNaissance);
    Date dob = Date.valueOf(localDate);
} catch (Exception e) {
    afficherAlert("Format de date invalide. Utilisez YYYY-MM-DD.", Alert.AlertType.ERROR);
    return;
}

        String TelephoneEleve = telephoneEleve.getText();
        
        if (TelephoneEleve.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs vide");
            alert.setContentText("Veuillez remplir ce champ");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
           
    
        String PrenomEleve = prenomEleve.getText();
       
        if (PrenomEleve.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs vide");
            alert.setContentText("Veuillez remplir ce champ");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
       
        String ClasseEleve = classeEleve.getText();        
        if (ClasseEleve.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs vide");
            alert.setContentText("Veuillez remplir ce champ");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        
        String TelephoneParent = telephoneParent.getText();
       
        if (TelephoneParent.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs contact  vide");
            alert.setContentText("Veuillez remplir ce champ");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

       
        String Sexe = sexe.getText();
        
        if (Sexe.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs genre vide");
            alert.setContentText("Veuillez remplir ce champ");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        
   
        String NomParent = nomParent.getText();
       
        if (NomParent.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs tuteur  vide");
            alert.setContentText("Veuillez remplir ce champ");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

       
 Eleves eleves = new Eleves(NomEleve,AdresseEleve,ClasseEleve,Sexe,TelephoneParent,PrenomEleve,NomParent,DateNaissance,TelephoneEleve);
   
        boolean insertion = eleves.insertion();
         idEleve.setText(String.valueOf(eleves.getIdELeve()));
        System.out.println("📌 Résultat insertion : " + insertion);

        if (insertion) {
            afficherAlert("Enregistrement réussi avec succès", Alert.AlertType.INFORMATION);
        } else {
            afficherAlert("Échec de l'enregistrement", Alert.AlertType.ERROR);
        }
    }

    private void afficherAlert(String message) {
        afficherAlert(message, Alert.AlertType.WARNING);
    }

    private void afficherAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Notification");
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    @FXML
    void Modifier(ActionEvent event) {

    // Validation similaire à Valider()
    String Nom = nomEleve.getText();
    String Adresse = adresseEleve.getText();
    String Classe = classeEleve.getText();
    String Sexe = sexe.getText();
    String TelParent = telephoneParent.getText();
    String Prenom = prenomEleve.getText();
    String NomTuteur = nomParent.getText();
    String DateNaiss = dateNaissance.getText();
    String TelEleve = telephoneEleve.getText();

    if (Nom.isEmpty() || Adresse.isEmpty() || Classe.isEmpty() || Sexe.isEmpty()
            || TelParent.isEmpty() || Prenom.isEmpty() || NomTuteur.isEmpty()
            || DateNaiss.isEmpty() || TelEleve.isEmpty()) {
        afficherAlert("Tous les champs doivent être remplis pour modifier un élève.", Alert.AlertType.WARNING);
        return;
    }

    try {
        LocalDate ld = LocalDate.parse(DateNaiss);
        Date dob = Date.valueOf(ld);
        
int id = Integer.parseInt(idEleve.getText());
Eleves eleve = new Eleves(Nom, Adresse, Classe, Sexe, TelParent, Prenom, NomTuteur, DateNaiss, TelEleve);
eleve.setIdELeve(id); 
boolean modifie = eleve.modifier();

        if (modifie) {
            afficherAlert("Élève modifié avec succès", Alert.AlertType.INFORMATION);
        } else {
            afficherAlert("Échec de la modification", Alert.AlertType.ERROR);
        }

    } catch (Exception e) {
        afficherAlert("Date invalide. Format attendu : YYYY-MM-DD", Alert.AlertType.ERROR);
    }

    // Nettoyage
    nomEleve.clear(); adresseEleve.clear(); classeEleve.clear(); sexe.clear();
    telephoneParent.clear(); prenomEleve.clear(); nomParent.clear();
    dateNaissance.clear(); telephoneEleve.clear();
}

    

    @FXML
    void Supprimer(ActionEvent event) {

    String nom = nomEleve.getText();

    if (nom.isEmpty()) {
        afficherAlert("Veuillez saisir le nom de l'élève à supprimer.", Alert.AlertType.WARNING);
        return;
    }

    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
    confirmation.setTitle("Confirmation de suppression");
    confirmation.setHeaderText(null);
    confirmation.setContentText("Voulez-vous vraiment supprimer cet élève ?");
    confirmation.showAndWait();

    if (confirmation.getResult().getText().equals("OK")) {
      int id = Integer.parseInt(idEleve.getText());
Eleves eleve = new Eleves();
eleve.setIdELeve(id);
boolean supprime = eleve.supprimer();


        if (supprime) {
            afficherAlert("Élève supprimé avec succès", Alert.AlertType.INFORMATION);
        } else {
            afficherAlert("Échec de la suppression", Alert.AlertType.ERROR);
        }

        // Effacer les champs
        nomEleve.clear(); adresseEleve.clear(); classeEleve.clear(); sexe.clear();
        telephoneParent.clear(); prenomEleve.clear(); nomParent.clear();
        dateNaissance.clear(); telephoneEleve.clear();
    }
    
}

    }

  



