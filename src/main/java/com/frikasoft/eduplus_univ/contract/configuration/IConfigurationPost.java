package com.frikasoft.eduplus_univ.contract.configuration;

import com.frikasoft.eduplus_univ.contract.IController;
import com.frikasoft.eduplus_univ.entities.db.*;

import java.sql.Date;
import java.util.List;

public interface IConfigurationPost extends IController {

    void saveAnneeAcademique(String description, Date debut, Date fin, Integer idForUpdate );
    void saveAuditoire(String description, Integer fkAnneeAcademique, Integer fkDepartement, Integer idForUpdate);
    void saveCours(String description, String commentaire, Integer idForUpdate);
    void saveDapartement(String description, Integer fkFaculte, Integer idForUpdate);
    void saveEtablissement(String adresse, Integer fkVille, String logo, String description, Integer idForUpdate);
    void saveFaculte(String description, Integer idForUpdate);
    void saveMotifPaiement(String description, Integer idForUpdate);
    void saveProvince(String description, Integer idForUpdate);
    void saveUser(String userName, String password, Integer idForUpdate);
    void saveVacation(String description, Integer idForUpdate);
    void saveVille(String description, Integer idForUpdate);
    void saveCategorieAgent(String description, Integer idForUpdate);
}
