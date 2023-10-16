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
@Table(name = "accesscategory")
@NamedQueries({
    @NamedQuery(name = "Accesscategory.findAll", query = "SELECT a FROM Accesscategory a")})
public class Accesscategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "numeroRole")
    private int numeroRole;
    @Column(name = "status")
    private Boolean status;

    public Accesscategory() {
    }

    public Accesscategory(Integer id) {
        this.id = id;
    }

    public Accesscategory(Integer id, int numeroRole) {
        this.id = id;
        this.numeroRole = numeroRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumeroRole() {
        return numeroRole;
    }

    public void setNumeroRole(int numeroRole) {
        this.numeroRole = numeroRole;
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
        if (!(object instanceof Accesscategory)) {
            return false;
        }
        Accesscategory other = (Accesscategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.entity.Accesscategory[ id=" + id + " ]";
    }
    
}
