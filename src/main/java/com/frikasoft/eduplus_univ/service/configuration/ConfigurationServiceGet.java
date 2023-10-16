package com.frikasoft.eduplus_univ.service.configuration;

import com.frikasoft.eduplus_univ.contract.configuration.IConfigurationGet;
import com.frikasoft.eduplus_univ.entities.db.*;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.configuration.*;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationServiceGet implements IConfigurationGet {
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
    private VilleRepository villeRepository;
    @Autowired
    private CategorieAgentRepository categorieAgentRepository;




    @Override
    public ErrorResponse getErroResponse() {
        if(error==null)
            error = new ErrorResponse();
        return error;
    }

    @Override
    public Anneeacademique getAnneeAcademique(Integer id) {
        error = new ErrorResponse();
        Anneeacademique anneeAcademique = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner l'année académique");
            anneeAcademique =  anneeAcademiqueRepository.findById(id).orElse(null);
            if(anneeAcademique!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici l'année académique séléctionnée :" + anneeAcademique.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return anneeAcademique;
    }

    @Override
    public List<Anneeacademique> getAnneeAcademiqueAll() {
        error = new ErrorResponse();
        List<Anneeacademique> anneeAcademiques = null;
        try {
            anneeAcademiques =  anneeAcademiqueRepository.findAll();
            if(anneeAcademiques!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des données" );
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return anneeAcademiques;
    }

    @Override
    public Auditoire getAuditoire(Integer id) {
        error = new ErrorResponse();
        Auditoire auditoire = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner l'auditoire");
            auditoire =  auditoireRepository.findById(id).orElse(null);
            if(auditoire!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici l'auditoire sélectionné :" + auditoire.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return auditoire;
    }



    @Override
    public List<Auditoire> getAuditoireAll() {
        error = new ErrorResponse();
        List<Auditoire> auditoires = null;
        try {
            auditoires =  auditoireRepository.findAll();
            if(auditoires!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des auditoires ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return auditoires;
    }

    @Override
    public Cours getCours(Integer id) {
        error = new ErrorResponse();
        Cours  cours = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner le cours");
            cours =  coursRepository.findById(id).orElse(null);
            if(cours!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici le cours sélectionné :" + cours.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return cours;
    }

    @Override
    public List<Cours> getCoursAll() {
        error = new ErrorResponse();
        List<Cours> cours = null;
        try {
            cours =  coursRepository.findAll();
            if(cours!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des cours ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return cours;
    }

    @Override
    public Departement getDepartement(Integer id) {
        error = new ErrorResponse();
        Departement departement = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner le departement");
            departement =  departementRepository.findById(id).orElse(null);
            if(departement!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici le departement sélectionné :" + departement.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return departement;
    }

    @Override
    public List<Departement> getDepartementall() {
        error = new ErrorResponse();
        List<Departement> departements = null;
        try {
            departements =  departementRepository.findAll();
            if(departements!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des departements ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return departements;
    }

    @Override
    public Etablissement getEtablissement(Integer id) {
        error = new ErrorResponse();
        Etablissement etablissement = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner l'établissement");
            etablissement =  etablissementRepository.findById(id).orElse(null);
            if(etablissement!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici l'établissement sélectionné :" + etablissement.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return etablissement;
    }

    @Override
    public List<Etablissement> getEtablissementAll() {
        error = new ErrorResponse();
        List<Etablissement> etablissements = null;
        try {
            etablissements =  etablissementRepository.findAll();
            if(etablissements!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des établissements ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return etablissements;
    }

    @Override
    public Faculte getFaculte(Integer id) {
        error = new ErrorResponse();
        Faculte faculte = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner la faculté");
            faculte =  faculteRepository.findById(id).orElse(null);
            if(faculte!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la faculté sélectionnée :" + faculte.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return faculte;
    }

    @Override
    public List<Faculte> getFaculteAll() {
        error = new ErrorResponse();
        List<Faculte> facultes = null;
        try {
            facultes =  faculteRepository.findAll();
            if(facultes!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des facultés ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return facultes;
    }

    @Override
    public Motifpaiement getMotifPaiement(Integer id) {
        error = new ErrorResponse();
        Motifpaiement motifpaiement = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner le motif");
            motifpaiement =  motifPaiementRepository.findById(id).orElse(null);
            if(motifpaiement!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la faculté sélectionnée :" + motifpaiement.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return motifpaiement;
    }

    @Override
    public List<Motifpaiement> getMotifPaiementAll() {
        error = new ErrorResponse();
        List<Motifpaiement> motifpaiements = null;
        try {
            motifpaiements =  motifPaiementRepository.findAll();
            if(motifpaiements!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des motifs de paiement ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return motifpaiements;
    }

    @Override
    public Province getProvince(Integer id) {
        error = new ErrorResponse();
        Province province = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner la province");
            province =  provinceRepository.findById(id).orElse(null);
            if(province!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la province sélectionnée :" + province.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return province;
    }

    @Override
    public List<Province> getProvinceAll() {
        error = new ErrorResponse();
        List<Province> provinces = null;
        try {
            provinces =  provinceRepository.findAll();
            if(provinces!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des provinces ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return provinces;
    }

    @Override
    public User getuser(Integer id) {
        error = new ErrorResponse();
        User user = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner l'utilisateur");
            user =  userRepository.findById(id).orElse(null);
            if(user!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici l'utilisateur séléctionée' :" + user.getUserName());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return user;
    }

    @Override
    public List<User> getUserAll() {
        error = new ErrorResponse();
        List<User> users = null;
        try {
            users =  userRepository.findAll();
            if(users!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des utilisateurs ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return users;
    }

    @Override
    public Vacation getVacation(Integer id) {
        error = new ErrorResponse();
        Vacation vacation = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner la vacation");
            vacation =  vacationRepository.findById(id).orElse(null);
            if(vacation!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la vacation séléctionée' :" + vacation.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return vacation;
    }

    @Override
    public List<Vacation> getVacationAll() {
        error = new ErrorResponse();
        List<Vacation> vacations = null;
        try {
            vacations =  vacationRepository.findAll();
            if(vacations!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des vacations ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return vacations;
    }

    @Override
    public Categorieagent getCategorie(Integer id) {
        error = new ErrorResponse();
        Categorieagent categorie =  null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner la catégorie ");
            categorie =  categorieAgentRepository.findById(id).orElse(null);
            if(categorie!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la catégorie selectionée' :" + categorie.getDescription());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return categorie;
    }

    @Override
    public List<Categorieagent> getCategorieAgentAll() {
        error = new ErrorResponse();
        List<Categorieagent> categories = null;
        try {
            categories =  categorieAgentRepository.findAll();
            if(categories!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des catégories ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return categories;
    }

    @Override
    public Ville getVille(Integer id) {
        error = new ErrorResponse();
        Ville ville = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner la catégorie ");
            ville = villeRepository.findById(id).orElse(null);
            if (ville != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la catégorie selectionée' :" + ville.getDescription());
            } else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        } catch (DataValueException e) {
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return ville;
    }


    @Override
    public List<Ville> getVilleAll() {
            error = new ErrorResponse();
            List<Ville> villes = null;
            try {
                villes =  villeRepository.findAll();
                if(villes!=null) {
                    error.setErrorCode(ErrorResponse.OK);
                    error.setErrorDescription("Voici la liste des villes ");
                }else {
                    throw new DataValueException(AppConst.VALUE_NOT_FOUND);
                }
            }catch(DataValueException e){
                error.setErrorCode(ErrorResponse.KO);
                error.setErrorDescription(e.getMessage());
            }catch(Exception e){
                e.printStackTrace();
                error.setErrorCode(ErrorResponse.KO);
                error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
            }
            return villes;
    }
}
