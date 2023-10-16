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
@Table(name = "evaluation")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")})
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "epreuveType")
    private String epreuveType;
    @Column(name = "periode")
    private String periode;
    @Column(name = "semestre")
    private String semestre;
    @Column(name = "description")
    private String description;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pointObtenu")
    private BigDecimal pointObtenu;
    @Column(name = "pointReference")
    private Integer pointReference;
    @Column(name = "fkCours")
    private Integer fkCours;
    @Column(name = "fkEtudiant")
    private Integer fkEtudiant;
    @Column(name = "status")
    private Boolean status;

    public Evaluation() {
    }

    public Evaluation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEpreuveType() {
        return epreuveType;
    }

    public void setEpreuveType(String epreuveType) {
        this.epreuveType = epreuveType;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public BigDecimal getPointObtenu() {
        return pointObtenu;
    }

    public void setPointObtenu(BigDecimal pointObtenu) {
        this.pointObtenu = pointObtenu;
    }

    public Integer getPointReference() {
        return pointReference;
    }

    public void setPointReference(Integer pointReference) {
        this.pointReference = pointReference;
    }

    public Integer getFkCours() {
        return fkCours;
    }

    public void setFkCours(Integer fkCours) {
        this.fkCours = fkCours;
    }

    public Integer getFkEtudiant() {
        return fkEtudiant;
    }

    public void setFkEtudiant(Integer fkEtudiant) {
        this.fkEtudiant = fkEtudiant;
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
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.Evaluation[ id=" + id + " ]";
    }
    
}
