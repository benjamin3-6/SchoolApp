/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Eleves;
import Model.Utilisateurs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author nsholebenjamin
 */
public class UtlisateursController implements Initializable {
 

    @FXML
    private Button Button;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private TextField Nom;

     @FXML
    private TextField Role;

    @FXML
    private TextField password;
     @FXML
    private TableColumn< Utilisateurs, String> colNom;

    @FXML
    private TableColumn< Utilisateurs, String> colPasse;

    @FXML
    private TableColumn< Utilisateurs, String> colRole;
        @FXML
    private TableColumn<Utilisateurs,String> colEleve;

    @FXML
    private TableView< Utilisateurs> tableview;
    @FXML
    private ComboBox<Eleves> comboEleve;
        @FXML
    private TableColumn<Utilisateurs, String> colnum;
    private Object listUtilisateurs;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  ObservableList<Eleves> listEleves = Eleves.recupererEleves();
    comboEleve.setItems(listEleves);

    // Colonnes
    colNom.setCellValueFactory(new PropertyValueFactory<>("nomutilisateur"));
    colPasse.setCellValueFactory(new PropertyValueFactory<>("passeword"));
    colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    colnum.setCellValueFactory(new PropertyValueFactory<>("idUtilisateur"));

    colEleve.setCellValueFactory(cellData -> {
        Eleves eleve = cellData.getValue().getEleves();
        if (eleve != null) {
            return new SimpleStringProperty(eleve.getNomEleve() + " " + eleve.getPrenomEleve());
        }
        return new SimpleStringProperty("—");
    });

    // Charger les données
    tableview.setItems(Utilisateurs.recupererUtilisateurs());
}

       
    
   

   
       
       
 @FXML
    void Ajouter(ActionEvent event) {
        String nom=Nom.getText();
        if(nom.isEmpty()){
 Alert alert = new Alert(Alert.AlertType.WARNING);
 alert.setTitle ("champs vide");
 alert.setContentText("Veuillez saisir votre nomutilisateur");
 alert.setHeaderText(null);
 alert.showAndWait();
 return;
        }
         String Password=password.getText();
        if(Password.isEmpty()){
 Alert alert = new Alert(Alert.AlertType.WARNING);
 alert.setTitle ("champs vide");
 alert.setContentText("Veuillez saisir votre passeword");
 alert.setHeaderText(null);
 alert.showAndWait();
 return;
        }
         String role=Role.getText();
        if(role.isEmpty()){
 Alert alert = new Alert(Alert.AlertType.WARNING);
 alert.setTitle ("champs vide");
 alert.setContentText("Veuillez saisir votre role");
 alert.setHeaderText(null);
 alert.showAndWait();
 return;
        }
System.out.println("📌 Vérification des valeurs avant insertion : ");
System.out.println("NomUtilisateur : " + (Nom.getText() == null ? "NULL" : Nom.getText()));
System.out.println("Mot de passe : " + (password.getText() == null ? "NULL" : password.getText()));
System.out.println("Role : " + (Role.getText() == null ? "NULL" : Role.getText()));
System.out.println("Combo Eleve : " + (comboEleve == null ? "NULL" : comboEleve));

Eleves elevesSelectionne = comboEleve.getSelectionModel().getSelectedItem();
if (elevesSelectionne == null) {
    System.err.println("🚨 Aucun élève sélectionné !");
    afficherAlert("Veuillez sélectionner un élève avant l'ajout", Alert.AlertType.WARNING);
    return;
}

  
        
        Nom.setText("");
        password.setText("");
        Role.setText("");
        comboEleve.setValue(null);
Utilisateurs utilisateurs = new Utilisateurs(nom, Password, role, elevesSelectionne);


boolean insertion =utilisateurs.insertion();

if (insertion){
    afficherAlert("enregistré de l'utilisateur avec succé",Alert.AlertType.INFORMATION);
    
}else{
    afficherAlert("echec de l'enregistrement de l'utilisateur",Alert.AlertType.ERROR);
}
    
    
    } 
   private void afficherAlert(String message){
       afficherAlert(message, Alert.AlertType.WARNING);
   }
   private void afficherAlert(String message,Alert.AlertType type){
   Alert alert=new Alert (type);
   alert.setTitle ("Notification");
   alert.setHeaderText(null);
   alert.setContentText(message);
   alert.showAndWait();
   }
       
    @FXML
    void Modifier(ActionEvent event) {

    Utilisateurs utilisateurSelectionne = tableview.getSelectionModel().getSelectedItem();

    if (utilisateurSelectionne == null) {
        afficherAlert("Veuillez sélectionner un utilisateur à modifier.", Alert.AlertType.WARNING);
        return;
    }

    String nom = Nom.getText();
    String motDePasse = password.getText();
    String role = Role.getText();
    Eleves eleve = comboEleve.getSelectionModel().getSelectedItem();

    if (nom.isEmpty() || motDePasse.isEmpty() || role.isEmpty() || eleve == null) {
        afficherAlert("Tous les champs doivent être remplis pour modifier.", Alert.AlertType.WARNING);
        return;
    }

    utilisateurSelectionne.setNomutilisateur(nom);
    utilisateurSelectionne.setPasseword(motDePasse);
    utilisateurSelectionne.setRole(role);
    utilisateurSelectionne.setEleves(eleve);

    boolean modifie = utilisateurSelectionne.modifier();

    if (modifie) {
        afficherAlert("✅ Utilisateur modifié avec succès.", Alert.AlertType.INFORMATION);
        tableview.setItems(Utilisateurs.recupererUtilisateurs()); // Rafraîchir la table
    } else {
        afficherAlert("❌ Échec de la modification.", Alert.AlertType.ERROR);
    }
}

    

    @FXML
    void Supprimer(ActionEvent event) {

    Utilisateurs utilisateurSelectionne = tableview.getSelectionModel().getSelectedItem();

    if (utilisateurSelectionne == null) {
        afficherAlert("Veuillez sélectionner un utilisateur à supprimer.", Alert.AlertType.WARNING);
        return;
    }

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    confirm.setTitle("Confirmation de suppression");
    confirm.setHeaderText(null);
    confirm.setContentText("Supprimer cet utilisateur ?");
    confirm.showAndWait();

    if (confirm.getResult().getText().equals("OK")) {
        boolean supprime = utilisateurSelectionne.supprimer();

        if (supprime) {
            afficherAlert("✅ Utilisateur supprimé.", Alert.AlertType.INFORMATION);
            tableview.setItems(Utilisateurs.recupererUtilisateurs()); // Rafraîchir la table
        } else {
            afficherAlert("❌ Échec de la suppression.", Alert.AlertType.ERROR);
        }
    }
}

    }
    


    
    
    
