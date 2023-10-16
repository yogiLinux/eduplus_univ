package com.frikasoft.eduplus_univ.service.configuration;

import com.frikasoft.eduplus_univ.contract.configuration.IConfigurationPost;
import com.frikasoft.eduplus_univ.entities.db.*;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.configuration.*;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ConfigurationServicePost implements IConfigurationPost {
    private ErrorResponse error = null;

    @Autowired
    private AnneeAcademiqueRepository anneeAcademiqueRepository;
    @Autowired
    private AuditoireRepository auditoireRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private FaculteRepository faculteRepository;
    @Autowired
    private LoginManagementRepository loginManagementRepository;
    @Autowired
    private ModeEnsignementRepository modeEnsignementRepository;
    @Autowired
    private MotifPaiementRepository motifPaiementRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VacationRepository vacationRepository;
    @Autowired
    private CategorieAgentRepository categorieAgentRepository;
    @Autowired
    private VilleRepository villeRepository;


    @Override
    public ErrorResponse getErroResponse() {
        if(error==null)
            error = new ErrorResponse();
        return error;
    }


    @Override
    public void saveAnneeAcademique(String description, Date debut, Date fin, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description de l'année académique");
            AppUtilities.controlValue(debut, "Veuillez renseigner la date du debut de l'année academique");
            AppUtilities.controlValue(fin, "Veuillez rensiegner fin de l'année académique");
            var anneeAcademique = new Anneeacademique();
            anneeAcademique.setDescription(description);
            anneeAcademique.setDebut(debut);
            anneeAcademique.setFin(fin);
            anneeAcademique.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                anneeAcademique = anneeAcademiqueRepository.findById(idForUpdate).orElse(anneeAcademique);
                anneeAcademique.setDescription(description);
                anneeAcademique.setDebut(debut);
                anneeAcademique.setFin(fin);
                anneeAcademique.setStatus(true);
            }
            var save =  anneeAcademiqueRepository.save(anneeAcademique);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Année Académique  :" +anneeAcademique.getDescription()+" enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }
    }

    @Override
    public void saveAuditoire(String description, Integer fkAnneeAcademique, Integer fkDepartement, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description de l'auditoire");
            AppUtilities.controlValue(fkAnneeAcademique, "Veuillez rensieeigner l'annee academique");
            AppUtilities.controlValue(fkDepartement, "Veuillez renseigner le Departement");

            var auditoire = new Auditoire();
            auditoire.setDescription(description);
            auditoire.setFkAnneeAcademique(fkAnneeAcademique);
            auditoire.setFkDepartement(fkDepartement);
            auditoire.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                auditoire = auditoireRepository.findById(idForUpdate).orElse(auditoire);
                auditoire.setDescription(description);
                auditoire.setFkAnneeAcademique(fkAnneeAcademique);
                auditoire.setFkDepartement(fkDepartement);
                auditoire.setStatus(true);
            }
            var save =  auditoireRepository.save(auditoire);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("L'auditoire   :" +auditoire.getDescription()+"  est enregistré avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }

    @Override
    public void saveCours(String description, String commentaire, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description du cours");

            var cours  = new Cours();
            cours.setDescription(description);
            if(commentaire==null)
                commentaire="";
            cours.setCommentaire(commentaire);
            cours.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                cours = coursRepository.findById(idForUpdate).orElse(cours);
                cours.setDescription(description);
                if(commentaire==null)
                    commentaire="";
                cours.setCommentaire(commentaire);
                cours.setStatus(true);

            }
            var save =  coursRepository.save(cours);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Le cours   : " +cours.getDescription()+"  est enregistré avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }
    }

    @Override
    public void saveDapartement(String description, Integer fkFaculte, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description du departement");
            var departement  = new Departement();
            departement.setDescription(description);
            departement.setFkFaculte(fkFaculte);
            departement.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                departement = departementRepository.findById(idForUpdate).orElse(departement);
                departement.setDescription(description);
                departement.setFkFaculte(fkFaculte);
                departement.setStatus(true);
            }
            var save =  departementRepository.save(departement);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Le departement   : " +departement.getDescription()+"  est enregistré avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }
    }

    @Override
    public void saveEtablissement(String adresse, Integer fkVille, String logo, String description,  Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(adresse, "Veuillez renseigner l'adresse de l'établissment");
            AppUtilities.controlValue(fkVille, "Veuillez séléctionner la province");
            AppUtilities.controlValue(description, "Veuillez renseigner la descritpion de l'établissement");
            var etablissement  = new Etablissement();
            etablissement.setAdresse(adresse);
            etablissement.setFkProvince(fkVille);
            if(logo==null)
                logo = "";
            etablissement.setLogo(logo);
            etablissement.setDescription(description);
            etablissement.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                etablissement = etablissementRepository.findById(idForUpdate).orElse(etablissement);
                etablissement.setAdresse(adresse);
                etablissement.setFkProvince(fkVille);
                if(logo==null)
                    logo = "";
                etablissement.setLogo(logo);
                etablissement.setDescription(description);
                etablissement.setStatus(true);
            }
            var save =  etablissementRepository.save(etablissement);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("L'établissement  : " +etablissement.getDescription()+"  est enregistré avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }
    }

    @Override
    public void saveFaculte(String description, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description de la faculté");
            var faculte  = new Faculte();
            faculte.setDescription(description);
            faculte.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                faculte = faculteRepository.findById(idForUpdate).orElse(faculte);
                faculte.setDescription(description);
                faculte.setStatus(true);
            }
            var save =  faculteRepository.save(faculte);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("La factulté  : " +faculte.getDescription()+"  est enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }
    }

    @Override
    public void saveMotifPaiement(String description, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description du motif de paiement");
            var motif  = new Motifpaiement();
            motif.setDescription(description);
            motif.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                motif = motifPaiementRepository.findById(idForUpdate).orElse(motif);
                motif.setDescription(description);
                motif.setStatus(true);
            }
            var save =  motifPaiementRepository.save(motif);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("le motif de paiement : " +motif.getDescription()+"  est enregistré avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }

    @Override
    public void saveProvince(String description, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description");
            var province  = new Province();
            province.setDescription(description);
            province.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                province = provinceRepository.findById(idForUpdate).orElse(province);
                province.setDescription(description);
                province.setStatus(true);
            }
            var save =  provinceRepository.save(province);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("La province : " +province.getDescription()+"  est enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }

    @Override
    public void saveUser(String userName, String password, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(userName, "Veuillez renseigner le nom d'utilisateur");
            AppUtilities.controlValue(password, "Veuillez renseigner le mot de passe");
            var user  = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                user = userRepository.findById(idForUpdate).orElse(user);
                user.setUserName(userName);
                user.setPassword(password);
                user.setStatus(true);
            }
            var save =  userRepository.save(user);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("L'Utilisateur'  est enregistré avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }

    @Override
    public void saveVacation(String description, Integer idForUpdate) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description de la vacation");
            var vacation  = new Vacation();
            vacation.setDescription(description);
            vacation.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                vacation = vacationRepository.findById(idForUpdate).orElse(vacation);
                vacation.setDescription(description);
                vacation.setStatus(true);
            }            var save =  vacationRepository.save(vacation);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("La vacation: " +vacation.getDescription()+"  est enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }

    @Override
    public void saveVille(String description, Integer idForUpdate) {

        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description de la ville");
            var ville  = new Ville();
            ville.setDescription(description);
            ville.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                ville = villeRepository.findById(idForUpdate).orElse(ville);
                ville.setDescription(description);
                ville .setStatus(true);
            }
            var save =  villeRepository.save(ville);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("La ville: " +ville.getDescription()+"  est enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }

    @Override
    public void saveCategorieAgent(String description, Integer idForUpdate) {

        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(description, "Veuillez renseigner la description de la categorie ");
            var categorie  = new Categorieagent();
            categorie.setDescription(description);
            categorie.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                categorie = categorieAgentRepository.findById(idForUpdate).orElse(categorie);
                categorie.setDescription(description);
                categorie.setStatus(true);
            }
            var save =  categorieAgentRepository.save(categorie);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("La categorie: " +categorie.getDescription()+"  est enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }


}
