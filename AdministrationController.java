/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.io.IOException;
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
public class AdministrationController implements Initializable {

       @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

   


    private String userRole;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
         }
        public void setUserRole(String role){
            
       this.userRole=role;
       adjustButtonsForRole();
        
        }
        public  void adjustButtonsForRole(){
            if("Admin".equals(userRole)){
            Button1.setVisible(true);
            Button2.setVisible(true);
            Button3.setVisible(true);
      
          
            
            }
           
            }

    
@FXML
    void Comptes_Utilisateurs(ActionEvent event) {

  try{
        URL url=AdministrationController.class.getClass().getResource("/Views/Utlisateurs.fxml");
        
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
    void Gestions_ELeves(ActionEvent event) {

        try{
        
            URL url=AdministrationController.class.getClass().getResource("/Views/Gestions_Eleves.fxml");
            
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
    void Rapports(ActionEvent event) {
      try{
            
          URL url=AdministrationController.class.getClass().getResource("/Views/Rapports.fxml");
          
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
    }
    
            
        
              


  
        
    

