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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BENJAMIN NSHOLE
 */
public class FenêtrePrincipaleController implements Initializable {


    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;
    private String setuserRole;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
     
    }    
//Methode qui aide à recupérer le rôle d'utilisateur
    
    public void setUserRole(String role) {
    this.setuserRole = role;
    adjustButtonsForRole(role); // Ajoute le paramètre ici
   

}

      //Pour rendre les boutons visibles

  public void adjustButtonsForRole(String userRole) {

         if("Admin".equals(userRole)){
         Button1.setVisible(true);
         Button2.setVisible(true);
         Button3.setVisible(true);
         Button4.setVisible(true);
         Button5.setVisible(true);
         Button6.setVisible(true);
        }else if("Enseignant".equals(userRole)){
             Button1.setVisible(false);
              Button2.setVisible(false); 
              Button3.setVisible(false);
               Button4.setVisible(false);
                Button5.setVisible(false);
                 Button6.setVisible(false);
         }
         if("Caissier".equals(userRole)){
             Button1.setVisible(true);
             Button2.setVisible(true);
             Button3.setVisible(true);
              Button4.setVisible(false);
               Button5.setVisible(true);
                Button6.setVisible(false);
             
         }else if("Eleve".equals(userRole)){
             Button1.setVisible(true);
              Button2.setVisible(false);
               Button3.setVisible(false);
                Button4.setVisible(false);
                 Button5.setVisible(true);
                  Button6.setVisible(false);
             
         }
    }
   

   
   @FXML
    void Eleves(ActionEvent event) {

    

try{
     URL url=FenêtrePrincipaleController.class.getClass().getResource("/Views/Eleves.fxml");
     
        FXMLLoader loader=new FXMLLoader(url);
        
        AnchorPane pane=loader.load();
        
        Scene scene=new Scene(pane);
        
        Stage stage=new Stage();
        
        stage.setMaximized(false);
        
        stage.setScene(scene);
        
        stage.show();
        
    }catch(Exception e){
        
        System.err.println("Erreur lors du chargement de la vue : " + e.getMessage());

       
    }
    }
    
    
  
        @FXML
    void Administration(ActionEvent event) {
try{
     
    URL url=FenêtrePrincipaleController.class.getClass().getResource("/Views/Administration.fxml");
    
    FXMLLoader loader=new FXMLLoader(url);
    
    AnchorPane pane=loader.load();
    
    Scene scene=new Scene(pane);
    
    Stage stage=new Stage();
    
    stage.setMaximized(false);
    
    stage.setScene(scene);
    
    stage.show();
    
    
}catch(Exception e){
 
    System.err.println("Erreur lors du chargement de la vue : " + e.getMessage());
}

    }
   
    @FXML
    void Enregistrement(ActionEvent event) {

    
try{
    
    URL url=FenêtrePrincipaleController.class.getClass().getResource("/Views/Enregistrement.fxml");
    
    FXMLLoader loader=new FXMLLoader(url);
    
    AnchorPane pane=loader.load();
    
    Scene scene=new Scene(pane);
    
    Stage stage=new Stage();
    
    stage.setMaximized(false);
    
    stage.setScene(scene);
    
    stage.show();
    
    
    
}catch(Exception e){
   System.out.println("erreur du chargement de la page "+ e.getMessage());
}
    }
    
      @FXML
    void Parametres(ActionEvent event) {
try{
        URL url=FenêtrePrincipaleController.class.getClass().getResource("/Views/Parametres.fxml");
        
        FXMLLoader loader=new FXMLLoader(url);
        
        AnchorPane pane=loader.load();
              
        Scene scene=new Scene(pane);
        
        Stage stage=new Stage();
        
        stage.setMaximized(false);
        
        stage.setScene(scene);
        
        stage.show();
        
        
    }catch(Exception e){
    
     System.err.println("Erreur lors du chargement de la vue : " + e.getMessage());
    }
    
    }
    
     @FXML
    void Frais(ActionEvent event) {

        try{
        URL url=FenêtrePrincipaleController.class.getClass().getResource("/Views/Frais.fxml");
        
        FXMLLoader loader=new FXMLLoader(url);
        
        AnchorPane pane=loader.load();
        
        Scene scene=new Scene(pane);
        
        Stage stage=new Stage();
        
        stage.setMaximized(false);
        
        stage.setScene(scene);
        
        stage.show();
        
      
                
    }catch(Exception e){
       
 System.err.println("Erreur lors du chargement de la vue : " + e.getMessage());
    }
       
    }
    
    @FXML
    void Annonces(ActionEvent event) {
 try{
        URL url=FenêtrePrincipaleController.class.getClass().getResource("/Views/Annonces.fxml");
        
        FXMLLoader loader=new FXMLLoader(url);
        
        AnchorPane pane=loader.load();
        
        Scene scene=new Scene(pane);
        
        Stage stage=new Stage();
        
        stage.setMaximized(false);
        
        stage.setScene(scene);
        
        stage.show();
        
      
                
    }catch(Exception e){
       
    System.err.println("Erreur lors du chargement de la vue : " + e.getMessage());
    }
    }



    


    
    }
  
    

   

  
    
    

