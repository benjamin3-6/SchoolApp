/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author BENJAMIN NSHOLE
 */
public class LoginController implements Initializable {
    

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;
    @FXML
    private void handleButtonAction(ActionEvent event) {
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
   
    @FXML
    void Valider(ActionEvent event) {

//Recuperation des informations saisies par l'utilisateur
try{
String Nomutilisateur=Username.getText();
    String Passeword=Password.getText();
    
    //Verification du rôle utilisateur
    String role=getRoleFromDatabase(Nomutilisateur,Passeword);
    
    if(role!=null){
        System.out.println("URL de chargement");
        URL url=LoginController.class.getClass().getResource("/Views/FenêtrePrincipale.fxml");
        FXMLLoader loader=new FXMLLoader(url);
            
        AnchorPane pane=loader.load();
        Scene scene=new Scene(pane);
        
        
       FenêtrePrincipaleController controller=loader.getController();
           if(controller == null){
               System.out.println("Pas moyen de récuperer la fenêtre");
               return;
           }        
        Stage stage=new Stage();
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
        Stage currentStage=(Stage)Username.getScene().getWindow();
        currentStage.close();
    
       
    }else{
       Alert alert=new Alert(Alert.AlertType.WARNING);
       alert.setTitle("Nom d'utilisateur ou Mot de pase incorrect");
       alert.setContentText("Veuillez entrer les bonnes données");
       alert.setHeaderText(null);
       alert.showAndWait();
       return;
    }
}catch(Exception e ){
    
    }
    
}
    


    private String getRoleFromDatabase(String Nomutilisateur, String Passeword) {
        String role=null;
        try{
            Connection connection=Database.getConnection();
           if(connection == null){
               System.out.println("Erreur: connexion à la bd");
               return null;
           }
            String sql="Select role From utilisateurs Where nomutilisateur=? AND passeword=?";
         System.out.println("execution de la requête:" +sql);
         
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,Nomutilisateur);
            preparedStatement.setString(2, Passeword);
         
           ResultSet result=preparedStatement.executeQuery();
           if(result!= null && result.next()){
               role=result.getString("role");
               System.out.println("Rôle trouvé" + role);
          }else{
               System.out.println("Aucun résultat trouvé pour l'utlisateur.");
           }

}catch (Exception e)
{e.printStackTrace();}
return role;
    }
}


    

