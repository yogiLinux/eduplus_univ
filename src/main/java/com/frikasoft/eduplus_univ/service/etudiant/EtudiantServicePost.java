package com.frikasoft.eduplus_univ.service.etudiant;

import com.frikasoft.eduplus_univ.contract.etudiant.IEtudiantPost;
import com.frikasoft.eduplus_univ.entities.db.Agent;
import com.frikasoft.eduplus_univ.entities.db.Etudiant;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.etudiant.EtudiantRepository;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Service
public class EtudiantServicePost implements IEtudiantPost {

    private ErrorResponse error = null;

    private EtudiantRepository etudiantRepository;

    @Override
    public ErrorResponse getErroResponse() {
        if(error == null)
            error = new ErrorResponse();
        return error;
    }


    @Override
    public void saveEtudiant(String adresse, Date dateNaissance, String lieuNaissance,
            String nom, String nomTuteur, String telephone, String photo, String postnom, String prenom, String sexe, Integer idForUpdate) {
        long millis = System.currentTimeMillis();
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(adresse, "Veuillez renseigner l'adresse de l'étudiant");
            AppUtilities.controlValue(lieuNaissance, "Veuillez renseigner la date de naissance de l'étudiant");
            AppUtilities.controlValue(nom, "Veuillez renseigner le nom de l'étudiant");
            AppUtilities.controlValue(nomTuteur, "Veuillez renseigner le nom du tuteur de l'étudiant");
            AppUtilities.controlValue(telephone, "Veuillez renseigner le numero de telephone");
            AppUtilities.controlValue(photo, "Veuillez charger la photo de l'étudiant");
            AppUtilities.controlValue(postnom, "Veuillez saisir le postnom de l'étudiant");
            AppUtilities.controlValue(prenom, "Veuillez saisir le prenom de l'étudiant");
            AppUtilities.controlValue(sexe, "Veuillez selectionner le sexe de l'étudiant");

            Date dateCreate ;

            var etudiant = new Etudiant();
            etudiant.setAdresseEtudiant(adresse);
            etudiant.setDateCreate(new java.sql.Date(millis));
            etudiant.setLieuNaissance(lieuNaissance);
            etudiant.setNom(nom);
            etudiant.setNomTuteur(nomTuteur);
            etudiant.setNumeroTelephone(telephone);
            etudiant.setPhoto(photo);
            etudiant.setPostNom(postnom);
            etudiant.setPrenom(prenom);
            etudiant.setSexe(sexe);
           etudiant.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                etudiant = etudiantRepository.findById(idForUpdate).orElse(etudiant);
                etudiant.setAdresseEtudiant(adresse);
                etudiant.setDateCreate(new java.sql.Date(millis));
                etudiant.setLieuNaissance(lieuNaissance);
                etudiant.setNom(nom);
                etudiant.setNomTuteur(nomTuteur);
                etudiant.setNumeroTelephone(telephone);
                etudiant.setPhoto(photo);
                etudiant.setPostNom(postnom);
                etudiant.setPrenom(prenom);
                etudiant.setSexe(sexe);
                etudiant.setStatus(true);
            }
            var save =  etudiantRepository.save(etudiant);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("l'Etudiant :" +etudiant.getNom()+" est  enregistré avec succès");
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
