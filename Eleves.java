/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
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
public class Eleves {

    public static Eleves getEleves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ObservableList<Eleves> recupererEleves() {
       try {
            ObservableList<Eleves> listEleves = FXCollections.observableArrayList();
            Connection connection = Database.getConnection();
            
            String sql = "SELECT idEleve, nomEleve, prenomEleve FROM eleves";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                int idEleve = resultSet.getInt("idEleve");
                String nomEleve = resultSet.getString("nomEleve");
                String prenomEleve = resultSet.getString("prenomEleve");

                listEleves.add(new Eleves(idEleve, nomEleve, prenomEleve));
            }
            
            return listEleves;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    
    }

  
     private int idELeve;
     private String nomEleve;
     private String prenomEleve;
     private Date dateNaissance;
     private String sexe;
     private String classeEleve;
     private String telephoneEleve;
     private String adresseELeve;
     private String nomParent;
     private String telephoneParent;

    public Eleves() {

    }
   public String toString() {
        return nomEleve + " " + prenomEleve;
    }
    public Eleves(int idELeve, String nomEleve, String prenomEleve, Date dateNaissance, String sexe, String classeEleve, String telephoneEleve, String adresseELeve, String nomParent, String telephoneParent) {
        this.idELeve = idELeve;
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.classeEleve = classeEleve;
        this.telephoneEleve = telephoneEleve;
        this.adresseELeve = adresseELeve;
        this.nomParent = nomParent;
        this.telephoneParent = telephoneParent;
    }

    public Eleves(String nomEleve, String prenomEleve, Date dateNaissance, String sexe, String classeEleve, String telephoneEleve, String adresseELeve, String nomParent, String telephoneParent) {
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.classeEleve = classeEleve;
        this.telephoneEleve = telephoneEleve;
        this.adresseELeve = adresseELeve;
        this.nomParent = nomParent;
        this.telephoneParent = telephoneParent;
    }
public Eleves(int idEleve, String nomEleve) {
    this.idELeve = idEleve;
    this.nomEleve = nomEleve;
}


    public Eleves(String NomEleve, String AdresseEleve, String ClasseEleve, String Sexe, String TelephoneParent, String PrenomEleve, String NomParent, String DateNaissance, String TelephoneEleve) {
     this.nomEleve = NomEleve;
    this.adresseELeve = AdresseEleve;
    this.classeEleve = ClasseEleve;
    this.sexe = Sexe;
    this.telephoneParent = TelephoneParent;
    this.prenomEleve = PrenomEleve;
    this.nomParent = NomParent;
  try {
    this.dateNaissance = Date.valueOf(DateNaissance);
    System.out.println("✅ Date validée : " + this.dateNaissance);
} catch (IllegalArgumentException e) {
    System.err.println("🚨 Format de date invalide : " + DateNaissance);
}

    
    this.telephoneEleve = TelephoneEleve;

    }

    Eleves(int idEleve, String nomEleve, String prenomEleve) {
        this.idELeve = idEleve;
    this.nomEleve = nomEleve;
    this.prenomEleve = prenomEleve;
    }

    public int getIdELeve() {
        return idELeve;
    }

    public void setIdELeve(int idELeve) {
        this.idELeve = idELeve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getClasseEleve() {
        return classeEleve;
    }

    public void setClasseEleve(String classeEleve) {
        this.classeEleve = classeEleve;
    }

    public String getTelephoneEleve() {
        return telephoneEleve;
    }

    public void setTelephoneEleve(String telephoneEleve) {
        this.telephoneEleve = telephoneEleve;
    }

    public String getAdresseELeve() {
        return adresseELeve;
    }

    public void setAdresseELeve(String adresseELeve) {
        this.adresseELeve = adresseELeve;
    }

    public String getNomParent() {
        return nomParent;
    }

    public void setNomParent(String nomParent) {
        this.nomParent = nomParent;
    }

    public String getTelephoneParent() {
        return telephoneParent;
    }

    public void setTelephoneParent(String telephoneParent) {
        this.telephoneParent = telephoneParent;
    }

public boolean insertion() {
    try {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO eleves(nomEleve, prenomEleve, dateNaissance, sexe, classeEleve, telephoneEleve, adresseELeve, nomParent, telephoneParent) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, this.nomEleve);
        stmt.setString(2, this.prenomEleve);
        stmt.setDate(3, this.dateNaissance);
        stmt.setString(4, this.sexe);
        stmt.setString(5, this.classeEleve);
        stmt.setString(6, this.telephoneEleve);
        stmt.setString(7, this.adresseELeve);
        stmt.setString(8, this.nomParent);
        stmt.setString(9, this.telephoneParent);

        int lignesInserees = stmt.executeUpdate();
        if (lignesInserees > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.idELeve = rs.getInt(1);
                System.out.println("🆔 ID généré : " + this.idELeve);
            }
            
            return true;
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

  public String getNom() {
    return this.nomEleve;
}

public int getIdEleves() {
    return this.idELeve;
}

    public int getIdEleve() {
    return this.idELeve;
}

    public boolean modifier() {
    try {
        Connection connection = Database.getConnection();
        String sql = "UPDATE eleves SET nomEleve = ?, prenomEleve = ?, dateNaissance = ?, sexe = ?, classeEleve = ?, telephoneEleve = ?, adresseELeve = ?, nomParent = ?, telephoneParent = ? WHERE idEleve = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, this.nomEleve);
        stmt.setString(2, this.prenomEleve);
        stmt.setDate(3, this.dateNaissance);
        stmt.setString(4, this.sexe);
        stmt.setString(5, this.classeEleve);
        stmt.setString(6, this.telephoneEleve);
        stmt.setString(7, this.adresseELeve);
        stmt.setString(8, this.nomParent);
        stmt.setString(9, this.telephoneParent);
        stmt.setInt(10, this.idELeve);
if (this.idELeve <= 0) {
    System.err.println("🚨 ID élève non défini pour l'opération.");
    return false;
}

        int lignesAffectees = stmt.executeUpdate();
        return lignesAffectees > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    

    public boolean supprimer() {
 
    try {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM eleves WHERE idEleve = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, this.idELeve);
if (this.idELeve <= 0) {
    System.err.println("🚨 ID élève non défini pour l'opération.");
    return false;
}

        int lignesSupprimees = stmt.executeUpdate();
        return lignesSupprimees > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    }

