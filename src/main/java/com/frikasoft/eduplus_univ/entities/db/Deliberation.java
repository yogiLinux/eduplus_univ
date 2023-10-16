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
@Table(name = "deliberation")
@NamedQueries({
    @NamedQuery(name = "Deliberation.findAll", query = "SELECT d FROM Deliberation d")})
public class Deliberation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fkEleve")
    private Integer fkEleve;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pointTotal")
    private BigDecimal pointTotal;
    @Column(name = "reference")
    private BigDecimal reference;
    @Column(name = "moyen")
    private BigDecimal moyen;
    @Column(name = "pourcentage")
    private BigDecimal pourcentage;
    @Column(name = "obervation")
    private String obervation;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "dateDeliberation")
    @Temporal(TemporalType.DATE)
    private Date dateDeliberation;

    public Deliberation() {
    }

    public Deliberation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkEleve() {
        return fkEleve;
    }

    public void setFkEleve(Integer fkEleve) {
        this.fkEleve = fkEleve;
    }

    public BigDecimal getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(BigDecimal pointTotal) {
        this.pointTotal = pointTotal;
    }

    public BigDecimal getReference() {
        return reference;
    }

    public void setReference(BigDecimal reference) {
        this.reference = reference;
    }

    public BigDecimal getMoyen() {
        return moyen;
    }

    public void setMoyen(BigDecimal moyen) {
        this.moyen = moyen;
    }

    public BigDecimal getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getObervation() {
        return obervation;
    }

    public void setObervation(String obervation) {
        this.obervation = obervation;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDateDeliberation() {
        return dateDeliberation;
    }

    public void setDateDeliberation(Date dateDeliberation) {
        this.dateDeliberation = dateDeliberation;
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
        if (!(object instanceof Deliberation)) {
            return false;
        }
        Deliberation other = (Deliberation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.Deliberation[ id=" + id + " ]";
    }
    
}
