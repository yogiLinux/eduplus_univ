/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frikasoft.eduplus_univ.entities.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yogiLinux
 */
@Entity
@Table(name = "auditoire")
@NamedQueries({
    @NamedQuery(name = "Auditoire.findAll", query = "SELECT a FROM Auditoire a")})
public class Auditoire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fkAnneeAcademique")
    private int fkAnneeAcademique;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "section")
    private String section;
    @Column(name = "remarque")
    private String remarque;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "salle")
    private String salle;
    @Column(name = "fkDepartement")
    private Integer fkDepartement;

    public Auditoire() {
    }

    public Auditoire(Integer id) {
        this.id = id;
    }

    public Auditoire(Integer id, int fkAnneeAcademique, String description) {
        this.id = id;
        this.fkAnneeAcademique = fkAnneeAcademique;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFkAnneeAcademique() {
        return fkAnneeAcademique;
    }

    public void setFkAnneeAcademique(int fkAnneeAcademique) {
        this.fkAnneeAcademique = fkAnneeAcademique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public Integer getFkDepartement() {
        return fkDepartement;
    }

    public void setFkDepartement(Integer fkDepartement) {
        this.fkDepartement = fkDepartement;
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
        if (!(object instanceof Auditoire)) {
            return false;
        }
        Auditoire other = (Auditoire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.Auditoire[ id=" + id + " ]";
    }
    
}
