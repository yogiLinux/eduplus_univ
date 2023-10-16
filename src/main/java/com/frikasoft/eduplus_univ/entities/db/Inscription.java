/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frikasoft.eduplus_univ.entities.db;

import java.io.Serializable;
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
@Table(name = "inscription")
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i")})
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fkVacation")
    private int fkVacation;
    @Basic(optional = false)
    @Column(name = "fkDepartement")
    private int fkDepartement;
    @Basic(optional = false)
    @Column(name = "fkFaculte")
    private int fkFaculte;
    @Basic(optional = false)
    @Column(name = "fkEtudiant")
    private int fkEtudiant;
    @Basic(optional = false)
    @Column(name = "fkAuditoire")
    private int fkAuditoire;
    @Basic(optional = false)
    @Column(name = "fkAnneeAcademique")
    private int fkAnneeAcademique;
    @Basic(optional = false)
    @Column(name = "dateInscription")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;

    public Inscription() {
    }

    public Inscription(Integer id) {
        this.id = id;
    }

    public Inscription(Integer id, int fkVacation, int fkDepartement, int fkFaculte, int fkEtudiant, int fkAuditoire, int fkAnneeAcademique, Date dateInscription, short status) {
        this.id = id;
        this.fkVacation = fkVacation;
        this.fkDepartement = fkDepartement;
        this.fkFaculte = fkFaculte;
        this.fkEtudiant = fkEtudiant;
        this.fkAuditoire = fkAuditoire;
        this.fkAnneeAcademique = fkAnneeAcademique;
        this.dateInscription = dateInscription;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFkVacation() {
        return fkVacation;
    }

    public void setFkVacation(int fkVacation) {
        this.fkVacation = fkVacation;
    }

    public int getFkDepartement() {
        return fkDepartement;
    }

    public void setFkDepartement(int fkDepartement) {
        this.fkDepartement = fkDepartement;
    }

    public int getFkFaculte() {
        return fkFaculte;
    }

    public void setFkFaculte(int fkFaculte) {
        this.fkFaculte = fkFaculte;
    }

    public int getFkEtudiant() {
        return fkEtudiant;
    }

    public void setFkEtudiant(int fkEtudiant) {
        this.fkEtudiant = fkEtudiant;
    }

    public int getFkAuditoire() {
        return fkAuditoire;
    }

    public void setFkAuditoire(int fkAuditoire) {
        this.fkAuditoire = fkAuditoire;
    }

    public int getFkAnneeAcademique() {
        return fkAnneeAcademique;
    }

    public void setFkAnneeAcademique(int fkAnneeAcademique) {
        this.fkAnneeAcademique = fkAnneeAcademique;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
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
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.Inscription[ id=" + id + " ]";
    }
    
}
