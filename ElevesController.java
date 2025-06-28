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
 * @author nsholebenjamin
 */
public class ElevesController implements Initializable {

 

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;
   
    private String setuserRole;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
            
       
       
    }  
            // Methode qui aide à recuper le role d'utlisateur
    
    public  void setUSerRole(String role){
        
    this.setuserRole=role;
    adjustButtonsForRole();
}
    //pour rendre les bouttons visibles
    
    public void adjustButtonsForRole(Object userRole){
       
        if("eleve".equals(userRole)){
         
           Button2.setVisible(true);
           Button3.setVisible(true);
        
        }
        if("Admin".equals(userRole)){
        
            Button2.setVisible(true);
            Button3.setVisible(true);
        }else if("Enseignant".equals(userRole)){
          
            Button2.setVisible(true);
            Button3.setVisible(true);
        }
        
   
    }
 @FXML
    void Cours(ActionEvent event) {
try{
  URL url=ElevesController.class.getClass().getResource("/Views/Cours.fxml");
    
  FXMLLoader loader=new FXMLLoader(url);
  
  AnchorPane pane=loader.load();
  
  Scene scene=new Scene(pane);
  
  Stage stage=new Stage();
  
  stage.setMaximized(false);
  
  stage.setScene(scene);
  
  stage.show();
  
}catch(Exception e){
    
e.printStackTrace();

}
    }
    
        
     @FXML
    void Homework(ActionEvent event) {
    
try{
  URL url=ElevesController.class.getClass().getResource("/Views/Homework.fxml");
    
  FXMLLoader loader=new FXMLLoader(url);
  
  AnchorPane pane=loader.load();
  
  Scene scene=new Scene(pane);
  
  Stage stage=new Stage();
  
  stage.setMaximized(false);
  
  stage.setScene(scene);
  
  stage.show();
  
}catch(Exception e){
    
e.printStackTrace();

}
}

    private void adjustButtonsForRole() {
    }
    }
    
