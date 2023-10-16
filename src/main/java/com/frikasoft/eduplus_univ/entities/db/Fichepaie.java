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
@Table(name = "fichepaie")
@NamedQueries({
    @NamedQuery(name = "Fichepaie.findAll", query = "SELECT f FROM Fichepaie f")})
public class Fichepaie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fkagent")
    private int fkagent;
    @Column(name = "mois")
    private String mois;
    @Column(name = "datePaiment")
    @Temporal(TemporalType.DATE)
    private Date datePaiment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Double montant;
    @Column(name = "description")
    private String description;
    @Column(name = "fkMotifPaiement")
    private Integer fkMotifPaiement;

    @Column(name ="fkAnneeAcademique")
    private Integer fkAnneeAcademique;
    @Column(name = "observation")
    private String observation;
    @Column(name = "status")
    private Boolean status;

    public Fichepaie() {
    }

    public Fichepaie(Integer id) {
        this.id = id;
    }

    public Fichepaie(Integer id, int fkagent) {
        this.id = id;
        this.fkagent = fkagent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFkagent() {
        return fkagent;
    }

    public void setFkagent(int fkagent) {
        this.fkagent = fkagent;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Date getDatePaiment() {
        return datePaiment;
    }

    public void setDatePaiment(Date datePaiment) {
        this.datePaiment = datePaiment;
    }

    public Double getMontant() {
        return montant;
    }

    public Integer getFkMotifPaiement() {
        return fkMotifPaiement;
    }

    public void setFkMotifPaiement(Integer fkMotifPaiement) {
        this.fkMotifPaiement = fkMotifPaiement;
    }

    public Integer getFkAnneeAcademique() {
        return fkAnneeAcademique;
    }

    public void setFkAnneeAcademique(Integer fkAnneeAcademique) {
        this.fkAnneeAcademique = fkAnneeAcademique;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer  getfkMotifPaiement() {
        return fkMotifPaiement;
    }

    public void setMotifPaiement(Integer motifPaiement) {
        this.fkMotifPaiement = fkMotifPaiement;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        if (!(object instanceof Fichepaie)) {
            return false;
        }
        Fichepaie other = (Fichepaie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.Fichepaie[ id=" + id + " ]";
    }
    
}
