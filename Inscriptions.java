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

/**
 *
 * @author nsholebenjamin
 */
public class Inscriptions {
   private int idInscription;
    private String nom;
    private String postnom;
    private String prenom;
    private String genre;
    private Date dateNaissance;
    private String nationalite;
    private String lieuNaissance;
    private String quartier;
    private String commune;
    private String district;
    private String territoire;
    private String avenue;
    private String secteur;
    private String langues;
    private String religion;
    private String nomPere;
    private String telPere;
    private String nomMere;
    private String telMere;
    private String nomTuteur;
    private String contactTuteur;
    private String email;
    private String telephone;
    private String numEcole;
    private String promotion;
    private String classe;
    private String section;
    private String modePaiement;
    private float fraisInscription;
    private String transport;
    private String observations;
    private Date dateInscription;
    
   Eleves eleves;  
    private int idEleve;
    private int idELeve;

    public Inscriptions(String nom, String postnom, String prenom, String genre, Date dateNaissance, String nationalite, String lieuNaissance, String quartier, String commune, String district, String territoire, String avenue, String secteur, String langues, String religion, String nomPere, String telPere, String nomMere, String telMere, String nomTuteur, String contactTuteur, String email, String telephone, String numEcole, String promotion, String classe, String section, String modePaiement, float fraisInscription, String transport, String observations, Date dateInscription, Eleves eleves) {
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.lieuNaissance = lieuNaissance;
        this.quartier = quartier;
        this.commune = commune;
        this.district = district;
        this.territoire = territoire;
        this.avenue = avenue;
        this.secteur = secteur;
        this.langues = langues;
        this.religion = religion;
        this.nomPere = nomPere;
        this.telPere = telPere;
        this.nomMere = nomMere;
        this.telMere = telMere;
        this.nomTuteur = nomTuteur;
        this.contactTuteur = contactTuteur;
        this.email = email;
        this.telephone = telephone;
        this.numEcole = numEcole;
        this.promotion = promotion;
        this.classe = classe;
        this.section = section;
        this.modePaiement = modePaiement;
        this.fraisInscription = fraisInscription;
        this.transport = transport;
        this.observations = observations;
        this.dateInscription = dateInscription;
        this.eleves = eleves;
    }

    public Inscriptions() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTerritoire() {
        return territoire;
    }

