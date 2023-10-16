package com.frikasoft.eduplus_univ.contract.configuration;

import com.frikasoft.eduplus_univ.contract.IController;
import com.frikasoft.eduplus_univ.entities.db.*;

import java.util.List;

public interface IConfigurationGet extends IController {

    Anneeacademique getAnneeAcademique(Integer id);
    List<Anneeacademique> getAnneeAcademiqueAll();
    Auditoire getAuditoire(Integer id);
    List<Auditoire> getAuditoireAll();
    Cours getCours(Integer id);
    List<Cours> getCoursAll();
    Departement getDepartement(Integer id);
    List<Departement> getDepartementall();
    Etablissement getEtablissement(Integer id);
    List<Etablissement> getEtablissementAll();
    Faculte getFaculte(Integer id);
    List<Faculte> getFaculteAll();
    Motifpaiement getMotifPaiement(Integer id);
    List<Motifpaiement> getMotifPaiementAll();
    Province getProvince(Integer id);
    List<Province> getProvinceAll();
    User getuser(Integer id);
    List<User> getUserAll();
    Vacation getVacation(Integer id);
    List<Vacation> getVacationAll();
    Categorieagent getCategorie(Integer id);
    List<Categorieagent> getCategorieAgentAll();
    Ville getVille(Integer id);
    List<Ville> getVilleAll();


}
