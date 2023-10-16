package com.frikasoft.eduplus_univ.entities.adapter;

import java.sql.Date;

public class PaieAgentAdapter {
    String nom;
    String postnom;
    String prenom;
    Date date;
    Double montant ;
    String motif;
    String fonction;
    String categorieAgent;
    String Observatio;

    public PaieAgentAdapter() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getCategorieAgent() {
        return categorieAgent;
    }

    public void setCategorieAgent(String categorieAgent) {
        this.categorieAgent = categorieAgent;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getObservatio() {
        return Observatio;
    }

    public void setObservatio(String observatio) {
        Observatio = observatio;
    }
}
