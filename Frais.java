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
import javafx.scene.control.TextField;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author nsholebenjamin
 */
public class Frais {

    private  int idPaiement;
    private String typeFrais;
    private float montant;
    private String observations;
    private String modePaiement;
    private Date datePaiement;
            
           
         Eleves eleves;

    public Frais(int idPaiement, String typeFrais, float montant, String observations, String modePaiement, Date datePaiement, Eleves eleves) {
        this.idPaiement = idPaiement;
        this.typeFrais = typeFrais;
        this.montant = montant;
        this.observations = observations;
        this.modePaiement = modePaiement;
        this.datePaiement = datePaiement;
        this.eleves = eleves;
    }

    public Frais(String typeFrais, float montant, String observations, String modePaiement, Date datePaiement) {
        this.typeFrais = typeFrais;
        this.montant = montant;
        this.observations = observations;
        this.modePaiement = modePaiement;
        this.datePaiement = datePaiement;
    }

  
   
public String getEleveNom() {
    return (eleves != null) ? eleves.getNomEleve() + " " + eleves.getPrenomEleve() : "";
}

    

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public String getTypeFrais() {
        return typeFrais;
    }

    public void setTypeFrais(String typeFrais) {
        this.typeFrais = typeFrais;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Eleves getEleves() {
        return eleves;
    }

    public void setEleves(Eleves eleves) {
        this.eleves = eleves;
    }

    

         
    public static List<Frais> recupererEleves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Frais> recupererPaiements() {
  
    List<Frais> paiements = new ArrayList<>();
    try {
        Connection connection = Database.getConnection();
        String sql = "SELECT p.*, e.nomEleve, e.prenomEleve FROM paiements p INNER JOIN eleves e ON p.idEleve = e.idEleve";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String typeFrais = rs.getString("typeFrais");
            float montant = rs.getFloat("montant");
            String modePaiement = rs.getString("modePaiement");
            Date datePaiement = rs.getDate("datePaiement");
            String observations = rs.getString("observations");
            String nom = rs.getString("nomEleve");
String prenom = rs.getString("prenomEleve");
Eleves eleve = new Eleves(0, nom, prenom);

System.out.println("👉 Date : " + datePaiement);
System.out.println("👉 Observation : " + observations);

int id = rs.getInt("idPaiement");
Frais frais = new Frais(id, typeFrais, montant, observations, modePaiement, datePaiement, eleve);

frais.setEleves(eleve);
paiements.add(frais);
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return paiements;
}

    

   

    public boolean insertion() {
      try{
        Connection connection=Database.getConnection();
        
        String sql="insert into paiements(typeFrais,montant,modePaiement,datePaiement,observations, idEleve)"+"values(?,?,?,?,?,?)";
      
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        
        preparedStatement.setString(1, this.typeFrais);
        preparedStatement.setFloat(2, this.montant);
        preparedStatement.setString(3, this.modePaiement);
        preparedStatement.setDate(4, this.datePaiement);
        preparedStatement.setString(5, this.observations);
 if (this.eleves == null) {
    System.err.println("🚨 Élève non défini dans l’objet Frais !");
    return false;
}

        preparedStatement.setInt(6, this.eleves.getIdEleve());
System.out.println("🔎 typeFrais = " + this.typeFrais);
System.out.println("🔎 montant = " + this.montant);
System.out.println("🔎 modePaiement = " + this.modePaiement);
System.out.println("🔎 datePaiement = " + this.datePaiement);
System.out.println("🔎 observations = " + this.observations);
System.out.println("🔎 idEleve = " + (this.eleves != null ? this.eleves.getIdEleve() : "eleves est null"));

        int nbrLigne=preparedStatement.executeUpdate();
        return nbrLigne>0;
    }catch(Exception e){
       e.printStackTrace();
    }
      return false;
    }

    
}



    

