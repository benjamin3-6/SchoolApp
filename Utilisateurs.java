/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nsholebenjamin
 */
public class Utilisateurs {

    private static int idEleve;

    
private int idUtilisateur;
private String 	nomutilisateur;
private String passeword;
 private String  role;
 
Eleves eleves;

    public Utilisateurs(int idUtilisateur, String nomutilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.nomutilisateur = nomutilisateur;
        this.passeword = passeword;
        this.role = role;
        this.eleves = eleves;
    }

    public Utilisateurs(String nomutilisateur, String passeword, String role) {
        this.nomutilisateur = nomutilisateur;
        this.passeword = passeword;
        this.role = role;
    }

    public Utilisateurs(String nomutilisateur, String passeword, String role, Eleves eleves) {
        this.nomutilisateur = nomutilisateur;
        this.passeword = passeword;
        this.role = role;
        this.eleves = eleves;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Eleves getEleves() {
        return eleves;
    }

    public void setEleves(Eleves eleves) {
        this.eleves = eleves;
    }

  public boolean insertion(){
     try { // recuperation de la connection à partir de la classe database
            Connection connection=Database.getConnection();
            //requête sql pour inserer dans la table maison
            String sql="INSERT INTO utilisateurs(nomutilisateur,passeword,role,idEleve) values (?,?,?,?)";
            //preparation de la requête sql
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            //remplissage des parametres avec les valeurs correspondantes
            preparedStatement.setString(1,this.	nomutilisateur);
            preparedStatement.setString(2,this.passeword);
            preparedStatement.setString(3,this.role);
            if (eleves == null) {
    System.err.println("🚨 Aucun élève sélectionné !");
    return false;
}

           preparedStatement.setInt(4, eleves.getIdEleves());
              int nbreLigne = preparedStatement.executeUpdate();
     return nbreLigne>0;
            
        } catch (SQLException e) {  
        }
return false;
        
        
    
  }
  
public static  ObservableList<Utilisateurs>recupererUtilisateur(){
   
         try { 
            ObservableList<Utilisateurs>listUtilisateurs=FXCollections.observableArrayList(); 
             Connection connection = Database.getConnection();
         String sql="Select idUtilisateur,nomutilisateur from utilisateurs";
         
         Statement statement=connection.createStatement();
         ResultSet resultSet=statement.executeQuery(sql);
         
         while(resultSet.next()){
             int idUtilisateur=resultSet.getInt("idUtilisateur");
             String nomutilisateur=resultSet.getString("nomutilisateur");
             
                      listUtilisateurs.add(new Utilisateurs(idUtilisateur, nomutilisateur));
               
         }
         return listUtilisateurs;
         
             
         } catch (SQLException e) {
             return null;
         }
     }
 
     public String toString(){
         return this.nomutilisateur;
     }
    public static ObservableList<Utilisateurs> recupererUtilisateurs() {
    try {
        ObservableList<Utilisateurs> listUtilisateurs = FXCollections.observableArrayList();
        Connection connection = Database.getConnection();

        String sql = "SELECT utilisateurs.idUtilisateur, utilisateurs.nomutilisateur, utilisateurs.passeword, utilisateurs.role, "
                   + "eleves.idEleve, eleves.nomEleve, eleves.prenomEleve "
                   + "FROM utilisateurs "
                   + "LEFT JOIN eleves ON utilisateurs.idEleve = eleves.idEleve";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int idUtilisateur = rs.getInt("idUtilisateur");
            String nomutilisateur = rs.getString("nomutilisateur");
            String passeword = rs.getString("passeword");
            String role = rs.getString("role");

            int idEleve = rs.getInt("idEleve");
            String nomEleve = rs.getString("nomEleve");
            String prenomEleve = rs.getString("prenomEleve");

            Eleves eleve = new Eleves(idEleve, nomEleve, prenomEleve);
            Utilisateurs utilisateur = new Utilisateurs(nomutilisateur, passeword, role, eleve);
            utilisateur.setIdUtilisateur(idUtilisateur);

            listUtilisateurs.add(utilisateur);
        }

        return listUtilisateurs;

    } catch (SQLException e) {
        e.printStackTrace();
        return FXCollections.observableArrayList();
    }
}

    public boolean modifier() {

    try {
        Connection connection = Database.getConnection();
        String sql = "UPDATE utilisateurs SET nomutilisateur = ?, passeword = ?, role = ?, idEleve = ? WHERE idUtilisateur = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, this.nomutilisateur);
        stmt.setString(2, this.passeword);
        stmt.setString(3, this.role);
        stmt.setInt(4, (eleves != null) ? eleves.getIdEleves() : 0);
        stmt.setInt(5, this.idUtilisateur);

        int lignesModifiees = stmt.executeUpdate();
        return lignesModifiees > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

    

    public boolean supprimer() {

    try {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM utilisateurs WHERE idUtilisateur = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, this.idUtilisateur);

        int lignesSupprimees = stmt.executeUpdate();
        return lignesSupprimees > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

    }