    public void setTerritoire(String territoire) {
        this.territoire = territoire;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getTelPere() {
        return telPere;
    }

    public void setTelPere(String telPere) {
        this.telPere = telPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getTelMere() {
        return telMere;
    }

    public void setTelMere(String telMere) {
        this.telMere = telMere;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public String getContactTuteur() {
        return contactTuteur;
    }

    public void setContactTuteur(String contactTuteur) {
        this.contactTuteur = contactTuteur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumEcole() {
        return numEcole;
    }

    public void setNumEcole(String numEcole) {
        this.numEcole = numEcole;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public float getFraisInscription() {
        return fraisInscription;
    }

    public void setFraisInscription(float fraisInscription) {
        this.fraisInscription = fraisInscription;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Eleves getEleves() {
        return eleves;
    }

    public void setEleves(Eleves eleves) {
        this.eleves = eleves;
    }

    
    
     public boolean insertion() {
        try {
            Connection connection = Database.getConnection();
            String sql = "INSERT INTO inscriptions (dateInscription, nom, postnom, prenom, genre, dateNaissance, nationalite, lieuNaissance, quartier, commune, district, territoire, avenue, secteur, langues, religion, nomPere, telPere, nomMere, telMere, nomTuteur, contactTuteur, email, telephone, numEcole, promotion, classe, section, modePaiement, fraisInscription, transport, observations, idEleve ) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, this.dateInscription);
            preparedStatement.setString(2, this.nom);
            preparedStatement.setString(3, this.postnom);
            preparedStatement.setString(4, this.prenom);
            preparedStatement.setString(5, this.genre);
            preparedStatement.setDate(6, this.dateNaissance);
            preparedStatement.setString(7, this.nationalite);
            preparedStatement.setString(8, this.lieuNaissance);
            preparedStatement.setString(9, this.quartier);
            preparedStatement.setString(10, this.commune);
            preparedStatement.setString(11, this.district);
            preparedStatement.setString(12, this.territoire);
            preparedStatement.setString(13, this.avenue);
            preparedStatement.setString(14, this.secteur);
            preparedStatement.setString(15, this.langues);
            preparedStatement.setString(16, this.religion);
            preparedStatement.setString(17, this.nomPere);
            preparedStatement.setString(18, this.telPere);
            preparedStatement.setString(19, this.nomMere);
            preparedStatement.setString(20, this.telMere);
            preparedStatement.setString(21, this.nomTuteur);
            preparedStatement.setString(22, this.contactTuteur);
            preparedStatement.setString(23, this.email);
            preparedStatement.setString(24, this.telephone);
            preparedStatement.setString(25, this.numEcole);
            preparedStatement.setString(26, this.promotion);
            preparedStatement.setString(27, this.classe);
            preparedStatement.setString(28, this.section);
            preparedStatement.setString(29, this.modePaiement);
            preparedStatement.setFloat(30, this.fraisInscription);
            preparedStatement.setString(31, this.transport);
            preparedStatement.setString(32, this.observations);
            preparedStatement.setInt(33, this.eleves.getIdELeve());
     

            int nbreLigne = preparedStatement.executeUpdate();
            return nbreLigne >=1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public boolean modifier() {
    try {
        Connection connection = Database.getConnection();
        String sql = "UPDATE inscriptions SET dateInscription = ?, nom = ?, postnom = ?, prenom = ?, genre = ?, dateNaissance = ?, nationalite = ?, lieuNaissance = ?, quartier = ?, commune = ?, district = ?, territoire = ?, avenue = ?, secteur = ?, langues = ?, religion = ?, nomPere = ?, telPere = ?, nomMere = ?, telMere = ?, nomTuteur = ?, contactTuteur = ?, email = ?, telephone = ?, numEcole = ?, promotion = ?, classe = ?, section = ?, modePaiement = ?, fraisInscription = ?, transport = ?, observations = ?, idEleve = ? WHERE idInscription = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDate(1, this.dateInscription);
        stmt.setString(2, this.nom);
        stmt.setString(3, this.postnom);
        stmt.setString(4, this.prenom);
        stmt.setString(5, this.genre);
        stmt.setDate(6, this.dateNaissance);
        stmt.setString(7, this.nationalite);
        stmt.setString(8, this.lieuNaissance);
        stmt.setString(9, this.quartier);
        stmt.setString(10, this.commune);
        stmt.setString(11, this.district);
        stmt.setString(12, this.territoire);
        stmt.setString(13, this.avenue);
        stmt.setString(14, this.secteur);
        stmt.setString(15, this.langues);
        stmt.setString(16, this.religion);
        stmt.setString(17, this.nomPere);
        stmt.setString(18, this.telPere);
        stmt.setString(19, this.nomMere);
        stmt.setString(20, this.telMere);
        stmt.setString(21, this.nomTuteur);
        stmt.setString(22, this.contactTuteur);
        stmt.setString(23, this.email);
        stmt.setString(24, this.telephone);
        stmt.setString(25, this.numEcole);
        stmt.setString(26, this.promotion);
        stmt.setString(27, this.classe);
        stmt.setString(28, this.section);
        stmt.setString(29, this.modePaiement);
        stmt.setFloat(30, this.fraisInscription);
        stmt.setString(31, this.transport);
        stmt.setString(32, this.observations);
        stmt.setInt(33, this.eleves.getIdELeve());
        stmt.setInt(34, this.idInscription); // Clé primaire

        int lignesAffectees = stmt.executeUpdate();
        return lignesAffectees > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
public boolean supprimer() {
    try {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM inscriptions WHERE idInscription = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, this.idInscription);

        int lignesSupprimees = stmt.executeUpdate();
        return lignesSupprimees > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
public static int recupererIdParEleve(int idEleve) {
    try {
        Connection conn = Database.getConnection();
        String sql = "SELECT idInscription FROM inscriptions WHERE idEleve = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idEleve);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("idInscription");
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return -1;
    
}

}