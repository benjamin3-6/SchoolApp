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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

/**
 *
 * @author nsholebenjamin
 */
public class Devoirs {


    private int idDevoir;
    private String titreDevoir ;
    private String descrption;
    private Date datePublication;
    private Date dateLimite;
     private String statut;
                  
     Matieres matieres;

    public Devoirs(int idDevoir, String titreDevoir, String descrption, Date datePublication, Date dateLimite, String statut, Matieres matieres) {
        this.idDevoir = idDevoir;
        this.titreDevoir = titreDevoir;
        this.descrption = descrption;
        this.datePublication = datePublication;
        this.dateLimite = dateLimite;
        this.statut = statut;
        this.matieres = matieres;
    }

    public Devoirs(String titreDevoir, String descrption, Date datePublication, Date dateLimite, String statut) {
        this.titreDevoir = titreDevoir;
        this.descrption = descrption;
        this.datePublication = datePublication;
        this.dateLimite = dateLimite;
        this.statut = statut;
    }

    public Devoirs(String titreDevoir, String descrption, Date datePublication, Date dateLimite, String statut, Matieres matieres) {
        this.titreDevoir = titreDevoir;
        this.descrption = descrption;
        this.datePublication = datePublication;
        this.dateLimite = dateLimite;
        this.statut = statut;
        this.matieres = matieres;
    }

public Devoirs(String titreDevoir, String statut, String descrption, Date dateLimite, Matieres matieres) {
    this.titreDevoir = titreDevoir;
    this.descrption = descrption;
    this.datePublication = new Date(System.currentTimeMillis());
    this.dateLimite = dateLimite;
    this.statut = statut;
    this.matieres = matieres;
}

    public Devoirs() {
       
    }

    


    public int getIdDevoir() {
        return idDevoir;
    }

    public void setIdDevoir(int idDevoir) {
        this.idDevoir = idDevoir;
    }

    public String getTitreDevoir() {
        return titreDevoir;
    }

    public void setTitreDevoir(String titreDevoir) {
        this.titreDevoir = titreDevoir;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Matieres getMatieres() {
        return matieres;
    }

    public void setMatieres(Matieres matieres) {
        this.matieres = matieres;
    }

  public boolean insertion() {
    try {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO devoirs (titreDevoir, descrption, datePublication, dateLimite, statut, idMatiere) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, this.titreDevoir);
        preparedStatement.setString(2, this.descrption);
        preparedStatement.setDate(3, this.datePublication);
        preparedStatement.setDate(4, this.dateLimite);
        preparedStatement.setString(5, this.statut);

        if (matieres != null) {
            preparedStatement.setInt(6, matieres.getIdMatiere());
        } else {
            System.err.println("Erreur : matieres est null !");
            return false;
        }

        int nbreLigne = preparedStatement.executeUpdate();
        return nbreLigne > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
  }
      public static ObservableList<Matieres> recupererMatieress() {
        ObservableList<Matieres> listeMatieres = FXCollections.observableArrayList();

    try {
        Connection con = Database.getConnection();
        String sql = "SELECT idMatiere, nomMatiere FROM matieres";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

   System.out.println("Récupération matières...");
        while (rs.next()) {
            int id = rs.getInt("idMatiere");
            String nom = rs.getString("nomMatiere");
            System.out.println("→ " + id + " - " + nom);
            listeMatieres.add(new Matieres(id, nom));
        }
        System.out.println("Total récupéré : " + listeMatieres.size());

    } catch (Exception e) {
        e.printStackTrace();
        // Tu peux ajouter ici un logging plus formel si tu veux
    }

    return listeMatieres;
}

    public boolean modifier() {
   
    try {
        Connection connection = Database.getConnection();
        String sql = "UPDATE devoirs SET descrption = ?, dateLimite = ?, statut = ?, idMatiere = ? WHERE titreDevoir = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, this.descrption);
        stmt.setDate(2, this.dateLimite);
        stmt.setString(3, this.statut);
        stmt.setInt(4, this.matieres.getIdMatiere());
        stmt.setString(5, this.titreDevoir);

        int lignesAffectees = stmt.executeUpdate();
        return lignesAffectees > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
 
    

  public void setTitre(String titreDevoir) {
    this.titreDevoir = titreDevoir;
}


    public boolean supprimer() {

    try {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM devoirs WHERE titreDevoir = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, this.titreDevoir);

        int lignesSupprimees = stmt.executeUpdate();
        return lignesSupprimees > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    }
    

