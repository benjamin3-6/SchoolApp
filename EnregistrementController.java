/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Eleves;
import Model.Inscriptions;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
public class EnregistrementController implements Initializable {

    @FXML
    private TextField Avenue;

    @FXML
    private ComboBox<String> ComboGenre;

    @FXML
    private TextField Commune;

    @FXML
    private DatePicker Datenaissance;

    @FXML
    private TextField District;

    @FXML
    private TextField Email;

    @FXML
    private TextField Langues;

    @FXML
    private TextField Lien;

    @FXML
    private TextField LieuNaissance;

    @FXML
    private TextField Nationalite;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Nommere;

    @FXML
    private TextField Nompere;

    @FXML
    private TextField Nomtutuer;

    @FXML
    private TextField Numerecole;

    @FXML
    private TextField Numero;

    @FXML
    private TextField Postnom;

    @FXML
    private TextField Postnsolli;

    @FXML
    private TextField Prenom;

    @FXML
    private TextField Prenomsollici;

    @FXML
    private TextField Promotion;

    @FXML
    private TextField Quartier;

    @FXML
    private TextField Religion;

    @FXML
    private TextField Sollicitant;

    @FXML
    private TextField Telemere;

    @FXML
    private TextField Telepere;

    @FXML
    private TextField Telephone;

    @FXML
    private TextField Territoire;

    @FXML
    private TextField Transport;

    @FXML
    private TextField classe;

    @FXML
    private TextField contact;

    @FXML
    private TextField secteur;
        @FXML
    private ComboBox<Eleves> comboeleve;

    


    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<String> listGenre=FXCollections.observableArrayList();
      listGenre.add("M");
      listGenre.add("F");
      ComboGenre.setItems(listGenre);
   
