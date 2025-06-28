/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BENJAMIN NSHOLE
 */
public class Database {
 private static Connection connection;
// creation d'une methode pour recuperer la connection de la base de donnée
public static Connection getConnection(){
    if (connection!=null){
        return connection;
        //si non donIIner nous l'acces à la base de donnée 
   } else{
      try{
          String connectionString ="jdbc:mysql://127.0.0.1/school";
      
      Class.forName("com.mysql.jdbc.Driver");
      
      connection=DriverManager.getConnection(connectionString,"root","");
      
      System.out.println("connection reussie");
      return connection;
          
      }catch(Exception ex){
          ex.printStackTrace();
          return null;
      }
    }}}


