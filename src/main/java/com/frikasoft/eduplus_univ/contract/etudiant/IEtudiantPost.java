package com.frikasoft.eduplus_univ.contract.etudiant;

import com.frikasoft.eduplus_univ.contract.IController;

import java.sql.Date;

public interface IEtudiantPost extends IController {

    void saveEtudiant (String adresse, Date dateNaissance, String lieuNaissance,
                       String nom, String nomTuteur, String telephone, String  photo, String postnom, String prenom, String sexe, Integer idForUpdate);
}