  ObservableList<Eleves> listEleves = Eleves.recupererEleves();
if (listEleves == null || listEleves.isEmpty()) {
    System.err.println("🚨 Aucun élève récupéré depuis la base !");
} else {
    System.out.println("✅ Élèves chargés : " + listEleves.size());
    comboeleve.setItems(listEleves);
}
  
    }    
     
 
    @FXML
    void Valider(ActionEvent event) {
System.out.println("✅ Le bouton Valider a été cliqué");

String avenue=Avenue.getText();
if(avenue.isEmpty()){
    Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs avenue vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
    alert.showAndWait();
    return;
}
        if (ComboGenre.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("champs vide");
            alert.setContentText("Veuillez selectionner votre portefeuille");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        String Genre = ComboGenre.getValue();

String commune=Commune.getText();
if(commune.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs  vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}

        String district=District.getText();
       if(district.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
       String email=Email.getText();
           if(email.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
              String langues=Langues.getText();
           if(langues.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
              String lien=Lien.getText();
           if(lien.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
              String lieuNaissance=LieuNaissance.getText();
           if(lieuNaissance.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;


           }
              String nationalite=Nationalite.getText();
           if(nationalite.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
       String nom=Nom.getText();
           if(nom.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}       
              String nommere=Nommere.getText();
           if(nommere.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
              String nompere=Nompere.getText();
           if(nompere.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
              String nomtutuer=Nomtutuer.getText();
           if(nomtutuer.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
              String numerecole=Numerecole.getText();
           if(numerecole.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
                       String numero=Numero.getText();
           if(numero.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
                       String postnom=Postnom.getText();
           if(postnom.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
                       String postnomsolli=Postnsolli.getText();
           if(postnomsolli.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

}
                   String prenom=Prenom.getText();
           if(prenom.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                          String prenomsollici=Prenomsollici.getText();
           if(prenomsollici.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;
           }
                     String promotion=Promotion.getText();
           if(promotion.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                            String quartier=Quartier.getText();
           if(quartier.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                            String religion=Religion.getText();
           if(religion.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                            String sollicitant=Sollicitant.getText();
           if(sollicitant.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                              String telemere=Telemere.getText();
           if(telemere.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                                   String telepere=Telepere.getText();
           if(telepere.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                                   String territoire=Territoire.getText();
           if(territoire.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                                   String transport=Transport.getText();
           if(transport.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
           
                   if (comboeleve.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("District vide");
            alert.setContentText("Veuillez selectionner votre client");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
  

             Eleves idEleve=comboeleve.getValue();

                                   String clase=classe.getText();
           if(clase.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                                   String contant=contact.getText();
           if(contant.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;

           }
                                       String Secteur=secteur.getText();
           if(Secteur.isEmpty()){
     Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("champs vide");
    alert.setContentText("Veuillez remplir ce champs");
    alert.setHeaderText(null);
   alert.showAndWait();
    return;
           }


        if (Datenaissance.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Date naissance vide");
            alert.setContentText("Veuillez selectionner la date");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        LocalDate localDate = Datenaissance.getValue();
        Date dob = Date.valueOf(localDate.toString());

        
Eleves elevesSelectionne = comboeleve.getSelectionModel().getSelectedItem();
if (elevesSelectionne == null) {
    System.err.println("🚨 Aucun élève sélectionné !");
    afficherAlert("Veuillez sélectionner un élève avant l'ajout", Alert.AlertType.WARNING);
    return;
}
Inscriptions inscriptions = new Inscriptions();

inscriptions.setNom(nom);
inscriptions.setPostnom(postnom);
inscriptions.setPrenom(prenom);
inscriptions.setGenre(Genre);
inscriptions.setDateNaissance(dob);
inscriptions.setNationalite(nationalite);
inscriptions.setLieuNaissance(lieuNaissance);
inscriptions.setQuartier(quartier);
inscriptions.setCommune(commune);
inscriptions.setDistrict(district);
inscriptions.setTerritoire(territoire);
inscriptions.setAvenue(avenue);
inscriptions.setSecteur(Secteur);
inscriptions.setLangues(langues);
inscriptions.setReligion(religion);
inscriptions.setNomPere(nompere);
inscriptions.setTelPere(telepere);
inscriptions.setNomMere(nommere);
inscriptions.setTelMere(telemere);
inscriptions.setNomTuteur(nomtutuer);
inscriptions.setContactTuteur(contant);
inscriptions.setEmail(email);
inscriptions.setTelephone(numero);
inscriptions.setNumEcole(numerecole);
inscriptions.setPromotion(promotion);
inscriptions.setClasse(clase);
inscriptions.setSection(""); 
inscriptions.setModePaiement("");
inscriptions.setFraisInscription(0); 
inscriptions.setTransport(transport);
inscriptions.setObservations("");
inscriptions.setDateInscription(Date.valueOf(LocalDate.now()));
inscriptions.setEleves(elevesSelectionne);
boolean succes = inscriptions.insertion();

if (succes) {
    afficherAlert("✅ L'inscription a bien été enregistrée", Alert.AlertType.INFORMATION);
} else {
    afficherAlert("❌ Échec de l'enregistrement", Alert.AlertType.ERROR);
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

    Eleves eleveSelectionne = comboeleve.getSelectionModel().getSelectedItem();
    if (eleveSelectionne == null) {
        afficherAlert("Veuillez sélectionner un élève.", Alert.AlertType.WARNING);
        return;
    }

    int idInscription = Inscriptions.recupererIdParEleve(eleveSelectionne.getIdELeve());
System.out.println("🔎 ID inscription récupéré = " + idInscription);

if (idInscription == -1) {
    afficherAlert("Aucune inscription trouvée pour cet élève.", Alert.AlertType.WARNING);
    return;
}


    Inscriptions inscription = new Inscriptions();
    inscription.setIdInscription(idInscription);

    inscription.setNom(Nom.getText());
    inscription.setPostnom(Postnom.getText());
    inscription.setPrenom(Prenom.getText());
    inscription.setGenre(ComboGenre.getValue());
    inscription.setDateNaissance(java.sql.Date.valueOf(Datenaissance.getValue()));
    inscription.setNationalite(Nationalite.getText());
    inscription.setLieuNaissance(LieuNaissance.getText());
    inscription.setQuartier(Quartier.getText());
    inscription.setCommune(Commune.getText());
    inscription.setDistrict(District.getText());
    inscription.setTerritoire(Territoire.getText());
    inscription.setAvenue(Avenue.getText());
    inscription.setSecteur(secteur.getText());
    inscription.setLangues(Langues.getText());
    inscription.setReligion(Religion.getText());
    inscription.setNomPere(Nompere.getText());
    inscription.setTelPere(Telepere.getText());
    inscription.setNomMere(Nommere.getText());
    inscription.setTelMere(Telemere.getText());
    inscription.setNomTuteur(Nomtutuer.getText());
    inscription.setContactTuteur(contact.getText());
    inscription.setEmail(Email.getText());
    inscription.setTelephone(Numero.getText());
    inscription.setNumEcole(Numerecole.getText());
    inscription.setPromotion(Promotion.getText());
    inscription.setClasse(classe.getText());
    inscription.setSection("");
    inscription.setModePaiement("");
    inscription.setFraisInscription(0);
    inscription.setTransport(Transport.getText());
    inscription.setObservations("");
    inscription.setDateInscription(java.sql.Date.valueOf(LocalDate.now()));
    inscription.setEleves(eleveSelectionne);

    boolean modifie = inscription.modifier();
    if (modifie) {
        afficherAlert("✅ Inscription modifiée avec succès", Alert.AlertType.INFORMATION);
    } else {
        afficherAlert("❌ Échec de la modification", Alert.AlertType.ERROR);
    }
}

  

    @FXML
    void Supprimer(ActionEvent event) {

    Eleves eleveSelectionne = comboeleve.getSelectionModel().getSelectedItem();
    if (eleveSelectionne == null) {
        afficherAlert("Veuillez sélectionner un élève.", Alert.AlertType.WARNING);
        return;
    }

    int idInscription = Inscriptions.recupererIdParEleve(eleveSelectionne.getIdELeve());
  System.out.println("🗑️ Tentative suppression ID = " + idInscription);

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    confirm.setTitle("Confirmation");
    confirm.setHeaderText(null);
    confirm.setContentText("Supprimer définitivement cette inscription ?");
    confirm.showAndWait();

    if (confirm.getResult().getText().equals("OK")) {
        Inscriptions inscription = new Inscriptions();
        inscription.setIdInscription(idInscription);
        boolean supprime = inscription.supprimer();

        if (supprime) {
            afficherAlert("✅ Inscription supprimée", Alert.AlertType.INFORMATION);
        } else {
            afficherAlert("❌ Échec de la suppression", Alert.AlertType.ERROR);
        }
    }
}

    }
