/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.collections.ObservableList;

/**
 *
 * @author nsholebenjamin
 */
public class Matieres {

    public static ObservableList<Matieres> recupererMatieres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int idMatiere;
    private String nomMatiere;
    private String codeMatiere;
    private String description;
    private String niveau;

    public Matieres(int idMatiere, String nomMatiere, String codeMatiere, String description, String niveau) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.codeMatiere = codeMatiere;
        this.description = description;
        this.niveau = niveau;
    }

    public Matieres(String nomMatiere, String codeMatiere, String description, String niveau) {
        this.nomMatiere = nomMatiere;
        this.codeMatiere = codeMatiere;
        this.description = description;
        this.niveau = niveau;
    }
@Override
public String toString() {
    return this.nomMatiere; 
}

   public Matieres(int idMatiere, String nomMatiere) {
    this.idMatiere = idMatiere;
    this.nomMatiere = nomMatiere;
}

    public Matieres() {

    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    public boolean insertion(){
    try{
    Connection connection=Database.getConnection();
    
    String sql="insert into matieres(nomMatiere,codeMatiere,description,niveau)"+"values(?,?,?,?)";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1, this.nomMatiere);
    preparedStatement.setString(2, this.codeMatiere);
    preparedStatement.setString(3, this.description);
       preparedStatement.setString(4, this.niveau);
       
       int nbrLigne=preparedStatement.executeUpdate();
       return nbrLigne>0;
    }catch(Exception e){
    e.printStackTrace();
    }
    return false;
    }

    int getIMatiere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    



    public boolean Modifier() {
try {
        Connection connection = Database.getConnection();
        String sql = "UPDATE matieres SET nomMatiere = ?, description = ?, niveau = ? WHERE codeMatiere = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, this.nomMatiere);
        stmt.setString(2, this.description);
        stmt.setString(3, this.niveau);
        stmt.setString(4, this.codeMatiere);

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
        String sql = "DELETE FROM matieres WHERE codeMatiere = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, this.codeMatiere);

        int lignesSupprimees = stmt.executeUpdate();
        return lignesSupprimees > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
  
    }



