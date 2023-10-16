/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frikasoft.eduplus_univ.entities.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yogiLinux
 */
@Entity
@Table(name = "paiement_etudiant")
@NamedQueries({
    @NamedQuery(name = "PaiementEtudiant.findAll", query = "SELECT p FROM PaiementEtudiant p")})
public class PaiementEtudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mois")
    private String mois;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private BigDecimal montant;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "fkEtudiant")
    private Integer fkEtudiant;
    @Column(name = "datePaiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Column(name = "observation")
    private String observation;
    @Column(name = "fkAnneeAcademique")
    private Integer fkAnneeAcademique;
    @Basic(optional = false)
    @Column(name = "fkMotifPaiement")
    private int fkMotifPaiement;

    public PaiementEtudiant() {
    }

    public PaiementEtudiant(Integer id) {
        this.id = id;
    }

    public PaiementEtudiant(Integer id, int fkMotifPaiement) {
        this.id = id;
        this.fkMotifPaiement = fkMotifPaiement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getFkEtudiant() {
        return fkEtudiant;
    }

    public void setFkEtudiant(Integer fkEtudiant) {
        this.fkEtudiant = fkEtudiant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getFkAnneeAcademique() {
        return fkAnneeAcademique;
    }

    public void setFkAnneeScolaire(Integer fkAnneeAcademique) {
        this.fkAnneeAcademique = fkAnneeAcademique;
    }

    public int getFkMotifPaiement() {
        return fkMotifPaiement;
    }

    public void setFkMotifPaiement(int fkMotifPaiement) {
        this.fkMotifPaiement = fkMotifPaiement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaiementEtudiant)) {
            return false;
        }
        PaiementEtudiant other = (PaiementEtudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.PaiementEtudiant[ id=" + id + " ]";
    }
    
}
