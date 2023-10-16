package com.frikasoft.eduplus_univ.entities.adapter;

import java.sql.Date;

public class PaiementEtudiantAdapter {
    String nomEtudiant;
    String postnom;
    String prenom;
    String faculte;
    String auditoire;
    Double montant;
    String motif;
    Date datePaiement;
    String Observation;

    public PaiementEtudiantAdapter() {
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
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

    public String getAuditoire() {
        return auditoire;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public void setAuditoire(String auditoire) {
        this.auditoire = auditoire;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
