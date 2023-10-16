package com.frikasoft.eduplus_univ.service.etudiant;

import com.frikasoft.eduplus_univ.contract.etudiant.IEtudiantGet;
import com.frikasoft.eduplus_univ.entities.db.Etudiant;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.etudiant.EtudiantRepository;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceGet implements IEtudiantGet {
    private ErrorResponse error = null;

    private EtudiantRepository etudiantRepository;


    @Override
    public ErrorResponse getErroResponse() {
        if(error==null)
            error = new ErrorResponse();
        return error;
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        error = new ErrorResponse();
        Etudiant etudiant = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner l'étudiant");
            etudiant =  etudiantRepository.findById(id).orElse(null);
            if(etudiant!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici l'étudiant séléctionné :" + etudiant.getNom());
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
        return etudiant;
    }

    @Override
    public List<Etudiant> getEtudiantListByName(String name) {
        error = new ErrorResponse();
        List<Etudiant> etudiants = null;
        try {
            AppUtilities.controlValue(name, "Vueillez saisir le mot clé que vous rechercher");
            etudiants =  etudiantRepository.researchEtudiantByName(name);
            if(etudiants!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des étudiants correspondant au mot clé saisi :" );
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
        return etudiants;
    }

    @Override
    public List<Etudiant> getEtudiantByAnneeAcademique(String anneeAcademique) {
        error = new ErrorResponse();
        List<Etudiant> etudiants = null;
        try {
            AppUtilities.controlValue(anneeAcademique, "Vueillez selectionner l'année academique ");
            etudiants =  etudiantRepository.searchByAnneeAcademique(anneeAcademique);
            if(etudiants!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des étudiants  :" );
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
        return etudiants;
    }

    @Override
    public List<Etudiant> getEtudiantByanneeAndVacation(String anneeAcademique, String vacation) {
        error = new ErrorResponse();
        List<Etudiant> etudiants = null;
        try {
            AppUtilities.controlValue(anneeAcademique, "Vueillez selectionner l'année academique ");
            AppUtilities.controlValue(vacation,"Veuillez selection la vacation pour continuer la recheche");
            etudiants =  etudiantRepository.searchByAnneeAcademiqueAndVacation(anneeAcademique, vacation);
            if(etudiants!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des étudiants  :" );
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
        return etudiants;
    }

    @Override
    public List<Etudiant> getEtudiantByVacation(String vacation) {
        error = new ErrorResponse();
        List<Etudiant> etudiants = null;
        try {
            AppUtilities.controlValue(vacation, "Vueillez selectionner la vacation ");
            etudiants =  etudiantRepository.searchByVacation(vacation);
            if(etudiants!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des étudiants  :" );
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
        return etudiants;
    }
}
